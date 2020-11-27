package com.ivanov.stepan.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class RWUtils {

    static Properties loadProperties(String fileName) {
        Properties props = new Properties();
        File propsFile = new File("target/classes/" + fileName + ".props");
        try (InputStream input = new FileInputStream(propsFile)) {
            props.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return props;
    }

}
