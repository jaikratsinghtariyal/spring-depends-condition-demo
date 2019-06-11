package com.tektutorial.spring.boot.custom.annotation;

import com.tektutorial.spring.boot.conditions.AppNestedCondition;
import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(AppNestedCondition.class)
public @interface ConditionalApp {
}
