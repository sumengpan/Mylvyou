<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2020/9/29
  Time: 20:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>注册</title>
    <link rel="stylesheet" type="text/css" href="css/common.css">
    <link rel="stylesheet" href="css/register.css">
    <!--导入jquery-->
    <script src="js/jquery-3.3.1.js"></script>
</head>
<body>
<!--引入头部-->
<div id="header">
    <%@include file="header.jsp"%>
</div>
<!-- 头部 end -->
<div style="text-align:center;red:yellow;font-weight:bold;height:150px;padding-top:100px;font-size:30px;">
    <h4 type="center">恭喜，注册成功！</h4>
    <br>
    <h5 type="center">请登录您的注册邮箱进行激活您的账号，激活后才能登录。</h5>

</div>
<!--引入尾部-->
<div id="footer">
    <%@include file="footer.jsp"%>
</div>
<!--导入布局js，共享header和footer-->

</body>
</html>
