package edu.wgu.d387_sample_code;

import edu.wgu.d387_sample_code.translation.MessageService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.Executors.newFixedThreadPool;

@SpringBootApplication
public class D387SampleCodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(D387SampleCodeApplication.class, args);




/*
        ZoneId zUtc = ZoneId.of("UTC"); // Coordinated Universal Time
        ZoneId zEastern = ZoneId.of("America/New_York"); // Eastern Time
        ZoneId ZMtc = ZoneId.of("America/Denver"); // Mountain Time

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");


        ZoneId zoneId = ZoneId.systemDefault();

        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = localDateTime.atZone(zoneId);

        ZonedDateTime zonedDateTimeUniversal = zonedDateTime.withZoneSameInstant(zUtc);
        String formattedUniversalTime = zonedDateTimeUniversal.format(formatter);
        System.out.println("Universal time " + formattedUniversalTime);


        ZonedDateTime zonedDateTimeEastern = zonedDateTime.withZoneSameInstant(zEastern);
        String formattedEasternTime = zonedDateTimeEastern.format(formatter);
        System.out.println("Eastern time " + formattedEasternTime);


        ZonedDateTime zonedDateTimeMountain = zonedDateTime.withZoneSameInstant(ZMtc);
        String formattedMountainTime = zonedDateTimeMountain.format(formatter);
        System.out.println("Mountain time " + formattedMountainTime);
*/

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

/*
        ExecutorService messageExecutor = Executors.newFixedThreadPool(2);

        Properties properties=new Properties();
        messageExecutor.execute(()-> {
            try {
                InputStream stream = new ClassPathResource("translation_fr_CA.properties").getInputStream();
                properties.load(stream);
                System.out.println(properties.getProperty("welcome"));

                stream = new ClassPathResource("translation_fr_CA.properties").getInputStream();
                properties.load(stream);
                System.out.println(properties.getProperty("welcome"));

                stream = new ClassPathResource("translation_fr_CA.properties").getInputStream();
                properties.load(stream);
                System.out.println(properties.getProperty("welcome"));

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        messageExecutor.execute(()-> {
            try {
                InputStream stream = new ClassPathResource("translation_en_US.properties").getInputStream();
                properties.load(stream);
                System.out.println(properties.getProperty("welcome"));

                stream = new ClassPathResource("translation_en_US.properties").getInputStream();
                properties.load(stream);
                System.out.println(properties.getProperty("welcome"));

                stream = new ClassPathResource("translation_en_US.properties").getInputStream();
                properties.load(stream);
                System.out.println(properties.getProperty("welcome"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
*/
    }





}
