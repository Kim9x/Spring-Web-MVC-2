package me.pulpury.demobootweb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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
}
