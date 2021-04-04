package hit.controller;

import hit.entity.ItemNeed;
import hit.entity.Need;
import hit.entity.User;
import hit.repository.NeedRepository;
import hit.repository.UserRepository;
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
public class NeedController {
    @Autowired
    private NeedRepository needRepository;
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/need/query/all")
    public List<Need> getAllNeed()
    {
        List<Need> list=needRepository.findAll();
        return list;
    }
    @GetMapping("/need/query/all/map")
    public List<ItemNeed> findAllMap() {
        System.out.println("进入查询所有需求方法");
        try {
            List<Need> needs = needRepository.findAll();

            System.out.println("查询出的所有需求为");
            for(Need b:needs)
            {
                System.out.println(b);
            }
            List<ItemNeed> items = new ArrayList<>();
            for (Need need: needs)
            {
                System.out.println("查询出的userid为"+need.getUserid());
                User user=userRepository.findAllByUserId(need.getUserid());
                System.out.println("查询出的user为"+user);
                String userName = user.getName();
                System.out.println("查询出的name为"+userName);

                String state=need.getState();
                ItemNeed itemneed=new ItemNeed(need,userName,state);
                items.add(itemneed);
            }
            for(ItemNeed a:items)
            {
                System.out.println(a);
            }
            return items;
        }
        catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
//    @GetMapping("/need/query/with")
//    public List<Need> findBlogsWithString(@RequestParam(value = "string") String string) {
//        try {
//            return needRepository.getByNeedTextContainingOrNeedTitleContaining(string, string);
//        }
//        catch (Exception e) {
//            return null;
//        }
//    }
    @PostMapping(value = "/need/add")
    public Need addNeed(@RequestParam("userid")Integer userid,@RequestParam("title")String title, @RequestParam("text")String text,@RequestParam("reward")Integer reward)
    {
        System.out.println("进入插入数据方法！");
        Need need;
        Date date=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try{
            need=new Need(title,text,sdf.format(date),"none",reward,userid);
            need=needRepository.save(need);
            return need;
        }catch (Exception e){
            System.out.println("insert error");
            return null;
        }
    }
    @GetMapping("/need/query/all/map/with")
    public List<ItemNeed> findAllMapWithKeyword(@RequestParam("keyword")String keyword) {
        System.out.println("进入查询包含关键字所有需求方法");
        try {
            List<Need> needs = needRepository.getByTextContainingOrTitleContaining(keyword,keyword);
            List<ItemNeed> result=new ArrayList<>();
            System.out.println("查询出的所有需求为");
            for(Need b:needs)
            {
                System.out.println(b);
                String username=userRepository.findAllByUserId(b.getUserid()).getName();
                String state=b.getState();
                ItemNeed itemNeed=new ItemNeed(b,username,state);
                result.add(itemNeed);
            }
            return result;
        }
        catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

}
