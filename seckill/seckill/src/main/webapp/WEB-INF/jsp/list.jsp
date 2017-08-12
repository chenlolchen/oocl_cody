<%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2016/5/31
  Time: 13:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp"%>

<html>
<head>
    <title>秒杀列表</title>
    <%@include file="common/head.jsp"%>
</head>
<body>
    <div class="container">
        <div class="panel panel-default">
            <div class="panel-heading text-center">
                <h2>商品列表</h2>
            </div>
            <div class="panel-body">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>名称</th>
                            <th>库存</th>
                            <th>开始时间</th>
                            <th>结束时间</th>
                            <th>创建时间</th>
                            <th>详情页</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="item" items="${pagelist}">
                            <tr>
                                <td>${item.name}</td>
                                <td>${item.number}</td>
                                <td>
                                    <fmt:formatDate value="${item.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                                <td>
                                    <fmt:formatDate value="${item.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                                <td>
                                    <fmt:formatDate value="${item.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                                <td>
                                    <a class="btn btn-info" href="/seckill/${item.seckillId}/detail" target="_blank">购买</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <nav class="text-center">
                    <ul class="pagination">

                        <c:if test="${totalPages > 0 }">
                            <c:if test="${pageNumber == 1 }">
                                <li class="disabled"><span aria-hidden="true">&laquo;</span></li>
                            </c:if>
                            <c:if test="${pageNumber != 1 }">
                                <li><a href="/seckill/${pageNumber-1}/pagelist" aria-label="Previous"><span
                                        aria-hidden="true">&laquo;</span></a></li>
                            </c:if>

                            <c:forEach var="i" begin="1" end="${totalPages}">
                                <c:if test="${pageNumber == i }">
                                    <li class="active"><a href="/seckill/${i}/pagelist"><c:out value="${i}"/></a></li>
                                </c:if>
                                <c:if test="${pageNumber != i }">
                                    <li><a href="/seckill/${i}/pagelist"><c:out value="${i}"/></a></li>
                                </c:if>
                            </c:forEach>

                            <c:if test="${pageNumber == totalPages}">
                                <li class="disabled"><span aria-hidden="true">&raquo;</span></li>
                            </c:if>
                            <c:if test="${pageNumber != totalPages}">
                                <li><a href="/seckill/${pageNumber+1}/pagelist" aria-label=""><span aria-hidden="true">&raquo;</span></a></li>
                            </c:if>
                        </c:if>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
<!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
<script src="/js/jquery-1.12.4.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="/js/bootstrap.min.js"></script>
</body>
</html>