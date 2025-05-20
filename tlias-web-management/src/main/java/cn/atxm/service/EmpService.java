package cn.atxm.service;

import cn.atxm.pojo.Emp;
import cn.atxm.pojo.EmpQueryParam;
import cn.atxm.pojo.LoginInfo;
import cn.atxm.pojo.PageResult;

import java.util.List;

/***
 * @author 马文卓
 * @version 1.0
 * @date 2025/4/2
 */
public interface EmpService {

    PageResult<Emp> page(EmpQueryParam empQueryParam);

    void insert(Emp emp);

    void delete(List<Integer> ids);

    Emp getInfo(Integer id);

    void update(Emp emp);

    LoginInfo checkLogin(Emp emp);

    List<Emp> list();
}
