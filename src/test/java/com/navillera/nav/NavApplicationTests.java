package com.navillera.nav;

import java.util.Random;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NavApplicationTests {

	@Test
	void contextLoads() {

	}

	@Test
	public void givenUsingPlainJava_whenGeneratingRandomStringBounded_thenCorrect() {

		int leftLimit = 49; // letter 'a'
		int rightLimit = 57; // letter 'z'
		int targetStringLength = 10;
		Random random = new Random();
		StringBuilder buffer = new StringBuilder(targetStringLength);
		for (int i = 0; i < targetStringLength; i++) {
			int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
			buffer.append((char) randomLimitedInt);
		}
		String generatedString = buffer.toString();

		System.out.println(generatedString);
	}

}
