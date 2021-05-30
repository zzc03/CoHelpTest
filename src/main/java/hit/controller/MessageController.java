package hit.controller;

import hit.entity.Admin;
import hit.entity.ItemMessage;
import hit.entity.Message;
import hit.repository.AdminRepository;
import hit.repository.MessageRepository;
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
    @GetMapping("/message/querybyuserid")
    public List<ItemMessage> getMessageByReceiverid(@RequestParam("userid")Integer userid)
    {
        List<Message> messages=messageRepository.findAllByReceiverid(userid);
        List<ItemMessage> results=new ArrayList<>();
        for(Message a:messages)
        {
            if(a.getType()==1)
            {
                Admin admin=adminRepository.findAdminById(a.getSendid());
                results.add(new ItemMessage(a,admin.getName()));
            }

        }
        return results;
    }
    @PostMapping("/message/usersend")
    public void UserSend(@RequestParam("userid")String userid,@RequestParam("text")String text,@RequestParam("adminid")String adminid)
    {
        Date date=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if(adminid.equals(""))
        {
            Message message=new Message(2,Integer.parseInt(userid),1,0,"",text,sdf.format(date));
            messageRepository.save(message);
        }
        else
        {
            Message message=new Message(2,Integer.parseInt(userid),Integer.parseInt(adminid),0,"",text,sdf.format(date));
            messageRepository.save(message);
        }
    }
    @PostMapping("/message/setread")
    public void SetRead(@RequestParam("messageid")String id)
    {
       Message message=messageRepository.getAllById(Integer.parseInt(id));
       message.setIsread(1);
       messageRepository.saveAndFlush(message);
    }
}
