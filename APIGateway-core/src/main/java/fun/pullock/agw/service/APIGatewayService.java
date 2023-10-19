package fun.pullock.agw.service;

import fun.pullock.agw.result.Result;
import fun.pullock.agw.chains.CommonContext;

public interface APIGatewayService {

    /**
     * 处理请求，调用commons-chain来处理
     * @param context commons-chain使用的上下文
     * @return 结果
     */
    Result<String> processRequest(CommonContext context);
}
