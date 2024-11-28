package com.kanban.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
<<<<<<< HEAD

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000")  // 允许的源
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // 允许的请求方法
                .allowedHeaders("*")  // 允许的头部
                .allowCredentials(true);  // 允许携带凭证
    }
}

=======
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*") // 或者指定特定的来源
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
>>>>>>> b5dc19de15dcf86a592376c6ba27475bc7288e1a
