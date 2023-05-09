package com.joy.mybatis;

import com.joy.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Joy
 */
public class JoyFactoryBean implements FactoryBean {

	private Class mapperInterface;

	private SqlSession sqlSession;

	public void setSqlSession(SqlSessionFactory sqlSessionFactory) {
		sqlSessionFactory.getConfiguration().addMapper(mapperInterface);
		this.sqlSession = sqlSessionFactory.openSession();
	}

	public JoyFactoryBean(Class mapperInterface) {
		this.mapperInterface = mapperInterface;
	}

	@Override
	public Object getObject() throws Exception {
		return sqlSession.getMapper(mapperInterface);
	}

	@Override
	public Class<?> getObjectType() {
		return mapperInterface;
	}
}
