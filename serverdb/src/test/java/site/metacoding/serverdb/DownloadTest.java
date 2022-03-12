import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

public class DownloadTest{

    @Test
    public void 다운로드(){
        RestTemplate rt = new RestTemplate();
        String[] response =
        rt.getForObject("http://3.38.254.72:5000/api/hospital?sidoCdNm=%EB%B6%80%EC%82%B0", String[].class);
        List<String> list = Arrays.asList(response);
        System.out.println(list.get(0));
    }
}
