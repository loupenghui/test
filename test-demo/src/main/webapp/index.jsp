<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<html>
<head>
    <meta charset="utf-8">
</head>
<body>
<h2>Hello World!</h2>
<form name="execlform" action="importexcel/order" method="post" enctype="multipart/form-data">
    <input type="file" name = "excel">
    <input type="submit" value="提交">
</form>
</body>
</html>
