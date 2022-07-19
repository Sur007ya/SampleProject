package org.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.test.help.BaseClass;

public class LoginPage extends BaseClass{
	
	public LoginPage() {
	
	PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(id="email")
	private WebElement txtuser;
	
	@FindBy (id="pass")
	private WebElement  txtpa;
	
	@FindBy (name="login")
	private WebElement  btnlog;
	

	public WebElement getTxtuser() {
		return txtuser;
	}

	public WebElement getTxtpa() {
		return txtpa;
	}

	public WebElement getBtnlog() {
		return btnlog;
	}
	
	
	
	
	
		

	
	
	
	
	
	
	
	
	
	
	
	
	
}
