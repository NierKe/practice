package com.dk.demo1.config;
 
import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
 
 
@Configuration
public class ExecutorConfig extends AsyncConfigurerSupport {
 

    @Bean
    @Override
    public ThreadPoolTaskExecutor getAsyncExecutor() {
        // 获取当前机器CPU核数
        int cpuProcessors = Runtime.getRuntime().availableProcessors();
        if (cpuProcessors == 0) {
            cpuProcessors = 4;
        }
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(cpuProcessors);
        executor.setMaxPoolSize(cpuProcessors+1);
        // 线程池维护线程所允许的空闲时间
        executor.setKeepAliveSeconds(60);
        // 队列长度
        executor.setQueueCapacity(1000);
        // 等待任务执行完成在关闭
        executor.setWaitForTasksToCompleteOnShutdown(true);
        //该方法用来设置线程池中任务的等待时间，如果超过这个时候还没有销毁就强制销毁，以确保应用最后能够被关闭，而不是阻塞住。
        executor.setAwaitTerminationSeconds(60);
        // 线程前缀名称
        executor.setThreadNamePrefix("async-service-");
        // 配置拒绝策略：如果队列满了，继续往队列增加数据，则直接丢弃
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
        executor.initialize();
        return executor;

    }
 
}
 