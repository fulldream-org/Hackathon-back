package hack.fulldream.hackathonback.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
public class HelloController {
  @GetMapping("/")
  public String greet() {
    return "Hello Spring !!!!";
  }
}
