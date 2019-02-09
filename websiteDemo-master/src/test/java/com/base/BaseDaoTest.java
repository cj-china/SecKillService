package com.base;

import com.secKillService.SecKillServiceApplication;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = SecKillServiceApplication.class)
public class BaseDaoTest {

    static {
//      System.setProperty("spring.profiles.active", "dev");
    }

    @Before
    public void before() {
      System.out.println("before:--------------------------------------------------");
    }

    @After
    public void after() {
      System.out.println("after:--------------------------------------------------");
  }
}
