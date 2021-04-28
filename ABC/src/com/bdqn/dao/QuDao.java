package com.bdqn.dao;

import java.util.List;

import com.bdqn.entity.Button;
import com.bdqn.entity.Power;

public interface QuDao {
	//查询权限
	 List<Power> selequan();
	 //查询按钮
	 List<Power> selequanniu(int id);
	 //删除权限
	 int delquan(int id);
	 //查看类型
	 List<Power> seletype(int id);
	 
	 //新增权限
	 int  inertquan(Power po);
	 //查询所有按钮
	 List<Button> sellebutton();
	 //查询当前用户信息
	 List<Power> seleByid(int id);
	 //传询父类的值
	 List<Power> seleByfid(int id);
	 int updatrole(Power po);
	
	 
}
