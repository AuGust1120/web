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
    ArrayList <String> arrayList = new ArrayList<>();
    int line = 0;//记录已读行数
    try {
        String path ="C:\\Users\\28612\\eclipse\\Final\\src\\main\\webapp\\jsp";//文件的目录,绝对路径
        File file = new File(path,"1.txt");
        FileReader fr = new FileReader(file);//按字符读取流中数据
        BufferedReader bf = new BufferedReader(fr); //创建一个使用默认大小输入缓冲区的缓冲字符输入流。
        String str;
        // 按行读取字符串
        while ((str = bf.readLine()) != null) {
            arrayList.add(str);
            line++;
        }
        bf.close();
        fr.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
    // 对ArrayList中存储的字符串进行处理
    int length = arrayList.size();
    int[] array = new int[length];
    String[] strings = new String[line];//创建一个字符串数组存取文本中每行的内容，为比较做准备
    for (int i = 0; i < length; i++) {
        strings[i]=arrayList.get(i);
    }
    //从index.jsp获取输入的用户名和密码
    String uname = request.getParameter("username");
    String pwd = request.getParameter("password");
    //依次对文件中的用户名和密码进行比较，其中的逻辑很容易理解，奇数行为用户名，偶数行为密码
    for(int i = 0;i < length;) {
        if (uname.equals(strings[i]) && pwd.equals(strings[i + 1])) {
            request.getSession().setAttribute("username",uname);//将用户名保存在整个会话期间,便于成功登录显示
            response.sendRedirect("../list.jsp");
            break;
        } else {
            i+=2;
        }
        out.print("<script>alert('用户名或密码错误，请重新登录');location.href='../login.jsp';</script>");//比较全部数据后不正确返回首页
    }
%>
</body>
</html>
