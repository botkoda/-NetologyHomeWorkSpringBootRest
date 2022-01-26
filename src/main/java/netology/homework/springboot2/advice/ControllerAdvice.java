package netology.homework.springboot2.advice;

import netology.homework.springboot2.InvalidCredentials;
import netology.homework.springboot2.UnauthorizedUser;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice("netology.homework.springboot2")
public class ControllerAdvice {

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedUser.class)
    public String uHandler(UnauthorizedUser e){
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidCredentials.class)
    public String iHandler(InvalidCredentials e){
        return e.getMessage();
    }
}
