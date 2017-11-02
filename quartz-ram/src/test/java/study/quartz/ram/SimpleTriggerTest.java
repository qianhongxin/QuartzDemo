package study.quartz.ram;

import org.junit.Test;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import study.quartz.ram.job.HelloJob;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * Created by Red on 2017/11/1.
 */
public class SimpleTriggerTest {

    @Test
    public void test() {
        try {
            //Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            //scheduler.start();
            //scheduler.shutdown();
            SchedulerFactory schedulerFactory = new StdSchedulerFactory();
            Scheduler scheduler = schedulerFactory.getScheduler();

            scheduler.start();

            JobDetail helloJob = JobBuilder.newJob(HelloJob.class)
                    .withIdentity("myJob", "group1")
                    .build();

            Trigger helloTrigger = TriggerBuilder.newTrigger()
                    .withIdentity("myTrigger", "group1")
                    .startNow()
                    .withSchedule(simpleSchedule().withIntervalInSeconds(3)
                            .repeatForever())
                    .build();

            scheduler.scheduleJob(helloJob, helloTrigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
