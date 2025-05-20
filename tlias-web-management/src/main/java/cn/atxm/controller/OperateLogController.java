package cn.atxm.controller;

import cn.atxm.pojo.OperateLog;
import cn.atxm.pojo.PageResult;
import cn.atxm.pojo.Result;
import cn.atxm.service.OperateLogService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/***
 * @author 马文卓
 * @version 1.0
 * @date 2025/4/18
 */
@Slf4j
@RestController
public class OperateLogController {

    @Autowired
    private OperateLogService operateLogService;

    @GetMapping("/log/page")
    public Result getOperateLogs(@RequestParam(defaultValue = "1") Integer page,
                                 @RequestParam(defaultValue = "10")Integer pageSize) {
        return Result.success(operateLogService.page(page, pageSize));
    }
}
