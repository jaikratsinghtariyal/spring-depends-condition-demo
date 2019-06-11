package com.tektutorial.spring.boot.config;

import com.tektutorial.spring.boot.beans.*;
import com.tektutorial.spring.boot.conditions.AppNestedCondition;
import com.tektutorial.spring.boot.conditions.CustomCondition;
import com.tektutorial.spring.boot.custom.annotation.ConditionalApp;
import org.springframework.boot.autoconfigure.condition.*;
import org.springframework.boot.cloud.CloudPlatform;
import org.springframework.boot.system.JavaVersion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    @ConditionalOnProperty(
            value = "emp.address.enabled",
            havingValue = "true",
            matchIfMissing = false
    )
    public Address getAddress(){
        return new Address();
    }

    @Bean
    @ConditionalOnExpression(
            "${module.emp.enabled} and ${module.submodule.enabled:true}"
    )
    @ConditionalOnBean(Address.class)
    public Employee getEmployee(){
        return new Employee();
    }

    @Bean
    @ConditionalOnMissingBean(
            NotABean.class
    )
    public Name getName(){
        return new Name();
    }

    @Bean
    @ConditionalOnResource(
            resources = "/application.properties"
    )
    public NoResourceBean getNoResourceBean(){
        return new NoResourceBean();
    }

    @Bean
    @ConditionalOnClass(
            name = "org.springframework.boot.web.embedded.tomcat.TomcatWebServer"
    )
    public ClassPathBean getClassPathBean(){
        return new ClassPathBean();
    }

    @Bean
    @ConditionalOnMissingClass(
            value = "class.not.found"
    )
    public MissingClassBean getMissingClassBean(){
        return new MissingClassBean();
    }

    @Bean
    @ConditionalOnJndi(
            value = "java:comp/env/foo"
    )
    public JNDIClass getJNDIClass(){
        return new JNDIClass();
    }

    @Bean
    @ConditionalOnJava(
            value = JavaVersion.EIGHT
    )
    public JavaBean getJavaBean(){
        return new JavaBean();
    }

    @Bean
    @ConditionalOnSingleCandidate(
            value = Employee.class
    )
    public SingleCandidateBean getSingleCandidateBean(){
        return new SingleCandidateBean();
    }

    @Bean
    @ConditionalOnWebApplication
    public WebApplicationBean getWebApplicationBean(){
        return new WebApplicationBean();
    }

    @Bean
    @ConditionalOnNotWebApplication
    public NotWebApplication getNotWebApplication(){
        return new NotWebApplication();
    }

    @Bean
    @ConditionalOnCloudPlatform(CloudPlatform.HEROKU)
    public CloudApplicationBean getCloudApplicationBean(){
        return new CloudApplicationBean();
    }

    @Bean
    @Conditional(CustomCondition.class)
    public CustomConditionBean getCustomConditionBean(){
        return new CustomConditionBean();
    }

    @Bean
    @ConditionalApp
    public NestedConditionBean getNestedConditionBean(){
        return new NestedConditionBean();
    }
}
