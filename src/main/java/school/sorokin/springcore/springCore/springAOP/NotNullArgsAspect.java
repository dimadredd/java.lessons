package school.sorokin.springcore.springCore.springAOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class NotNullArgsAspect {

    @Around("@annotation(notNullArgs)")
    public Object notNullArgs(ProceedingJoinPoint pjp, NotNullArgs notNullArgs) throws Throwable {
        Object[] args = pjp.getArgs();

        for (int i = 0; i < args.length; i++) {
            if (args[i] == null) {
                throw new IllegalArgumentException("Аргумент " + (i + 1) + " не может быть null в методе: " +
                        pjp.getSignature().getName());
            }
        }
        return pjp.proceed();
    }
}
