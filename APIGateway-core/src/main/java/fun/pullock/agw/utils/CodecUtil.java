package fun.pullock.agw.utils;

import com.alibaba.fastjson.JSONObject;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class CodecUtil {

    public static final String HMAC_SHA1 = "HmacSHA1";

    public static final String AES = "AES";

    public static final String AES_CBC = "AES/CBC/PKCS5Padding";


    public static String encrypt(String key, String content) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), AES);
            Cipher cipher = Cipher.getInstance(AES_CBC);
            IvParameterSpec iv = new IvParameterSpec(new byte[16]);
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, iv);
            return bytesToHexString(cipher.doFinal(content.getBytes(StandardCharsets.UTF_8)));
        } catch (NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeyException | BadPaddingException | IllegalBlockSizeException | InvalidAlgorithmParameterException e) {
            e.printStackTrace();
            throw new RuntimeException("Encrypt data error!");
        }
    }

    public static String decrypt(String key, String content) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), AES);
            Cipher cipher = Cipher.getInstance(AES_CBC);
            IvParameterSpec iv = new IvParameterSpec(new byte[16]);
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, iv);
            return new String(cipher.doFinal(hexStringToBytes(content)));
        } catch (NoSuchAlgorithmException | InvalidKeyException | InvalidAlgorithmParameterException | NoSuchPaddingException | BadPaddingException | IllegalBlockSizeException e) {
            e.printStackTrace();
            throw new RuntimeException("Decrypt data error!");
        }
    }

    public static String sign(String key, String data, String nonce) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), HMAC_SHA1);
            Mac mac = Mac.getInstance(HMAC_SHA1);
            mac.init(secretKeySpec);
            mac.update(data.getBytes(StandardCharsets.UTF_8));
            return bytesToHexString(mac.doFinal(nonce.getBytes(StandardCharsets.UTF_8)));
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            throw new RuntimeException("Sign error!");
        }
    }

    private static String bytesToHexString(byte[] bytes) {
        StringBuilder builder = new StringBuilder(bytes.length * 2);
        for (byte data : bytes) {
            builder.append(String.format("%02x", data & 0xff));
        }
        return builder.toString();
    }

    private static byte[] hexStringToBytes(String str) {
        byte[] bytes = new byte[str.length() / 2];
        for(int i = 0; i < str.length() / 2; i++) {
            String subStr = str.substring(i * 2, i * 2 + 2);
            bytes[i] = (byte) Integer.parseInt(subStr, 16);
        }

        return bytes;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        String key = "678901345678905432HHHYGHD#google";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", 123);
        jsonObject.put("buyerName", "测试姓名");

        String param = URLEncoder.encode(jsonObject.toJSONString(), "utf-8");
        System.out.println("param: " + param);

        int nonce = new SecureRandom().nextInt();
        String url = "http://localhost:8080/api/v1/";
        String apiCode = "1TRW556GGH#TEST";
        String data = String.format("code=%s&query=%s&nonce=%d", apiCode, param, nonce);
        System.out.println("data: " + data);

        data = encrypt(key, data);
        System.out.println("encrypt data: " + data);

        String sign = sign(key, data, nonce + "");
        System.out.println("sign: " + sign);

        String biz = "tradecenter";
        String apiName = "queryOrders";
        String outName = "google";
        String finalUrl = String.format(
                "%s%s/%s?out=%s&nonce=%d&sig=%s",
                url,
                biz,
                apiName,
                outName,
                nonce,
                sign
                );

        System.out.println("finalUrl: " + finalUrl);

        System.out.println("key: " + key);
        String decryptData = decrypt(key, data);
        System.out.println("DecryptData: " + decryptData);
    }
}
