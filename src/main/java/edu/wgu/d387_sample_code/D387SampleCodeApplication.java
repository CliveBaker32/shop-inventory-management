package edu.wgu.d387_sample_code;

import edu.wgu.d387_sample_code.translation.MessageService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.Executors.newFixedThreadPool;

@SpringBootApplication
public class D387SampleCodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(D387SampleCodeApplication.class, args);


        MessageService getLangproperty = new MessageService();
        //System.out.println(english());

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
        ExecutorService messageExecutor = Executors.newFixedThreadPool(2);

        String[] returnVal = {""}; // Use an array to hold the mutable result

        Properties properties = new Properties();
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                InputStream stream = new ClassPathResource("translation_en_US.properties").getInputStream();
                properties.load(stream);
                returnVal[0] = properties.getProperty("welcome");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, messageExecutor);

        // Wait for the asynchronous task to complete
        future.join();

        return returnVal[0];
    }
}
