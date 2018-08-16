package api.service.user;

import api.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import api.repository.UserRepository;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@ComponentScan(basePackages={"com.kangwira"})
@Service
public class UserServiceImpl implements  UserService{

    @Autowired
    UserRepository userRepository;


    @Override
    public User validate(String username, String password) {
        //check if the parameter is valid, the correct username is only on email format
        if(!isEmail(username)){
            throw new WrongFormatException(username);
        }
        else{
            //check if the username is exists
            User user = userRepository.findByUsername(username);
            if(user == null){
             throw new UserNotFoundException(username);
            }
            else{
                //check if the user has the right password
                user = userRepository.findByUsernameAndPassword(username, password);
                if(user == null){
                    throw new UserNotFoundException(username,password);
                }
                else{
                    return user;
                }
            }
        }
    }

    public boolean isEmail(String username){
        //regex pattern for email, return true if username is formed as the pattern.
        Pattern pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
        Matcher match = pattern.matcher(username);

        if(match.matches()) {
            return true;
        }
        return false;
    }

}
