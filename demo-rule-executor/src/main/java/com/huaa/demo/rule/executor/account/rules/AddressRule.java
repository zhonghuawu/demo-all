package com.huaa.demo.rule.executor.account.rules;

import com.huaa.demo.rule.executor.AbstractRule;
import com.huaa.demo.rule.executor.dto.AccountDto;
import com.huaa.demo.rule.executor.exception.RuleException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.util.StringUtils;

import java.util.function.Function;

/**
 * Desc:
 *
 * @author wuzhonghua
 * @date 4/9/21 5:40 下午
 */
@AllArgsConstructor
public class AddressRule extends AbstractRule<AccountDto, String> {

    private final int maxLength;

    @Getter
    private final Function<AccountDto, String> converter = AccountDto::getAddress;

    @Override
    protected boolean doExecute(String address) {
        if (!StringUtils.hasText(address)) {
            throw new RuleException("address is required");
        }
        // for sample
        if (address.contains("xxx")) {
            super.setReason("address contain invalid character");
            return false;
        }
        if (address.length() > maxLength) {
            super.setReason("address length must less then [" + maxLength + "]");
            return false;
        }
        return true;
    }

}
