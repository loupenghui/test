package com.hzsun.test.testspringbatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

/**
 * @Description:
 * @Author: louph
 * @Date: 2019/12/10 0010
 */
public class PersonItemProcessor
		implements ItemProcessor<Person, String> {

	private static final Logger LOGGER =
			LoggerFactory.getLogger(PersonItemProcessor.class);

	@Override
	public String process(Person person) throws Exception {
		String greeting = "Hello " + person.getFirstName() + " "
				+ person.getLastName() + "!";

		LOGGER.info("converting '{}' into '{}'", person, greeting);
		return greeting;
	}
}
