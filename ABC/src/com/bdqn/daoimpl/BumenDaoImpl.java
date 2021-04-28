package com.bdqn.daoimpl;

import java.util.List;

import com.bdqn.dao.BaseDao;
import com.bdqn.dao.BumenDao;
import com.bdqn.entity.Power;
import com.bdqn.entity.Section;

public class BumenDaoImpl extends BaseDao implements BumenDao{

	@Override
	public List<Section> selebu() {
		String sql="SELECT id,name,count FROM `section`";
		return this.queryForList(Section.class, sql);
	}

	@Override
	public List<Power> selebuton() {
		String sql="SELECT * FROM `power` WHERE TYPE=3 AND fid=18";
		return this.queryForList(Power.class, sql);
	}

}
