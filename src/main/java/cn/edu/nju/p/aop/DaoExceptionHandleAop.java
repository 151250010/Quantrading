package cn.edu.nju.p.aop;

import cn.edu.nju.p.exception.StockNotFoundException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by soft on 2017/5/15.
 */
@Aspect
@Component
public class DaoExceptionHandleAop {

    @Pointcut(value = "execution(* cn.edu.nju.p.dao.StockDao.*(..)) && @annotation(cn.edu.nju.p.annotation.StockNotFoundCheck)") //implies all the methods of stock dao
    public void getStockInfo(){}

    @Around(value = "getStockInfo()")
    public Object getStockInfo(ProceedingJoinPoint proceedingJoinPoint) {
        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
            if (result == null) {
                throw new StockNotFoundException(proceedingJoinPoint.getSignature().getName() + " could not find the stock!");
            }
        } catch (Throwable throwable) {
            /**
             * to be completed
             */
        }
        return result;
    }
}
