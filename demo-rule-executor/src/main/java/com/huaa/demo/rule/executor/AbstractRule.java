package com.huaa.demo.rule.executor;

import lombok.Getter;
import lombok.Setter;

import java.util.function.Function;

/**
 * Desc:
 *
 * @author wuzhonghua
 * @date 4/9/21 5:29 下午
 */
public abstract class AbstractRule<T, E> implements IRule<T> {

    @Getter
    @Setter
    protected String reason = "Invalid Parameters";

    @Override
    public boolean execute(T t) {
        return doExecute(getConverter().apply(t));
    }

    /**
     * convert rawType to other type for doing executor
     */
    protected abstract Function<T, E> getConverter();

    protected boolean doExecute(E e) {
        return true;
    }

}
