package org.mosakashaka.web.base.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

public final class IpUtil
{
    public static final String UNKNOWN = "unknown";
    public static final String X_FORWARDED_FOR = "x-forwarded-for";
    public static final String PROXY_CLIENT_IP = "Proxy-Client-IP";
    public static final String WL_PROXY_CLIENT_IP = "WL-Proxy-Client-IP";
    public static final String DEFAULT_IPV6 = "0:0:0:0:0:0:0:1";

    private IpUtil()
    {
        throw new AssertionError();
    }

    public static String getRequestIp()
    {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        return getRequestIp(request);
    }

    public static String getRequestIp(HttpServletRequest request)
    {
        String ip = request.getHeader("x-forwarded-for");
        if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
            ip = request.getRemoteAddr();
        }

        if ("0:0:0:0:0:0:0:1".equals(ip)) {
            ip = getLocalhostIp();
        }
        return ip;
    }

    public static String getLocalhostIp() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException localUnknownHostException) {
        }
        return null;
    }
}
