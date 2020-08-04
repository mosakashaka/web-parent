package core.handler;

import base.exception.BizException;
import base.model.ResponseData;
import base.util.IpUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class DefaultExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(DefaultExceptionHandler.class);
    private static ObjectMapper objectMapper = new ObjectMapper();

    @ExceptionHandler({BizException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseData exceptionHandler(HttpServletRequest req, Exception e) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        BizException ex = null;
        if (e instanceof BizException) {
            ex = (BizException)e;
        } else {
            ex = new BizException(-1, e.getMessage(), e);
        }

        Map map = new HashMap();

        String url = request.getRequestURI();
        map.put("path", url);

        String ip = IpUtil.getRequestIp();
        map.put("ip", ip);

        String requestMethod = request.getMethod();
        map.put("requestMethod", requestMethod);

        String contentType = request.getContentType();
        map.put("contentType", contentType);

        map.put("time", Long.valueOf(System.currentTimeMillis()));

        map.put("errorCode", ex.getCode());

        map.put("errorMessage", ex.getMessage());

        map.put("errorCause", ExceptionUtils.getRootCauseMessage(e));

        try {
            log.error("HTTP_RESPONSE_ERROR {}", objectMapper.writeValueAsString(map));
        } catch (JsonProcessingException jsonProcessingException) {
            //jsonProcessingException.printStackTrace();
        }

        ResponseData data = new ResponseData();
        data.fail(ex.getCode(), ex.getDescription());

        return data;
    }
}
