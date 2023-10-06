package ytr.intern.springweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller         //bu classın bir controller(cleint'tan gelen istekleri karşılayan class) class'ı oldugunu belirten anotasyon
public class WelcomeController {
    @RequestMapping("/welcome")     //•	Gelen request’in URL’ine bağlı olarak hangi class/fonksiyona gitmesi gerektiğini spring’e söylemek için kullanılır. Class ve method seviyesinde kullanılabilir.
    public String welcome(){
        return "welcome.html";
    }
}
