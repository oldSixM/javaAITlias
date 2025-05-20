package cn.atxm.aop;

import cn.atxm.mapper.OperateLogMapper;
import cn.atxm.pojo.OperateLog;
import cn.atxm.utils.CurrentHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/***
 * @author 马文卓
 * @version 1.0
 * @date 2025/4/12
 */
@Aspect
@Component
public class OperationLogAspect {

    @Autowired
    private OperateLogMapper operateLogMapper;

    @Around("@annotation(cn.atxm.anno.Log)")
    public Object logOperation(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        long endTime = System.currentTimeMillis();
        long costTime = endTime - startTime;


        OperateLog operateLog = new OperateLog();
        operateLog.setOperateEmpId(CurrentHolder.getCurrentId());
        operateLog.setOperateTime(LocalDateTime.now());
        operateLog.setClassName(joinPoint.getTarget().getClass().getName());
        operateLog.setMethodName(joinPoint.getSignature().getName());
        operateLog.setMethodParams(joinPoint.getArgs().toString());
        operateLog.setReturnValue(proceed != null ? proceed.toString() : "void");
        operateLog.setCostTime(costTime);

        operateLogMapper.insert(operateLog);

        return proceed;
    }
}
