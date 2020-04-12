package me.cxis.agw.controller;

import me.cxis.agw.chains.CommonContext;
import me.cxis.agw.result.Result;
import me.cxis.agw.service.APIGatewayService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.Map;

import static me.cxis.agw.constants.Constants.*;
import static me.cxis.agw.model.ErrorCode.PARAM_ERROR;
import static me.cxis.agw.model.ErrorCode.SYSTEM_ERROR;

@RestController
@RequestMapping("/api")
public class APIGatewayController {

    private static final Logger LOGGER = LoggerFactory.getLogger(APIGatewayController.class);

    @Resource
    private APIGatewayService apiGatewayService;

    @PostMapping("/v1/{biz}/{api}")
    public Result<String> v1Service(
            HttpServletRequest request,
            @PathVariable(name = "biz") String sys,
            @PathVariable(name = "api") String apiName,
            @RequestParam(name = "out") String outName,
            @RequestParam(name = "nonce") String nonce,
            @RequestParam(name = "sig") String signature,
            @RequestBody String param
    ) {
        try {
            if (StringUtils.isEmpty(sys)) {
                return new Result<>(PARAM_ERROR, "param: biz is empty");
            }

            if (StringUtils.isEmpty(apiName)) {
                return new Result<>(PARAM_ERROR, "param: api is empty");
            }

            if (StringUtils.isEmpty(outName)) {
                return new Result<>(PARAM_ERROR, "param: out is empty");
            }

            if (StringUtils.isEmpty(nonce)) {
                return new Result<>(PARAM_ERROR, "param: nonce is empty");
            }

            if (StringUtils.isEmpty(signature)) {
                return new Result<>(PARAM_ERROR, "param: sig is empty");
            }

            if (StringUtils.isEmpty(param)) {
                return new Result<>(PARAM_ERROR, "param is null");
            }
            LOGGER.info(
                    "request sys: {}, api: {}, out: {}, nonce: {}, sig: {}, param: {}",
                    sys,
                    apiName,
                    outName,
                    nonce,
                    signature,
                    param
                    );

            Map<String, String> params = new HashMap<>();

            params.put(SYS, sys);
            params.put(API_NAME, apiName);
            params.put(OUT_NAME, outName);
            params.put(NONCE, nonce);
            params.put(SIGNATURE, signature);
            params.put(PARAM, param);

            CommonContext context = new CommonContext();
            context.setReqParams(params);


            String clientIp = request.getRemoteHost();
            LOGGER.info("request clientIp: {}", clientIp);

            String xff = request.getHeader(X_FORWARDED_FOR);
            if (StringUtils.isNotEmpty(xff)) {
                LOGGER.info("request {}: {}", X_FORWARDED_FOR, xff);
                clientIp = xff.split(",")[0];
            }
            LOGGER.info("request clientIp: {}", clientIp);
            context.setClientIp(clientIp);

            return apiGatewayService.processRequest(context);
        } catch (Exception e) {
            LOGGER.warn("system error, sys: {}, api: {}, cause: ", sys, apiName, e);
            return new Result<>(SYSTEM_ERROR);
        }

    }
}
