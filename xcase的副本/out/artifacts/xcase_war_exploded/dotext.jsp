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
    <title>试题信息管理</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">

        td, th {
            text-align: left;
            border-width: 0;
        }
    </style>
</head>
<body>
<div class="container" style="width: 80%">
    <h3 style="text-align: center">java基础测试题目列表</h3>
    <table  border="1" class="table table-bordered table-hover">
        <c:forEach var="quest" items="${sessionScope.adminText}" varStatus="s">
            <tr  class="success">
                <td>${s.count}.${quest.text}</td>
                <td width="15%" > <a class="btn btn-default btn-sm" href="javascript:deleteUser(${quest.id});" >移除</a></td>
            </tr>

            <tr>
                <td class="A_td_${s.count}" href="javascript:void(0);" colspan="2">
                    &ensp;&ensp;A.${quest.a} <br>
                </td>
            </tr>

            <tr>
                <td class="B_td_${s.count}" href="javascript:void(0);" colspan="2">
                    &ensp;&ensp;B.${quest.b} <br>
                </td>
            </tr>

            <tr>
                <td class="C_td_${s.count}" href="javascript:void(0);" colspan="2">
                    &ensp;&ensp;C.${quest.c} <br>
                </td>
            </tr>

            <tr>
                <td class="D_td_${s.count}" href="javascript:void(0);" colspan="2">
                    &ensp;&ensp;D.${quest.d} <br>
                </td>
            </tr>


        </c:forEach>

        <tr>
            <td colspan="10" >
                <center><input id="accc" class="btn btn-primary"  href="javascript:void(0);" value="添加" /></center>
            </td>
        </tr>
    </table>

</div>
<script>





</script>

</body>
</html>