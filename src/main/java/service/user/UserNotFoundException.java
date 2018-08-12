package service.user;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String username){
        super(username+" tidak ditemukan");
    }

    public UserNotFoundException(String username, String password){
        super("Password untuk "+username+" salah");
    }
}
