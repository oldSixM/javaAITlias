package cn.atxm.service;

import cn.atxm.pojo.Clazz;
import cn.atxm.pojo.ClazzQueryParam;
import cn.atxm.pojo.PageResult;

import java.util.List;

/***
 * @author 马文卓
 * @version 1.0
 * @date 2025/4/9
 */
public interface ClazzService {

    PageResult<Clazz> page(ClazzQueryParam queryParam);

    void delete(Integer id);

    void insert(Clazz clazz);

    Clazz getInfo(Integer id);

    void update(Clazz clazz);

    List<Clazz> list();
}
