package com.myh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.myh.bean.News;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html;charset=UTF-8");
		String cityname = request.getParameter("cityname");
		String state = request.getParameter("state");
		String mintemp = request.getParameter("mintemp");
		String maxtemp = request.getParameter("maxtemp");
		String nowtemp = request.getParameter("nowtemp");
		String windir = request.getParameter("windir");
		String winpower = request.getParameter("winpower");
		String imageurl = request.getParameter("imageurl");
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/mydb?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
			String username = "root";
			String password = "123456";
			Connection conn = DriverManager.getConnection(url, username,
					password);
			String sql = "insert into tb_inf(cityname,state,mintemp,maxtemp,nowtemp,windir,winpower,imageurl) values(?,?,?,?,?,?,?,?)";
			News news = new News();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,cityname);
			ps.setString(2, state);
			ps.setString(3, mintemp);
			ps.setString(4, maxtemp);
			ps.setString(5, nowtemp);
			ps.setString(6, windir);
			ps.setString(7, winpower);
			ps.setString(8, imageurl);
			int row = ps.executeUpdate();
			// 判断是否更新成功
			if (row > 0) {
				// 更新成输出信息
				PrintWriter out = response.getWriter();
				out.println ("<html><head><meta charset='UTF-8'></head><script language=javascript>alert('添加成功');window.location='add.jsp'</script>");
			}
			// 关闭PreparedStatement，释放资源
			ps.close();
			// 关闭Connection，释放资源
			conn.close();
		} catch (Exception e) {
			response.sendRedirect("fail.jsp");
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
