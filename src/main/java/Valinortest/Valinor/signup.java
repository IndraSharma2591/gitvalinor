package Valinortest.Valinor;

import static org.testng.Assert.assertEquals;

import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import dev.failsafe.internal.util.Assert;

public class signup {
	WebDriver d;
	
	public void signup(WebDriver d)
	{
		this.d = d;
		PageFactory.initElements(d, this);
	}
	@FindBy(xpath = "//button[normalize-space()='Sign Up']")
	WebElement signuphome;
	@FindBy(xpath = "//input[@placeholder='Full Name']")
	WebElement fullname;
	@FindBy(xpath="//input[@placeholder='Email Address']")
	WebElement email;
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement password;
	@FindBy(xpath="//input[@placeholder='Confirm Password']")
	WebElement cnfpassword;
	@FindBy(xpath="//input[@id='check1']")
	WebElement terms;
	@FindBy(xpath="//button[normalize-space()='Sign Up']")
	WebElement signupfrm;
	@FindBy(xpath="//p[normalize-space()='Full name is required.']")
	WebElement fullnamev;
	@FindBy(xpath="//p[normalize-space()='Email is required.']")
	WebElement emailv;
	@FindBy(xpath="//p[normalize-space()='Password is required.']")
	WebElement passwordv;
	@FindBy(xpath="//p[normalize-space()='Confirm password is required.']")
	WebElement cnfpasswordv;
	@FindBy(xpath="//p[normalize-space()='This field is required.']")
	WebElement termsv;
	@FindBy(xpath="//p[normalize-space()='Email address is not valid.']")
	WebElement invalidemailv;
	@FindBy(xpath="//p[contains(text(),'Password must contain 1 uppercase, 1 lower case, 1')]")
	WebElement passworderr;
	@FindBy(xpath="//p[normalize-space()='Password and Confirm Password must match.']")
	WebElement cnfpassworderrv;
	@FindBy(xpath="//h3[normalize-space()='Create New Account']")
	WebElement signuptext;
	
	
	public void verify_signup_page()
	{
		signuphome.click();
		String expectedtext = "Create New Account";
		String actualtext = signuptext.getText();
		if(actualtext.equals(expectedtext))
		{
			System.out.println("Signup Page Text matched");
			
		}
		else
		{
			System.out.println("Signup Page Text not matched");
		}
		
	}
	
      public void verify_blankfield_validations()
	{
		signupfrm.click();
		String expfullname_error = "Full name is required.";
		String actualfullname_error = fullnamev.getText();
		String email_error = "Email is required.";
		String actualemail_error = emailv.getText();
		String password_error = "Password is required.";
		String actualpassword_error = passwordv.getText();
		String cnfpassword_error = "Confirm password is required.";
		String actualcnfpassword_error = cnfpasswordv.getText();
		String terms_error = "This field is required.";
		String actualterms_error = termsv.getText();
	    
	    
	}
	
}
