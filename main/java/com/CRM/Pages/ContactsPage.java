package com.CRM.Pages;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.CRM.TestUtil.TestBase;
import com.CRM.TestUtil.Testutil;

import cucumber.api.DataTable;



public class ContactsPage extends TestBase {
	
	Testutil util;
	HomePage homepage= new HomePage();
	
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
     
	
//  	
	
@FindBy(name="title")
WebElement title1;

@FindBy(id="first_name")
WebElement firstname;

@FindBy(id="surname")
WebElement Surname;

@FindBy(name="client_lookup")
WebElement company;

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

public boolean VerifyAdvancedSearch()
{
	return AdvancedSearch.isDisplayed();
}
public String VerifyContactsPageTitle()
{
	return driver.getTitle();
}

public void createNewContact(DataTable Contactsdata, String titletext ) throws InterruptedException
{

    
    for(Map<String, String> data:Contactsdata.asMaps(String.class, String.class))
    {
    	util = new Testutil();
    	util.ExplicitlywaitbyName(title1,"title");
        util.SelectbyVisibleText(title1, titletext);
    	util.ExplicitlywaitbyID(firstname, "first_name");
    	firstname.sendKeys(data.get("Firstname"));
    	Surname.sendKeys(data.get("Surname"));
    	company.sendKeys(data.get("Company"));
    	Savebutton.click();
   
    	
    	// to click on create contact after saving one data
    	
   	 homepage= new HomePage();
   	 Thread.sleep(5000);
	 homepage.clickonNewContact();
	 Thread.sleep(5000);
	 
    	
    }
    
    
	
	

}


}
