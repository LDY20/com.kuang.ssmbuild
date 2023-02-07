<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/book/uploadfile/uploadFile" method="post" enctype="multipart/form-data">
        名称：<input type="text" name="username"><br/>
        文件：<input type="file" name="file"><br/>
        多个文件：<input type="file" name="files"><br/>

    </form>



</body>
</html>