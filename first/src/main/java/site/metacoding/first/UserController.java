package site.metacoding.first;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("/home")
    public void home(){
System.out.println("home!~!~!~!~!~!~!~!~");
    }
    @GetMapping("/bye")
    public void bye(){
System.out.println("BYE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!;;");
    }
    @GetMapping("/data")
    public String data(){
        return "<h1>data</h1>";
    }
}
