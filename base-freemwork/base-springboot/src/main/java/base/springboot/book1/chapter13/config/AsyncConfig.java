package base.springboot.book1.chapter13.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author Clay
 * @date 2019/12/23 19:40
 */
@Configuration
@EnableAsync
public class AsyncConfig  implements AsyncConfigurer {

    //定义线程池
    @Override
    public Executor getAsyncExecutor() {
        //定义线程池
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();

        //核心线程数
        taskExecutor.setCorePoolSize(10);
        //线程池最大线程数
        taskExecutor.setMaxPoolSize(30);
        //初始化
        taskExecutor.initialize();

        return taskExecutor;
    }
}
