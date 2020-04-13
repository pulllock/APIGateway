package me.cxis.agw.service;

import me.cxis.agw.chains.CommonContext;
import me.cxis.agw.result.Result;

public interface APIGatewayService {

    /**
     * 处理请求，调用commons-chain来处理
     * @param context commons-chain使用的上下文
     * @return 结果
     */
    Result<String> processRequest(CommonContext context);
}
