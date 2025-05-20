package cn.atxm.controller;

import cn.atxm.anno.Log;
import cn.atxm.pojo.*;
import cn.atxm.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/***
 * @author 马文卓
 * @version 1.0
 * @date 2025/4/9
 */
@Slf4j
@RequestMapping("/clazzs")
@RestController
public class ClazzController {
    @Autowired
    private ClazzService clazzService;

    @GetMapping
    public Result list(ClazzQueryParam queryParam){
        log.info("分页查询，参数：{}",queryParam);
        System.out.println("master test");
        PageResult<Clazz> pageResult = clazzService.page(queryParam);
        return Result.success(pageResult);
    }

    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("根据id查询班级信息，id：{}",id);
        Clazz clazz = clazzService.getInfo(id);
        return Result.success(clazz);
    }

    @GetMapping("/list")
    public Result list(){
        List<Clazz> list = clazzService.list();
        return Result.success(list);
    }

    @Log
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("根据id删除班级信息，id：{}",id);
        clazzService.delete(id);
        return Result.success();
    }

    @Log
    @PostMapping
    public Result insert(@RequestBody Clazz clazz){
        System.out.println(clazz);
        clazzService.insert(clazz);
        return Result.success();
    }

    @Log
    @PutMapping
    public Result update(@RequestBody Clazz clazz){
        clazzService.update(clazz);
        return Result.success();
    }
}
