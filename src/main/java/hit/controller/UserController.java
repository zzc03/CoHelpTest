package hit.controller;

import hit.entity.Register;
import hit.entity.User;
import hit.repository.RegisterRepository;
import hit.repository.UserRepository;
import hit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.jdbc.datasource.UserCredentialsDataSourceAdapter;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//import org.springframework.web.bind.annotation.RequestMapping;

//import org.springframework.web.multipart.MultipartFile;
@EnableAutoConfiguration

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/user/query/all")
    public List<User> getAllUser() {
        return userService.getAllUser();
    }
    @GetMapping("/user/querybyid")
    public User getUserByid(@RequestParam("userid")Integer userid) {
        return userService.getUserByid(userid);
        }
    @GetMapping("/user/querybyaccount")
    public User getUserByAccount(@RequestParam("account")String account) {
        return userService.getUserByAccount(account);
    }

    //post方法插入一个用户
    @PostMapping(value = "/user/add")
    public Register insertUser(@RequestParam("name")String name, @RequestParam("account")String account, @RequestParam("password") String password, @RequestParam("description") String description, @RequestParam("money") Integer money,@RequestParam("head") String head) {
       return userService.insertUser(name, account, password, description, money, head);
    }

    @GetMapping("/user/query")
    public User findUser(@RequestParam("userId") Integer userId,@RequestParam("password") String password){
       return userService.findUser(userId,password);
    }
}
