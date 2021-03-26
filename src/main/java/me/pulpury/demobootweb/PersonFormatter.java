package me.pulpury.demobootweb;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

/**
 * 해당 Formatter를 bean으로 등록 시 WebConfig에서 addFormatter 해줄 필요 없다.
 * @author gimtaeju
 *
 */
//@Component
public class PersonFormatter implements Formatter<Person> {

	@Override
	public Person parse(String text, Locale locale) throws ParseException {
		Person person = new Person();
		person.setName(text);
		return person;
	}

	@Override
	public String print(Person object, Locale locale) {
		return object.toString();
	}
	
	
}
