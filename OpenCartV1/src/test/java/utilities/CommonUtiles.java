package utilities;

import java.io.FileReader;
import java.util.Properties;

public class CommonUtiles {
	private static Properties properties;
	public static void loadProperties()
	{
	
		try {
		FileReader fil=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
		 properties=new Properties();
		properties.load(fil);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static String getProperty(String key)
	{
		if(properties==null)
		{
			loadProperties();
		}
		return properties.getProperty(key);
	}

}
