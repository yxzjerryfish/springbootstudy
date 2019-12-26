package fish.study.geekband1.controller;

import fish.study.geekband1.OutPutLog;
import fish.study.geekband1.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserController.
 *
 * @date: 2019-12-26
 * @version: 1.0
 * @author: fish paradise
 */
@RestController
public class UserController {

    @OutPutLog
    @RequestMapping("/getuser")
    public User getUser(){
        User user = new User();
        user.setId(123);
        user.setName("fish");
        return user;
    }

}