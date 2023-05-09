package com.joy.mybatis;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;
import java.util.Map;

/**
 * @author Joy
 */
public class JoyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry, BeanNameGenerator importBeanNameGenerator) {
		Map<String, Object> annotationAttributes = importingClassMetadata.getAnnotationAttributes(JoyMapperScan.class.getName());
		String path = (String) annotationAttributes.get("value");
		JoyBeanDefinitionScanner joyBeanDefinitionScanner = new JoyBeanDefinitionScanner(registry);
		joyBeanDefinitionScanner.addIncludeFilter((metadataReader, metadataReaderFactory) -> true);
		joyBeanDefinitionScanner.scan(path);
	}
}
