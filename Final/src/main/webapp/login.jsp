<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>登录</title>
    <link rel="stylesheet" href="css/style.css">
</head>

 <body background="img/bg3.jpg"

               style="background-repeat:no-repeat               

               background-attachment:fixed;               

               background-size:100% 100%; ">
    <section  style="background-color: rgba(255,255,255,0.15);">

        <!-- 登录 -->

        <div class="container">
            <div class="user singinBx">
                <div class="imgBx"><img src="img/bg1.jpg" alt=""></div>
                <div class="formBx">
                    <form action="jsp/logincheck.jsp" method="post">
                        <h2>登录</h2>
                        <input type="number" placeholder="请输入学号" name="username" />
                        <input type="password" placeholder="请输入密码" name="password" />
                        <input type="submit" id="login" value="登录">
                        <p class="signup">没有账号？<a href="#" onclick="topggleForm();">注册</a></p>
                    </form>
                </div>
            </div>

            <!-- 注册 -->

            <div class="user singupBx">
                <div class="formBx">
                    <form action="jsp/registeredcheck.jsp" method="post">
                        <h2>注册</h2>
                        <input type="text" placeholder="请输入姓名" name="name" />
                        <input type="number" placeholder="请输入学号" name="username" />
                        <input type="password" placeholder="请输入密码" name="password" />
                        <input type="password" placeholder="请确认密码" name="okpassword" />
                        <input type="submit" id="register" value="注册">
                        <p class="signup">已有账号？<a href="#" onclick="topggleForm();">登录</a></p>
                        <input type="reset" id="register" value="重置">
                    </form>
                </div>
                <div class="imgBx"><img src="img/bg2.jpg" alt=""></div>
            </div>

        </div>
    </section>
    <script type="text/javascript" src="js/load.js"></script>
</body>

</html>