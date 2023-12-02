package it.unibo.mvc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;

public class ConfigReader {

    private static final ClassLoader classloader = Thread.currentThread().getContextClassLoader();
    private static final InputStream is = classloader.getResourceAsStream("config.yml");
    public static Map<String, Integer> readConfig() {
        Objects.requireNonNull(is);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"))) {
            String line;
            Map<String, Integer> map = new HashMap<>();
            while ((line = br.readLine()) != null) {
                String[] split = line.split(": ");
                map.put(split[0], Integer.parseInt(split[1]));
            }
            System.out.println(map);
            return map;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
