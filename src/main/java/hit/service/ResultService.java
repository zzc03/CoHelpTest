package hit.service;

import hit.entity.*;
import hit.repository.NeedRepository;
import hit.repository.PictureRepository;
import hit.repository.ResultRepository;
import hit.repository.UserRepository;
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
public class ResultService {
    @Autowired
    ResultRepository resultRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PictureRepository pictureRepository;
    @Autowired
    NeedRepository needRepository;

    public List<ItemResult> getResultsById(Integer needid)
    {
        List<ItemResult> results=new ArrayList<>();
        List<Result> result=resultRepository.getAllByNeedid(needid);
        for(Result a:result)
        {
            User user=userRepository.findAllByUserId(a.getAcceptuserid());
            String name=user.getName();
            results.add(new ItemResult(a,name));
        }

        return results;
    }

    public boolean isAccpeted(Integer needid,Integer userid)
    {

        List<Result> results=resultRepository.getAllByNeedid(needid);
        for(Result a:results)
        {
            if(a.getAcceptuserid()==userid)
            {
                return true;

            }
        }
        return false;
    }

    public void addResult(Integer needid,Integer userid,String text, List<String> pictures)
    {
        Date date=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Result result=new Result(needid,userid,"正在进行",sdf.format(date),text,pictures.size(),0);
            Result b=resultRepository.save(result);
            Need need=needRepository.findByNeedId(needid);
            need.setState("正在进行");
            needRepository.saveAndFlush(need);
            if(pictures.size()!=0)
            {
                for(String a:pictures)
                {
                    pictureRepository.save(new Picture(b.getResultId(),a));
                }
            }
        }catch (Exception e){
            System.out.println("insert error");

        }


    }

    public ItemResult getResultsByResultId(Integer resultid)
    {
        Result result=resultRepository.getAllByResultId(resultid);
        User user=userRepository.findAllByUserId(result.getAcceptuserid());
        String name=user.getName();

        if(result.getPicture()!=0)
        {
            List<Picture> pictures=pictureRepository.getAllByResultid(resultid);
            List<String> b=new ArrayList<>();
            for (Picture a:pictures)
            {
                b.add(a.getPicture());
            }
            return new ItemResult(user.getIcon(),result,name,b);
        }
        else
        {
            return new ItemResult(user.getIcon(),result,name,null);
        }


    }

    public List<ItemResult> getResultsByNeedId(Integer needid)
    {
        List<Result> results=resultRepository.getAllByNeedid(needid);
        List<ItemResult> results1=new ArrayList<>();

        for(Result a:results)
        {
            User user=userRepository.findAllByUserId(a.getAcceptuserid());
            String name=user.getName();
            String icon=user.getIcon();
            if(a.getPicture()!=0)
            {
                List<Picture> pictures=pictureRepository.getAllByResultid(a.getResultId());

                List<String> b=new ArrayList<>();
                for (Picture c:pictures)
                {
                    b.add(c.getPicture());
                }
                results1.add(new ItemResult(icon,a,name,b));
            }
            else
            {
                results1.add(new ItemResult(icon,a,name,null));
            }
        }

        return results1;

    }

    public boolean updateReward(Integer resultid, Integer reward,String comment)
    {
        try{
            Result result=resultRepository.getAllByResultId(resultid);
            Integer publishid=needRepository.findByNeedId(result.getNeedid()).getUserid();
            Integer acceptid=result.getAcceptuserid();
            User publish=userRepository.findAllByUserId(publishid);
            publish.setMoney(publish.getMoney()-reward);
            userRepository.saveAndFlush(publish);
            User accept=userRepository.findAllByUserId(acceptid);
            accept.setMoney(accept.getMoney()+reward);
            userRepository.saveAndFlush(accept);
            result.setReward(reward);
            result.setComment(comment);
            resultRepository.saveAndFlush(result);
            Need need=needRepository.findByNeedId(result.getNeedid());
            need.setState("已完成");
            needRepository.saveAndFlush(need);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    public List<ItemResult> getResultsByacceptuserId(Integer userid)
    {
        List<Result> results=resultRepository.getAllByAcceptuserid(userid);
        List<ItemResult> results1=new ArrayList<>();

        for(Result a:results)
        {
            User user=userRepository.findAllByUserId(a.getAcceptuserid());
            String name=user.getName();
            String icon=user.getIcon();
            if(a.getPicture()!=0)
            {
                List<Picture> pictures=pictureRepository.getAllByResultid(a.getResultId());

                List<String> b=new ArrayList<>();
                for (Picture c:pictures)
                {
                    b.add(c.getPicture());
                }
                results1.add(new ItemResult(icon,a,name,b));
            }
            else
            {
                results1.add(new ItemResult(icon,a,name,null));
            }
        }

        return results1;

    }
}
