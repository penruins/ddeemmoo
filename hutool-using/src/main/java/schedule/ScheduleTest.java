package schedule;

import cn.hutool.core.lang.Console;
import cn.hutool.cron.CronUtil;
import cn.hutool.cron.task.Task;

public class ScheduleTest {
  public static void main(String[] args) {
    test001();

  }
  public static void test001() {
    CronUtil.schedule("*/2 * * * * *", new Task() {
      @Override
      public void execute() {
        Console.log("Task executed.");
      }
    });
    CronUtil.setMatchSecond(true);
    CronUtil.start();
  }
}
