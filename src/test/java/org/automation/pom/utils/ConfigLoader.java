package org.automation.pom.utils;

import org.automation.pom.constants.EnvType;

import java.util.Properties;

public class ConfigLoader {
    private final Properties properties;
    private static ConfigLoader configLoader;

    private ConfigLoader(){
        String env = System.getProperty("environment",String.valueOf(EnvType.STAGING));

        switch (EnvType.valueOf(env)){
            case STAGING -> properties = PropertyUtils.propertyLoader("src/test/resources/properties/stg_config.properties");
            case PROD -> properties = PropertyUtils.propertyLoader("src/test/resources/properties/prod_config.properties");
            default -> throw new IllegalStateException("invalid scenario type: "+env);
        }
    }

    public static ConfigLoader getInstance(){
        if(configLoader == null){
            configLoader = new ConfigLoader();
        }
        return configLoader;
    }

    public String getBaseUrl(){
        String prop = properties.getProperty("baseUrl");
        if(prop != null) return prop;
        else throw new RuntimeException("property baseUrl is not specified in the stg_config.properties file");
    }

    public String getDashboardUrl(){
        String prop = properties.getProperty("dashboard");
        if(prop != null) return prop;
        else throw new RuntimeException("property dashboard is not specified in the stg_config.properties file");
    }

    public String getUsername(){
        String prop = properties.getProperty("username");
        if(prop != null) return prop;
        else throw new RuntimeException("property username is not specified in the stg_config.properties file");
    }

    public String getPassword(){
        String prop = properties.getProperty("password");
        if(prop != null) return prop;
        else throw new RuntimeException("property password is not specified in the stg_config.properties file");
    }
}
