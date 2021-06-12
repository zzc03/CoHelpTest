package hit.controller;
import hit.entity.*;
import hit.repository.NeedRepository;
import hit.repository.PictureRepository;
import hit.repository.ResultRepository;
import hit.repository.UserRepository;
//import com.lzy.imagepicker.bean.ImageItem;
import hit.service.ResultService;
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
    ResultService resultService;
    @GetMapping("/result/querybyid")
    public List<ItemResult> getResultsById(@RequestParam("needid")Integer needid)
    {
       return resultService.getResultsById(needid);
    }
    @GetMapping("/result/querybyneedidanduserid")
    public boolean isAccpeted(@RequestParam("needid") Integer needid,@RequestParam("userid") Integer userid)
    {

        return resultService.isAccpeted(needid, userid);
    }
    @PostMapping("/result/add")
    public void addResult(@RequestParam("needid")Integer needid,@RequestParam("userid")Integer userid,@RequestParam("text")String text,@RequestParam("picture") List<String> pictures)
    {
        resultService.addResult(needid, userid, text, pictures);
    }
    @GetMapping("/result/querybyresultid")
    public ItemResult getResultsByResultId(@RequestParam("resultid")Integer resultid)
    {
        return resultService.getResultsByResultId(resultid);

    }
    @GetMapping("/result/querybyneedid")
    public List<ItemResult> getResultsByNeedId(@RequestParam("needid")Integer needid)
    {
        return resultService.getResultsByNeedId(needid);

    }
    @PostMapping("/result/updatereward")
    public boolean updateReward(@RequestParam("resultid")Integer resultid,@RequestParam("reward") Integer reward,@RequestParam("comment")String comment)
    {
       return resultService.updateReward(resultid, reward, comment);
    }
    @GetMapping("/result/querybyacceptuserid")
    public List<ItemResult> getResultsByacceptuserId(@RequestParam("userid")Integer userid)
    {
       return resultService.getResultsByacceptuserId(userid);
    }
}
