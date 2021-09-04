package com.huaa.demo.vertx;

import io.vertx.core.Vertx;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Desc:
 *
 * @author wuzhonghua
 * @date 2021/6/28 01:15
 */
@Slf4j
@Component
@AllArgsConstructor
public class Starter {

    private final Vertx vertx;

    @PostConstruct
    public void init() {
        final long startTime = System.currentTimeMillis();
        vertx.deployVerticle(new VerticleDemo())
                .onSuccess(deploymentId -> {
                    log.info("deploy [{}]", deploymentId);
                    long timeId = vertx.setTimer(5 * 1000L, id -> {
                        log.info("inner timeId[{}]", id);
                        vertx.undeploy(deploymentId)
                                .onSuccess(v -> log.info("undeploy [{}]", deploymentId));
                        final long cost = System.currentTimeMillis() - startTime;
                        log.info("cost: {} ms", cost);
                    });
                    log.info("outer timeId[{}]", timeId);
                })
                .onFailure(e -> {
                    log.error("init:", e);
                });
    }

}
