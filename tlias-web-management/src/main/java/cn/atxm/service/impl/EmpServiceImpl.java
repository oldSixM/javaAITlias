package cn.atxm.service.impl;

import cn.atxm.mapper.EmpLogMapper;
import cn.atxm.mapper.EmpMapper;
import cn.atxm.pojo.*;
import cn.atxm.service.EmpService;
import cn.atxm.utils.JWTUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;


import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/***
 * @author 马文卓
 * @version 1.0
 * @date 2025/4/2
 */
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private EmpLogMapper empLogMapper;

    @Autowired
    private EmpExprServiceImpl empExprService;

    @Override
    public PageResult<Emp> page(EmpQueryParam empQueryParam) {
        //1.设置分页
        PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());
        //2.执行查询
        List<Emp> rows = empMapper.list(empQueryParam);
        //3.封装到PageResult中并返回
        Page<Emp> p = (Page<Emp>) rows;
        //4.返回
        return new PageResult<Emp>(p.getTotal(),rows);
    }

    @Transactional(rollbackFor = {Exception.class}) // 事务注解
    @Override
    public void insert(Emp emp) {
        try {
            emp.setCreateTime(LocalDateTime.now());
            emp.setUpdateTime(LocalDateTime.now());
            empMapper.insert(emp);

            List<EmpExpr> exprList = emp.getExprList();
            if(!CollectionUtils.isEmpty(exprList)){
                exprList.forEach(expr->{
                    expr.setEmpId(emp.getId());
                });
                empExprService.addBatch(exprList);
            }
        } finally {
            EmpLog empLog = new EmpLog(null, LocalDateTime.now(), "添加新员工：" + emp);
            empLogMapper.insert(empLog);
        }

    }

    @Override
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);
        empExprService.deleteByEmpIds(ids);
    }

    @Override
    public Emp getInfo(Integer id) {
        return empMapper.getById(id);
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void update(Emp emp) {

        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);

        empExprService.deleteByEmpIds(Collections.singletonList(emp.getId()));

        Integer empId = emp.getId();
        List<EmpExpr> exprList = emp.getExprList();
        if (!CollectionUtils.isEmpty(exprList)) {
            exprList.forEach(expr -> {
                expr.setEmpId(empId);
            });
            empExprService.addBatch(exprList);
        }
    }

    @Override
    public LoginInfo checkLogin(Emp emp) {
        Emp e = empMapper.checkLogin(emp);
        if (e != null) {
            HashMap<String, Object> claims = new HashMap<>();
            claims.put("id", e.getId());
            claims.put("username", e.getUsername());
            String token = JWTUtils.generateToken(claims);
            return new LoginInfo(e.getId(), e.getUsername(), e.getName(), token);
        }
        return null;
    }

    @Override
    public List<Emp> list() {
        return empMapper.alllist();
    }
}
