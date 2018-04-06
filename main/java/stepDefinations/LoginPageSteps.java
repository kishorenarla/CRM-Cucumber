package stepDefinations;

import com.CRM.Pages.HomePage;
import com.CRM.Pages.LoginPage;
import com.CRM.TestUtil.TestBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class LoginPageSteps extends TestBase{

	LoginPage loginpage;
	HomePage homepage;
	
	@Given("^user is opens browser$")
	public void user_is_opens_browser() throws Throwable 
	{
		initialization();
	}

	@Given("^user ids on loginpage$")
	public void user_ids_on_loginpage() throws Throwable 
	{
	    LoginPage loginpage = new LoginPage();
	    loginpage.ValidateLoginPagetitle();
	    
	}

	@When("^user enters username and password clicks on login button$")
	public void user_enters_username_and_password_clicks_on_login_button() throws Throwable {
		homepage= new HomePage();
        loginpage = new LoginPage();
		homepage =loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
	}

	
	@Then("^user should be on homepage$")
	public void user_should_be_on_homepage() throws Throwable {
		homepage= new HomePage();
	    homepage.LoggeruserVerify();
	    Assert.assertTrue(true);
	    String title =homepage.ValidateHomePagePagetitle();
	    Assert.assertEquals("CRMPRO", title);
	   
	    
	}


	
}
