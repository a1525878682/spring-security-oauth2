package com.liyx.auth.translator;

import java.util.HashMap;

/**
 * @author ouyangxiap
 * @version 1.0
 * @date 2020/8/26 16:08
 */
public class CommonResponse extends HashMap<String, Object> {

    private static final long serialVersionUID = -8713837118340960775L;

    public CommonResponse message(String message,String code) {
        this.put("message", message);
        this.put("code",code);
        return this;
    }

    public CommonResponse message(String message) {
        this.put("message", message);
        return this;
    }

    public CommonResponse data(Object data) {
        this.put("data", data);
        return this;
    }

    @Override
    public CommonResponse put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    public String getMessage() {
        return String.valueOf(get("message"));
    }

    public Object getData() {
        return get("data");
    }
}