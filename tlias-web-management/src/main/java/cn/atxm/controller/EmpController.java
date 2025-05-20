package cn.atxm.controller;

import cn.atxm.anno.Log;
import cn.atxm.pojo.Emp;
import cn.atxm.pojo.EmpQueryParam;
import cn.atxm.pojo.PageResult;
import cn.atxm.pojo.Result;
import cn.atxm.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/***
 * @author 马文卓
 * @version 1.0
 * @date 2025/4/2
 * 员工管理
 */
@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {
    @Autowired
    private EmpService empService;
    @GetMapping
    public Result list(EmpQueryParam empQueryParam){
        PageResult<Emp> pageResult = empService.page(empQueryParam);
        return Result.success(pageResult);
    }

    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        Emp emp = empService.getInfo(id);
        return Result.success(emp);
    }

    @GetMapping("/list")
    public Result list(){
        List<Emp> list = empService.list();
        return Result.success(list);
    }

    @Log
    @PostMapping
    public Result insert(@RequestBody Emp emp){
        empService.insert(emp);
        return Result.success();
    }

    @Log
    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids){
        empService.delete(ids);
        return Result.success();
    }

    @Log
    @PutMapping
    public Result update(@RequestBody Emp emp){
        empService.update(emp);
        return Result.success();
    }
}
