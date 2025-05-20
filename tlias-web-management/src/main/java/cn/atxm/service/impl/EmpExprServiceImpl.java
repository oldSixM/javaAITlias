package cn.atxm.service.impl;

import cn.atxm.mapper.EmpExprMapper;
import cn.atxm.pojo.EmpExpr;
import cn.atxm.service.EmpExprService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 * @author 马文卓
 * @version 1.0
 * @date 2025/4/2
 */
@Service
public class EmpExprServiceImpl implements EmpExprService {
    @Autowired
    private EmpExprMapper empExprMapper;

    @Override
    public void addBatch(List<EmpExpr> exprList) {
        empExprMapper.addBatch(exprList);
    }

    @Override
    public void deleteByEmpIds(List<Integer> ids) {
        empExprMapper.deleteByEmpIds(ids);
    }
}
