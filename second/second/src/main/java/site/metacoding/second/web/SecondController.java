package site.metacoding.second.web;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SecondController {
    @GetMapping("/user")
    public String test1(){
        return "<h1>주세요</h1>";
    }
    @PostMapping("/user")
    public String test2(){
        return "<h2>줄꼐요</h2>";
    }
 
    @PutMapping("/user")
    public String test3(String title, String content){
        return "<h3>수정해주세요</h3>";
    }
    @DeleteMapping("/user")
    public String test4(){
        return "<h4>삭제해주세요</h4>";
    }
}
                        