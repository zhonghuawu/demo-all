package com.huaa.demo.rule.executor.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Desc:
 *
 * @author wuzhonghua
 * @date 4/9/21 5:27 下午
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {
    private String name;
    private String address;
}
