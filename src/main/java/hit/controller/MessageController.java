package hit.controller;

import hit.entity.Admin;
import hit.entity.ItemMessage;
import hit.entity.Message;
import hit.repository.AdminRepository;
import hit.repository.MessageRepository;
import hit.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@EnableAutoConfiguration

@RestController
public class MessageController {
    @Autowired
    MessageRepository messageRepository;
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    MessageService messageService;
    @GetMapping("/message/querybyuserid")
    public List<ItemMessage> getMessageByReceiverid(@RequestParam("userid")Integer userid)
    {
       return messageService.getMessageByReceiverid(userid);
    }
    @PostMapping("/message/usersend")
    public void UserSend(@RequestParam("userid")String userid,@RequestParam("text")String text,@RequestParam("adminid")String adminid)
    {
        messageService.UserSend(userid, text, adminid);
    }
    @PostMapping("/message/setread")
    public void SetRead(@RequestParam("messageid")String id)
    {
       messageService.SetRead(id);
    }
}
