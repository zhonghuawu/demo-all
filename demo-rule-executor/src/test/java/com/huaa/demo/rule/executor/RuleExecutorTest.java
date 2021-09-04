package com.huaa.demo.rule.executor;

import com.huaa.demo.rule.executor.account.rules.AddressRule;
import com.huaa.demo.rule.executor.account.rules.NameRule;
import com.huaa.demo.rule.executor.dto.AccountDto;
import org.junit.jupiter.api.Test;

class RuleExecutorTest {


    @Test
    void execute() {

        final AccountDto accountDto = AccountDto.builder()
                .name("rule")
                .address("singapore")
                .build();

        boolean result = RuleExecutor.<AccountDto>create()
                .and(new NameRule(3))
                .and(new AddressRule(1000))
                .execute(accountDto);

        System.out.println(result);

        assert result;

    }

}