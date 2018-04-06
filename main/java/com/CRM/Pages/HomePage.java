package com.CRM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.CRM.TestUtil.TestBase;
import com.CRM.TestUtil.Testutil;



public class HomePage extends TestBase
{
	
	Testutil util;
	
public HomePage()
{
	
	PageFactory.initElements(driver, this);
	
	
}

@FindBy(xpath="//a[@title='Contacts']")
WebElement Contactslink;



@FindBy(xpath="//a[@title='Deals']")
WebElement DealsLink;

@FindBy(xpath="//td[@class='headertext'][contains(text(),'Kishore Narla')]")
WebElement LoggeduserVerify;

@FindBy(xpath ="//a[contains(text(),'New Contact')]")
WebElement NewContact;

@FindBy(xpath ="//a[contains(text(),'New Deal')]")
WebElement NewDeallink;

//Schedule Call

@FindBy(xpath="//div[@id='leftMenuContainer']//child::div[@id='navMenu']//child::li[10]/a")
WebElement Schedulecalllink;

//Actions in HomePage



public boolean LoggeruserVerify()
{
	driver.switchTo().frame("mainpanel");
	return  LoggeduserVerify.isDisplayed();

}

public ContactsPage clickOnContactsLink()
{ 
	util= new Testutil();
	util.swithchtoFrame();
	WebElement Contactslink = (new WebDriverWait(driver, 30))
			.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Contacts']")));
	Contactslink.click();
	return new ContactsPage();
	
}



public void clickonNewContact() throws InterruptedException
{   try {
	util= new Testutil();
	util.swithchtoFrame();
}catch(NoSuchFrameException e)
{
	System.out.println("No Such frame Exist");
}
	Actions action = new Actions(driver);	
	action.moveToElement(Contactslink).build().perform();
    util.ExplicitlywaitbyXpath(NewContact, "//a[contains(text(),'New Contact')]");
	NewContact.click();
}

public String ValidateHomePagePagetitle()
{
return driver.getTitle();
}

public DealsPage ClickonDealslink()
{
	util= new Testutil();
	util.swithchtoFrame();
	WebElement DealsLink = (new WebDriverWait(driver, 40))
			.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Deals']")));
	DealsLink.click();
	
	return new DealsPage();
}


public void clickonNewDealLink() throws InterruptedException
{
	{   try {
		util= new Testutil();
		util.swithchtoFrame();
	}catch(NoSuchFrameException e)
	{
		System.out.println("No Such frame Exist");
	}
	Actions action = new Actions(driver);
	Thread.sleep(5000);
	action.moveToElement(DealsLink).build().perform();
	util.ExplicitlywaitbyXpath(NewDeallink, "//a[contains(text(),'New Deal')]");
	NewDeallink.click();
}
}
}