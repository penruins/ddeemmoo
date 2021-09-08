package chart;

import lombok.Data;

import java.util.Vector;

/**
 *  https://gitee.com/coding4j/jfreechart
 */
@Data
public class Serie {
  private String name;
  private Vector<Object> data;

  public Serie() {

  }

  public Serie(String name, Vector<Object> data) {
    this.name = name;
    this.data = data;
  }

  public Serie(String name, Object[] array) {
    this.name = name;
    if(array != null) {
      data = new Vector<Object>(array.length);
      for(int i=0;i<array.length;i++) {
        data.add(array[i]);
      }
    }
  }
}
