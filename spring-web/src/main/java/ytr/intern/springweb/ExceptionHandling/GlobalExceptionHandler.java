package ytr.intern.springweb.ExceptionHandling;
/*  UYGULAMA
    -> Validation hatası alındığında hangi exception fırlatıldığını bulun
    -> Bu exception'ı global bir exception handler içerisinde yakalayın ve annotation içerisine yazdığınız mesajın veya mesajların geri dönmesini sağlayın.
 */

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<String> handleValidationException(MethodArgumentNotValidException exception) {
        return exception.getFieldErrors().stream().map(error -> error.getDefaultMessage()).toList();
    }
}
