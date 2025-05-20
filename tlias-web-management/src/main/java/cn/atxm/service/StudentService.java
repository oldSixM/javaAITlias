package cn.atxm.service;

import cn.atxm.pojo.PageResult;
import cn.atxm.pojo.Student;
import cn.atxm.pojo.StudentQueryParam;

/***
 * @author 马文卓
 * @version 1.0
 * @date 2025/4/9
 */
public interface StudentService {
    PageResult<Student> page(StudentQueryParam queryParam);

    void delete(String ids);

    void insert(Student student);

    Student getInfo(Integer id);

    void update(Student student);

    void violation(Integer id, Integer score);
}
