package driverUtils;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

	// Read data from config properties file
	private Properties properties;
	private final String propertyFilePath = "datasource//config.properties";
	FileReader reader=null;
	
	public ConfigFileReader(){
		
		try {
			reader = new FileReader(propertyFilePath);
			properties = new Properties();
			try {
				properties.load(reader);
				} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}		
	}
	
	public String getDriverPath(){
		String driverPath = properties.getProperty("driverPath");
		if(driverPath!= null) return driverPath;
		else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");		
	}

	public String getBrowserType() {
		String BrowserType = properties.getProperty("browser");
		if(BrowserType!= null) return BrowserType;
		else throw new RuntimeException("browser not specified in the Configuration.properties file.");	
	}

	public String getApplicationUrl() {
		String nodeUrl = properties.getProperty("nodeUrl");
		if(nodeUrl!= null) return nodeUrl;
		else throw new RuntimeException("nodeUrl not specified in the Configuration.properties file.");		
	}
	
	public String getApplicationsubUrl() {
		String subUrl = properties.getProperty("subUrl");
		if(subUrl!= null) return subUrl;
		else throw new RuntimeException("subUrl not specified in the Configuration.properties file.");		
	}
	
	public long getImplicitlyWait() {		
		String implicitlyWait = properties.getProperty("implicitlyWait");
		if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
		else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");		
	}
	
	public String getusername() {
		String username = properties.getProperty("username");
		if(username != null) return username;
		else throw new RuntimeException("username not specified in the Configuration.properties file.");
	}
	public String getpassword() {
		String password = properties.getProperty("password");
		if(password != null) return password;
		else throw new RuntimeException("password not specified in the Configuration.properties file.");
	}
		
	public String getfApplicationUrl() {
		String nodeUrl = properties.getProperty("facebookAppeUrl");
		if(nodeUrl!= null) return nodeUrl;
		else throw new RuntimeException("nodeUrl not specified in the Configuration.properties file.");		
	}
	
	public String getfusername() {
		String fusername = properties.getProperty("fusername");
		if(fusername != null) return fusername;
		else throw new RuntimeException("fusername not specified in the Configuration.properties file.");
	}
	public String getfpassword() {
		String fpassword = properties.getProperty("fpassword");
		if(fpassword != null) return fpassword;
		else throw new RuntimeException("fpassword not specified in the Configuration.properties file.");
	}
	
}
