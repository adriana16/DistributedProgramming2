package judete.web;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.stereotype.Controller; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod; 
import java.util.HashMap;
import judete.model.Judet;
import judete.service.JudeteManager;

@Controller
@RequestMapping("/judete.htm") 
public class JudeteController{
  @Autowired
  private JudeteManager jm;
  
  @RequestMapping(method = RequestMethod.GET)
  public ModelAndView metodaCerereInitiala() {
    Judet jud=new Judet();
    ModelAndView modelAndView=new ModelAndView("judeteForm");
    modelAndView.addObject("command", jud);
    modelAndView.addObject("lstJud",jm.getLstJud());
    return modelAndView; 
  }
 
  //a 2-a pagina (in caz apel POST)
  @RequestMapping(method = RequestMethod.POST) 
  public ModelAndView metodaDupaSubmit(@ModelAttribute("command") Judet jud) {
    System.out.println(jud.getNume());
    String nume=jud.getNume();	
  	HashMap<String,Judet> refJudete=jm.getRefJudete();
  	jud=refJudete.get(nume);  
    ModelAndView modelAndView = new ModelAndView("judete");
    modelAndView.addObject("nume",nume);
    modelAndView.addObject("capitala", jud.getCapitala());
    modelAndView.addObject("abrevierea",jud.getAbreviere());
    return modelAndView;
  }  
}
