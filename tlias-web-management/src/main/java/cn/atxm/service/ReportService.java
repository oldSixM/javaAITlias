package cn.atxm.service;

import cn.atxm.pojo.JobOption;
import cn.atxm.pojo.StuOption;

import java.util.List;
import java.util.Map;

/***
 * @author 马文卓
 * @version 1.0
 * @date 2025/4/9
 */
public interface ReportService {
    JobOption empJobData();

    List<Map<Object, Object>> empGenderData();

    List<Map<Object, Object>> getStudentDegreeData();

    StuOption getStudentCountData();
}
