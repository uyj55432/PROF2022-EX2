package es.upm.grise.prof2022.ex2;

import java.io.FileInputStream;
import java.util.Properties;

public class Colaborator {

    Properties p;
    
    public Colaborator(){
        p = new Properties();
    }

    public void load(String filename) throws Exception{
        p.load(new FileInputStream("resources/" + filename));
    }

    public String getProperty(String key){
        return p.getProperty(key);
    }
}