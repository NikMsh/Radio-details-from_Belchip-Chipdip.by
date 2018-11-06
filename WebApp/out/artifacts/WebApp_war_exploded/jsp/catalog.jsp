

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <title>Nik_Msh</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-responsive.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/catalog.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/gallery-grid.css" />
    <link href="${pageContext.request.contextPath}/icons/icon.ico" rel="icon" type="image/x-icon" />
    <style>
        td {
            text-align: center;
        }
    </style>
</head>
  <body>
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav mr-auto">
              <li class="nav-item active">
                  <a class="nav-link" href="http://localhost:8080/nik_msh">Home <span class="sr-only">(current)</span></a>
              </li>
              <li class="nav-item">
                  <a class="nav-link disabled" href="http://localhost:8080/login">Exit</a>
              </li>
          </ul>
          <form class="form-inline my-2 my-lg-0" method="get" action="${nik_msh}search">
              <input class="form-control" type="search" name="find" placeholder="Search" aria-label="Search"/>
              <input class="btn btn-outline-success my-2 my-sm-0" type="submit" value="Search"/>
              <p>${findCatalog}
          </form>

      </div>
  </nav>


  <div class="normalPadding">
  <div class="container gallery-container">
      <section class="section">
          <div class="section-inner">
              <div class="h2pad">
                  <h3 class="heading text-center">Products catalog:</h3>
              </div>

              <div class="content text-center">
                  <div class="txt-style">
                        ${product}
                        <c:forEach var="catalog" items="${catalogs}">
                             <p><a href="${urlSection}${catalog.getURL()}"> ${catalog.getName()}</a>
                          </c:forEach>

                          <c:forEach var="catalog" items="${subCatalog}">
                            <p><a href="${subUrlSection}${catalog.getURL()}"> ${catalog.getName()}</a>
                          </c:forEach>
                            <br>
                            <div>
                                <input type="submit" style="color: #fff;
                                background: #00b4ef;" value="Back" class="btn btn-default" onclick="goBack()"/>
                            </div>
                    </div>
              </div>
          </div>
      </section>
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

  <script type="text/javascript">
      function goBack() {
          window.history.back();
      }
  </script>

  </body>
</html>