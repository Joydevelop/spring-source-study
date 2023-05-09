package com.joy.mybatis;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

import java.util.Set;

/**
 * @author Joy
 */
public class JoyBeanDefinitionScanner extends ClassPathBeanDefinitionScanner {

	public JoyBeanDefinitionScanner(BeanDefinitionRegistry registry) {
		super(registry);
	}

	@NotNull
	@Override
	protected Set<BeanDefinitionHolder> doScan(@NotNull String... basePackages) {
		Set<BeanDefinitionHolder> beanDefinitionHolders = super.doScan(basePackages);
		for (BeanDefinitionHolder beanDefinitionHolder : beanDefinitionHolders) {
			GenericBeanDefinition beanDefinition = (GenericBeanDefinition) beanDefinitionHolder.getBeanDefinition();
			beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(beanDefinition.getBeanClassName());
			beanDefinition.setBeanClassName(JoyFactoryBean.class.getName());
			beanDefinition.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);
		}
		return beanDefinitionHolders;
	}

	@Override
	protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
		return beanDefinition.getMetadata().isInterface();
	}
}
