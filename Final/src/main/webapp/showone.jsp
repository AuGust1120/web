<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.sql.*" %>
<jsp:directive.page import="java.util.List" />
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.*" %>
<%@ page language="java" import="java.sql.*" pageEncoding="UTF-8"%>
<jsp:useBean id="stu" class="Student.StudentBean"> </jsp:useBean>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <title>信息管理系统</title>
    <%! ResultSet rs;%>
    <%
        /*分页器*/
        long a = 0;
        String sql = null;
        String sql1=null;
        String stuid = request.getParameter("stuidid");
    if(stuid==null){
    	sql="select count(*) from student";
    	sql1="select *from student limit ?,?";
    }else{
    	sql="select * from student where id=?;";
    	sql1="select * from student where id=? limit ?,?;";
    	a = Long.parseLong(stuid);}
        String n = request.getParameter("pageNow");//获取当前页数
        int pageSize = 17;//设置分页器显示数据数
        int lineCount;  //总的行数来源于数据库
        int pageCount;  //分的页数，计算得到
        int pageNow = 1; //默认显示第一页
        //判断当前页页数是否为空
        if (n != null) {
            //强制转换n并赋值给pageNow
            pageNow = Integer.parseInt(n);
        }
        Class.forName("com.mysql.jdbc.Driver");
        //获取数据库连接
        
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","august");
        //查询总的行数
        //返回查询结果
        PreparedStatement psta = conn.prepareStatement(sql);
        if(a!=0){
        psta.setLong(1,a);}
        ResultSet rs = psta.executeQuery();
        rs.next();
        //从数据库找到的结果集中的第一行的第一列读取数值
        lineCount = rs.getInt(1);
        //计算页数
        //算法：总的行数对每页显示的多少取余数，如果是0，执行总行数除以页面的显示条数，否则除以页面的显示条数+1
        pageCount = lineCount % pageSize == 0 ? lineCount / pageSize : lineCount / pageSize + 1;
        //对当前页进行判断
        if (pageNow <= 0) {
            //如果小于等于0,当前页是第一页
            pageNow = 1;
        }
        if (pageNow > pageCount) {
            //如果当前页大于分页就是分页
            pageNow = pageCount;
        }
        //采用限制查询控制显示条数
        psta = conn.prepareStatement(sql1);
        if(a!=0){
            psta.setLong(1,a);
        //设置第一个占位符（？）表示的内容
        psta.setInt(2, pageSize * (pageNow - 1));
        //设置第二个占位符（？）表示的内容
        psta.setInt(3, pageSize);}
        else{
        	psta.setInt(1, pageSize * (pageNow - 1));
            //设置第二个占位符（？）表示的内容
            psta.setInt(2, pageSize);
        }
        //返回查询的结果集
        rs = psta.executeQuery();
    %>
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
                <li>
                    <input name="game" type="radio" id="game1" checked><label for="game1"><a href="list.jsp">选课详情</a></label>
                </li>
                <li>
                    <input  name="game" type="radio" id="game2"><label for="game2"><a href="addstudent.jsp">添加学生信息</a></label>
                </li>
                <li>
                    <input name="game" type="radio" id="game3"><label for="game3"><a href="queryone.jsp">查询学生信息</a></label>
                </li>
                <li>
                    <input  name="game" type="radio" id="game4"><label for="game4"><a href="queryone.jsp">修改学生信息</a></label>
                </li>
            </ul>
			</div>
			<div class="runimage" bgcolor="white" >
                    <form>
						<table id="mytable" cellspacing="0" >
                             <tr>  
                               <th colspan="11" scope="col" style=" font-size: x-large; alignment: center">选课信息表</th>
                             </tr>  
                             <tr style=" text-align: center" scope="row" abbr="model" class="spec">
                               <td>序号</td>
                               <td>姓名</td>
                               <td>班级</td>
                               <td>课程名称</td>
                               <td>成绩</td>
                               <td colspan="2">上课时间</td>
                               <td>上课地点</td>
                               <td colspan="3">操作</td> 
                             </tr> 
                             <tr style=" text-align: center" scope="row" abbr="model">
                               <td colspan="2">学号:</td> 
                               <td colspan="9" style="text-align: left;">
                               <input name="num" name="stuidid" value = "<%=a%>" style="text-align: center; border:transparent;width:125px;font-size:14px;">
                               </td></tr>
                             <%int aaa=0;
                             while (rs.next()) { %>
                             <tr style=" text-align: center" >
                               <td class="alt"><%= ++aaa %></td>
                               <td class="alt"><%= rs.getString(3)%></td>
                               <td class="alt"><%= rs.getString(4)%></td>
                               <td class="alt"><%= rs.getString(5)%></td>
                               <td class="alt"><%= rs.getString(6)%></td>
                               <td class="alt"><%= rs.getString(7)%></td>
                               <td class="alt"><%= rs.getString(8)%></td>
                               <td class="alt"><%= rs.getString(9)%></td>
                               <td class="alt" colspan="1.5"><a href="/Final/delete?stuid=<%=rs.getInt(1)%>">删除</a></td>
                               <td class="alt" colspan="1.5"><a href="/Final/modifyto?stuid=<%=rs.getInt(1)%>&id=<%=rs.getString(2)%>&name=<%=rs.getString(3)%>">修改</a></td>
                              </tr>
                              <%};
                                rs.close();
                                psta.close();
                                conn.close();
                               %>
                               <tr>  
                               <th colspan="11" scope="col" style=" font-size: 20px; alignment: center"> 
						[<a href="showone.jsp?pageNow=1&stuidid=<%=a%>">首页</a>]
						<%--如果是下一页就当前页加1--%>
						[<a href="showone.jsp?pageNow=<%=pageNow-1%>&stuidid=<%=a%>">上一页</a>]
						<%
						   //循环将我们的分页数打印到页面上
    						for (int i = 1; i <= pageCount; i++) {
						%>
						[<a href="showone.jsp?pageNow=<%=i%>&stuidid=<%=a%>"><%=i%>
						</a>]
						<%
						    }
						%>
						<%--如果是上一页就当前页减1--%>
						[<a href="showone.jsp?pageNow=<%=pageNow+1%>&stuidid=<%=a%>">下一页</a>]
						<%--如果是尾页就是pageCount--%>
						[<a href="showone.jsp?pageNow=<%=pageCount%>&stuidid=<%=a%>">尾页</a>]</th>
                             </tr> 
                           </table>
					</form>
				</div>
			<div class="moreservices">
				<table border=1 bordercolor="lightgray" bgcolor="white">
					<tr >
						<th colspan="4">校讯快报</td>
						<!--<td></td>
						<td></td>
						<td></td>-->
					</tr>
					<tr>
						<td colspan="4" style="height:140px; padding: 10px; text-align: left; vertical-align: middle;">
							<ul>
								<li><span>[公告]学校建设进入快速发展新篇章</span>
								</li>
								<li>
									<span>[公告]知名教育学家莅临我校进行指导</span>
								</li>
								<li>
									<span>[公告]我校将在2023年举办亚运会项目</span>
								</li>
								<li>
									<span>[公告]疫情防控依然不可忽视</span>
								</li>
								<li>
									<span>[公告]每天一个居家隔离小妙招</span>
								</li>
								<li>
									<span>[公告]你的年度学习报单出来啦</span>
								</li>
								<li>
									<span>[公告]学校体恤学生舆情反馈正在积极响应学生号召</span>
								</li>
								
							</ul>
						</td>
					</tr>
				</table>
			</div>
		</div>
		
	</body>

</html>
