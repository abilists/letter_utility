package io.utility.letter;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import io.utility.BasicTest;
import io.utility.letter.bean.TemplateModel;

public class TemplateUtilityTest extends BasicTest {

	@BeforeClass
	public static void beforeClass() {
		System.out.println("This is the first excuted");
	}

	@Before
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

	@After
	public void after() {
		System.out.println("Before");
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("This is the end excuted");
	}
}
