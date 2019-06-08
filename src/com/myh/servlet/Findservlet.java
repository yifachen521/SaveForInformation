package com.myh.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myh.bean.News;

/**
 * Servlet implementation class Findservlet
 */
@WebServlet(description = "ssdsa", urlPatterns = { "/Findservlet" })
public class Findservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Object request;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Findservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			//加载数据驱动，注册驱动管理
			Class.forName("com.mysql.jdbc.Driver");
			String url= "jdbc:mysql://localhost:3306/mydb?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
			String un= "root";
			String pw = "123456";
			Connection conn = DriverManager.getConnection(url,un,pw);
			String sql = "select * from tb_inf";
			Statement statement = conn.createStatement();
			List<News> list = new ArrayList<News>();
			//数组
			ResultSet resultSet =  statement.executeQuery(sql);
			
			while (resultSet.next()){
				News user = new News();
				user.setId(resultSet.getInt("id"));
				user.setCityname(resultSet.getString("cityname"));
				user.setState(resultSet.getString("state"));
				user.setMintemp(resultSet.getString("mintemp"));
				user.setMaxtemp(resultSet.getString("maxtemp"));
				user.setNowtemp(resultSet.getString("nowtemp"));
				user.setWindir(resultSet.getString("windir"));
				user.setWinpower(resultSet.getString("winpower"));
				user.setImageurl(resultSet.getString("imageurl"));
				list.add(user);
			}
			request.setAttribute("list", list);
			resultSet.close();
			statement.close();
			conn.close();
		}catch(Exception e){
			System.out.println("连接失败");
			//这里定义了一个连接异常处理
			e.printStackTrace();
		}
		request.getRequestDispatcher("show.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
