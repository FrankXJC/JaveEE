<%@ page import="cn.domain.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">

<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>信息填报</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-2.1.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

</head>
<body>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">个人信息填报</h3>
    <form id="form" action="${pageContext.request.contextPath}/userAddServlet" method="post">
        <div class="form-group">

            <div class="form-group">
                <label for="username">账号：</label>
                <input type="text" class="form-control" id="username" name="username" placeholder="请输入账号"/>
            </div>

            <div class="form-group">
                <label for="password">密码：</label>
                <input type="text" class="form-control" id="password" name="password" placeholder="请输入密码"/>
            </div>
            <div class="form-group">
                <label for="name">姓名：</label>
                <input type="text" class="form-control" id="name" name="name" placeholder="请输入姓名">
            </div>

            <div class="form-group">
                <label>性别：</label>
                <input type="radio" name="sex" value="男" checked="checked"/>男
                <input type="radio" name="sex" value="女"/>女
            </div>

            <div class="form-group">
                <label for="age">年龄：</label>
                <input type="text" class="form-control" id="age" name="age" placeholder="请输入年龄">
            </div>

            <div class="form-group">
                <label for="phoneNumber">电话：</label>
                <input type="text" class="form-control" id="phoneNumber" name="phoneNumber" placeholder="请输入电话号码">
            </div>


            <div class="form-group">
                <label for="address">意向工作地址：</label>
                <select name="address" class="form-control" id="address">
                    <option value="">--请选择--</option>
                    <option value="西安">西安</option>
                    <option value="上海">上海</option>
                    <option value="杭州">杭州</option>
                </select>
            </div>

            <div class="form-group" style="text-align: center">
                <input id="accc" class="btn btn-primary" href="javascript:void(0);" value="提交"/>
                <input id="b" class="btn btn-default" type="reset" value="重置"/>
            </div>
        </div>
    </form>
    <script>
        window.onload = function () {
            document.getElementById("accc").onclick = function () {
                if (confirm("您确定要提交吗？信息错误可能使我们的回复找不到您！！")) {
                    var form = document.getElementsByClassName("form-control");
                    var a = true;
                    for (var i = 0; i < form.length; i++) {
                        if (form[i].value == "") {
                            alert("请认真完成数据填报");
                            a = false;
                            break;
                        }
                    }
                    if (a == true) {
                        document.getElementById("form").submit();
                    }
                }
            }
        }


    </script>

</div>
</body>
</html>