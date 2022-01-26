package netology.homework.springboot2;

public class InvalidCredentials extends RuntimeException {
    public  InvalidCredentials(String msg) {
        super(msg);
    }

}
