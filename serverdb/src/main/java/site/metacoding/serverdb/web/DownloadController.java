package site.metacoding.serverdb.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class DownloadController {

    @GetMapping("/download")
    public String download(){

        RestTemplate rt = new RestTemplate();
        Hospital[] hospital=
        rt.getForObject("http://3.38.254.72:5000/api/hospital?sidoCdNm=%EB%B6%80%EC%82%B0&sgguCdNm=%EB%B6%80%EC%82%B0%EC%82%AC%ED%95%98%EA%B5%AC", Hospital[].class);
        List<String>list = Arrays.asList(response);
        System.out.println(list.get(0));
        
        //1.uri로 다운로드
        //2 db에 saveall()+ model에 담기
        //3. 리턴 
        return "/download";
    }
    
}
