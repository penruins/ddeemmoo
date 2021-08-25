package common;

public class PrintUtils {
  public static void printDelimiter(String header) {
    for(int i=0;i<30;i++) {
      if(i == 14) {
        System.out.print("  " + header + "  ");
      } else {
        System.out.print("#");
      }
    }
    System.out.println();
  }
}
