package edu.wgu.d387_sample_code.translation;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@CrossOrigin("*")
@RequestMapping("/welcome")
public class MessageRestController {

    private MessageService messageService;

    public MessageRestController(MessageService messageService) {
        this.messageService = messageService;
    }


    @GetMapping("/getmessage")
    public String getMessages() {

        return this.messageService.french();
    }

    @GetMapping("/timezone")
    public String convertTimeZone() {

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



        String returnVal = "UTC " + formattedUniversalTime + "<br>" + "EST " + formattedEasternTime + "<br>" + "MST " + formattedMountainTime;


        return returnVal;
    }
}
