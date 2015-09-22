package demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.JoinPoint.StaticPart;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
public class ApiLoggerAspect {
	private Log log = LogFactory.getLog(ApiLoggerAspect.class);

	@Pointcut("within(@org.springframework.stereotype.Controller *) || within(@org.springframework.web.bind.annotation.RestController *)")
	private void controllerBean() {
	}

	@Pointcut("execution(* demo.api.*.*(..))")
	private void apiMethod() {
	}

	@Before("controllerBean() && apiMethod()")
	public void beforeMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		CodeSignature codeSignature = (CodeSignature) joinPoint.getSignature();
		Object[] argValues = joinPoint.getArgs();
		Object[] argNames = codeSignature.getParameterNames();
		StringBuilder param = new StringBuilder();
		for (int i = 0; i < argNames.length; i++) {
			param.append(String.format("%s=%s", argNames[i], argValues[i]));
			if (i  <=  argNames.length - 1) {
				param.append(",");
			}
		}
		log.info(String.format("[API][%s] START. request:%s", methodName, param.toString()));
	}

	@AfterReturning(pointcut = "controllerBean() && apiMethod()", returning = "ret")
	public void afterMethod(StaticPart staticPart, Object ret) {
		String methodName = staticPart.getSignature().getName();
		log.info(String.format("[API]%s END. response:%s", methodName, ret));
	}

	@Around("controllerBean() && apiMethod()")
	public Object aroundMethod(ProceedingJoinPoint pjp) throws Throwable {
		String methodName = pjp.getSignature().getName();
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		Object result = pjp.proceed();
		stopWatch.stop();
		log.info(String.format("[API]%s elasped time:%s secs", methodName, stopWatch.getTotalTimeSeconds()));
		return result;
	}

}
