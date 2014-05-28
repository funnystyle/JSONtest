<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
   <meta charset="utf-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <title>List</title>

   <!-- Bootstrap -->
   <link href="/lib/bootstrap-3.1.1-dist/css/bootstrap.min.css" rel="stylesheet">

   <!-- Custom styles for this template -->
   <link href="/lib/bootstrap-custom-css/starter-template.css" rel="stylesheet">

   <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
   <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
   <!--[if lt IE 9]>
     <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
     <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
   <![endif]-->
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
		<li<c:if test="${!page.hasPreviousBlock}"> class="disabled"</c:if>><a href="/board?page=${page.currentPage - page.blockSize}">&laquo;</a></li>
		<li<c:if test="${!page.hasPreviousPage}"> class="disabled"</c:if>><a href="/board?page=${page.currentPage - 1}">&lsaquo;</a></li>
		
		<c:forEach begin="${page.firstPageOfCurrentBlock}" end="${page.lastPageOfCurrentBlock}" varStatus="loop">
		<li<c:if test="${loop.index == page.currentPage}"> class="active"</c:if>><a href="/board?page=${loop.index}">${loop.index}<c:if test="${loop.index == page.currentPage}"> <span class="sr-only">(current)</span></c:if></a></li>
		</c:forEach>  
		
		<li<c:if test="${!page.hasNextPage}"> class="disabled"</c:if>><a href="/board?page=${page.currentPage + 1}">&rsaquo;</a></li>
		<li<c:if test="${!page.hasNextBlock}"> class="disabled"</c:if>><a href="/board?page=${page.currentPage + page.blockSize}">&raquo;</a></li>
	</ul>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="/lib/bootstrap-3.1.1-dist/js/bootstrap.min.js"></script>	
</body>
</html>
