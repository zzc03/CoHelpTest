package hit.controller;

import hit.entity.*;
import hit.repository.NeedApplyRepository;
import hit.repository.NeedRepository;
import hit.repository.UserRepository;
import hit.repository.ZhongcaiRepository;
import hit.service.NeedService;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
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
import java.util.Optional;

@EnableAutoConfiguration

@RestController
public class NeedController {
    @Autowired
    private NeedService needService;
    @GetMapping("/need/query/all")
    public List<Need> getAllNeed()
    {

        return needService.getAllNeed();
    }
    @GetMapping("/need/query/all/map")
    public List<ItemNeed> findAllMap() {
        return needService.findAllMap();
    }
    @PostMapping(value = "/need/add")
    public NeedApply addNeed(@RequestParam("userid")Integer userid,@RequestParam("title")String title, @RequestParam("text")String text,@RequestParam("reward")Integer reward)
    {
        return needService.addNeed(userid, title, text, reward);
    }
    @GetMapping("/need/query/all/map/with")
    public List<ItemNeed> findAllMapWithKeyword(@RequestParam("keyword")String keyword) {
        return needService.findAllMapWithKeyword(keyword);
    }
    @GetMapping("/need/querybyneedid")
    public ItemNeed findNeedByNeedid(@RequestParam("needid")Integer needid)
    {
        return needService.findNeedByNeedid(needid);
    }
    @GetMapping("/need/querybyuserid")
    public List<ItemNeed> getNeedByUserid(@RequestParam("userid")Integer userid)
    {
        return needService.getNeedByUserid(userid);
    }
    @GetMapping("/needapply/querybyuserid")
    public List<ItemNeedApply> findAllApplyMapWithKeyword(@RequestParam("userid") Integer id) {
        return needService.findAllApplyMapWithKeyword(id);
    }
    @GetMapping("/needapply/querybyneedapplyid")
    public ItemNeedApply findAllApplyMapWithid(@RequestParam("applyid") Integer id) {
       return needService.findAllApplyMapWithid(id);
    }
    @PostMapping(value = "/need/zhongcai/add")
    public ZhongCai addNeedZc(@RequestParam("applyid")Integer applyid,@RequestParam("applyuserid")Integer userid,@RequestParam("zcreason")String reason)
    {
       return needService.addNeedZc(applyid, userid, reason);
    }

}
