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
	//��ѯ��ǰ˵��Ȩ��
	List<Power> selequan();
	//��ѯ��ǰ�û���Ȩ��
	List<UserRole> selequan(int id);
	//��¼
	User deng(String name,String password);
	//ɾ������Ȩ��
	int deleGuan(int id );
	  public int insertGuan(String sqlyu) ;
	    
  }
