@Component
@Aspect
public class PrintExcutionTimeAspect {
    @AterReturning(
        pointcut = "@annotation(PrintExceptionTime)",
        returning ="result"
    )
    public void afterReturReturnung(JoinPoint joinPoint.Object result) {
        System.out.println("afterReturning " + joinPoint, toShortString()
                + " with " +joinPoint.getArgs().length
                + " args returning "  + result.toString());
    }
        //...
}