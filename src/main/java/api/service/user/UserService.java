package api.service.user;

import api.domain.User;

public interface UserService {
    User validate(String username, String password);
}
