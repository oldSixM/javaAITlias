package cn.atxm.service;

import cn.atxm.pojo.OperateLog;
import cn.atxm.pojo.PageResult;

/***
 * @author 马文卓
 * @version 1.0
 * @date 2025/4/18
 */
public interface OperateLogService {
    PageResult<OperateLog> page(Integer page, Integer pageSize);
}
