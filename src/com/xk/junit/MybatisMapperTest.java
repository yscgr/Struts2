package com.xk.junit;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.xk.mapper.UserMapper;
import com.xk.model.User;
import com.xk.model.UserExample;
import com.xk.util.MybatisUtil;

public class MybatisMapperTest {
	@Test
	public void testGetUser() throws IOException {
		SqlSession sqlSession = MybatisUtil.getSqlSession(true);
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.selectByPrimaryKey(6);
		System.out.println(user.getUsername()+" "+user.getEmail());
	}
	@Test
	public void testGetAllUser() throws IOException {
		SqlSession sqlSession = MybatisUtil.getSqlSession(true);
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		UserExample example = new UserExample();
		List<User> users = userMapper.selectByExample(example);
		System.out.println(users);
	}
	@Test
	public void testDeleteUser() throws IOException {
		SqlSession sqlSession = MybatisUtil.getSqlSession(true);
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		userMapper.deleteByPrimaryKey(12);
	}
	
}
