package hit.controller;

import hit.entity.Register;
import hit.entity.User;
import hit.repository.RegisterRepository;
import hit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//import org.springframework.web.bind.annotation.RequestMapping;

//import org.springframework.web.multipart.MultipartFile;
@EnableAutoConfiguration

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RegisterRepository registerRepository;
    @GetMapping("/user/query/all")
    public List<User> getAllUser() {
        List<User> user=userRepository.findAll();
        return user;
    }
    @GetMapping("/user/querybyid")
    public User getUserByid(@RequestParam("userid")Integer userid) {
        User user=userRepository.findAllByUserId(userid);
        return user;
        }
    @GetMapping("/user/querybyaccount")
    public User getUserByAccount(@RequestParam("account")String account) {
        User user=userRepository.findAllByAccount(account);
        return user;
    }

    //post方法插入一个用户
    @PostMapping(value = "/user/add")
    public Register insertUser(@RequestParam("name")String name, @RequestParam("account")String account, @RequestParam("password") String password, @RequestParam("description") String description, @RequestParam("money") Integer money,@RequestParam("head") String head) {
        System.out.println("进入插入数据方法！");
        Register register=new Register(account,password,name,description,head,"申请中");
        try{
            register=registerRepository.save(register);
            return register;
        }catch (Exception e){
            System.out.println("insert error");
            return null;
        }
    }

    @GetMapping("/user/query")
    public User findUser(@RequestParam("userId") Integer userId,@RequestParam("password") String password){
        System.out.println("进入查询数据方法！");
        User user=userRepository.findAllByUserId(userId);
        System.out.println("查询的id为"+userId);
        System.out.println("查询的密码为"+user.getPassword());
        System.out.println("查询的密码为"+user.getPassword());
        if(user.getPassword().equals(password))
        {
            return user;
        }
        else
        {
            return null;
        }
    }
}
