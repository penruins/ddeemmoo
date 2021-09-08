package chart;

import java.io.File;
import java.util.Vector;

import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.junit.Test;

public class ChartFactoryTest {

  /**
   * 测试柱状图
   *
   * @throws Exception
   */
  @Test
  public void testCreateBarChart() throws Exception {
    // 标注类别
    String[] categories = { "Jan", "Feb", "Mar", "Apr", "May", "Jun",
      "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
    Vector<Serie> series = new Vector<Serie>();
    // 柱子名称：柱子所有的值集合
    series.add(new Serie("Tokyo", new Double[] { 49.9, 71.5, 106.4, 129.2,
      144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4 }));
    series.add(new Serie("New York", new Double[] { 83.6, 78.8, 98.5, 93.4,
      106.0, 84.5, 105.0, 104.3, 91.2, 83.5, 106.6, 92.3 }));
    series.add(new Serie("London", new Double[] { 48.9, 38.8, 39.3, 41.4,
      47.0, 48.3, 59.0, 59.6, 52.4, 65.2, 59.3, 51.2 }));
    series.add(new Serie("Berlin", new Double[] { 42.4, 33.2, 34.5, 39.7,
      52.6, 75.5, 57.4, 60.4, 47.6, 39.1, 46.8, 51.1 }));

    String title = "Monthly Average Rainfall";
    String categoryAxisLabel = "";
    String valueAxisLabel = "Rainfall (mm)";
    JFreeChart chart = ChartFactory.createBarChart(title,
      categoryAxisLabel, valueAxisLabel, series, categories);

    File file = new File("C:\\Users\\liuxiang37\\code\\ddeemmoo\\barChart.jpeg");
    int width = 1024;
    int height = 420;
    ChartUtilities.saveChartAsJPEG(file, chart, width, height);
  }

  /**
   * 测试饼图
   *
   * @throws Exception
   */
  @Test
  public void testCreatePieChart() throws Exception {
    String[] categories = { "Bananas", "Kiwi", "Mixed nuts", "Oranges",
      "Apples", "Pears", "Clementines", "Reddish (bag)",
      "Grapes (bunch)", };
    Object[] datas = { 8, 3, 1, 6, 8, 4, 4, 1, 1 };
    String title = "Contents of Highsoft's weekly fruit delivery";
    JFreeChart chart = ChartFactory
      .createPieChart(title, categories, datas);
    File file = new File("D:\\jfreechart\\pieChart.jpeg");
    int width = 1024;
    int height = 420;
    ChartUtilities.saveChartAsJPEG(file, chart, width, height);
  }

  /**
   * 测试折线图
   *
   * @throws Exception
   */
  @Test
  public void testCreateLineChart() throws Exception {
    // 标注类别
    String[] categories = { "Jan", "Feb", "Mar", "Apr", "May", "Jun",
      "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
    Vector<Serie> series = new Vector<Serie>();
    // 柱子名称：柱子所有的值集合
    series.add(new Serie("Tokyo", new Double[] { 49.9, 71.5, 106.4, 129.2,
      144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4 }));
    series.add(new Serie("New York", new Double[] { 83.6, 78.8, 98.5, 93.4,
      106.0, 84.5, 105.0, 104.3, 91.2, 83.5, 106.6, 92.3 }));
    series.add(new Serie("London", new Double[] { 48.9, 38.8, 39.3, 41.4,
      47.0, 48.3, 59.0, 59.6, 52.4, 65.2, 59.3, 51.2 }));
    series.add(new Serie("Berlin", new Double[] { 42.4, 33.2, 34.5, 39.7,
      52.6, 75.5, 57.4, 60.4, 47.6, 39.1, 46.8, 51.1 }));

    String title = "Monthly Average Rainfall";
    String categoryAxisLabel = "";
    String valueAxisLabel = "Rainfall (mm)";
    JFreeChart chart = ChartFactory.createLineChart(title,
      categoryAxisLabel, valueAxisLabel, series, categories);
    File file = new File("D:\\jfreechart\\lineChart.jpeg");
    int width = 1024;
    int height = 420;
    ChartUtilities.saveChartAsJPEG(file, chart, width, height);
  }

  /**
   * 测试StackedBarChart
   *
   * @throws Exception
   */
  @Test
  public void testCreateStackedBarChart() throws Exception {
    // 标注类别
    String[] categories = { "Jan", "Feb", "Mar", "Apr", "May", "Jun",
      "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
    Vector<Serie> series = new Vector<Serie>();
    // 柱子名称：柱子所有的值集合
    series.add(new Serie("Tokyo", new Double[] { 49.9, 71.5, 106.4, 129.2,
      144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4 }));
    series.add(new Serie("New York", new Double[] { 83.6, 78.8, 98.5, 93.4,
      106.0, 84.5, 105.0, 104.3, 91.2, 83.5, 106.6, 92.3 }));
    series.add(new Serie("London", new Double[] { 48.9, 38.8, 39.3, 41.4,
      47.0, 48.3, 59.0, 59.6, 52.4, 65.2, 59.3, 51.2 }));
    series.add(new Serie("Berlin", new Double[] { 42.4, 33.2, 34.5, 39.7,
      52.6, 75.5, 57.4, 60.4, 47.6, 39.1, 46.8, 51.1 }));
    String title = "Monthly Average Rainfall";
    String domainAxisLabel = "";
    String rangeAxisLabel = "Rainfall (mm)";
    JFreeChart chart = ChartFactory.createStackedBarChart(title,
      domainAxisLabel, rangeAxisLabel, series, categories);
    File file = new File("D:\\jfreechart\\stackedBarChart.jpeg");
    int width = 1024;
    int height = 420;
    ChartUtilities.saveChartAsJPEG(file, chart, width, height);
  }
}
