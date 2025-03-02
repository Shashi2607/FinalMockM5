package fileutility;

	import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.Properties;

	public class ReadfromProperties {

		public static String getData(String key) throws IOException {
			Properties prop= new Properties();
			
			FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\vitger.properties");
			prop.load(fis);
			String data=prop.getProperty(key);
			return data;
		}
		
				
	}


