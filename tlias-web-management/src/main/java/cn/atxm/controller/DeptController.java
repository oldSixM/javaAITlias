package cn.atxm.controller;

import cn.atxm.anno.Log;
import cn.atxm.pojo.Dept;
import cn.atxm.pojo.Result;
import cn.atxm.service.DeptService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/***
 * @author 马文卓
 * @version 1.0
 * @date 2025/3/31
 * 部门管理信息
 */
@Slf4j
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping("/depts")
    public Result list(){
        return Result.success(deptService.getALLDept());
    }

    @Log
    @DeleteMapping("/depts")
    public Result delete(@RequestParam("id") Integer deptId){
        deptService.delete(deptId);
        return Result.success();
    }

    @Log
    @PostMapping("/depts")
    public Result add(@RequestBody Dept dept){
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptService.add(dept);
        return Result.success();
    }

    @GetMapping("/depts/{id}")
    public Result getById(@PathVariable("id") Integer deptId){
        return Result.success(deptService.getById(deptId));
    }

    @Log
    @PutMapping("/depts")
    public Result update(@RequestBody Dept dept){
        dept.setUpdateTime(LocalDateTime.now());
        deptService.update(dept);
        return Result.success();
    }
}
