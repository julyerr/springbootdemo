package com.julyerr.springboot.mvc.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

//@Configuration
//public class Config extends WebMvcConfigurationSupport {
//    @Override
//    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        super.configureMessageConverters(converters);
//        /*
//         * 先创建一个convert对象
//         * 配置convert实例config
//         * 添加到总的converts中
//         * */
//
//        FastJsonHttpMessageConverter messageConverter = new FastJsonHttpMessageConverter();
//        FastJsonConfig jsonConfig = new FastJsonConfig();
//        jsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
////        处理中文乱码问题
//        List<MediaType> fastMediaTypes = new ArrayList<>();
//        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
//        messageConverter.setSupportedMediaTypes(fastMediaTypes);
//
//        messageConverter.setFastJsonConfig(jsonConfig);
//        converters.add(messageConverter);
//    }
//
//
//    @Override
//    protected void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new InterceptorConfig()).addPathPatterns("/**");
//        super.addInterceptors(registry);
//    }
//}

//@Configuration
//public class Config implements WebMvcConfigurer {
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new InterceptorConfig()).addPathPatterns("/**");
//    }
//}
