package com.example.springboot0004springtask.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class OrderTimeOutCancelTask {

  // 每隔两秒钟执行一次
  @Scheduled(cron = "0/2 * * * * *")
  private void cancelTimeOutOrder() {
    System.out.println("取消订单，并根据 sku 编号释放锁定库存");
  }
}
