package com.atguigu.springboot.config;

import com.atguigu.springboot.component.MyErrorAttributes;
import com.atguigu.springboot.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


//使用webMvcConfigurerAdapter可以来扩展SpringMvc的功能
//@EnableWebMvc   不要接管SpringMvc
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer configurer = new WebMvcConfigurer(){
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                //super.addViewControllers(registry)
                //浏览器发送 /atguigu请求来到success
                registry.addViewController("/atguigu").setViewName("success");
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");

            }
            //注册拦截器
            @Override
            public void addInterceptors (InterceptorRegistry registry){
                //super.addInterceptors(registry);
                //静态资源；  *.css , *.js
                //SpringBoot已经做好了静态资源映射
                /*registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns
                        ("/**")
                        .excludePathPatterns("/index.html", "/", "/user/login","/asserts/**","/webjars/**");*/
            }

        };
        return configurer;
    }




    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }


    @Bean
    public MyErrorAttributes errorAttributes() {
        return new MyErrorAttributes();
    }
}
