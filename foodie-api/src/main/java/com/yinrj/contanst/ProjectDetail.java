package com.yinrj.contanst;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author yinrongjie
 * @version 1.0
 * @description
 * @date 2021/4/24
 */
@Configuration
@ConfigurationProperties
@Data
@PropertySource(value = "classpath:custom/custom.properties", encoding = "UTF-8")
public class ProjectDetail {
    @Value("${project.detail.name}")
    private String projectName;

    @Value("${project.detail.version}")
    private String version;

    @Value("${project.detail.user.name}")
    private String userName;

    @Value("${project.detail.user.email}")
    private String email;
}
