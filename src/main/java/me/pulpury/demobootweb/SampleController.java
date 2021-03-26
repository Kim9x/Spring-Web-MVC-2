package me.pulpury.demobootweb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
	
//	@GetMapping("/hello/{name}")
//	public String hello(@PathVariable("name") Person person) {
	@GetMapping("/hello")
	public String hello(@RequestParam("id") Person person) {
		return "hello " + person.getName();
	}
}