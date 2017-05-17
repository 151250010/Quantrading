package cn.edu.nju.p.aop;

import cn.edu.nju.p.exception.StockNotFoundException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AdviceName;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by soft on 2017/5/15.
 */
//@Aspect
//@Component
public class DaoExceptionHandleAop {

    /* execution(* cn.edu.nju.p.dao.StockDao.*(..)) && @annotation(cn.edu.nju.p.annotation.StockNotFoundCheck)*/

    @Pointcut(value = "execution(* cn.edu.nju.p.dao.StockDao.*(..))") //implies all the methods of stock dao
    public void getStockInfo(){}

    @Pointcut("execution(* cn.edu.nju.p.controller.exhibition.ExhibitionController.*(..))")
    public void exhibition(){}

    @Around(value = "exhibition()")
    public Object getStockInfo(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("Could go here!");
        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (NullPointerException ne) {
            throw new StockNotFoundException(proceedingJoinPoint.getSignature().getName() + " could not find the stock!");
        } catch (Throwable throwable) {
            /**
             * to be completed
             */
        }
        return result;
    }
}
