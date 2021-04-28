package com.bdqn.dao;

import java.util.List;

import com.bdqn.entity.Power;
import com.bdqn.entity.Rank;
import com.bdqn.entity.Role;
import com.bdqn.entity.Section;
import com.bdqn.entity.Staff;
import com.bdqn.entity.UserId;

public interface StaffDao {
	List<Staff> seleStaff();
	List<Power> selePower();
	List<Power>  chaniu1(int id);
	int useradd(String name,int...is);
	//查询角色
	public List<Role> seleRole();
	//查询职责
	public List<Rank> seleRank();
	//查询部门
	public List<Section> seleSection();
	//删除用户
	int deleUser(int id);
	//查询用户
	List<UserId>  seleuser(int id);
	//修改用户
	int updaUser(UserId us);
}
