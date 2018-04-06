package com.CRM.Pages;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.CRM.TestUtil.TestBase;
import com.CRM.TestUtil.Testutil;

import cucumber.api.DataTable;



public class DealsPage extends TestBase {
	
	Testutil util;
	HomePage homepage= new HomePage();
	
	public DealsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
     
	
//  	
	
@FindBy(id="title")
WebElement Dealtitle;


@FindBy(name="client_lookup")
WebElement Companyname;

@FindBy(id="amount")
WebElement Amount;

@FindBy(xpath="//input[@id='btn_cs_search']")
WebElement AdvancedSearch;

@FindBy(xpath="//input[@class='button'][@value='Save']")
WebElement Savebutton;


@FindBy(xpath="//a[contains(text(),'Kishore Kumar')]")
WebElement Contactname;




//Actions on Contact Page


public boolean VerifyconactSaved()
{
	return Contactname.isDisplayed();
}

public String verifyDealsPageTitle()
{
	return driver.getTitle();
}


public void createNewDeals(DataTable DealsData) throws InterruptedException
{	
	for(Map<String,String> data:DealsData.asMaps(String.class, String.class))
			{
					
			util=  new Testutil();
	        util.ExplicitlywaitbyID(Dealtitle, "title");
	        Dealtitle.sendKeys(data.get("Title"));
	        Companyname.sendKeys(data.get("Company"));
	        Amount.sendKeys(data.get("Amount"));
	        Savebutton.click();

    	   	// to click on create contact after saving one data
    	
   	        homepage= new HomePage();
   	        Thread.sleep(5000);
   	        homepage.clickonNewDealLink();
   	        Thread.sleep(5000);
	 
    	
    }
    
    

	

}


}
