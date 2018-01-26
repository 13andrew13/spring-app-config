package andrew.prog.springporject.controllers;

import andrew.prog.springporject.services.FacebookService;
import andrew.prog.springporject.services.UserService;
import andrew.prog.springporject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    private Facebook facebook;
    @Autowired
    private ConnectionRepository connectionRepository;
    @Autowired
    UserService userService;
    @Autowired
    FacebookService facebookService;
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
    @GetMapping("/facebook")
    public String helloFacebook() {
        return "social";
    }
    @GetMapping("/registerFacebook")
    public ModelAndView registerFacebook(ModelAndView vm){
        User user = facebookService.getUser ();
        userService.addUser (user);
        vm.setViewName ("welcome");
        vm.addObject ("user",user);
        return vm;
    }
}
