package helloname.web;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import helloname.service.NumeManager;

@Controller
@RequestMapping("/newname2.htm")
public class SecondNameController {
	@Autowired
	private NumeManager nm;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView metoda() {  
		String myMessage = nm.sayHello();
		String myDate=(new java.util.Date()).toString();
		ModelAndView modelAndView = new ModelAndView("hello");
		modelAndView.addObject("message", myMessage);
		modelAndView.addObject("date", myDate);
		return modelAndView;
	}
}
