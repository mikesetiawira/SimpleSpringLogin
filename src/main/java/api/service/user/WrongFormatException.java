package api.service.user;

public class WrongFormatException extends RuntimeException {
    public WrongFormatException(String username){
        super(username + " bukan format yang tepat, format harusnya abc@def.xyz");
    }
}
