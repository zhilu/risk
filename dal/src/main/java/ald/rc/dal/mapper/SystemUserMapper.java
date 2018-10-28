package ald.rc.dal.mapper;

import ald.rc.dal.BaseMapper;
import ald.rc.dal.MyBatisDao;
import ald.rc.dal.bo.SystemUser;

/**
 * 用户表dao
 * 
 * @author shi
 * @date 2018-10-28
 */
@MyBatisDao
public interface SystemUserMapper extends BaseMapper<SystemUser,Long> {
}
