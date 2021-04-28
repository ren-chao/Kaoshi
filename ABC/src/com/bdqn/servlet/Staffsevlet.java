package com.bdqn.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bdqn.dao.Abservlet;
import com.bdqn.dao.StaffDao;
import com.bdqn.daoimpl.StaffDaoImpl;
import com.bdqn.entity.Power;
import com.bdqn.entity.Rank;
import com.bdqn.entity.Role;
import com.bdqn.entity.Section;
import com.bdqn.entity.Staff;
import com.bdqn.entity.UserId;
import com.bdqn.entity.layui;

import util.PrintUtil;
@WebServlet(value="/sta")
public class Staffsevlet  extends Abservlet{
	
		private StaffDao st=new StaffDaoImpl();
		public void seleStaff(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException {
				List<Staff> seleStaff = st.seleStaff();
				layui<Staff> lay=new layui<Staff>();
				lay.setCode(0);
				lay.setData(seleStaff);
				lay.setMsg("");
				lay.setCount(seleStaff.size());
				PrintUtil.write(lay, response);
	 	}
		
		
		public void seleLeft(HttpServletRequest request, HttpServletResponse response)
		           throws ServletException, IOException {
				 List<Power> selePower = st.selePower();
				 System.out.println(selePower);
				request.getSession().setAttribute("zhi", selePower);
				response.sendRedirect("index.jsp");
		}
		public void chaniu1(HttpServletRequest request, HttpServletResponse response)
		           throws ServletException, IOException {
				request.setAttribute("chazhi", st.chaniu1(2));
		 request.getRequestDispatcher("userlist.jsp").forward(request, response); 
		}
		//添加
		public void useradd(HttpServletRequest request, HttpServletResponse response)
		           throws ServletException, IOException {
				String loginname = request.getParameter("loginname");
				int type1 = Integer.parseInt(request.getParameter("type1"));
				int type2 = Integer.parseInt(request.getParameter("type2"));
				int type3 = Integer.parseInt(request.getParameter("type3"));
				PrintUtil.write(st.useradd(loginname, type1,type2,type3), response); 
		}
		//查询角色
		public void seleRole(HttpServletRequest request, HttpServletResponse response)
		           throws ServletException, IOException {
					List<Role> seleRole = st.seleRole();
					PrintUtil.write(seleRole, response);
		}
		//查询职责
		public void seleRank(HttpServletRequest request, HttpServletResponse response)
		           throws ServletException, IOException {
						List<Rank> seleRank = st.seleRank();
						PrintUtil.write(seleRank, response);
		}
		//查询部门
		public void seleSection(HttpServletRequest request, HttpServletResponse response)
		           throws ServletException, IOException {
					List<Section> seleSection = st.seleSection();
					PrintUtil.write(seleSection, response);
		}
		//删除用户
		public void deleUser(HttpServletRequest request, HttpServletResponse response)
		           throws ServletException, IOException {
				String id = request.getParameter("userid");
				int deleUser = st.deleUser(Integer.parseInt(id));
				PrintUtil.write(deleUser,response);
		}
		//查询当前用户的id
		public void seleuser(HttpServletRequest request, HttpServletResponse response)
		           throws ServletException, IOException {
				String id = request.getParameter("userid");
				PrintUtil.write(st.seleuser(Integer.parseInt(id)), response);
		}
		//修改用户
		public void updaUser(HttpServletRequest request, HttpServletResponse response)
		           throws ServletException, IOException {
			String loginname = request.getParameter("loginname");
			String id = request.getParameter("id");
			int type1 = Integer.parseInt(request.getParameter("type1"));
			int type2 = Integer.parseInt(request.getParameter("type2"));
			int type3 = Integer.parseInt(request.getParameter("type3"));
			UserId us=new UserId();
			us.setId(Integer.parseInt(id));
			us.setName(loginname);
			us.setRoleid(type1);
			us.setRankid(type2);
			us.setSectionid(type3);
			PrintUtil.write(st.updaUser(us), response);
		}
}
