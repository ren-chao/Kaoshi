package com.bdqn.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bdqn.dao.Abservlet;
import com.bdqn.daoimpl.jueDaoImpl;
import com.bdqn.entity.Power;
import com.bdqn.entity.Staff;
import com.bdqn.entity.TreeTable;
import com.bdqn.entity.User;
import com.bdqn.entity.UserId;
import com.bdqn.entity.UserRole;
import com.bdqn.entity.layui;

import util.PrintUtil;

@WebServlet(value="/jue")
public class JueServlet extends Abservlet{
	private jueDaoImpl ju=new jueDaoImpl();
	//查询角色信息
	public void selerole(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException {
				List<Power> seanniu = ju.seanniu();
				request.setAttribute("zhi", seanniu);
				request.getRequestDispatcher("jue.jsp").forward(request, response); 
	}
	public void selelist(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException {
			List<Staff> selelist = ju.selelist();
			layui<Staff> lay=new layui<Staff>();
			lay.setCode(0);
			lay.setData(selelist);
			lay.setMsg("");
			lay.setCount(selelist.size());
			PrintUtil.write(lay, response);
	}
	//
	public void selequan(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    		List<Power> selequan = ju.selequan();
    	
        	List<TreeTable> tree1=new ArrayList <TreeTable>();
        	
        	layui<TreeTable> lay=new layui<TreeTable>();
        	for (Power power : selequan) {
    			TreeTable tree=new TreeTable();
        		tree.setId(power.getId());
        		tree.setParentId(power.getFid());
        		tree.setTitle(power.getName());
        		tree.setCheckArr("0");
        		tree1.add(tree);
        		lay.setData(tree1);
				
			}
        	lay.setCode(0);
        	lay.setCount(20);
        	lay.setMsg("0");
        	PrintUtil.write(lay, response);
    }
	//判断登录
	public void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			User deng = ju.deng(request.getParameter("username"), request.getParameter("password"));
			if(deng==null) {
				response.sendRedirect("login.jsp");
			}else {
				request.getSession().setAttribute("us", deng);
				response.sendRedirect("index.jsp");
			}
	}
	//查询当前用户的权限
	public void selequanid(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			User attribute = (User)request.getSession().getAttribute("us");
			Integer num=Integer.parseInt(request.getParameter("userid"));
			System.out.println("查询是"+request.getParameter("userid"));
			List<UserRole> selequan = ju.selequan(num);
			PrintUtil.write(selequan, response);
	}
	 //分配权限
    public void menuByUserid(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException  {
    	User attribute = (User)req.getSession().getAttribute("us");
    	Integer num=Integer.parseInt(req.getParameter("userid"));
    	String[] pa = req.getParameterValues("array");
    	if(req.getParameterValues("array")==null) {
    		int deleGuan = ju.deleGuan(num);
   		 	PrintUtil.write(deleGuan, resp); 
   		 	return ;
    	}
    	StringBuffer str=new StringBuffer();
    	if(pa!=null || pa.length>0) {
        	str.append("INSERT INTO `privilege` VALUES");
    		for (int i = 0; i < pa.length; i++) {
    			str.append("("+num+","+pa[i]+")");
    			
    			if(i>=pa.length-1) {
    				break;
    			}
    			str.append(",");
    		}
    		ju.deleGuan(num);
    		int insertGuan = ju.insertGuan(str.toString());
    		System.out.println(str.toString());
   		 	PrintUtil.write(insertGuan, resp); 
   		 	
   		
    	}
    	
    	
    		
    	}
}
