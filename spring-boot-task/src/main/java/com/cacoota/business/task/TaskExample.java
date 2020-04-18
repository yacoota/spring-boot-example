package com.cacoota.business.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TaskExample {

    @Scheduled(fixedRateString = "${example.task.hack.fixed}", initialDelayString = "${example.task.hack.init}")
    public void execute() {
        log.info("定时任务执行：{}", this);
    }
}
