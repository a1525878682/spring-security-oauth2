package com.liyx.auth.utils;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.extension.service.IService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

/**
 * @author ouyangxiap
 * @version 1.0
 * @date 2020/8/27 14:06
 */
@Slf4j
public class CommonUtil {

    /**
     * 设置响应
     *
     * @param response    HttpServletResponse
     * @param contentType content-type
     * @param status      http状态码
     * @param value       响应内容
     * @throws IOException IOException
     */
    public static void makeResponse(HttpServletResponse response, String contentType,
                                    int status, Object value) throws IOException {
        response.setContentType(contentType);
        response.setStatus(status);
        response.getOutputStream().write(JSONObject.toJSONString(value).getBytes());
    }

    /**
     * 封装前端分页表格所需数据
     *
     * @param pageInfo pageInfo
     * @return Map<String, Object>
     */
    public static Map<String, Object> getDataTable(IPage<?> pageInfo) {
        Map<String, Object> data = new HashMap<>(16);
        data.put("rows", pageInfo.getRecords());
        data.put("total", pageInfo.getTotal());
        return data;
    }

    /**
     * 正则校验
     *
     * @param regex 正则表达式字符串
     * @param value 要匹配的字符串
     * @return 正则校验结果
     */
    public static boolean match(String regex, String value) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }

    /**
     * 驼峰转下划线
     *
     * @param value 待转换值
     * @return 结果
     */
    public static String camelToUnderscore(String value) {
        if (StringUtils.isBlank(value)) {
            return value;
        }
        String[] arr = StringUtils.splitByCharacterTypeCamelCase(value);
        if (arr.length == 0) {
            return value;
        }
        StringBuilder result = new StringBuilder();
        IntStream.range(0, arr.length).forEach(i -> {
            if (i != arr.length - 1) {
                result.append(arr[i]).append(StringPool.UNDERSCORE);
            } else {
                result.append(arr[i]);
            }
        });
        return StringUtils.lowerCase(result.toString());
    }

    /**
     * 下划线转驼峰
     *
     * @param value 待转换值
     * @return 结果
     */
    public static String underscoreToCamel(String value) {
        StringBuilder result = new StringBuilder();
        String[] arr = value.split("_");
        for (String s : arr) {
            result.append((String.valueOf(s.charAt(0))).toUpperCase()).append(s.substring(1));
        }
        return result.toString();
    }

    /**
     * 获取本机IP
     *
     * @return 本机ip
     */
    public static String getLocalIp() {
//        try {
//            return InetAddress.getLocalHost().getHostAddress();
//        } catch (UnknownHostException e) {
//            log.info(e.getMessage());
//            return "0.0.0.0";
//        }
        RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) attributes;
        String ip = StringUtils.EMPTY;
        if (servletRequestAttributes != null) {
            ip = servletRequestAttributes.getRequest().getRemoteAddr();
        }
        return ip;
        // 设置操作用户
        //User user = (User) SecurityUtils.getSubject().getPrincipal();
    }

    public static String getRemortIP(HttpServletRequest request) {
        if (request.getHeader("x-forwarded-for") == null) {
            return request.getRemoteAddr();
        }
        return request.getHeader("x-forwarded-for");
    }

    /**
     * 获取用户真实IP地址，不使用request.getRemoteAddr();的原因是有可能用户使用了代理软件方式避免真实IP地址,
     * 可是，如果通过了多级反向代理的话，X-Forwarded-For的值并不止一个，而是一串IP值，究竟哪个才是真正的用户端的真实IP呢？
     * 答案是取X-Forwarded-For中第一个非unknown的有效IP字符串。
     *
     * @param request
     * @return
     */
    public static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if ("127.0.0.1".equals(ip) || "0:0:0:0:0:0:0:1".equals(ip)) {
            try {
                ip = InetAddress.getLocalHost().getHostAddress();
            } catch (Exception e) {
                ip = "";
            }
        }
        return ip;
    }

    /**
     * 把对象转化为整数，非整数则返回defaultNum
     *
     * @param obj
     * @param defaultNum
     * @return
     */
    public static int getInt(Object obj, int defaultNum) {
        String value = ClearTrim(obj);
        int num = defaultNum;
        if (value != null && !"".equals(value)) {
            try {
                num = Integer.parseInt(value);
            } catch (Exception ignored) {
            }
        }
        return num;
    }

    /**
     * 清除字符串两边的空格
     *
     * @param obj
     * @return
     */
    public static String ClearTrim(Object obj) {

        if (obj != null) {
            String result = obj.toString();
            String trim = result.trim();
            if (trim == null) {
                return "";
            } else {
                return trim;
            }
        } else {
            return "";
        }
    }


    /**
     * @param cal         开始日期
     * @param times       分隔次数 比如7 按天来算就是7天
     * @param field       需要使用Calendar.DAY_OF_YEAR 这样的参数 也就是Calendar的常量池
     * @param maps        不全的map列表 以keyStringX:xxx， valueString: XXX格式存放
     * @param keyString   map中使用的时间的key值
     * @param valueString map中使用的计数的key值
     * @return 返回一个 时间为key 计数为value的map列表
     * @description 根据入参 补全map列表
     */
    public static List<Map<String, Object>> complementMap(Calendar cal, Integer times, int field, List<Map<String, Object>> maps, String formatString, String keyString, String valueString) {
        SimpleDateFormat format = new SimpleDateFormat(formatString);
        Calendar now = (Calendar) cal.clone();
        Map<String, Object> map = new HashMap<>(8);
        for (Map<String, Object> objectMap : maps) {
            String time = objectMap.get(keyString).toString();
            map.put(time, objectMap.get(valueString));
        }
        List<Map<String, Object>> mapList = new ArrayList<>();
        for (int integer = 0; integer < times; integer++) {
            Map<String, Object> objectMap = new HashMap<>(2);
            String key = format.format(now.getTime());
            Object o = map.get(format.format(now.getTime()));
            if (o == null) {
                objectMap.put(key, "0");
            } else {
                objectMap.put(key, o.toString());
            }
            now.add(field, -1);
            mapList.add(objectMap);
        }
        return mapList;
    }

    /**
     * @param cal   开始日期
     * @param times 分隔次数 比如7 按天来算就是7天
     * @param field 需要使用Calendar.DAY_OF_YEAR 这样的参数 也就是Calendar的常量池
     * @param maps  不全的map列表 以keyStringX:xxx， valueString: XXX格式存放
     * @return 返回一个 时间为key 计数为value的map列表
     * @description 根据入参 补全map列表 keyString默认name valueString默认value
     */
    public static List<Map<String, Object>> complementMap(Calendar cal, Integer times, int field, List<Map<String, Object>> maps, String formatString) {
        return complementMap(cal, times, field, maps, formatString, "name", "value");
    }



}
