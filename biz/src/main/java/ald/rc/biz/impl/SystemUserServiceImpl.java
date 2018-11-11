package ald.rc.biz.impl;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;

import ald.rc.biz.SystemUserService;
import ald.rc.dal.bo.SystemUser;

@Service("systemUserService")
public class SystemUserServiceImpl implements SystemUserService {

	@Override
	public int insert(SystemUser t) {
		return 0;
	}

	@Override
	public int deleteById(Long d) {
		return 0;
	}

	@Override
	public int updateById(SystemUser t) {
		return 0;
	}

	@Override
	public SystemUser findById(Long d) {
		return null;
	}

	@Override
	public PageInfo<SystemUser> page(int start, int end) {
		// TODO Auto-generated method stub
		return null;
	}

}
