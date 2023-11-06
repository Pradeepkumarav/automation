package mercurytour_utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Readconfig {

Properties prop;
	
	public Readconfig()
	{
		File src = new File("./Configurations/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getLocalizedMessage());
		}
	}
	
	public String getApplicationURL()
	{
		String url = prop.getProperty("baseurl");
		
		 if (url != null) return url;
	     else throw new RuntimeException("url not specified in the Config.properties file.");
	}
	
	public String getUsername()
	{
		String username = prop.getProperty("username");
		return username;
	}
	
	public String getPassword()
	{
		String password = prop.getProperty("password");
		return password;
	}
	
	public String getChromePath()
	{
		String chromepath = prop.getProperty("chromepath");
		return chromepath;
	}
	
	public String getFireFoxPath()
	{
		String firefoxpath = prop.getProperty("firefoxpath");
		return firefoxpath;
	}
	
	public String getIEPath()
	{
		String iepath = prop.getProperty("iepath");
		return iepath;
		
	}


}
