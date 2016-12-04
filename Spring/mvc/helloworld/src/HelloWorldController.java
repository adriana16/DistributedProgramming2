package helloworld.web;
import java.io.IOException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

  @RequestMapping("/hw.htm")
  public ModelAndView handleRequest() {
    ModelAndView modelAndView = new ModelAndView("hello");
    modelAndView.addObject("message", "Hello World MVC!");
    modelAndView.addObject("date",(new java.util.Date()).toString());
    return modelAndView;
  }
}
