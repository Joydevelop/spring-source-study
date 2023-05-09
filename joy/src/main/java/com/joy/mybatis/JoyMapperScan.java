package com.joy.mybatis;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Joy
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(JoyImportBeanDefinitionRegistrar.class)
public @interface JoyMapperScan {
	String value() default "";
}
