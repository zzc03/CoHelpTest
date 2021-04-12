package hit.controller;
import hit.entity.ItemNeed;
import hit.entity.Need;
import hit.entity.Picture;
import hit.entity.User;
import hit.repository.NeedRepository;
import hit.repository.UserRepository;
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
public class PictureController {

}
