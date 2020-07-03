package org.springframework.samples.petclinic.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) // 메소드에 적용되는 annotation
@Retention(RetentionPolicy.RUNTIME) // Runtime 시간 동안 적용 된다
public @interface LogExecutionTime {

}
