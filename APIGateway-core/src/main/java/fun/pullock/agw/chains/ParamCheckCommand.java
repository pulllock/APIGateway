package fun.pullock.agw.chains;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import fun.pullock.agw.dao.model.ApiDO;
import fun.pullock.agw.dao.model.ApiParamDO;
import fun.pullock.agw.manager.ApiManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

import static fun.pullock.agw.model.ErrorCode.PARAM_MISSING;

/**
 * 检查业务参数，并组织参数
 */
public class ParamCheckCommand extends AbstractCommand {

    private static final Logger LOGGER = LoggerFactory.getLogger(ParamCheckCommand.class);

    @Resource
    private ApiManager apiManager;

    @Override
    public boolean execute(CommonContext context) {

        String apiCode = context.getApiCode();
        ApiDO apiDO = apiManager.queryByCode(apiCode);
        List<ApiParamDO> apiParams = apiManager.queryApiParamsByApiId(apiDO.getId());

        Map<String, String> reqParams = context.getReqParams();

        for (ApiParamDO apiParam : apiParams) {
            if (!reqParams.containsKey(apiParam.getName())) {
                LOGGER.warn("param missing, param: {}", apiParam.getName());
                context.setRetCode(PARAM_MISSING.getCode());
                context.setRetMsg(PARAM_MISSING.getMsg());
                context.setSuccess(false);
                return true;
            }
        }

        int size = apiParams.size();
        String[] paramTypes = new String[size];
        Object[] params = new Object[size];

        for (int i = 0; i < apiParams.size(); i++) {
            String paramType = apiParams.get(i).getType();
            paramTypes[i] = paramType;

            params[i] = convertToActualType(paramType, reqParams.get(apiParams.get(i).getName()));
        }

        context.setParamTypes(paramTypes);
        context.setParams(params);
        context.setApiDO(apiDO);
        return false;
    }

    private Object convertToActualType(String paramType, String paramValue) {
        if (paramValue == null) {
            return null;
        }

        if ("java.lang.String".equals(paramType)) {
            return paramValue;
        }

        if ("java.lang.Byte".equals(paramType)) {
            return Byte.valueOf(paramValue);
        }

        if ("byte".equals(paramType)) {
            return Byte.parseByte(paramValue);
        }

        if ("java.lang.Short".equals(paramType)) {
            return Short.valueOf(paramValue);
        }

        if ("short".equals(paramType)) {
            return Short.parseShort(paramValue);
        }

        if ("java.lang.Integer".equals(paramType)) {
            return Integer.valueOf(paramValue);
        }

        if ("int".equals(paramType)) {
            return Integer.parseInt(paramValue);
        }

        if ("java.lang.Long".equals(paramType)) {
            return Long.valueOf(paramValue);
        }

        if ("long".equals(paramType)) {
            return Long.parseLong(paramValue);
        }

        if ("java.lang.Float".equals(paramType)) {
            return Float.valueOf(paramValue);
        }

        if ("float".equals(paramType)) {
            return Float.parseFloat(paramValue);
        }

        if ("java.lang.Double".equals(paramType)) {
            return Double.valueOf(paramValue);
        }

        if ("double".equals(paramType)) {
            return Double.parseDouble(paramValue);
        }

        if ("java.lang.Boolean".equals(paramType)) {
            return Boolean.valueOf(paramValue);
        }

        if ("boolean".equals(paramType)) {
            return Boolean.parseBoolean(paramValue);
        }

        if ("java.util.Date".equals(paramType)) {
            try {
                return (new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")).parse(paramValue);
            } catch (Exception e) {
                try {
                    long value = Long.parseLong(paramValue);
                    return new Date(value);
                } catch (Exception e1) {
                    e.printStackTrace();
                }
            }
        }

        Object jsonObject = JSON.parse(paramValue);
        if (jsonObject instanceof JSONObject) {
            return toMap((JSONObject) jsonObject);
        } else if (jsonObject instanceof JSONArray) {
            return toArray((JSONArray) jsonObject);
        } else {
            return jsonObject;
        }
    }

    private Object toMap(JSONObject jsonObject) {
        Map<String, Object> result = new HashMap<>();
        for (Map.Entry<String, Object> entry : jsonObject.entrySet()) {
            if (entry.getValue() instanceof JSONObject) {
                result.put(entry.getKey(), toMap((JSONObject) entry.getValue()));
            } else if (entry.getValue() instanceof JSONArray) {
                result.put(entry.getKey(), toArray((JSONArray) entry.getValue()));
            } else {
                result.put(entry.getKey(), entry.getValue());
            }
        }

        return result;
    }

    private Object toArray(JSONArray jsonArray) {
        List<Object> result = new ArrayList<>();
        for (Object object : jsonArray) {
            if (object instanceof JSONObject) {
                result.add(toMap((JSONObject) object));
            } else if (object instanceof JSONArray) {
                result.add(toArray((JSONArray) object));
            } else {
                result.add(object);
            }
        }

        return result;
    }
}
