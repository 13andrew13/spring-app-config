package my.prog.controllers;

import com.sun.org.apache.regexp.internal.RE;
import my.prog.UserService;
import my.prog.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    UserService userService;
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


    @RequestMapping(value = "/signUp",method = RequestMethod.GET)
    public ModelAndView register(ModelAndView vm){
        vm.setViewName ("signUp");
        vm.addObject ("user",new User());
        return vm;
    }

    @RequestMapping(value ="/signUp",method = RequestMethod.POST)
    public ModelAndView register(@ModelAttribute("user")User user,ModelAndView vm){
        vm.setViewName ("welcome");
        vm.addObject ("user",userService.addUser (user));
        return vm;
    }

}
