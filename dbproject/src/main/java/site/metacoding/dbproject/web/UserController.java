package site.metacoding.dbproject.web;

import java.util.Optional;

import java.sql.PreparedStatement;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import site.metacoding.dbproject.domain.user.User;
import site.metacoding.dbproject.domain.user.UserRepository;

@Controller
public class UserController {

    private UserRepository userRepository;
    private HttpSession session;

    public UserController(UserRepository userRepository, HttpSession session) {
        this.userRepository = userRepository;
        this. session = session;    
    }

    // 회원가입페이지 --로그인x
    @GetMapping("/joinForm")
    public String jointForm() {
        return "user/joinForm";
    }

    // username=ssar&password=1234&email=ssar@nate.com (x-www-form)
    // 회원가입 - 로그인X
    @PostMapping("/join")
    public @ResponseBody String join(User user) {

        StringBuffer sb= new StringBuffer();
        sb.append("<script>");
        sb.append("alert('값을 제대로 전달받지 못했습니다.')");
        sb.append("history.back();");
        sb.append("</script>");
        
        //1,null -> 공백체크
        if(user.getUsername()==null || user.getPassword()==null || user.getEmail()==null){
            return sb.toString();
        }
        if(user.getUsername().equals("") || user.getPassword().equals("") || user.getEmail().equals("")){
            return sb.toString();
        }

        System.out.println("user : " + user);
        User userEntity = userRepository.save(user);
        System.out.println("userEntity : " + userEntity);
        // redirect:매핑주소
        return "redirect:/loginForm"; // 로그인페이지 이동해주는 컨트롤러 메서드를 재활용
    }

    @PostMapping("/user")
    public String join() {
        return "redirect:/loginForm";// 로그인페이지 이동해주는 컨트롤러 메서드 재활용
    }

    // 로그인페이지 - login x
    @GetMapping("/loginForm")
    public String loginForm() {
    public String loginForm(HttpServletRequest request, Model model) {
        // request.getHeader("Cookie");
        Cookie[] cookies = request.getCookies(); // jS
        for (Cookie cookie : cookies) {
            System.out.println("쿠키값 : " + cookie.getName());
            if (cookie.getName().equals("remember")) {
                model.addAttribute("remember", cookie.getValue());
            }
        }
    
        return "user/loginForm";
    }
    // SELECT * FROM user WHERE username =? AND password=?
    // 원래는 SELECT 는 무조건 get
    // 로그인은 예외(post)
    // 주소에 패스워드를 남길 수 없으니까

    @PostMapping("/login") // login x
    public String login(HttpServletRequest request, User user) {
        HttpSession session = request.getSession(); // 쿠키에 sessionId : 85

        User userEntity = userRepository.mLogin(user.getUsername(), user.getPassword());

        if (userEntity == null) {
            System.out.println("아이디 혹은 패스워드가 틀렸습니다");
        } else {
            System.out.println("로그인 되었습니다");
            session.setAttribute("principal", userEntity);
        }
        // 1. DB연결해서 username, password 있는지 확인
        // 2. 있으면 session 영역에 인증됨 이라고 메시지 하나 넣어두자.
        return "redirect:/"; // PostController 만들고 수정하자.
    }

    // 유저상제페이지(동적) -login o
    //http://localhost:8080/user/1
    @GetMapping("/user/{id}")
    
    public String detail(@PathVariable Integer id, Model model) {
    //인증체크
        User principal = (User) session.getAttribute("principal");
        if(principal == null) {
            return "error/page1";
        }
        //권한체크
        if (principal.getId() != id) {
            return "error/page1";
        }        

        Opitional<User> userOp = userRepository.findById(id);

        if (userOp.isPresent()){
            User userEntity = userOp.get();
            model.addAttribute("user", userEntity);
            return "user/detail";
        } else {
            return "error/page1";
        }
        User userEntity = userRepository.findById(id).get();
        if(userEntity==null){
            //경고창이 있으면 좋겠다.
            return "redirect:/";
        } else {
        model.addAttribute("user", userEntity);
        return "user/detail";
        }
    }

    // 유저수정페이지(동적) -login o
    @GetMapping("/user/updateForm")
    public String updateForm() {
        return "user/updateForm";
    }

    // 유저수정 -login o
    @PutMapping("/user/{id}")
    public String update(@PathVariable Integer id) {
        return "redirect:/user/" + id;
    }

    // 로그아웃 login o
    @GetMapping("logout")
    public String logout() {
        session.invalidate();
        
        return "redirect:/loginForm"; // postcontroller 만들고 수정
    }

}
