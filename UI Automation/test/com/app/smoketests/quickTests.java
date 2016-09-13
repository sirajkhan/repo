package com.app.smoketests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.app.pageobjects.Homepage;
import com.app.pageobjects.Registrationpage;
import com.app.pageobjects.SignInpage;
import com.app.utils.DriverMethod;

public class quickTests {

	Homepage hp;
	SignInpage sp;
	Registrationpage rp;

	@BeforeClass
	public void setUp()
	{
		DriverMethod.setUpDriver();
		hp = new Homepage();
		sp = new SignInpage();
		rp = new Registrationpage();
	}

	@BeforeMethod
	public void initialize_test()
	{
		DriverMethod.goto_url("http://www.google.com");
	}

	@Test
	public void search_keyword_and_validate_results()
	{
		hp.enter_search_keyword("new zealand");
		List<String> results = hp.get_search_results();
		for (String item : results)
		{
			System.out.println(item);
			Assert.assertTrue(item.contains("new zealand"), "search result do not match keyword");
		}
	}

	@Test
	public void create_new_account()
	{
		hp.click_gmail();
		sp.click_create_account();
		rp.input_name("Siraj", "khan");
		rp.input_username("sirajkhan342156");
		rp.input_password("test_password");
		rp.input_confirm_password("test_password");
		rp.select_birth_month("March");

		Assert.assertEquals("March", rp.get_birth_month());
	}

	@AfterClass
	public void tearDown()
	{
		DriverMethod.terminateDriver();
	}
}
