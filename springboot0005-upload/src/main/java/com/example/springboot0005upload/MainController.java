package com.example.springboot0005upload;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @RestController 注解相当于 @ResponseBody + @Controller 合在一起的作用
 * 如果使用 @RestController, 则 Controller 类中的方法无法返回 jsp 页面，配置的
 * 视图解析器 InternalResourceResolver 则不起作用，返回的内容就是 Return 里的内容
 *
 * @Controller 标识一个 Spring
 */
@Controller
public class MainController {

  private static final String UPLOADED_FOLDER = "";

  @GetMapping("/")
  public String index() {
    return "upload";
  }

  /**
   * 通过 MultipartFile 读取文件信息，如果文件为空跳转到结果页并给出提示；如果不为空读取文件流并写入到指定目录，最后将结果展示到页面
   *
   * MultipartFile 是 Spring 上传文件的封装类，包含了文件的二进制流和文件属性等信息，在配置文件中也可对相关属性进行配置
   *
   * spring.http.multipart.enabled=true # 默认支持文件上传
   * spring.http.multipart.file-size-threshold=0 # 支持文件写入磁盘
   * spring.http.multipart.location= # 上传文件的临时目录
   * spring.http.multipart.max-file-size=1Mb # 最大支持文件大小
   * spring.http.multipart.max-request-size=10Mb # 最大支持请求大小
   *
   * 最常用的是最后两个配置内容，限制文件上传大小，上传时超过大小会抛异常
   *
   * @param file
   * @param redirectAttributes
   * @return
   */
  @PostMapping("/upload")
  public String singleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
    if(file.isEmpty()) {
      redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
      return "redirect:uploadStatus";
    }

    try {
      // Get the file and save it somewhere
      byte[] bytes = file.getBytes();
      Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
      Files.write(path,bytes);

      redirectAttributes.addFlashAttribute("message", "You successfully uploaded" + file.getOriginalFilename());

    } catch (IOException e) {
      e.printStackTrace();
    }

    return "redirect:/uploadStatus";
  }
}
