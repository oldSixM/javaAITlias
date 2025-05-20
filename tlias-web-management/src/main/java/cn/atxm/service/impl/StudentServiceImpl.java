package cn.atxm.service.impl;

import cn.atxm.mapper.StudentMapper;
import cn.atxm.pojo.PageResult;
import cn.atxm.pojo.Student;
import cn.atxm.pojo.StudentQueryParam;
import cn.atxm.service.StudentService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/***
 * @author 马文卓
 * @version 1.0
 * @date 2025/4/9
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public PageResult<Student> page(StudentQueryParam queryParam) {
        PageHelper.startPage(queryParam.getPage(),queryParam.getPageSize());
        List<Student> pageResult = studentMapper.list(queryParam);
        Page<Student> page = (Page<Student>) pageResult;
        return new PageResult<Student>(page.getTotal(),pageResult);
    }

    @Override
    public void delete(String ids) {
        String[] split = ids.split(",");
        List<Integer> list = Arrays.stream(split).map(Integer::parseInt).toList();
        studentMapper.delete(list);
    }

    @Override
    public void insert(Student student) {
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.insert(student);
    }

    @Override
    public Student getInfo(Integer id) {
        return studentMapper.getById(id);
    }

    @Override
    public void update(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.update(student);
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void violation(Integer id, Integer score) {
        Student stu = studentMapper.getById(id);
        stu.setViolationCount(stu.getViolationCount() + 1);
        stu.setViolationScore(stu.getViolationScore() + score);
        stu.setUpdateTime(LocalDateTime.now());
        studentMapper.update(stu);
    }
}
