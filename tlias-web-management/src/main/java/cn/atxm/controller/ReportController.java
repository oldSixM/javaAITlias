package cn.atxm.controller;

import cn.atxm.pojo.JobOption;
import cn.atxm.pojo.Result;
import cn.atxm.pojo.StuOption;
import cn.atxm.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/***
 * @author 马文卓
 * @version 1.0
 * @date 2025/4/9
 */
@Slf4j
@RequestMapping("/report")
@RestController
public class ReportController {
    @Autowired
    private ReportService reportService;

    @GetMapping("/empJobData")
    public Result empJobData() {
        System.out.println(123);
        JobOption jobOption = reportService.empJobData();
        return Result.success(jobOption);
    }

    @GetMapping("/empGenderData")
    public Result empGenderData() {
        List<Map<Object, Object>> genderData = reportService.empGenderData();
        return Result.success(genderData);
    }

    @GetMapping("/studentDegreeData")
    public Result studentDegreeData() {
        List<Map<Object, Object>> degreeData = reportService.getStudentDegreeData();
        return Result.success(degreeData);
    }

    @GetMapping("/studentCountData")
    public Result studentCountData() {
        StuOption stuOption = reportService.getStudentCountData();
        return Result.success(stuOption);
    }
}
