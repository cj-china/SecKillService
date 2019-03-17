/**
 * 测试递归：自己调自己
 */
public class TestRecursion01 {
 public static void main(String[] args){
     a();
 }
  static int count=0;
  static void a(){
    System.out.println("a");
    count++;
    if(count<10){
      a();
    }else {
      return;
    }
  }
}
