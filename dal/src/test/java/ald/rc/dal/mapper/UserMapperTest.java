package ald.rc.dal.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ald.rc.dal.Main;
import ald.rc.dal.bo.SystemUser;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:config/dao-beans.xml"})
public class UserMapperTest {
	static {
		PropertyConfigurator.configure(Main.class.getClassLoader().getResource("config/properties/log4j.properties"));
	}
	
	private static final Logger logger =Logger.getLogger(UserMapperTest.class);

	@Autowired
	protected ApplicationContext ctx;

	@Autowired
	private SystemUserMapper systemUserMapper;

	@Test
	public void testApplicationContext() {
		Assert.assertNotNull(ctx);
	}

	@Test
	public void testMapper() {
		SystemUser user = systemUserMapper.findByPrimary(8871L);
		Assert.assertEquals(user.getId(), "97");
	}
	

}