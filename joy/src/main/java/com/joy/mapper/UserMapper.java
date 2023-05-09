package com.joy.mapper;

import org.apache.ibatis.annotations.Select;

/**
 * @author Joy
 */
public interface UserMapper {

	@Select("select 'user'")
	String selectName();
}
