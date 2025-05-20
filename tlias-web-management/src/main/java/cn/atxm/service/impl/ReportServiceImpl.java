package cn.atxm.service.impl;

import cn.atxm.mapper.ClazzMapper;
import cn.atxm.mapper.EmpMapper;
import cn.atxm.mapper.StudentMapper;
import cn.atxm.pojo.JobOption;
import cn.atxm.pojo.StuOption;
import cn.atxm.service.EmpService;
import cn.atxm.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/***
 * @author 马文卓
 * @version 1.0
 * @date 2025/4/9
 */
@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private ClazzMapper clazzMapper;

    @Override
    public JobOption empJobData() {
        //获取工作职位统计数据
        List<Map<Object,Object>> jobData = empMapper.getJobCountData();
        //获取职位名称
        List<Object> pos = jobData.stream().map(map -> map.get("pos")).toList();
        //获取职位数量
        List<Object> num = jobData.stream().map(map -> map.get("num")).toList();

        return new JobOption(pos,num);
    }

    @Override
    public List<Map<Object, Object>> empGenderData() {
        return empMapper.getEmpGenderData();
    }

    @Override
    public List<Map<Object, Object>> getStudentDegreeData() {
        return studentMapper.getStudentDegreeData();
    }

    @Override
    public StuOption getStudentCountData() {
        List<Map<Object, Object>> list = clazzMapper.getStudentCountData();
        List<Object> clazzList = list.stream().map(pos -> pos.get("pos")).toList();
        List<Object> dataList = list.stream().map(num -> num.get("num")).toList();
        return new StuOption(clazzList,dataList);
    }
}
