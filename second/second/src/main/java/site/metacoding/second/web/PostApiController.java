package site.metacoding.second.web;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostApiController {

    
@GetMapping("/post/{id}")
public String test1(@PathVariable int id){
    return "주세요id : "+id;
    //바디 없음
}
//바디 있음
//body: title =제목1&content=내용1
//header :  Content-Type : application/x-www-form-encoded
//request.getParameter()메서드가 스프링기본 파싱 전략
@PostMapping("/post")
public String test2(String title, String content){
    return "줄게요:title"+title+"줄게요: content"+content;
}
//바디 있음
@GetMapping("/post")
public String search(String title){
    return "주세요 title:" +title ;
}
   //title,content
   //body 있음
@PutMapping("/post/{id}")
public String test3(String title, String content,@PathVariable int id){
    return "수정해주세요 : title : "+title+",content :"+content;
}
//바디 없음
//delete from post where id = ?
@DeleteMapping("/post/{id}")
public String test4(String title, String content, @PathVariable int id){
    return "지워주세요: title : " +title+ " ,content : "+content;
}
}
