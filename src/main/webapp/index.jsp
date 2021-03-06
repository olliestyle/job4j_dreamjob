<%@ page contentType="text/html; charset=UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

    <title>Работа мечты</title>
</head>
<body>
<%@ include file = "/header.jsp" %>
<div class="container">
    <div class="row">
        <div class="card" style="width: 100%">
            <div class="card-header">
                Сегодняшние вакансии.
            </div>
            <div class="card-body">
                <table class="table">
                    <tbody>
                    <c:forEach items="${posts}" var="post">
                        <tr>
                            <td>
                                <a href='<c:url value="/post/edit.jsp?id=${post.id}"/>'>
                                    <i class="fa fa-edit mr-3"></i>
                                </a>
                            <td><c:out value="${post.name}"/></td>
                            <td><c:out value="${post.description}"/></td>
                            <td><c:out value="${post.date}"/></td>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="card-body">
            </div>
        </div>
    </div>
    <div class="row pt-3">
        <div class="card" style="width: 100%">
            <div class="card-header">
                Сегодняшние кандидаты.
            </div>
            <div class="card-body">
                <table class="table">
                    <tbody>
                    <c:forEach items="${candidates}" var="candidate">
                        <tr>
                            <td>
                                <a href='<c:url value="/candidate/edit.jsp?id=${candidate.id}"/>'>
                                    <button style="font-size:12px;color:blue">Edit candidate</button>
                                </a>
                                <a href='<c:url value="/photoUpload.do?id=${candidate.id}"/>'>
                                    <button style="font-size:12px;color:blue">Add photo</button>
                                </a>
                                <a href='<c:url value="/candidateDelete.do?id=${candidate.id}"/>'>
                                    <button style="font-size:12px;color:blue">Delete candidate</button>
                                </a>
                            <td><c:out value="${candidate.name}"/> </td>
                            <td><c:forEach items="${cities}" var="city">
                                <c:if test="${city.id == candidate.cityId}">
                                    <c:out value="${city.name}"/>
                                </c:if>
                            </c:forEach>
                            </td>
                            <td><c:out value="${candidate.date}"/></td>
                            </td>
                            <td>
                                <img src="<c:url value='/download?name=${candidate.id}'/>" width="100px" height="100px"/>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="card-body">
            </div>
        </div>
    </div>
</div>
</body>
</html>