package com.bdqn.dao;

import java.util.List;

import com.bdqn.entity.Button;
import com.bdqn.entity.Power;

public interface QuDao {
	//��ѯȨ��
	 List<Power> selequan();
	 //��ѯ��ť
	 List<Power> selequanniu(int id);
	 //ɾ��Ȩ��
	 int delquan(int id);
	 //�鿴����
	 List<Power> seletype(int id);
	 
	 //����Ȩ��
	 int  inertquan(Power po);
	 //��ѯ���а�ť
	 List<Button> sellebutton();
	 //��ѯ��ǰ�û���Ϣ
	 List<Power> seleByid(int id);
	 //��ѯ�����ֵ
	 List<Power> seleByfid(int id);
	 int updatrole(Power po);
	
	 
}
