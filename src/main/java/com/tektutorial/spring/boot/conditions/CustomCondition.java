package com.tektutorial.spring.boot.conditions;

import com.tektutorial.spring.boot.beans.ConditionBean;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class CustomCondition implements Condition {

    @Override
    public boolean matches(
            ConditionContext context,
            AnnotatedTypeMetadata metadata) {
        ConditionBean conditionBean = (ConditionBean) context.getBeanFactory().getBean("ConditionBean");
        return conditionBean != null;
    }
}
