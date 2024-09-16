package com.mycompany.chatiaintegrated.Controller;

/**
 *
 * @author João Capemba
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropetiesReader {
    
    public static String url = "C:\\Users\\joils\\Documents\\NetBeansProjects\\ChatIAIntegrated\\src\\main\\java\\resources\\application.properties";
    
    public String readUrlPropretie() throws FileNotFoundException, IOException{
        try{
        Properties property = new Properties();
        property.load(new FileInputStream(url));
        String urlReaded = property.getProperty("api.url");
        System.out.println(urlReaded);
        return urlReaded;
        }catch(IOException e){
            return "";
        }
    }
    
}
