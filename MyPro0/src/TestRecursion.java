public class TestRecursion {
  public static void main(String[] args){
    long a=System.currentTimeMillis();
    System.out.println(facorial(10));
    long a1=System.currentTimeMillis();
    System.out.println("递归调用耗时："+(a1-a)+"ms");

    System.out.println(result(10));
  }
  static long facorial(long n){
    if(n==1){
      return 1;
    }else {
      return n*facorial(n-1);
    }
  }

  static long result(long n){
    long result=1;
    long a=System.currentTimeMillis();
    while (n>1){
      result*=n*(n-1);
      n-=2;
    }
    long a1=System.currentTimeMillis();
    System.out.println("循环方法耗时:"+(a1-a)+"ms");
    return result;
  }

}
