package me.cxis.agw.chains;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import me.cxis.agw.chains.support.GenericInvokeDubbo;
import me.cxis.agw.dao.model.OutDO;
import me.cxis.agw.manager.OutManager;
import me.cxis.agw.utils.CodecUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

import java.security.SecureRandom;

import static me.cxis.agw.model.ErrorCode.SERVICE_ERROR;

/**
 * 泛化调用dubbo服务，将结果加密返回
 */
public class InvokeServiceCommand extends AbstractCommand {

    private static final Logger LOGGER = LoggerFactory.getLogger(InvokeServiceCommand.class);

    @Resource
    private GenericInvokeDubbo genericInvokeDubbo;

    @Resource
    private OutManager outManager;

    @Override
    public boolean execute(CommonContext context) {
        try {
            String[] paramTypes = context.getParamTypes();
            Object[] params = context.getParams();
            String interfaceClass = context.getApiDO().getName();
            String method = context.getApiDO().getMethod();
            Object object = genericInvokeDubbo.invokeDubbo(interfaceClass, method, paramTypes, params);

            String jsonData = JSON.toJSONString(object, SerializerFeature.WriteMapNullValue);

            String outName = context.getOutName();
            OutDO outDO = outManager.queryByName(outName);

            int nonce = new SecureRandom().nextInt();
            String encryptData = CodecUtil.encrypt(outDO.getCode(), jsonData);
            String sign = CodecUtil.sign(outDO.getCode(), encryptData, nonce + "");

            context.setRetSign(sign);
            context.setRetNonce(nonce);
            context.setRetModel(encryptData);
            return false;
        } catch (Exception e) {
            LOGGER.warn("invoke dubbo error, context: {}", JSON.toJSONString(context));
            context.setRetCode(SERVICE_ERROR.getCode());
            context.setRetMsg(SERVICE_ERROR.getMsg());
            context.setSuccess(false);
            return true;
        }
    }
}
