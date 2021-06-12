package hit.service;

import hit.entity.*;
import hit.repository.NeedApplyRepository;
import hit.repository.NeedRepository;
import hit.repository.UserRepository;
import hit.repository.ZhongcaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Repository
public class NeedService {
    @Autowired
    private NeedRepository needRepository;
    @Autowired
    private NeedApplyRepository needApplyRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ZhongcaiRepository zhongcaiRepository;
    public List<Need> getAllNeed()
    {
        List<Need> list=needRepository.findAll();
        return list;
    }
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
                ItemNeed itemneed=new ItemNeed(need,userName,state,user.getIcon());
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
    public NeedApply addNeed(Integer userid, String title, String text, Integer reward)
    {
        System.out.println("进入插入数据方法！");
        NeedApply need;
        Date date=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try{
//            need=new Need(title,text,sdf.format(date),"未完成",reward,userid,0);
//            need=needRepository.save(need);
            need=new NeedApply(userid,title,text,sdf.format(date),reward,"申请中",null,null,null);
            need=needApplyRepository.save(need);
            return need;
        }catch (Exception e){
            System.out.println("insert error");
            return null;
        }
    }
    public List<ItemNeed> findAllMapWithKeyword(String keyword) {
        System.out.println("进入查询包含关键字所有需求方法");
        try {
            List<Need> needs = needRepository.getByTextContainingOrTitleContaining(keyword,keyword);
            List<ItemNeed> result=new ArrayList<>();
            System.out.println("查询出的所有需求为");
            for(Need b:needs)
            {
                System.out.println(b);
                User user=userRepository.findAllByUserId(b.getUserid());
                String username=user.getName();
                String state=b.getState();
                ItemNeed itemNeed=new ItemNeed(b,username,state,user.getIcon());
                result.add(itemNeed);
            }
            return result;
        }
        catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public ItemNeed findNeedByNeedid(Integer needid)
    {
        try{
            Need need=needRepository.findByNeedId(needid);
            User user=userRepository.findAllByUserId(need.getUserid());
            String username=user.getName();
            String state=need.getState();
            ItemNeed itemNeed=new ItemNeed(need,username,state,user.getIcon());
            return itemNeed;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    public List<ItemNeed> getNeedByUserid(Integer userid)
    {
        List<ItemNeed> results=new ArrayList<>();
        List<Need> needs=needRepository.getAllByUserid(userid);
        for(Need a:needs)
        {
            User user=userRepository.findAllByUserId(a.getUserid());
            String username=user.getName();
            results.add(new ItemNeed(a,username,"",user.getIcon()));
        }
        return results;
    }

    public List<ItemNeedApply> findAllApplyMapWithKeyword(Integer id) {
        //System.out.println("进入查询包含关键字所有需求方法");
        try {
//            List<Need> needs = needRepository.getByTextContainingOrTitleContaining(keyword,keyword);
//            List<ItemNeed> result=new ArrayList<>();
//            System.out.println("查询出的所有需求为");
//            for(Need b:needs)
//            {
//                System.out.println(b);
//                User user=userRepository.findAllByUserId(b.getUserid());
//                String username=user.getName();
//                String state=b.getState();
//                ItemNeed itemNeed=new ItemNeed(b,username,state,user.getIcon());
//                result.add(itemNeed);
//            }
//            return result;
            List<NeedApply> list=needApplyRepository.getAllByApplyuserid(id);
            List<ItemNeedApply> result=new ArrayList<>();
            for(NeedApply a:list)
            {
                User user=userRepository.findAllByUserId(a.getApplyuserid());
                String icon=user.getIcon();
                result.add(new ItemNeedApply(user.getName(),a,icon));
            }
            return result;
        }
        catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public ItemNeedApply findAllApplyMapWithid( Integer id) {
        //System.out.println("进入查询包含关键字所有需求方法");
        try {
//            List<Need> needs = needRepository.getByTextContainingOrTitleContaining(keyword,keyword);
//            List<ItemNeed> result=new ArrayList<>();
//            System.out.println("查询出的所有需求为");
//            for(Need b:needs)
//            {
//                System.out.println(b);
//                User user=userRepository.findAllByUserId(b.getUserid());
//                String username=user.getName();
//                String state=b.getState();
//                ItemNeed itemNeed=new ItemNeed(b,username,state,user.getIcon());
//                result.add(itemNeed);
//            }
//            return result;
            NeedApply needApply=needApplyRepository.getAllByApplyid(id);
            User user=userRepository.findAllByUserId(needApply.getApplyuserid());
            String icon=user.getIcon();
            ItemNeedApply result=new ItemNeedApply(user.getName(),needApply,icon);
            return result;
        }
        catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public ZhongCai addNeedZc(Integer applyid,Integer userid,String reason)
    {
        System.out.println("进入插入数据方法！");
        NeedApply need;
        Date date=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try{
            need=needApplyRepository.getAllByApplyid(applyid);
            ZhongCai zhongCai=new ZhongCai(1,need.getApplyid(),reason,need.getApplyuserid(),sdf.format(date),null,null,null,null);
            zhongcaiRepository.save(zhongCai);
            return zhongCai;
        }catch (Exception e){
            System.out.println("insert error");
            return null;
        }
    }

}
