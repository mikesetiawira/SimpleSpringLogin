package controller;

import domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.user.UserNotFoundException;
import service.user.UserService;
import service.user.WrongFormatException;

@Controller
public class UserWebController {

    private final Logger logger = LoggerFactory.getLogger(UserWebController.class);

    @Autowired
    UserService userService;

    @RequestMapping(value="/login/go", method = RequestMethod.GET)
    public String home(Model model,
                       @RequestParam("username")String username,
                       @RequestParam("password")String password){
        try{
            User user = userService.validate(username, password);
            model.addAttribute(user);
        }

        catch(UserNotFoundException e){
            String message = e.getMessage();
            //send the error message on a logger just in case the error message is buried somewhere
            logger.info(e.getMessage());
            return "/login_error";
        }
        catch(WrongFormatException e){
            String message = e.getMessage();
            //send the error message on a logger just in case the error message is buried somewhere
            logger.info(e.getMessage());
            return "/login_error";
        }
        return "/home";
    }

}
