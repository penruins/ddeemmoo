package com.example.springboot0007responseentity;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
  @RequestMapping("/responseOK")
  public ResponseEntity<String> responseOK() {
    return new ResponseEntity<>(HttpStatus.OK);
  }
  @RequestMapping("/responseACCEPTED")
  public ResponseEntity<String> responseACCEPTED() {
    return new ResponseEntity<>(HttpStatus.ACCEPTED);
  }
  @RequestMapping("/responseOKWithContent")
  public ResponseEntity<String> responseOKWithContent() {
    return new ResponseEntity<>("response OK with content",HttpStatus.OK);
  }
  @RequestMapping("/responseOKWithHeader")
  public ResponseEntity<String> responseOKWithHeader() {

    HttpHeaders headers = new HttpHeaders();
    headers.add("penruins","you dont give up, then there's no limitation");

    return new ResponseEntity<>(headers , HttpStatus.OK);
  }
  @RequestMapping("/responseOKWithHeaderAndContent")
  public ResponseEntity<String> responseOKWithHeaderAndContent() {

    HttpHeaders headers = new HttpHeaders();
    headers.add("penruins","you dont give up, then there's no limitation");

    return new ResponseEntity<>("response ok with header and content",headers , HttpStatus.OK);
  }
  @RequestMapping("/responseOKWithHeaderAndContentChain")
  public ResponseEntity<String> responseOKWithHeaderAndContentChain() {

    return ResponseEntity.ok()
      .header("penruins","you dont give up then there's no limitation")
      .body("response ok with header and content chain");

  }
}
