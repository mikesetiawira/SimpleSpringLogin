package service.user;

import domain.User;

public interface UserService {
    User validate(String username, String password);
}
