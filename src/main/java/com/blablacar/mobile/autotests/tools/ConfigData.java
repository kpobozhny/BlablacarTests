package com.blablacar.mobile.autotests.tools;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


/*
 *  That class provides static methods for getting values from Config and UI mapping files
 */
public class ConfigData {

    private static String verificationFile = "src/main/resources/prop/verification.properties";
    private static String linksFile = "src/main/resources/prop/links.properties";
    private static String errorsFile = "src/main/resources/prop/validationMessages.properties";
    private static String configFile = "src/main/resources/prop/config.properties";

    /*
     * Return value from .properties file
     */
    public static String getValueFromFile(String key, String fileName)
            throws IOException {
        Properties p = new Properties();
        // Create stream for reading from file
        FileInputStream cfg = new FileInputStream(fileName);
        // Load Properties from input stream
        p.load(cfg);
        cfg.close();

        // Return value for the property
        return (p.getProperty(key));
    }


    /*
     * Return value from config file. Note, please, that returned value is
     * String. We should take care of value's type by himself when will use
     * config data value in the test.
     */
    public static String getVerificationValue(String key) throws IOException {
        return (getValueFromFile(key, verificationFile));
    }

    public static String getLinkValue(String key) throws IOException {
        return (getValueFromFile(key, linksFile));
    }

    public static String getErrorValue(String key) throws IOException {
        return (getValueFromFile(key, errorsFile));
    }

    public static String getConfigValue(String key) throws IOException {
        return (getValueFromFile(key, configFile));
    }


    public static long getRandomLong(long maxValue) {
        return (long)(Math.random() * maxValue);
    }

    public static int getRandomInt(int maxValue) {
        return (int)getRandomLong(maxValue);
    }

    public static String getRandomString(int length) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = (int)getRandomLong(alphabet.length() - 1);
            sb.append(alphabet.charAt(index));
        }
        return sb.toString();
    }

}