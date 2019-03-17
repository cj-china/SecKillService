package reflect;



public class C {
  public void f1() {
    System.out.println("C的f1方法");
  }

  @Test(vlaue = "TOM")
  public void f2() {
    System.out.println("C的f2方法");
  }

  @Test(vlaue = "JERRY")
  public void hello() {
    System.out.println("C的hello方法");
  }
}


