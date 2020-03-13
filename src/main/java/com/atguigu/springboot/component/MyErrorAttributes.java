package com.atguigu.springboot.component;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;


public  class MyErrorAttributes extends DefaultErrorAttributes {

    public MyErrorAttributes(){
        super(true);
    }
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {

        //调用父类的方法获取默认的数据
        Map<String, Object> map = new HashMap<>(super.getErrorAttributes(webRequest, includeStackTrace));
        map.put("company","atguigu");

        //从request域从获取到自定义数据
        //我们的异常处理器携带的数据
        Map<String,Object> ext = (Map<String, Object>) webRequest.getAttribute("ext", RequestAttributes.SCOPE_REQUEST);
        map.put("ext",ext);
        return map;
    }
}
