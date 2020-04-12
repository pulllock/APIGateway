package me.cxis.agw.service.impl;

import com.alibaba.fastjson.JSON;
import me.cxis.agw.chains.CommonContext;
import me.cxis.agw.result.Result;
import me.cxis.agw.service.APIGatewayService;
import org.apache.commons.chain.impl.ChainBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import static me.cxis.agw.model.ErrorCode.SYSTEM_ERROR;

@Service("apiGatewayService")
public class APIGatewayServiceImpl implements APIGatewayService {

    private static final Logger LOGGER = LoggerFactory.getLogger(APIGatewayServiceImpl.class);

    @Resource
    private ChainBase chains;

    @Override
    public Result<String> processRequest(CommonContext context) {
        try {
            chains.execute(context);

            Result<String> result = new Result<>();
            result.setCode(context.getRetCode());
            result.setMsg(context.getRetMsg());
            result.setSuccess(context.getSuccess());
            result.setModel((String) context.getRetModel());
            return result;
        } catch (Exception e) {
            LOGGER.warn("system error, context: {}, cause: ", JSON.toJSONString(context), e);
            return new Result<>(SYSTEM_ERROR);
        }
    }
}
