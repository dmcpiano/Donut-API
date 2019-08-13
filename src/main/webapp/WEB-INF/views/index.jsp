<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Donuts</title>
</head>
<body>

<div class="container">
	<h1>Donuts</h1>

			
			<ul>
			<c:forEach items="${list}" var="results">
			<li><a href="/details?id=${results.id}">${results.name}</a></li>
			</c:forEach>
		</ul>
		</div>
</body>
</html>