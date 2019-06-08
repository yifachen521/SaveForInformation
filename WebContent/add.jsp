<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>信息添加</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description"
	content="Sidebar Transitions: Transition effects for off-canvas views" />
<meta name="keywords"
	content="transition, off-canvas, navigation, effect, 3d, css3, smooth" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/CSS/normalize.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/CSS/demo.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/CSS/icons.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/CSS/component.css" />
<script src="js/modernizr.custom.js"></script>
<link href="${pageContext.request.contextPath}/CSS/bootstrap.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/CSS/myh.css"
	rel="stylesheet">
<script type="text/javascript">
	function btn(){
		location.href="http://localhost:8080/SaveInformation/NewsListServlet";
	}
	function btn2() {
		location.href="http://localhost:8080/SaveInformation/ServletForXML";
		
	}
</script>
</head>
<body>
    <%request.setCharacterEncoding("UTF-8"); %>
<form action="AddServlet" method="post" class="form-signin">
<div id="st-trigger-effects" class="column">
<h2>天气预报录入</h2>
<label>城市:</label>
<input type="text" name="cityname"></br>
<label>天气:</label>
<input type="text" name="state" ></br>
<label>风向:</label>
<input type="text" name="windir" ></br>
<label>风力:</label>
<input type="text" name="winpower" ></br>
<label>最低温度:</label>
<input type="text" name="mintemp" ></br>
<label>最高温度:</label>
<input type="text" name="maxtemp" ></br>
<label>当前温度:</label>
<input type="text" name="nowtemp" ></br>
<label>图片地址:</label>
<input type="text" name="imageurl"></br>
<input type="submit" class="btn btn-default" value="录入信息"></br>
<input type="button" value="生成json" onclick="btn()" class="btn btn-default"></br>
<input type="button" value="生成xml" onclick="btn2()" class="btn btn-default"><br>
<input type="submit" value="查看已录入的信息" formaction="Findservlet" class="btn btn-default"></br>
</div>
</form>

</body>
</html>