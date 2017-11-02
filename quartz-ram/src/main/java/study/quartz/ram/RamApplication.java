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
public class RamApplication {
    public static void main(String[] args) {

    }
}
