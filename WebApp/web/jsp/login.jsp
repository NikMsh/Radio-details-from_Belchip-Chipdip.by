

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <title>Login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/LogIn.css">
    <link href="${pageContext.request.contextPath}/icons/icon.ico" rel="icon" type="image/x-icon" />
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="navbar-brand" href="http://localhost:8080/login">Log in</a>
            </li>
        </ul>
    </div>
</nav>

<div class="normalPadding">
    <div class="container">
        <div class="row justify-content-md-center">
            <div class="col-md-offset-3 col-md-6">
                <form class="form-horizontal" method="post" action="/check">
                    <span class="heading">Log in</span>
                    <div class="form-group">
                        <input type="text" class="form-control" id="inputEmail" placeholder="E-mail" name="userName">
                        <i class="fa fa-user"></i>
                    </div>
                    <div class="form-group help">
                        <input type="password" class="form-control" id="inputPassword" placeholder="Password" name="userPassword">
                        <i class="fa fa-lock"></i>
                    </div>
                    <div class="form-group">
                        <div class="main-checkbox">
                            <input type="checkbox" value="none" id="checkbox1" name="check"/>
                            <label for="checkbox1"></label>
                        </div>
                        <span class="text">Remember me</span>
                        <input type="submit" value="Log In" class="btn btn-default" />
                    </div>
                </form>
            </div>

        </div>
    </div>
</div>

<footer id="footer" class="dark-wrapper">
    <div class="container inner">
        <div class="row">
            <div class="col-sm-4">
                2018
                <br/>Created By <div class="themeBy">Nik_Msh</div>
            </div>
        </div>
    </div>
</footer>
</body>
</html>
