<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>List</title>
</head>

<!-- <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script> -->
<!-- <script type="text/javascript" src="http://ajax.microsoft.com/ajax/jquery.templates/beta1/jquery.tmpl.js"></script> -->

<script type="text/javascript">
// $(document).ready(function() {
// 	$.ajax({
// 		url : "/board.json",
// 		statusCode: {
//   			404: function() {
//     			alert( "page not found" );
// 			},
// 			200 : function(json) {
// 				$.tmpl($("#dataTemplate"), json).appendTo("#templateBody");
// 			}
// 		}
// 	});
// });
</script>
<body>
	<c:if test="${not empty data}">
	<ul>
		<c:forEach var="board" items="${data}">
			<li>${board.name} | ${board.title}</li>
		</c:forEach>	
	</ul>
	</c:if>
	
	<ul class="pagination">
		<li><a href="/board?page=${page.currentPage - page.blockSize}">&laquo;</a></li>
		<li><a href="/board?page=${page.currentPage - 1}">&lsaquo;</a></li>
		<c:forEach begin="${page.firstPageOfCurrentBlock}" end="${page.lastPageOfCurrentBlock}" varStatus="loop">
		<li<c:if test="${loop.index == page.currentPage}"> class="active"</c:if>><a href="/board?page=${loop.index}">${loop.index}<c:if test="${loop.index == page.currentPage}"> <span class="sr-only">(current)</span></c:if></a></li>
		</c:forEach>  
		<li><a href="/board?page=${page.currentPage + 1}">&rsaquo;</a></li>
		<li><a href="/board?page=${page.currentPage + page.blockSize}">&raquo;</a></li>
	</ul>
</body>
</html>
