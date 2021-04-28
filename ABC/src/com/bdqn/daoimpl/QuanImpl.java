package com.bdqn.daoimpl;

import java.util.List;

import com.bdqn.dao.BaseDao;
import com.bdqn.dao.QuDao;
import com.bdqn.entity.Button;
import com.bdqn.entity.Power;

public class QuanImpl extends BaseDao implements QuDao{

	@Override
	public List<Power> selequan() {
		String sql="SELECT * FROM `power`";
		return this.queryForList(Power.class,sql);
	}

	@Override
	public List<Power> selequanniu(int id) {
		String sql="SELECT * FROM `power` WHERE TYPE=3  AND fid=2";
		return this.queryForList(Power.class,sql);
	}

	@Override
	public int delquan(int id) {
		String sql="delete from `power` where id=?";
		return this.update(sql, id);
	}

	@Override
	public List<Power> seletype(int id) {
		String sql="SELECT * FROM `power` WHERE TYPE=?";
		return this.queryForList(Power.class, sql, id);
	}

	@Override
	public int inertquan(Power po) {
		String sql="INSERT INTO `power`(NAME,fid,path,TYPE,mbth) VALUES(?,?,?,?,?)";
		return this.update(sql, po.getName(),po.getFid(),po.getPath(),po.getType(),po.getMbth());
	}

	@Override
	public List<Button> sellebutton() {
		String sql="SELECT * FROM `button`";
		return this.queryForList(Button.class, sql);
	}

	@Override
	public List<Power> seleByid(int id) {
		String sql="SELECT * FROM `power` WHERE ID=?";
		return this.queryForList(Power.class, sql, id);
	}

	@Override
	public List<Power> seleByfid(int id) {
		String sql="SELECT * FROM `power`  WHERE id=?";
		return this.queryForList(Power.class, sql, id);
	}

	@Override
	public int updatrole(Power po) {
		String sql="UPDATE `power` SET NAME=?, fid=?,path=?,TYPE=?,mbth=? WHERE id=?       ";
		return this.update(sql, po.getName(),po.getFid(),po.getPath(),po.getType(),po.getMbth(),po.getId());
	}

	
}
