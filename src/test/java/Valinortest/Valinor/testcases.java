package Valinortest.Valinor;

import org.testng.annotations.Test;

import valinorcomponents.baseclass;

public class testcases extends baseclass {

	@Test(priority =1)
	public void homepage()
	{
		brokenlinks broken = new brokenlinks(d); //Check the All links of Home Page
		broken.get_brokenlinks();
	}

	@Test(priority =2)
	public void signup()
	{
		
	}

}
