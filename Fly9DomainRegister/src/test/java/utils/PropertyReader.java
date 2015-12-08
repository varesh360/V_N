package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

public class PropertyReader 
{
	private Document doc;

	//Get user defined data
	public String readApplicationFile(String xmlName, String key) 
	{		
		SAXReader reader = new SAXReader();
		try 
		{
			String localPath = getFilePath();
			localPath = localPath+"//src//test//java//config//";			
			doc = reader.read(localPath+xmlName);
		} 
		catch (DocumentException e) 
		{ e.printStackTrace(); }		
		return doc.selectSingleNode("//" + key.replace('.', '/')).getText();
	}

	//Get file path
	public String getFilePath() 
	{
		String filepath = "";
		File file = new File("");
		String absolutePathOfFirstFile = file.getAbsolutePath();
		filepath = absolutePathOfFirstFile.replaceAll("\\\\+", "/");
		return filepath;
	}
	
	public void updateProperty(final String key, final String value) {
        final Properties props = new Properties();
        String localPath = getFilePath();
        final String propsFileName = localPath + "//src//test//java//config//user.properties";
        try {
            // first load old property file:
            final FileInputStream configStream = new FileInputStream(
                    propsFileName);
            props.load(configStream);
            configStream.close();

            // modifies new property
            props.setProperty(key, value);

            // save modified property file
            final FileOutputStream output = new FileOutputStream(propsFileName);
            props.store(output, "");
            output.close();

        } catch (final IOException ex) {
            System.out.println(ex);
        }
    }
	
	public String readApplicationFileForUsers(String key)
    { 
    	String value = "";
        try{         	  
	          Properties prop = new Properties();
	          String localPath = getFilePath();
	          File f = new File(localPath + "//src//test//java//config//user.properties");
	          if(f.exists()){
		          prop.load(new FileInputStream(f));
		          value = prop.getProperty(key); 		                 
          	}
	   }
        catch(Exception e){  
           System.out.println("Failed to read from user.properties file.");  
        }
        return value;
     } 
}