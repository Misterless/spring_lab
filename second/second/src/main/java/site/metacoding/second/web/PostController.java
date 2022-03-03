package site.metacoding.second.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import site.metacoding.second.domain.Post;

//View (글 쓰기 페이지, 글목록페이지, 글 상세보기 페이지)
@Controller
public class PostController {
    @GetMapping("/post/writeForm")
    public String writeForm() {
        return "post/writeForm";
    }

    @GetMapping("/post/list")
    public String list(Model model) {
        Post post1 = new Post(1, "제목1", "내용1");
        Post post2 = new Post(2, "제목2", "내용2");
        ArrayList posts = new ArrayList<Post>();
        
        // model.addAttribute("posts", post2);
        //model.addAttribute("posts", post2);
        posts.add(post1);
        posts.add(post2);
        model.addAttribute("posts", posts);
        return "post/list";
    }

    @GetMapping("/post/detail")
    public String detail(Model model) {

        // db에연결해서 select
        // resultset을 javaobject로 변경
        Post post = new Post(1, "제목1", "내용1");

        // request에 담기
        model.addAttribute("post", post);

        return "post/detail"; // requestdispatcher로 forward = request가 복제됨

    }
}
