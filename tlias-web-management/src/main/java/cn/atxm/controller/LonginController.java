package cn.atxm.controller;

import cn.atxm.pojo.Emp;
import cn.atxm.pojo.LoginInfo;
import cn.atxm.pojo.Result;
import cn.atxm.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/***
 * @author 马文卓
 * @version 1.0
 * @date 2025/4/11
 */
@Slf4j
@RequestMapping("/login")
@RestController
public class LonginController {

    @Autowired
    private EmpService empService;

    @PostMapping
    public Result checkLogin(@RequestBody Emp emp){
        LoginInfo loginInfo = empService.checkLogin(emp);
        if (loginInfo == null){
            return Result.error("用户名或密码错误");
        }
        return Result.success(loginInfo);
    }
}
