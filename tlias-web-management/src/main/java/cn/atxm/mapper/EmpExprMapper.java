package cn.atxm.mapper;

import cn.atxm.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/***
 * @author 马文卓
 * @version 1.0
 * @date 2025/4/3
 */
@Mapper
public interface EmpExprMapper {
    void addBatch(List<EmpExpr> exprList);

    void deleteByEmpIds(List<Integer> ids);
}
