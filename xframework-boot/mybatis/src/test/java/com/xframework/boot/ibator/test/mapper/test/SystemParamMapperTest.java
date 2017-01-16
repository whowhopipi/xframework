package com.xframework.boot.ibator.test.mapper.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.xframework.boot.ibator.test.XframeworkMybatisTest;
import com.xframework.boot.ibator.test.entity.SysParam;
import com.xframework.boot.ibator.test.entity.SysParamExample;
import com.xframework.boot.ibator.test.mapper.SysParamMapper;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = XframeworkMybatisTest.class)
@WebAppConfiguration
@Slf4j
public class SystemParamMapperTest {

	@Autowired
	private SqlSession sqlSession;
	@Autowired
	private SysParamMapper sysParamMapper;

	@Before
	public void before() {
//		sysParamMapper = sqlSession.getMapper(SysParamMapper.class);
	}

	@Test
	public void testInsert() {
		SysParam sysParam = new SysParam();

		sysParam.setParamCode("XXX2");
		sysParam.setParamValue("XXX");
		sysParam.setParamDesc("XXX");

		int ret = sysParamMapper.insert(sysParam);
		log.debug("插入，返回值：" + ret);
	}

	@Test
	public void testSelect() {
		SysParamExample example = new SysParamExample();
		long total = sysParamMapper.countByExample(example);
		log.debug("total = " + total);
		System.out.println("total = " + total);
		
		List<SysParam> params = sysParamMapper.selectByExample(example);
		log.debug(params.toString());
		System.out.println(params.toString());
	}
}
