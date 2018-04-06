package stepDefinations;

import com.CRM.Pages.ContactsPage;
import com.CRM.Pages.DealsPage;
import com.CRM.Pages.HomePage;
import com.CRM.Pages.LoginPage;
import com.CRM.TestUtil.TestBase;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class DealsPageTest extends TestBase  {
	
	HomePage homepage;
	LoginPage loginpage;
	ContactsPage contactpage;
	DealsPage dealspage;
	
	@Before 
	public void setup() throws InterruptedException
	{
		initialization();
		loginpage= new LoginPage();
		 homepage = new HomePage();
		 contactpage = new ContactsPage();
		 dealspage = new DealsPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
//	@After
//	public void teardown()
//	{
//		driver.close();
//	}
	@Given("^user is on the homepage$")
	public void user_is_on_homepage() throws Throwable 
	{
	   homepage = new HomePage();
	   String title=   homepage.ValidateHomePagePagetitle();
	   Assert.assertEquals("CRMPRO", title);
	}

	@When("^user mouse hover to DealsTab and clicks on New Deals link$")
	public void user_mouse_hover_to_contacts_and_clicks_on_New_Contacts_link() throws Throwable
	{
		 homepage= new HomePage();
		 dealspage = new DealsPage();
	     homepage.clickonNewDealLink();
	     
	}

	@Then("^user will be on Add New Deals page$")
	public void user_will_be_on_Add_New_Deals_page() throws Throwable {
	   String dealpagetitle = dealspage.verifyDealsPageTitle();
	   Assert.assertEquals("CRMPRO", dealpagetitle);
	}

	@Then("^user enter the required details and clicks on save button on dealspage$")
	public void user_enter_the_required_details_and_clicks_on_save_button_on_dealspage(DataTable Dealsdata) throws InterruptedException {
	    dealspage.createNewDeals(Dealsdata);
	}


}
