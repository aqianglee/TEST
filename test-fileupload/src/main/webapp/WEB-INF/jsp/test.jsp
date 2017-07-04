<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/js/jquery-1.9.0.min.js"></script>
<script type="text/javascript">
	function refresh() {
		var timer = setInterval(function() {
			$.getJSON("status", function(data) {
				console.log(data);
			});
		}, 20);
	}
</script>
</head>
<body>
	<form action="fileUpload" method="POST" enctype="multipart/form-data">
		<input type="file" name="file"> <input type="submit"
			value="submit" onclick="refresh()" />
	</form>
</body>
</html>