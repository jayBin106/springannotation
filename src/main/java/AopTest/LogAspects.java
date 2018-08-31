package AopTest;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * * 3、定义一个日志切面类（LogAspects）：切面类里面的方法需要动态感知MathCalculator.div运行到哪里然后执行；
 * 通知方法：
 * 前置通知(@Before)：logStart：在目标方法(div)运行之前运行
 * 后置通知(@After)：logEnd：在目标方法(div)运行结束之后运行（无论方法正常结束还是异常结束）
 * 返回通知(@AfterReturning)：logReturn：在目标方法(div)正常返回之后运行
 * 异常通知(@AfterThrowing)：logException：在目标方法(div)出现异常以后运行
 * 环绕通知(@Around)：动态代理，手动推进目标方法运行（joinPoint.procced()）
 */
@Aspect
public class LogAspects {

    @Pointcut("execution(public int AopTest.MathCalculator.*(..))")
    public void pointCut() {
    }
    @Before("pointCut()")
    public void before() {
        System.out.println("逻辑执行前。。。。");
    }

    @After("pointCut()")
    public void After() {
        System.out.println("逻辑执行后。。。。");
    }

    //JoinPoint一定要出现在参数表的第一位
    @AfterReturning(value = "pointCut()", returning = "result")
    public void AfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("逻辑执行后,正常返回数据。。。。" + joinPoint.getSignature().getName() + "---返回结果------" + result);
    }

    @AfterThrowing(value = "pointCut()", throwing = "result")
    public void AfterThrowing(JoinPoint joinPoint, Object result) {
        System.out.println("逻辑执行后,异常返回数据。。。。" + joinPoint.getSignature().getName() + "---返回结果------" + result);
    }

}
