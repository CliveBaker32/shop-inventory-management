package edu.wgu.d387_sample_code;

import edu.wgu.d387_sample_code.translation.GetLangproperty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ClassPathResource;
import java.util.concurrent.ExecutorService;

import java.io.InputStream;
import java.util.Properties;

@SpringBootApplication
public class D387SampleCodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(D387SampleCodeApplication.class, args);


        GetLangproperty getLangproperty = new GetLangproperty();
        System.out.println(getLangproperty.english());

/*
        try {
            Properties properties = new Properties();
            InputStream stream = new ClassPathResource("translation_en_US.properties").getInputStream();
            properties.load(stream);
            System.out.println(properties.getProperty("welcome"));

        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Properties properties = new Properties();
            InputStream stream = new ClassPathResource("translation_fr_CA.properties").getInputStream();
            properties.load(stream);
            System.out.println(properties.getProperty("welcome"));

        } catch (Exception e) {
            e.printStackTrace();
        }
*/



    }

    public static String english() {
        Properties properties = null;
        try {
            properties = new Properties();
            InputStream stream = new ClassPathResource("translation_en_US.properties").getInputStream();
            properties.load(stream);


        } catch (Exception e) {
            e.printStackTrace();
        }
        assert properties != null;
        return properties.getProperty("welcome");
    }

}
