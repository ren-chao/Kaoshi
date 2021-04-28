package com.bdqn.test;

import java.util.List;

import javax.management.relation.Role;

import org.junit.Test;

import com.bdqn.dao.QuDao;
import com.bdqn.dao.StaffDao;
import com.bdqn.daoimpl.QuanImpl;
import com.bdqn.daoimpl.StaffDaoImpl;
import com.bdqn.entity.Power;

public class a {
	private StaffDao st=new StaffDaoImpl();
	private QuDao q=new QuanImpl();
	@Test
	public void test() {
		 List<Power> selePower = st.selePower();
		 System.out.println(selePower);
	}
	@Test
	public void test1() {
		List<Power> chaniu1 = st.chaniu1(3);
		 System.out.println(chaniu1.get(1).getMbth());
	}
	@Test
	public void test2() {
		List<Power> selequan = q.selequan();
		System.out.println(selequan);
		
	}
}
