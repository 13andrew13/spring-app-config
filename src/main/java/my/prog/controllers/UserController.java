package my.prog.controllers;

import my.prog.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @RequestMapping (value = "/login",method = RequestMethod.GET)
    public ModelAndView login(ModelAndView vm){
        vm.setViewName ("login");
        vm.addObject ("user",new User ());
        return vm;
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute("user") User user, ModelAndView vm){
        return vm;
    }

}
