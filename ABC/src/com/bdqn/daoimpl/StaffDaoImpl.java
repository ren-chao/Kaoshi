package com.bdqn.daoimpl;

import java.util.List;

import com.bdqn.dao.BaseDao;
import com.bdqn.dao.StaffDao;
import com.bdqn.entity.Power;
import com.bdqn.entity.Rank;
import com.bdqn.entity.Role;
import com.bdqn.entity.Section;
import com.bdqn.entity.Staff;
import com.bdqn.entity.UserId;

public class StaffDaoImpl extends BaseDao implements StaffDao{

	@Override
	public List<Staff> seleStaff() {
		String sql="SELECT s.`id` id, s.`name` `name`,se.`name`  sectionname,r.`name` rankname,ro.`name` rolename FROM `staff` s LEFT JOIN `section`  se ON s.sectionid=se.`id` LEFT JOIN `rank` r ON s.rankid=r.`id` LEFT JOIN role ro ON s.roleid=ro.id";
		return this.queryForList(Staff.class, sql);
	}

	@Override
	public List<Power> selePower() {
		String sql="SELECT * FROM `power`";
		return this.queryForList(Power.class, sql);
	}

	@Override//查询按钮
	public List<Power> chaniu1(int id) {
		String sql="SELECT * FROM `power` where type=3 and fid=4";
		return this.queryForList(Power.class, sql);
	}

	@Override
	public int useradd(String name,int...is) {
		String sql="INSERT INTO `staff`(NAME,sectionid,rankid,roleid) VALUES(?,?,?,?)";
		return update(sql, name,is[0],is[1],is[2]);
	}

	@Override
	public List<Role> seleRole() {
		String sql="SELECT id,NAME FROM  `role`";
		return this.queryForList(Role.class, sql);
	}

	@Override
	public List<Rank> seleRank() {
		String sql="SELECT id,NAME FROM  `rank`";
		return this.queryForList(Rank.class, sql);
	}

	@Override
	public List<Section> seleSection() {
	String sql="SELECT id,NAME FROM  `section`";
	return this.queryForList(Section.class, sql);
	}

	@Override
	public int deleUser(int id) {
		String sql="DELETE FROM `staff` WHERE id=?";
		return this.update(sql, id);
	}

	@Override
	public List<UserId> seleuser(int id) {
		String sql="SELECT id,name,sectionid,  rankid,  roleid FROM `staff` WHERE id=?";
		return this.queryForList(UserId.class, sql, id);
	}

	@Override//修改用户
	public int updaUser(UserId us) {
		String sql="UPDATE  `staff` SET NAME=?, sectionid=?,  rankid=?,  roleid=?     WHERE id=?";
		return this.update(sql, us.getName(),us.getSectionid(),us.getRankid(),us.getRoleid(),us.getId());
	}

}
