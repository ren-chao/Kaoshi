package com.bdqn.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bdqn.dao.Abservlet;
import com.bdqn.dao.BumenDao;
import com.bdqn.daoimpl.BumenDaoImpl;
import com.bdqn.entity.Power;
import com.bdqn.entity.Section;
import com.bdqn.entity.layui;

import util.PrintUtil;
@SuppressWarnings("serial")
@WebServlet(value="/bu")
public class BuMenServlet extends Abservlet {
	private BumenDao bu=new BumenDaoImpl();
	//查询部门 信息
    public void SeleBuMen(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {//SeleBuMen
	    	 List<Section> selebu = bu.selebu();
	    	 layui<Section> lay=new layui<Section>();
				lay.setCode(0);
				lay.setData(selebu);
				lay.setMsg("");
				lay.setCount(selebu.size());
				PrintUtil.write(lay, response);
	    	
    }
    public void SeleBuMenButton(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    		List<Power> selebuton = bu.selebuton();
    		request.setAttribute("chazhi",selebuton);
    		request.getRequestDispatcher("bumen.jsp").forward(request,response);
    }
    //根据id查询当前部门的数据
    public void SeleBySection(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    		Section seleByid = bu.seleByid(Integer.parseInt(request.getParameter("userid")));
    		PrintUtil.write(seleByid, response);
    }
    public void UpdatSe(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	Section se=new Section();
    	se.setName(request.getParameter("loginname"));
    	se.setId(Integer.parseInt(request.getParameter("id")));
    	se.setCount(Integer.parseInt(request.getParameter("coutn")));
    	PrintUtil.write(bu.updateBumen(se), response);
    }
}	
