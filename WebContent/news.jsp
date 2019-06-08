<%@ page language="java" contentType="text/xml; charset=UTF-8" pageEncoding="UTF-8"%><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><?xml version="1.0" encoding="UTF-8"?>
<weathernews>
	<c:forEach items="${list}" var="news">
		<news cityname="${news.cityname}">
			<information name="${news.cityname}">
			<state>${news.state}</state>
			<mintemp>${news.mintemp}</mintemp>
			<maxtemp>${news.maxtemp}</maxtemp>
			<nowtemp>${news.nowtemp}</nowtemp>
			<windir>${news.windir}</windir>
			<winpower>${news.winpower}</winpower>
			<imageurl>${news.imageurl}</imageurl>
			</information>
		</news>
	</c:forEach>
</weathernews>