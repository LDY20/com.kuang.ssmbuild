<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/11/15 0015
  Time: 13:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
  <head>
    <title>首页</title>
    <style type="text/css">
      a {
        text-decoration: none;
        color: black;
        font-size: 18px;
      }
      h3 {
        width: 180px;
        height: 38px;
        margin: 100px auto;
        text-align: center; /*字体居中*/
        line-height: 38px;  /*居高对齐*/
        background: deepskyblue;  /*颜色：深蓝色*/
        border-radius: 4px; /*圆角边框*/
      }
    </style>
  </head>
  <body>

  <h3>       <%--${pageContext.request.contextPath}表示取绝对地址--%>
    <a href="${pageContext.request.contextPath}/book/allBook">进入书籍页面</a>  <%--这里无法从首页转到allBook页面，出现404问题--%>
  </h3>



  </body>
</html>
