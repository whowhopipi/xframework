package com.xframework.boot.ibator.test.mapper.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageRowBounds;
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
	private SysParamMapper sysParamMapper;

	@Test
	public void testInsert() {
		for (int i = 0; i < 50; i++) {
			SysParam sysParam = new SysParam();

			sysParam.setParamCode("code:" + i);
			sysParam.setParamValue("value:" + i);
			sysParam.setParamDesc("desc:" + i);

			int ret = sysParamMapper.insert(sysParam);
			log.debug("插入，返回值：" + ret);
		}
	}

	@Test
	public void testSelect() {
		SysParamExample example = new SysParamExample();
		example.setOrderByClause("param_code");
		long total = sysParamMapper.countByExample(example);
		log.debug("total = " + total);
		System.out.println("total = " + total);

		PageRowBounds rowBounds = new PageRowBounds(2, 10);
		List<SysParam> params = sysParamMapper.selectByExampleWithRowbounds(example, rowBounds);
		System.out.println("总共有:" + rowBounds.getTotal() + "条记录");
		for (SysParam param : params) {
			System.out.println(param);
		}
		log.debug(params.toString());
		System.out.println(params.toString());

		PageInfo<SysParam> pages = PageHelper.startPage(0, 5)
				.doSelectPageInfo(() -> sysParamMapper.selectByExample(example));
		System.out.println("总共有：" + pages.getTotal());
		for (SysParam param : pages.getList()) {
			System.out.println(param);
		}
	}
}
