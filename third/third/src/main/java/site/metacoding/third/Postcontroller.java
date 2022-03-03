package site.metacoding.third;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Postcontroller {
    @GetMapping("/post/writeForm")
    public String post1(){
        return "writeForm";
    }
    @PostMapping ("/post")
    public String write(String title, String content,Model model){
        //1. title content DB에 insert
        System.out.println("title : "+title);
        System.out.println("content : "+content);

        //2, 글목록페이지로 이동
        model.addAttribute("title", title);
        return "post/list";

    }
}
