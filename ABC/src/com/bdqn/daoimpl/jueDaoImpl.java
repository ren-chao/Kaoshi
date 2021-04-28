package com.bdqn.daoimpl;

import java.util.List;

import com.bdqn.dao.BaseDao;
import com.bdqn.dao.jueDao;
import com.bdqn.entity.Power;
import com.bdqn.entity.Staff;
import com.bdqn.entity.User;
import com.bdqn.entity.UserId;
import com.bdqn.entity.UserRole;

public class jueDaoImpl extends BaseDao implements jueDao {

	@Override
	public List<Staff> selelist() {
		String sql="SELECT s.`id` id, s.`name` `name`,se.`name`  sectionname,r.`name` rankname,ro.`name` rolename FROM `staff` s LEFT JOIN `section`  se ON s.sectionid=se.`id` LEFT JOIN `rank` r ON s.rankid=r.`id` LEFT JOIN role ro ON s.roleid=ro.id  ORDER BY roleid";
		return queryForList(Staff.class, sql);
	}

	@Override
	public List<Power> seanniu() {
		String sql="SELECT * FROM `power`  WHERE fid=3 AND TYPE=3";
		return this.queryForList(Power.class, sql);
	}

	@Override
	public List<Power> selequan() {
		String sql="SELECT * FROM `power`";
		return this.queryForList(Power.class, sql);
	}

	@Override
	public User deng(String name,String password) {
		String sql="SELECT * FROM `user` WHERE loginName=? AND `PASSWORD`=?";
		return   this.queryForOne(User.class,sql,name,password);
	}

	@Override
	public List<UserRole> selequan(int id) {
		String sql="SELECT userid FROM `privilege` WHERE id IN(SELECT userid FROM `privilege` WHERE userid=?)";
		return this.queryForList(UserRole.class, sql, id);
	}

	@Override
	public int deleGuan(int id) {
		String sql="DELETE FROM `privilege` where id=?";
		return this.update(sql,id);
	}

	@Override
	  public int insertGuan(String sqlyu) {
    	String sql=sqlyu;
    	return this.update(sql);
    }
	
}
