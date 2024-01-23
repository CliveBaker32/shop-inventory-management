package edu.wgu.d387_sample_code.translation;

import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;

public class GetLangproperty {

    static ExecutorService messageExecutor=newFixedThreadPool(5);

    public String english() {
        final String[] returnVal = {""}; // Use an array to hold the mutable result

        Properties properties = new Properties();
        messageExecutor.execute(() -> {
            try {
                InputStream stream = new ClassPathResource("translation_en_US.properties").getInputStream();
                properties.load(stream);
                returnVal[0] = properties.getProperty("welcome");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        return returnVal[0];
    }

    public String french() {
        Properties properties = null;


        try {
            properties = new Properties();
            InputStream stream = new ClassPathResource("translation_fr_CA.properties").getInputStream();
            properties.load(stream);


        } catch (Exception e) {
            e.printStackTrace();
        }
        assert properties != null;
        return properties.getProperty("welcome");

    }
}
