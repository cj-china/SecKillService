package reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class TestCase3 {
  public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException,
      InstantiationException, InvocationTargetException {
    Scanner scanner=new Scanner(System.in);
    String className=scanner.nextLine();
    Class clazz=Class.forName(className);
    Object obj=clazz.newInstance();
    Method[] methods=clazz.getDeclaredMethods();
    for(Method method:methods){
      Test test=method.getDeclaredAnnotation(Test.class);
      System.out.println("@Test:"+test);
      if(test!=null){
        method.invoke(obj);
        //读取注解的属性值
        String value=test.vlaue();
        System.out.println("value:"+value);
      }
    }
  }
}
