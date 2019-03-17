package reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestCase2 {
  public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException,
      InstantiationException, InvocationTargetException {
      Class clazz=Class.forName("reflect.B");
      Object obj=clazz.newInstance();
    Method[] methods=clazz.getDeclaredMethods();
    for(Method method:methods){
      String mName=method.getName();
      if(mName.startsWith("test")){
        method.invoke(obj);
      }
    }
  }
}
