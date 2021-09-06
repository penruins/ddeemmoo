package com.example.springboot0005upload;

import org.apache.coyote.http11.AbstractHttp11Protocol;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Springboot0005UploadApplication {

  public static void main(String[] args) {
    SpringApplication.run(Springboot0005UploadApplication.class, args);
  }

  // tomcatEmbedded 这段代码是为了解决，上传文件大于 10M 出现连接重置的问题。此异常内容 GlobalnException 也捕获不到
  @Bean
  public TomcatServletWebServerFactory tomcatEmbedded() {
    TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
    tomcat.addConnectorCustomizers( (TomcatConnectorCustomizer) connector -> {
      if((connector.getProtocolHandler() instanceof AbstractHttp11Protocol<?>)) {
        // -1 means unlimited
        ((AbstractHttp11Protocol<?>) connector.getProtocolHandler()).setMaxSwallowSize(-1);
      }
    });
    return tomcat;
  }

}
