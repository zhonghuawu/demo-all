package com.huaa.demo.vertx;

import io.vertx.core.AbstractVerticle;
import lombok.extern.slf4j.Slf4j;

/**
 * Desc:
 *
 * @author wuzhonghua
 * @date 2021/6/28 00:28
 */
@Slf4j
public class VerticleDemo extends AbstractVerticle {

    @Override
    public void start() {
        log.info("VerticleDemo start");
    }

    @Override
    public void stop() {
        log.info("VerticleDemo stop");
    }
}
