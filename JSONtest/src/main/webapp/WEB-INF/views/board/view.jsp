<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>View</title>
</head>

<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script type="text/javascript" src="http://ajax.microsoft.com/ajax/jquery.templates/beta1/jquery.tmpl.js"></script>



<script type="text/javascript">
$(document).ready(function() {
	$.ajax({
		url : "/board/${id}.json",
		statusCode: {
  			404: function() {
    			alert( "page not found" );
			},
			200 : function(json) {
				$.tmpl($("#dataTemplate"), json).appendTo("#templateBody");
			}
		}
	});
});
</script>
<body>
	<div id="templateBody">
	</div>
	<script id="dataTemplate" type="text/x-jquery-tmpl">
		\${name} | \${title}
	</script>
</body>
</html>
