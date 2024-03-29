package fun.pullock.agw.chains;

import com.alibaba.fastjson.JSON;
import fun.pullock.agw.dao.model.OutDO;
import fun.pullock.agw.manager.OutManager;
import fun.pullock.agw.model.ErrorCode;
import fun.pullock.agw.utils.CodecUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/**
 * 请求参数解密
 */
public class DecodeCommand extends AbstractCommand {

    private static final Logger LOGGER = LoggerFactory.getLogger(DecodeCommand.class);

    @Resource
    private OutManager outManager;

    @Override
    public boolean execute(CommonContext context) {
        String outName = context.getOutName();
        OutDO outDO = outManager.queryByName(outName);
        String data = context.getParam();
        try {
            String originData = CodecUtil.decrypt(outDO.getCode(), data);
            LOGGER.info("originData: {}", originData);
            Map<String, String> params = convertToMap(originData);
            for (String key : params.keySet()) {
                context.getReqParams().putIfAbsent(key, params.get(key));
            }
            LOGGER.info("context: {}", JSON.toJSONString(context));
        } catch (Exception e) {
            LOGGER.warn("decode error, out: {}", outName);
            context.setRetCode(ErrorCode.DECODE_DATA_ERROR.getCode());
            context.setRetMsg(ErrorCode.DECODE_DATA_ERROR.getMsg());
            context.setSuccess(false);
            return true;
        }

        return false;
    }

    private Map<String, String> convertToMap(String originData) {
        Map<String, String> result = new HashMap<>();
        String[] data = originData.split("&");
        String[] temp;
        for (String kvData : data) {
            temp = kvData.split("=");

            if (temp.length == 0) {
                result.put("", "");
            } else if (temp.length == 1) {
                result.put(temp[0], "");
            } else {
                try {
                    result.put(temp[0], URLDecoder.decode(temp[1], "utf-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
