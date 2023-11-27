package med.vol.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")  //mapeamos a rota qe essa controller ira responder
public class HelloController {
    @GetMapping //pega esse método quando o mapeamento for chamado
    public String helloWorld(){
        return "Hello World";
    }
}
