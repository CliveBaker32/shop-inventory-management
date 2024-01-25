package edu.wgu.d387_sample_code.translation;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.Executors.newFixedThreadPool;

@Service
public class MessageService {

    static ExecutorService messageExecutor=newFixedThreadPool(2);

    public String english() {
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

    public String french() {
        ExecutorService messageExecutor = Executors.newFixedThreadPool(2);

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Properties properties = new Properties();
                InputStream stream = new ClassPathResource("translation_en_US.properties").getInputStream();
                properties.load(stream);
                return properties.getProperty("welcome");
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }, messageExecutor);

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                Properties properties = new Properties();
                InputStream stream = new ClassPathResource("translation_fr_CA.properties").getInputStream();
                properties.load(stream);
                return properties.getProperty("welcome");
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }, messageExecutor);

        CompletableFuture<Object> combinedFuture = CompletableFuture.anyOf(future1, future2);

        // Wait for either of the asynchronous tasks to complete
        combinedFuture.join();

        // Get both results
        String result1 = future1.join();
        String result2 = future2.join();

        return result1 + "<br>" + result2;
    }

    public String messages() {

        ExecutorService messageExecutor = Executors.newFixedThreadPool(2);

        String[] returnVal = {""}; // Use an array to hold the mutable result

        Properties properties=new Properties();
        messageExecutor.execute(()-> {
            try {
                InputStream stream = new ClassPathResource("translation_fr_CA.properties").getInputStream();
                properties.load(stream);

                returnVal[0] = properties.getProperty("welcome");

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        messageExecutor.execute(()-> {
            try {
                InputStream stream = new ClassPathResource("translation_en_US.properties").getInputStream();
                properties.load(stream);

                returnVal[0] = returnVal[0] + "<br>" + properties.getProperty("welcome");


            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        return returnVal[0];
    }

}
