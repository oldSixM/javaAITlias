package cn.atxm.controller;

import cn.atxm.anno.Log;
import cn.atxm.pojo.PageResult;
import cn.atxm.pojo.Result;
import cn.atxm.pojo.Student;
import cn.atxm.pojo.StudentQueryParam;
import cn.atxm.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/***
 * @author 马文卓
 * @version 1.0
 * @date 2025/4/9
 */
@Slf4j
@RequestMapping("/students")
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public Result list(StudentQueryParam queryParam) {
        PageResult<Student> pageResult = studentService.page(queryParam);
        return Result.success(pageResult);
    }

    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id) {
        Student student = studentService.getInfo(id);
        return Result.success(student);
    }

    @Log
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable String ids) {
        studentService.delete(ids);
        return Result.success();
    }

    @Log
    @PostMapping
    public Result insert(@RequestBody Student student) {
        studentService.insert(student);
        return Result.success();
    }

    @Log
    @PutMapping
    public Result update(@RequestBody Student student) {
        log.info("student:{}", student);
        studentService.update(student);
        return Result.success();
    }

    @Log
    @PutMapping("/violation/{id}/{score}")
    public Result violation(@PathVariable Integer id, @PathVariable Integer score) {
        studentService.violation(id, score);
        return Result.success();
    }
}
