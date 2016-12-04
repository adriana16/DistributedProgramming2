package cmmdc.web;
import cmmdc.model.DouaNumere;
import cmmdc.service.CmmdcManager;
import cmmdc.service.DouaNumereValidator;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.validation.Errors;

@Controller
@RequestMapping("/cmmdcdata.htm")
public class CmmdcController {
  //@Autowired
  //private DouaNumereValidator validator;
  
  //prima pagina (apel GET)
  @RequestMapping(method = RequestMethod.GET)
  protected String metodaInitiala(ModelMap modelMap) {
    DouaNumere data=new DouaNumere();
    data.setSm("1");
    data.setSn("1");
    modelMap.addAttribute("command", data);
    return "dataForm";
  }

  //dupa submit (apel POST)
  @RequestMapping(method = RequestMethod.POST)
  protected ModelAndView metodaDupaSubmit
     (Model model,@ModelAttribute("command") DouaNumere data, BindingResult result){
    DouaNumereValidator validator=new DouaNumereValidator();
    validator.validate(data, result);
    if (result.hasErrors()){
       ModelAndView mv = new ModelAndView("dataForm");   
       return mv;
    }
    
    CmmdcManager cm=new CmmdcManager();
    cm.setData(data);	  
    String myMessage=cm.cmmdcService();
    ModelAndView modelAndView = new ModelAndView("cmmdc");
    modelAndView.addObject("message", myMessage);
    modelAndView.addObject("sm", data.getSm());
    modelAndView.addObject("sn", data.getSn());
    return modelAndView;
  }
}
