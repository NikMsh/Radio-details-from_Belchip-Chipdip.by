


<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <title>Error</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/LogIn.css">
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item active">
                    <a class="navbar-brand" href="http://localhost:8080/nik_msh">Home</a>
                </li>
            </ul>
        </div>
    </nav>

    <div class="normalWaitPadding">
        <div class="container">
            <div class="row justify-content-md-center">
                <div class="col-md-offset-3 col-md-6">
                    <form class="form-horizontal" action="/nik_msh">
                        <span class="heading">Something went wrong...</span>
                        <div class="form-group">
                            <img src="${pageContext.request.contextPath}/img/error.png" class="coffee">
                        </div>
                        <div class="form-group">
                            <input type="submit" value="Back" class="btn btn-default">
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
