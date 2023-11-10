package Valinortest.Valinor;



import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class brokenlinks {
	WebDriver d;
	
	public brokenlinks(WebDriver d)
	{
	     this.d = d;
	     PageFactory.initElements(d, this);
	}
	
	public void get_brokenlinks()
	{
		String URL = "";
    	HttpURLConnection huc = null;
    	int responcecode = 200;
    	List<WebElement> links = d.findElements(By.tagName("a"));
    	Iterator<WebElement> it = links.iterator();
    	while(it.hasNext())
    	{
    		URL = it.next().getAttribute("href");
    		System.out.println(URL);
    		if(URL == null || URL.isEmpty()) {
    			System.out.println("Url is not configure with anchor tag or its empty");
    			continue;
    		}
    		
    		try {
    		huc= (HttpURLConnection)(new URL(URL).openConnection());
    		huc.setRequestMethod("HEAD");
    		huc.connect();
    			responcecode = huc.getResponseCode();
    			if(responcecode >= 400) {
    				System.out.println(URL+ "  Link is Broken");
    			}else {
    				System.out.println(URL+"  Link is Valid");
    			}
    			
    		}
    		catch(MalformedURLException e){
    			e.printStackTrace();
    		} catch (IOException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    		}
    	}
	}
}

