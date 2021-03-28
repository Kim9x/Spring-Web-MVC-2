package me.pulpury.demobootweb;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.xpath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.StringWriter;

import javax.xml.bind.Marshaller;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;

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
	
	// json형으로 변환해주기 위해 사
	@Autowired
	ObjectMapper objectMapper;
	
	@Autowired
	Marshaller marshaller;
	
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
	
	@Test
	public void helloStatic() throws Exception {
		this.mockMvc.perform(get("/mobile/index.html"))
					.andDo(print())
					.andExpect(status().isOk())
//					.andExpect(content().string(Matchers.containsString("Hello Mobile")))
					.andExpect(content().string(Matchers.containsString("Hello Mobile TEST")))
					.andExpect(header().exists(HttpHeaders.CACHE_CONTROL));
	}
	
	@Test
	public void StringMessage() throws Exception {
		
		this.mockMvc.perform(get("/message")
					.content("hello"))
					.andDo(print())
					.andExpect(status().isOk())
					.andExpect(content().string("hello"));
	}
	
	@Test
	public void jsonMessage() throws Exception {
		Person person = new Person();
		person.setId(2019l);
		person.setName("taeju");
		
		StringWriter stringWriter = new StringWriter();
		Result result = new StreamResult(stringWriter);
		marshaller.marshal(person, result);
		String xmlString = stringWriter.toString();
		
		// Person 타입의 값을 json형으로 변환!
//		String jsonString = objectMapper.writeValueAsString(person);
		
		this.mockMvc.perform(get("/jsonMessage")
					.contentType(MediaType.APPLICATION_XML)
					.accept(MediaType.APPLICATION_XML)
					.content(xmlString))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect((ResultMatcher) xpath("person/name").string("2019"))
				.andExpect((ResultMatcher) xpath("person/name").string("taeju"))
				
	}

}
