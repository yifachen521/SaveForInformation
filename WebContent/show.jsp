<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import="java.util.List"%>
<%@page import="com.myh.bean.News"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看录入的信息</title>
<link href="${pageContext.request.contextPath}/CSS/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/CSS/myh.css" rel="stylesheet">
</head>
<body>
	<table class="table table-striped">
		<tr bgcolor="#EECBAD">
			<td align="center" colspan="9">
				<h2>所有信息</h2>
			</td>
		</tr>
		<tr align="center">
			<td><b>ID</b></td>
			<td><b>城市</b></td>
			<td><b>图片地址</b></td>
			<td><b>最高温度</b></td>
			<td><b>最低温度</b></td>
			<td><b>现在温度</b></td>
			<td><b>天气状况</b></td>
			<td><b>风向</b></td>
			<td><b>风力</b></td>
			<td><b>修改</b></td>
			<td><b>删除</b></td>
		</tr>
		<%
			List<News> list = (List<News>) request.getAttribute("list");
			if (list == null || list.size() < 1) {
				out.print("没有数据！");
			} else {
				for (News user : list) {
		%>
		<tr align="center"  bgcolor="#FFF8DC">
			<td><%=user.getId()%></td>
			<td><%=user.getCityname()%></td>
			<td><%=user.getImageurl()%></td>
			<td><%=user.getMaxtemp()%></td>
			<td><%=user.getMintemp()%></td>
			<td><%=user.getNowtemp()%></td>
			<td><%=user.getState()%></td>
			<td><%=user.getWindir()%></td>
			<td><%=user.getWinpower()%></td>
			<td>
			<a href="update.jsp?id=<%=user.getCityname() %>">修改</a>
			</td>
		    <td>
		    <a href="DeleteServlet?id=<%=user.getId()%>">删除</a>
		    </td>
		</tr>
		<%
			}
			}
		%>
	</table>
</body>
</html>