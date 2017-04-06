package dataProvider;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;

public class ConfigDataProvider {
	
	Properties prop;
	public ConfigDataProvider()
	{
		File src = new File("./Configuration/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			
			System.out.println("Exceptio is "+e.getMessage());
		}
		
	}
	
	public String getAppUrl()
	{
		String url = prop.getProperty("url");
		return url;
	}
	
	public String getFirefoxPath()
	{
		String path = prop.getProperty("firefoxpath");
		return path;
	}
	
	public String getChromePath()
	{
		String path = prop.getProperty("chrompath");
		return path;
	}
	public String getIEPath()
	{
		String path = prop.getProperty("IEpath");
		return path;
	}

}
