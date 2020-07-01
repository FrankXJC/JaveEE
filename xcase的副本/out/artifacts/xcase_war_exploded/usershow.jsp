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
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">用户信息列表</h3>
    <form class="form-inline" action="${pageContext.request.contextPath}/adminSelectUserServlet" method="post">
        <div style="float: left;">


            <div class="form-group">
                <label for="exampleInputName2">筛选分数从</label>
                <input type="text" name="start" class="form-control"
                       id="exampleInputName2">
            </div>
            <div class="form-group">
                <label for="exampleInputName3">————</label>
                <input type="text" name="over" class="form-control"
                       id="exampleInputName3">
                &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;<label for="exampleInputName3">排序方式
                ：</label>
            </div>
            <div class="form-group">
                &ensp;&ensp;&ensp;&ensp;&ensp;<input type="radio" value="up" name="by"><label
                    for="exampleInputName3">升序</label>
                &ensp;&ensp;&ensp;&ensp;&ensp;<input type="radio" value="down" name="by"><label
                    for="exampleInputName3">降序</label>
            </div>


        </div>
        <div style="float: right;margin: 5px;">


            <input class="btn btn-primary" type="submit"
                   value="&ensp;&ensp;&ensp;&ensp;&ensp;提交查询&ensp;&ensp;&ensp;&ensp;&ensp;"/>


        </div>

    </form>
    <table border="1" class="table table-bordered table-hover">
        <tr class="success">
            <th>编号</th>
            <th>用户编号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>意向工作地点</th>
            <th>成绩</th>
            <th>操作</th>
        </tr>
        <%--  获取面试者信息集合  --%>


        <c:forEach var="userShow" items="${pb.list}" varStatus="s">
            <tr>
                <td>${s.count}</td>
                <td>${userShow.uid}</td>
                <td>${userShow.name}</td>
                <td>${userShow.sex}</td>
                <td>${userShow.age}</td>
                <td>${userShow.address}</td>
                <td>${userShow.score}</td>


                <td>
                    <a class="btn btn-default btn-sm" href="javascript:deleteUser(${userShow.uid});">转移到新库</a>&nbsp;
                    <a class="btn btn-default btn-sm" href="javascript:addUserToBlack(${userShow.uid});">添加黑名单</a>&nbsp;
                </td>
            </tr>
        </c:forEach>
    </table>
    <div>
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <c:if test="${pb.currentPage == 1}">
                <li class="disabled">
                    </c:if>

                    <c:if test="${pb.currentPage != 1}">
                <li>
                    </c:if>


                    <a href="${pageContext.request.contextPath}/adminSelectUserServlet?currentPage=${pb.currentPage - 1}&rows=5&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}"
                       aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>


                <c:forEach begin="1" end="${pb.totalPage}" var="i">


                    <c:if test="${pb.currentPage == i}">
                        <li class="active"><a
                                href="${pageContext.request.contextPath}/adminSelectUserServlet?currentPage=${i}&rows=5&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}">${i}</a>
                        </li>
                    </c:if>
                    <c:if test="${pb.currentPage != i}">
                        <li>
                            <a href="${pageContext.request.contextPath}/adminSelectUserServlet?currentPage=${i}&rows=5&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}">${i}</a>
                        </li>
                    </c:if>

                </c:forEach>


                <li>
                    <a href="${pageContext.request.contextPath}/adminSelectUserServlet?currentPage=${pb.currentPage + 1}&rows=5&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}"
                       aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
                <span style="font-size: 25px;margin-left: 5px;">
                    共${pb.totalCount}条记录，共${pb.totalPage}页
                </span>

            </ul>
        </nav>


    </div>
</div>

<script>
    function deleteUser(id) {
        //用户安全提示
        if (confirm("您确定要转移吗？转移会将该人员当前表删除")) {
            //访问路径
            location.href = "${pageContext.request.contextPath}//adminTransferUser?id=" + id;
        }
    }

    function addUserToBlack(id) {
        //用户安全提示
        if (confirm("您确定要将他添加到黑名单吗？添加到黑名单后该用户将不能登陆！")) {
            //访问路径
            location.href = "${pageContext.request.contextPath}//addBlackServlet?id=" + id;
        }
    }

</script>
</body>
</html>
