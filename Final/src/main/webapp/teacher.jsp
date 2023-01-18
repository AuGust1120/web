<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@page import="java.sql.*" %>
<jsp:directive.page import="java.util.List" />
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.*" %>
<%@ page language="java" import="java.sql.*" pageEncoding="UTF-8"%>
<jsp:useBean id="stu" class="Student.StudentBean"> </jsp:useBean>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <title>信息管理系统</title>
	<head>
		<meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>学生教务管理系统</title>
		<link rel="stylesheet" type="text/css" href="css/project.css" />
	</head>

	 <body background="img/bg3.jpg" style="background-repeat:no-repeat background-attachment:fixed;background-size:100% 100%; ">
		<div class="header">
			<div class="address">
				<span style="line-height:35px;">你好！</span>
			</div>
			<div class="loginregist">
				<a href="login.jsp" style="color:red">退出</a>
			</div>
		</div>
		<div class="banner">
		</div>
		<div class="body">
			<div class="classes" style="background-repeat:no-repeat background-attachment:fixed; background-size:100% 100%; ">
				<div class="text">教务管理系统</div>
				<ul>
					<li><span><a href="teacher.jsp">教师打分</a></span></li>
				</ul>
			</div>
			<div class="categries">
				<ul>
                <li><input name="game" type="radio" id="game1" checked><label for="game1"><a href="list.jsp">选课详情</a></label></li>
                <li><input  name="game" type="radio" id="game2"><label for="game2"><a href="addstudent.jsp">添加学生信息</a></label></li>
                <li><input name="game" type="radio" id="game3"><label for="game3"><a href="queryone.jsp">查询学生信息</a></label></li>
                <li><input  name="game" type="radio" id="game4"><label for="game4"><a href="mod.jsp">修改学生信息</a></label></li>
            </ul>
			</div>
			<div class="runimage" bgcolor="white" >
			 <form action="jsp/teachcheck.jsp" method="post">
        <table id="mytable" cellspacing="0" >
                             <tr>  
                               <th colspan="11" scope="col" style=" font-size: x-large; alignment: center">教师登录</th>
                             </tr>
            <tr>
                <td>教师账号:</td>
                <td><input type="text" name="username"></td><tr>
                <tr><td>登录密码:</td>
                <td><input type="text" name="password"></td></tr>
                <tr><td colspan="2" align="center"><input type="submit" value="登录"></td>
            <tr>
        </table>
    </form>
				</div>
			<div class="moreservices">
				<table border=1 bordercolor="lightgray" bgcolor="white">
					<tr ><th colspan="4">校讯快报</th></tr>
					<tr>
						<td colspan="4" style="height:140px; padding: 10px; text-align: left; vertical-align: middle;">
							<ul>
								<li><span>[公告]学校建设进入快速发展新篇章</span></li>
								<li><span>[公告]知名教育学家莅临我校进行指导</span></li>
								<li><span>[公告]我校将在2023年举办亚运会项目</span></li>
								<li><span>[公告]疫情防控依然不可忽视</span></li>
								<li><span>[公告]每天一个居家隔离小妙招</span></li>
								<li><span>[公告]你的年度学习报单出来啦</span></li>
								<li><span>[公告]学校体恤学生舆情反馈正在积极响应学生号召</span></li>
							</ul>
						</td>
					</tr>
				</table>
			</div>
		</div>	
	</body>
</html>
