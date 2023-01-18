<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.File"%>
<%@page import="java.util.*"%>
<%@page import="java.io.IOException" %>
<html>
<head>
    <title>登录检查</title>
</head>
<body>
<%
    String uname = request.getParameter("username");
    String pwd = request.getParameter("password");
    //依次对文件中的用户名和密码进行比较，其中的逻辑很容易理解，奇数行为用户名，偶数行为密码
        if (uname.equals("Admin") && pwd.equals("123456")) {
            request.getSession().setAttribute("username",uname);//将用户名保存在整个会话期间,便于成功登录显示
            response.sendRedirect("../mark.jsp");
        } else {
        }
        out.print("<script>alert('用户名或密码错误，请重新登录');location.href='../teacher.jsp';</script>");//比较全部数据后不正确返回首页
%>
</body>
</html>
