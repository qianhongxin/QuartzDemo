package study.quartz.ram;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import study.quartz.ram.job.HelloJob;

import static org.quartz.JobBuilder.*;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.*;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.*;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * Created by Red on 2017/10/28.
 */
public class RamTest {
    public static void main(String[] args) {
        try {
            //Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            //scheduler.start();
            //scheduler.shutdown();

            SchedulerFactory schedulerFactory = new StdSchedulerFactory();
            Scheduler scheduler = schedulerFactory.getScheduler();

            scheduler.start();

            JobDetail helloJob = newJob(HelloJob.class)
                    .withIdentity("myJob", "group1")
                    .build();

            Trigger helloTrigger = newTrigger()
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
