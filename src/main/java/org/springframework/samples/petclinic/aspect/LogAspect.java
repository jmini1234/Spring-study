package org.springframework.samples.petclinic.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component // Bean이라는 뜻, Annotation 적용은 Bean에만 가능하다.
@Aspect
public class LogAspect {

	// logger 등록
	Logger logger = LoggerFactory.getLogger(LogAspect.class);

	@Around("@annotation(LogExecutionTime)")
	public Object LogExecutionTime(ProceedingJoinPoint joinPoints) throws Throwable {
		// java에서 제공하는 StopWatch 사용
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();

		Object ret = joinPoints.proceed();

		stopWatch.stop();
		logger.info(stopWatch.prettyPrint());

		return ret;
	}

}
