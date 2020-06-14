package libraries;

import java.io.FileInputStream;
import java.util.Properties;

public class GenericPropLib 
{
	public static String getDataFromPropertyfile(String path, String key)
	{	
		String value="";
		try {
			FileInputStream fin=new FileInputStream(path);
			Properties prop=new Properties();
			prop.load(fin);
			value=prop.getProperty(key);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return value;
	}

}
