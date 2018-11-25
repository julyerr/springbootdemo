package com.julyerr.springboot.mvc;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@ServletComponentScan
public class MvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(MvcApplication.class, args);
    }

    @Bean
    public HttpMessageConverters fastJsonMessageConverters() {
        FastJsonHttpMessageConverter messageConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig jsonConfig = new FastJsonConfig();
        jsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
//        处理中文乱码问题
        List<MediaType> fastMediaTypes = new ArrayList<>();
        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        messageConverter.setSupportedMediaTypes(fastMediaTypes);

        messageConverter.setFastJsonConfig(jsonConfig);
        return new HttpMessageConverters(messageConverter);
    }
}
