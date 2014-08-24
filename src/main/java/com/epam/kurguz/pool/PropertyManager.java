package com.epam.kurguz.pool;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyManager {
        private final Properties PROPERTIES = new Properties();

        public PropertyManager(String fileName) {
            InputStream inputStream = PropertyManager.class.getClassLoader().getResourceAsStream(fileName);
            try {
                PROPERTIES.load(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public String getProperty(String key) {
            return PROPERTIES.getProperty(key);
        }
    }