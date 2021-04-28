package com.bdqn.dao;

import java.util.List;

import com.bdqn.entity.Power;
import com.bdqn.entity.Staff;
import com.bdqn.entity.User;
import com.bdqn.entity.UserId;
import com.bdqn.entity.UserRole;

public interface jueDao {
	List<Staff> selelist();
	List<Power> seanniu();
	//查询当前说球权限
	List<Power> selequan();
	//查询当前用户的权限
	List<UserRole> selequan(int id);
	//登录
	User deng(String name,String password);
	//删除所有权限
	int deleGuan(int id );
	  public int insertGuan(String sqlyu) ;
	    
  }
