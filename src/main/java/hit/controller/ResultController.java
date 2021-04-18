package hit.controller;
import hit.entity.ItemResult;
import hit.entity.Picture;
import hit.entity.Result;
import hit.entity.User;
import hit.repository.NeedRepository;
import hit.repository.PictureRepository;
import hit.repository.ResultRepository;
import hit.repository.UserRepository;
//import com.lzy.imagepicker.bean.ImageItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//import org.springframework.web.bind.annotation.RequestMapping;

//import org.springframework.web.multipart.MultipartFile;
@EnableAutoConfiguration

@RestController
public class ResultController {
    @Autowired
    ResultRepository resultRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PictureRepository pictureRepository;
    @Autowired
    NeedRepository needRepository;
    @GetMapping("/result/querybyid")
    public List<ItemResult> getResultsById(@RequestParam("needid")Integer needid)
    {
        List<ItemResult> results=new ArrayList<>();
        List<Result> result=resultRepository.getAllByNeedid(needid);
        for(Result a:result)
        {
            String name=userRepository.findAllByUserId(a.getAcceptuserid()).getName();
            results.add(new ItemResult(a,name));
        }

        return results;
    }
    @GetMapping("/result/querybyneedidanduserid")
    public boolean isAccpeted(@RequestParam("needid") Integer needid,@RequestParam("userid") Integer userid)
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
    @PostMapping("/result/add")
    public void addResult(@RequestParam("needid")Integer needid,@RequestParam("userid")Integer userid,@RequestParam("text")String text,@RequestParam("picture") List<String> pictures)
    {
        Date date=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
                Result result=new Result(needid,userid,"doing",sdf.format(date),text,pictures.size(),0);
                Result b=resultRepository.save(result);
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
    @GetMapping("/result/querybyresultid")
    public ItemResult getResultsByResultId(@RequestParam("resultid")Integer resultid)
    {
        Result result=resultRepository.getAllByResultId(resultid);
        String name=userRepository.findAllByUserId(result.getAcceptuserid()).getName().toString();

        if(result.getPicture()!=0)
        {
            List<Picture> pictures=pictureRepository.getAllByResultid(resultid);
            List<String> b=new ArrayList<>();
            for (Picture a:pictures)
            {
                b.add(a.getPicture());
            }
            return new ItemResult(result,name,b);
        }
        else
        {
            return new ItemResult(result,name,null);
        }


    }
    @GetMapping("/result/querybyneedid")
    public List<ItemResult> getResultsByNeedId(@RequestParam("needid")Integer needid)
    {
        List<Result> results=resultRepository.getAllByNeedid(needid);
        List<ItemResult> results1=new ArrayList<>();

        for(Result a:results)
        {
            String name=userRepository.findAllByUserId(a.getAcceptuserid()).getName().toString();
            if(a.getPicture()!=0)
            {
                List<Picture> pictures=pictureRepository.getAllByResultid(a.getResultId());

                List<String> b=new ArrayList<>();
                for (Picture c:pictures)
                {
                    b.add(c.getPicture());
                }
               results1.add(new ItemResult(a,name,b));
            }
            else
            {
                results1.add(new ItemResult(a,name,null));
            }
        }

        return results1;

    }
    @PostMapping("/result/updatereward")
    public boolean updateReward(@RequestParam("resultid")Integer resultid,@RequestParam("reward") Integer reward,@RequestParam("comment")String comment)
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
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    return false;
    }
}
