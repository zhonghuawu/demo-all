package com.huaa.demo.rule.executor;

/**
 * Desc:
 *
 * @author wuzhonghua
 * @date 4/9/21 5:27 下午
 */
public interface IRule<T> {

    boolean execute(T t);

    String getReason();

}
