package com.huaa.demo.rule.executor.account.rules;

import com.huaa.demo.rule.executor.AbstractRule;
import com.huaa.demo.rule.executor.dto.AccountDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.util.StringUtils;

import java.util.function.Function;

/**
 * Desc:
 *
 * @author wuzhonghua
 * @date 4/9/21 6:00 下午
 */
@AllArgsConstructor
public class NameRule extends AbstractRule<AccountDto, String> {

    private final int maxLength;

    @Getter
    private final Function<AccountDto, String> converter = AccountDto::getName;

    @Override
    protected boolean doExecute(String name) {
        if (!StringUtils.hasText(name)) {
            super.setReason("name is required");
            return false;
        }
        if (name.length() > maxLength) {
            super.setReason("name length must less then [" + maxLength + "]");
            return false;
        }
        return true;
    }

}
