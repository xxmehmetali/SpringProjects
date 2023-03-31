package demo;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("helloServiceEs")
public class HelloServiceEs implements HelloService{
    @Override
    public String sayHello(String name) {
        return "Hola " + name + "!";
    }
}
