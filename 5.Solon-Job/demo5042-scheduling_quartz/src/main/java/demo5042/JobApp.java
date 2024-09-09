package demo5042;

import org.noear.solon.Solon;
import org.noear.solon.scheduling.annotation.EnableScheduling;
import org.noear.solon.scheduling.quartz.JobManager;

/**
 * @author noear 2022/1/6 created
 */
@EnableScheduling
public class JobApp {
    public static void main(String[] args) {
        Solon.start(JobApp.class, args, app->{
            //如果需要别的什么处理？可以加个拦截器 //只对注解在函数上有效
            JobManager.getInstance().addJobInterceptor(0, (job, handler) -> {
                Thread.currentThread().setName(job.getName());
                handler.handle(job.getContext());
            });
        });
    }
}
