package me.cxis.agw.service;

import me.cxis.agw.chains.CommonContext;
import me.cxis.agw.result.Result;

public interface APIGatewayService {

    Result<String> processRequest(CommonContext context);
}
