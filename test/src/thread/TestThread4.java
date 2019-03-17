package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThread4 {
  public static void main(String[] args){
    ExecutorService singleThreadExecutor= Executors.newSingleThreadExecutor();
    for(int i=0;i<10;i++){
      final int index=i;
      singleThreadExecutor.execute(new Runnable() {
        @Override
        public void run() {
          System.out.println(index);
          try {
            Thread.sleep(2000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      });
    }
  }
}
