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
	//��ѯ��ɫ
	public List<Role> seleRole();
	//��ѯְ��
	public List<Rank> seleRank();
	//��ѯ����
	public List<Section> seleSection();
	//ɾ���û�
	int deleUser(int id);
	//��ѯ�û�
	List<UserId>  seleuser(int id);
	//�޸��û�
	int updaUser(UserId us);
}
