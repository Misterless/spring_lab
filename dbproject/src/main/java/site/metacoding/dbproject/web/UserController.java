package site.metacoding.dbproject.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class UserController {
    
    //회원가입페이지 --로그인x
@GetMapping("/user/joinForm")
public String jointForm(){
    return "user/joinForm";
    }
    //회원가입  -로그인x
    @PostMapping("/user")
public String join(){
    return "redirect:/user/loginForm";//로그인페이지 이동해주는 컨트롤러 메서드 재활용
}
    //로그인페이지 - login x
@GetMapping("/user/loginForm")
public String loginForm(){
    return "user/loginForm";
}
//SELECT * FROM user WHERE username =? AND password=?
//원래는 SELECT 는 무조건 get 
//로그인은 예외(post)
//주소에 패스워드를 남길 수 없으니까


@PostMapping("/login") //login x
public String login(){
    return "메인페이지를 돌려주면 됨"; //postcontroller 만들고 수정
}

//유저상제페이지(동적) -login o
@GetMapping("/user/{id}")
public String detail(@PathVariable Integer id){
    return "user/detail";
}
//유저수정페이지(동적) -login o
@GetMapping("/user/updateForm")
public String updateForm(){
    return "user/updateForm";
}

//유저수정 -login o
@PutMapping("/user/{id}")
public String update(@PathVariable Integer id) {
    return "redirect:/user/"+id;
}

//로그아웃 login o
@GetMapping("logout")
public String logout(){
    return "메인페이지 돌려주자" ; //postcontroller 만들고 수정
}
    
}
