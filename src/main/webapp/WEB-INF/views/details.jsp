<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Donut Details</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/spacelab/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		
		<table class="table">
			<thead class="text-success">
				<tr>
					<th>Name</th>
					<th>Calories</th>
					<th>Extras</th>
				</tr>
			</thead>
			<tbody>
				
					<tr>
						<td>${result.name}</td>
						<td>${result.calories}</td>
						<td>${result.extras}</td>
					</tr>
				
			</tbody>
		</table>
		<center><img src=${result.photo} style="width:400px;height:400px"></center>
		<center><a href="/"><button>Home</button></a></center>
	</div>
</body>
</html>