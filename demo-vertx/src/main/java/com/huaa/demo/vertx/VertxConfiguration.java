package com.huaa.demo.vertx;

import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Desc:
 *
 * @author wuzhonghua
 * @date 2021/6/28 00:13
 */
@Slf4j
@Configuration
public class VertxConfiguration {

    @Bean
    public Vertx vertx() {
        VertxOptions options = new VertxOptions();

        return Vertx.vertx(options);
    }

}
