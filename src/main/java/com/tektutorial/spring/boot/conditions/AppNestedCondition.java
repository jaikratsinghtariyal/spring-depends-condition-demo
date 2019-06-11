package com.tektutorial.spring.boot.conditions;

import org.springframework.boot.autoconfigure.condition.AnyNestedCondition;
import org.springframework.context.annotation.Conditional;

public class AppNestedCondition extends AnyNestedCondition {

    public AppNestedCondition() {
        super(ConfigurationPhase.REGISTER_BEAN);
    }

    @Conditional(CustomConditionFirst.class)
    static class OnCustomConditionFirst {
    }

    @Conditional(CustomConditionSecond.class)
    static class OnCustomConditionSecond {
    }
}
