@Component
@Aspect
public class PrintExcutionTimeAspect {
    @AterThrowing(
           pointcut = "@annotation(PrintExceptionTime)",
           throwing="ex"
    )
    public void afterTrowing(JoinPoint joinPoint, Exception ex) {
        System.out.println("afterThrowing " + jionPoint.toShortSstring()
                + " with " + joinPoint.getArgs().length
                + " args throwing " + ex.toString());
    }

    // ...
}