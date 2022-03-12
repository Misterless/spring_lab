package site.metacoding.serverdb;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class ServerdbApplicationTests {

	@Test
	void contextLoads() {
		RestTemplate rt = new RestTemplate();
		String[] response = rt.getForObject("http://3.38.254.72:5000/api/hospital?sidoCdNm=%EB%B6%80%EC%82%B0&sgguCdNm=%EB%B6%80%EC%82%B0%EC%82%AC%ED%95%98%EA%B5%AC", 
		String[].class);
		List<String> list = Arrays.asList(response);
		
		System.out.println(list.get(0));
	}

}
