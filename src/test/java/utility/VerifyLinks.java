package utility;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class VerifyLinks {
	
	public static void VerifyUrl(String linkurl)
	{
		try {
			URL url = new URL(linkurl);
			HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
			httpURLConnect.connect();
			if(httpURLConnect.getResponseCode() == 200){
				System.out.println(linkurl + "--" + httpURLConnect.getResponseMessage());
			
			}
			if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)
			{
				
				System.out.println(linkurl + " -- " +  httpURLConnect.getResponseMessage()+ "-- " + HttpURLConnection.HTTP_NOT_FOUND);
				
			}
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
