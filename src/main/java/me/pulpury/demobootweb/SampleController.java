package me.pulpury.demobootweb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
	
	// preHandle 1
	// preHandle 2
	// 요청 처리
	
	// 역순으로 호출이 된다.  자료형 중에 Stack을 생각하면 될 듯?
	// postHandler 2
	// postHandler 1
	// 뷰 렌더링
	// afterCompletion 2
	// afterCompletion 1
	
//	@GetMapping("/hello/{name}")
//	public String hello(@PathVariable("name") Person person) {
	@GetMapping("/hello")
	public String hello(@RequestParam("id") Person person) {
		return "hello " + person.getName();
	}
	
	// @ResponseBody는 return값을 응답의 본문으로 넣어준다.
	// but 우리는 @RestController를 사용하고 있기 때문에
	// 모든 Handler Method에 @ResponseBody가 있는거나 마찬가지
	// @RequestBody는 요청 본문에 들어있는 메세지를 HttpMessageConverter를 사용해서
	// conversion 진행(아래 주석 처리된 경우 Person으로 conversion 진행)
	@GetMapping("/message")
	@ResponseBody 
//	public String message(@RequestBody Person person) {
	public String message(@RequestBody String body) {
		return body;
	}
	
	
}
