package cn.atxm.service;

import cn.atxm.pojo.EmpExpr;

import java.util.List;

/***
 * @author 马文卓
 * @version 1.0
 * @date 2025/4/2
 */
public interface EmpExprService {
    void addBatch(List<EmpExpr> exprList);

    void deleteByEmpIds(List<Integer> ids);
}
