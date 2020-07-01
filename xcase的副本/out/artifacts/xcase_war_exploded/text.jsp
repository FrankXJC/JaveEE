<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery-3.3.1.min.js"></script>
    <style type="text/css">

        td, th {
            text-align: left;
            border-width: 0;
        }
    </style>
</head>
<body>
<div class="container" style="width: 80%">
    <h3 style="text-align: center">java基础测试</h3>
    <form id="form" action="${pageContext.request.contextPath}/textInsertServlet">
    <table  border="1" class="table table-bordered table-hover">
        <c:forEach var="quest" items="${sessionScope.text}" varStatus="s">
            <tr  class="success">
                <td>${s.count}.${quest.text}</td>
            </tr>

            <tr >
                <td class="A" onclick="doit(this)" >
                    &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;<input class="A_${s.count}" type="radio" value="A" name="${s.count}">&ensp;&ensp;&ensp;A.${quest.a} <br>
                </td>
            </tr>

            <tr>
                <td class="B" onclick="doit(this);">
                    &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;<input class="B_${s.count}" type="radio" value="B" name="${s.count}">&ensp;&ensp;&ensp;B.${quest.b} <br>
                </td>
            </tr>

            <tr>
                <td class="C" onclick="doit(this)  ">
                    &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;<input class="C_${s.count}" type="radio" value="C" name="${s.count}">&ensp;&ensp;&ensp;C.${quest.c} <br>
                </td>
            </tr>

            <tr>
                <td class="D" onclick="doit(this)">
                    &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;<input class="D_${s.count}" type="radio" value="D" name="${s.count}">&ensp;&ensp;&ensp;D.${quest.d} <br>
                </td>
            </tr>


        </c:forEach>

        <tr>
            <td colspan="10" >
                <center><input id="accc" class="btn btn-primary"  href="javascript:void(0);" value="提交" /></center>
            </td>
        </tr>
    </table>
    </form>
</div>
<script>

    document.getElementById("accc").onclick =function () {
        if(confirm("您确定要提交吗？提交后无法修改")){
            document.getElementById("form").submit();
        }
    }









</script>

</body>
</html>