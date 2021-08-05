package date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {
  public static void main(String[] args) {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    Date now = new Date();
    String d1 = sdf1.format(now);
    String d2 = sdf2.format(now) + " 00:00:00";

    Calendar rightNow = Calendar.getInstance();
    rightNow.setTime(now);
    rightNow.add(Calendar.DAY_OF_YEAR,-7);
    String d3 = sdf2.format(rightNow.getTime()) + " 00:00:00";

    rightNow.setTime(now);
    rightNow.add(Calendar.DAY_OF_YEAR,-30);
    String d4 = sdf2.format(rightNow.getTime()) + " 00:00:00";

    System.out.println("此时此刻的时间 " + d1);
    System.out.println("今天最早的时间 " + d2);
    System.out.println("7天前时间 " + d3);
    System.out.println("30天前时间 " + d4);
  }
}
