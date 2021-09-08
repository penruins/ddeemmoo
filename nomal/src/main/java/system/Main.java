package system;

import com.sun.management.OperatingSystemMXBean;
import lombok.extern.slf4j.Slf4j;

import java.lang.management.ManagementFactory;

public class Main {
  private static OperatingSystemMXBean operatingSystemMXBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

  public static void main(String[] args) throws InterruptedException {
    test002();
  }

  public static void test001() throws InterruptedException {
    while (true) {
      // 获取 CPU
      int percentCpuLoad = getCPUPercent();
      // 获取内存
      int percentMemoryLoad = getMemPercent();
      System.out.println("CPU = " + percentCpuLoad);
      System.out.println("MEM = " + percentMemoryLoad);
      Thread.sleep(1000);
    }
  }
  public static void test002() throws InterruptedException {
    while(true) {
      int cpuPercent = getCPUPercent();
      for(int i=0;i<cpuPercent;i++) {
        System.out.print("#");
      }
      System.out.println();
      Thread.sleep(1000);
    }
  }
  public static int getCPUPercent() {
    double cpuLoad = operatingSystemMXBean.getSystemCpuLoad();
    int percentCpuLoad = (int) (cpuLoad * 100);
    return percentCpuLoad;
  }
  public static int getMemPercent() {
    double totalvirtualMemory = operatingSystemMXBean.getTotalPhysicalMemorySize();
    double freePhysicalMemorySize = operatingSystemMXBean.getFreePhysicalMemorySize();
    double value = freePhysicalMemorySize/totalvirtualMemory;
    int percentMemoryLoad = (int) ((1-value) * 100);
    return percentMemoryLoad;
  }
}
