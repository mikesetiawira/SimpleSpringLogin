package api.controller;

import api.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import api.service.user.UserNotFoundException;
import api.service.user.UserService;
import api.service.user.WrongFormatException;

@RequestMapping("/")
@RestController
public class UserWebController {

    private final Logger logger = LoggerFactory.getLogger(UserWebController.class);

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap model){
        return "login";
    }
    @RequestMapping(name="/go",method = RequestMethod.POST)
    public ModelAndView home(ModelMap model,
                             @RequestParam("username")String username,
                             @RequestParam("password")String password){
        try{
            //validate the user from the form
            User user = userService.validate(username, password);
            model.addAttribute("api/service/user",user);
        }

        catch(UserNotFoundException e){
            //send the error message on a logger just in case the error message is buried somewhere
            logger.info(e.getMessage());
            model.addAttribute("error",e.getMessage());
            return new ModelAndView("/login",model) ;
        }
        catch(WrongFormatException e){
            //send the error message on a logger just in case the error message is buried somewhere
            logger.info(e.getMessage());
            model.addAttribute("error",e.getMessage());
            return new ModelAndView("/login",model) ;
        }
        return new ModelAndView("/home",model);
    }

}
