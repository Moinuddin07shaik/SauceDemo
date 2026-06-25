package utilites;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader 
{
	Properties pro;

	public ConfigReader() 
	{
		try {
		FileInputStream fi = new FileInputStream("src/test/resources/config.properties");
		pro = new Properties();
		pro.load(fi);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}	

	public String url()
	{
		return pro.getProperty("url");

	}

	public String browser()
	{
		return pro.getProperty("browser");
	}

	public String username()
	{
		return pro.getProperty("username");
	}

	public String password()
	{
		return pro.getProperty("password");
	}
	
	public int timeout() {
	    return Integer.parseInt(pro.getProperty("timeouts"));
	}



}


