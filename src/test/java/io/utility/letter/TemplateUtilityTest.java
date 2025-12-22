package io.utility.letter;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.utility.BasicTest;
import io.utility.letter.bean.TemplateModel;

public class TemplateUtilityTest extends BasicTest {

	@BeforeAll
	public static void beforeClass() {
		System.out.println("This is the first excuted");
	}

	@BeforeEach
	public void before() {
		System.out.println("Before");
	}

	@Test
	public void testOne() {

		System.out.println("path=" + this.BASE_PATH);

		try {

			TemplateModel tempModel = new TemplateModel();
			tempModel.setToken1("token1");
			tempModel.setToken2("token2");
			tempModel.setUrl("www.abilists.com");
			tempModel.setUserId("admin");

			String body = TemplateUtility.mergeTemplate(
					this.BASE_PATH + "/src/test/resources", 
					"body.ftlh", 
					tempModel);

			System.out.println("body = " + body);

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("This is the test");
	}

	@AfterEach
	public void after() {
		System.out.println("Before");
	}

	@AfterAll
	public static void afterClass() {
		System.out.println("This is the end excuted");
	}
}
