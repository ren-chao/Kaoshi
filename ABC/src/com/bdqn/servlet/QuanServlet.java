package com.bdqn.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.bdqn.dao.Abservlet;
import com.bdqn.dao.QuDao;
import com.bdqn.daoimpl.QuanImpl;
import com.bdqn.entity.Button;
import com.bdqn.entity.Power;
import com.bdqn.entity.Staff;
import com.bdqn.entity.layui;

import util.PrintUtil;

@WebServlet(value="/qu")
public class QuanServlet extends Abservlet {
	private QuDao q=new QuanImpl();
	public void seleniu(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException {
				List<Power> selequanniu = q.selequanniu(3);
				request.setAttribute("selequanniu",selequanniu);
				request.getRequestDispatcher("quanxian.jsp").forward(request, response);
	}
	public void seleQuan(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException {
				List<Power> selequan = q.selequan();
				layui<Power> lay=new layui<Power>();
				lay.setCode(0);
				lay.setData(selequan);
				lay.setMsg("");
				lay.setCount(selequan.size());
				PrintUtil.write(lay, response);
	}
	//删除权限
	public void delquan(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException {
				String parameter = request.getParameter("userid");
				PrintUtil.write(q.delquan(Integer.parseInt(parameter)), response);
	}
	//查看类型
	public void seletype(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException {
			String type = request.getParameter("type");
			List<Power> seletype = q.seletype(Integer.parseInt(type));
			PrintUtil.write(seletype, response);
	}
	//新增权限
	public void insertquan(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException {
		//&name="+mname+"&function="+mfunction+"&type="+type2+"&mbth="+mbtn+"&fatherid="+father
		Power po=new Power();
		po.setFid(Integer.parseInt(request.getParameter("fatherid")));
		po.setMbth(request.getParameter("mbth1"));
		po.setType(Integer.parseInt(request.getParameter("type")));
		po.setName(request.getParameter("name"));
		po.setPath(request.getParameter("function"));
		
		PrintUtil.write(q.inertquan(po), response);
	}
	//查询所有按钮
	public void sellebutton(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException {
				List<Button> sellebutton = q.sellebutton();
				PrintUtil.write(sellebutton, response);
	}
	//查询当前的用户权限信息
	public void seleByid(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException {
			List<Power> seleByid = q.seleByid(Integer.parseInt(request.getParameter("userid")));
			PrintUtil.write(seleByid, response);
	}
	//查看当前父类
		public void seleByfid(HttpServletRequest request, HttpServletResponse response)
		           throws ServletException, IOException {
					List<Power> seleByfid = q.seleByfid(Integer.parseInt(request.getParameter("menuid")));
					PrintUtil.write(seleByfid, response);
		}
		public void updatrole(HttpServletRequest request, HttpServletResponse response)
		           throws ServletException, IOException {
				Power po=new Power();
				po.setId(Integer.parseInt(request.getParameter("id")));
				po.setMbth(request.getParameter("mbth"));
				po.setPath(request.getParameter("path"));
				po.setType(Integer.parseInt(request.getParameter("type")));
				po.setName(request.getParameter("name"));
				po.setFid(Integer.parseInt(request.getParameter("fatherid")));
				int updatrole = q.updatrole(po);
				PrintUtil.write(updatrole, response);
		}
}
