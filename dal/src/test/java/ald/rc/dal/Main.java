package ald.rc.dal;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ald.rc.dal.bo.SystemUser;
import ald.rc.dal.mapper.SystemUserMapper;


public class Main {
    
    private static final Logger logger =Logger.getLogger(Main.class);
    static{
        PropertyConfigurator.configure(Main.class.getClassLoader().getResource("config/properties/log4j.properties"));
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("config/dao-beans.xml");
        SystemUserMapper mapper  = ctx.getBean(SystemUserMapper.class);
        SystemUser user = mapper.findByPrimary(8871L);
        logger.info(user);
        logger.info(ctx);
    }
}
