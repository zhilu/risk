package ald.rc.biz;


import com.github.pagehelper.PageInfo;

import ald.rc.dal.bo.SystemUser;

public interface SystemUserService extends BaseService<SystemUser, Long> {

	PageInfo<SystemUser>  page(int start,int end);
}
