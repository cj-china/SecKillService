package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestThread3 {
  public static void main(String[] args){
   ScheduledExecutorService scheduledThreadPool=Executors.newScheduledThreadPool(5);
  scheduledThreadPool.schedule(new Runnable() {
    @Override
    public void run() {
      System.out.println("delay 3 seconds");
    }
  },3,TimeUnit.SECONDS);
  }
}
