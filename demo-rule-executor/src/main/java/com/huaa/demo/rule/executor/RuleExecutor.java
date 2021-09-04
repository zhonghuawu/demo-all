package com.huaa.demo.rule.executor;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.huaa.demo.rule.executor.exception.RuleException;
import org.springframework.data.util.Pair;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * Desc:
 *
 * @author wuzhonghua
 * @date 4/9/21 6:09 下午
 */
public class RuleExecutor<T> {

    public enum LogicalOperator {

        /**
         * logical operator
         */
        AND {
            @Override
            public <D> Pair<Boolean, String> predicate(D d, List<IRule<D>> rules) {
                for (IRule<D> rule : rules) {
                    if (!rule.execute(d)) {
                        return FAIL.apply(rule.getReason());
                    }
                }
                return OK;
            }
        },

        OR {
            @Override
            public <D> Pair<Boolean, String> predicate(D d, List<IRule<D>> rules) {
                for (IRule<D> rule : rules) {
                    if (rule.execute(d)) {
                        return FAIL.apply(rule.getReason());
                    }
                }
                return OK;
            }
        },
        ;

        private static final Pair<Boolean, String> OK = Pair.of(true, "OK");
        private static final Function<String, Pair<Boolean, String>> FAIL = reason -> Pair.of(false, reason);

        public abstract <D> Pair<Boolean, String> predicate(D d, List<IRule<D>> rules);

    }

    public static <T> RuleExecutor<T> create() {
        return new RuleExecutor<>();
    }

    /**
     * todo: need to support embed logical
     */
    private final Map<LogicalOperator, List<IRule<T>>> map = Maps.newHashMap();

    public RuleExecutor<T> and(IRule<T> rule) {
        map.computeIfAbsent(LogicalOperator.AND, o -> Lists.newArrayList()).add(rule);
        return this;
    }

    public RuleExecutor<T> or(IRule<T> rule) {
        map.computeIfAbsent(LogicalOperator.OR, o -> Lists.newArrayList()).add(rule);
        return this;
    }

    public boolean execute(T t) throws RuleException {
        for (Map.Entry<LogicalOperator, List<IRule<T>>> entry : map.entrySet()) {
            Pair<Boolean, String> pair = entry.getKey().predicate(t, entry.getValue());
            if (!pair.getFirst()) {
                throw new RuleException(pair.getSecond());
            }
        }
        return true;
    }

}
