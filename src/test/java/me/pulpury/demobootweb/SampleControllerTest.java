package me.pulpury.demobootweb;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
// Web과 관련된 테스트만 가능 즉, Formatter 사용 불가.
//@WebMvcTest
// 통합 TEST로 변경해줌. 혹은 해당 Formatter를 여기서 bean으로 등록 해도 됨.
@SpringBootTest
@AutoConfigureMockMvc
public class SampleControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	PersonRepository personRepository;
	
//	@Bean
//	public PersonFormatter pFormatter() {
//		return new PersonFormatter();
//	}
	
	// test Commit
	// test two
	
	@Test
	public void hello() throws Exception {
		Person person = new Person();
		person.setName("taeju");
		Person savedPerson = personRepository.save(person);
		
//		this.mockMvc.perform(get("/hello/taeju"))
		this.mockMvc.perform(get("/hello")
					.param("id", savedPerson.getId().toString()))
				.andDo(print())
				.andExpect(content().string("hello taeju"));
	}

}
