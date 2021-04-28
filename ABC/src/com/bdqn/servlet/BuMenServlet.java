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
	//��ѯ���� ��Ϣ
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
}	
