package hit.service;

import hit.entity.Register;
import hit.entity.User;
import hit.repository.RegisterRepository;
import hit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Repository
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RegisterRepository registerRepository;

    public List<User> getAllUser() {
        List<User> user=userRepository.findAll();
        return user;
    }

    public User getUserByid(Integer userid) {
        User user=userRepository.findAllByUserId(userid);
        return user;
    }

    public User getUserByAccount(String account) {
        User user=userRepository.findAllByAccount(account);
        return user;
    }


    public Register insertUser(String name, String account, String password, String description, Integer money, String head) {
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


    public User findUser(Integer userId,String password){
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
