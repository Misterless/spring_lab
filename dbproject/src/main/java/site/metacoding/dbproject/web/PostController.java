package site.metacoding.dbproject.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class PostController {

//글쓰기페이지 /post/writeForm
//글목록 페이지 /post/list,/
//@getmapping({"/","/post/list"})

//글상세보기 페이지 /post/{id}
//글수정 페이지 /post/{id}/updateform
    
//@GetMapping("/post/")

@GetMapping("/post/writeForm")
public String writeForm(){
    return "post/writeForm";
}
@GetMapping({"/","/post/list"})
    public String list(){
        return "/post/list";
    }
@GetMapping("/post/{id}")
public String detail(@PathVariable Integer id){
    return "post/detail";
}
@GetMapping("/post/{id}/updateForm")
public String updateForm(@PathVariable Integer id){
return "post/updateForm";
}
@PostMapping ("/post/")
public  String post(){
    return "redirect:/";
}
@PutMapping("post/{id}")
public String modify(@PathVariable Integer id){
    return "redirect:/post/"+id;
}
@DeleteMapping("post/{id}")
public String delete(@PathVariable Integer id){
    return "redirect:/";
}
}
