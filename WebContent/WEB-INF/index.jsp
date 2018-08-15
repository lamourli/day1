
<%@ page language="java"  pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div class="piclist" style="width: 300px;height: 200px;background: #f00;">
<div class="picItem">
<img  src="">
</div>

</div>






${sessionScope.picurl}
<form action="upload" method="post" enctype="multipart/form-data">
<input type="file" name="file">
<button type="submit">上传</button>



</form>

</body>
</html>