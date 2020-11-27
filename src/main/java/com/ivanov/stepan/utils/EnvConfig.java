package com.ivanov.stepan.utils;

import java.util.Map;

public class EnvConfig {

    static final String FILE_PATH = System.getProperty("env.config.name", "env");
    static final Map properties = RWUtils.loadProperties(FILE_PATH);
    public static final String URL = (String) properties.get("url");
    public static final String BROWER = (String) properties.get("browser");

}
