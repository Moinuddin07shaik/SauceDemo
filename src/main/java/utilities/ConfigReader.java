package utilities;

import java.io.FileInputStream;
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

	


	
	public int timeout() {
	    return Integer.parseInt(pro.getProperty("timeouts"));
	}



}


