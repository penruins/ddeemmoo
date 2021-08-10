package random;

public class NumberRandom {
  public static void main(String[] args) {
    test001();
  }
  public static int randomNumber(int number) {
    return (int)(Math.random() * number);
  }
  public static void test001() {
    for(int i=0;i<5;i++) {
      System.out.println(randomNumber(80));
    }
  }
}
