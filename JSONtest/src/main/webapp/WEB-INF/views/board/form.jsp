<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
	<title>Form</title>

	<style>
		.error {
			border: solid 1px red;
		}
	</style>
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script type="text/javascript" src="http://ajax.microsoft.com/ajax/jquery.templates/beta1/jquery.tmpl.js"></script>
	
	<script>
		$(document).ready(function() {
			$("[id*='.errors']").each(function() {
				var id = $(this).attr("id").split(".")[0];
				$("#" + id).addClass("error");
			});
		});
	</script>
</head>

<body>
<form:form id="form" commandName="board" action="/board"  method="POST">
	<label for="name">이름</label>
	<form:input path="name"/>
	<form:errors path="name" cssClass="errorblock"/>

	<label for="title">제목</label>
	<form:input path="title" />
	<form:errors path="title" cssClass="errorblock"/>

	<input type="submit" value="저장" />
</form:form>
</body>
</html>
