package edu.wgu.d387_sample_code.translation;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

        return this.messageService.english() + "<br>" + this.messageService.french();
    }
}
