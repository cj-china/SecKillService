/**
 * 测试方法的重载
 *重载：方法名相同，参数列表不同
 */
public class TestOverload {
  public static void main(String[] args){
    System.out.println(add(1,2));
    System.out.println(add(1,2,3));
    System.out.println(add(1.2,3));
  }

  //求和的方法
  public static int add(int n1,int n2){
    int sum=n1+n2;
    return sum;
  }
  //方法名相同，参数列表不同构成重载
  public static int add(int n1,int n2,int n3){
    int sum=n1+n2+n3;
    return sum;
  }
  public static int add(double n1,int n2){
    int sum=(int)(n1+n2);
    return sum;
  }

}
