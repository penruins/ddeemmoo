package excel;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;

import java.util.List;

/**
 * https://www.hutool.cn/docs/#/poi/Excel%E8%AF%BB%E5%8F%96-ExcelReader
 *
 * 要引入一个额外的依赖
 */
public class ExcelTest {
  public static void main(String[] args) {
    ExcelReader reader = ExcelUtil.getReader("C:\\Users\\liuxiang37\\Desktop\\channel_src.xls");
    List<List<Object>> readAll = reader.read();
    for(List<Object> list : readAll) {
      for(Object o : list) {
        System.out.print(o + " ");
      }
      System.out.println();
    }
    System.out.println(readAll.size());
  }
}
