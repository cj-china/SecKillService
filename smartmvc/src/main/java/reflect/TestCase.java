package reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class TestCase {
  public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException,
      InstantiationException, InvocationTargetException {
    Scanner scanner=new Scanner(System.in);
    String className=scanner.nextLine();
    System.out.println("className:"+className);
    
    Class clazz=Class.forName(className);
    Object obj=clazz.newInstance();
    System.out.println("obj:"+obj);

    //找出所有的方法
    Method[] methods=clazz.getDeclaredMethods();

    //遍历方法
    for(Method method:methods){
      String mName=method.getName();
      System.out.println("mName:"+mName);
      /*
       * 调用方法:
       * 要区分目标方法是否带参,
       * 可以调用getParameterTypes方法
       * 来获得目标方法的参数类型信息。
       * 如果types长度为0，表示目标方法
       * 不带参。
       */
      Class[] types=method.getParameterTypes();
      Object returnVal=null;
      if(types.length>0){
        //目标方法带参
        Object[] params=new Object[types.length];
        for(int i=0;i<types.length;i++){
          if(types[i]==String.class){
            params[i]="Giving";
          }
          if(types[i]==int.class){
            params[i]=100;
          }
        }
        returnVal=method.invoke(obj,params);
      }else {
        returnVal=method.invoke(obj);
      }
    }


  }
}
