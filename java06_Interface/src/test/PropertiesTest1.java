package test;

import org.w3c.dom.ls.LSOutput;

import java.util.Enumeration;
import java.util.Properties;

public class PropertiesTest1 {
    public static void main(String[] args) {
        Properties p = System.getProperties();
        Enumeration en = p.propertyNames();
        while (en.hasMoreElements()) {                  // key 가 있다면
            String name = (String) en.nextElement();    // key
            String value = p.getProperty(name);         // value

            System.out.println(name + ":: " + value);
        }
    }
}
