<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="ru.job4j.model.Post" %>
<%@ page import="ru.job4j.store.PsqlStore" %>
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
    <script>
        function validateInput() {
            var isValid = true;
            var postName = $('#postName').val();
            var postDesc = $('#postDesc').val();
            if (postName === '' || postDesc === '') {
                alert("Оба поля должны быть заполнены");
                isValid = false;
            }
            return isValid;
        }
    </script>
    <title>Работа мечты</title>
</head>
<body>
<%@ include file = "/header.jsp" %>
<%
    String id = request.getParameter("id");
    Post post = new Post(0, "", "");
    if (id != null) {
        post = PsqlStore.instOf().findPostById(Integer.parseInt(id));
    }
%>
<div class="container pt-3">
    <div class="row">
        <div class="card" style="width: 100%">
            <div class="card-header">
                <% if (id == null) { %>
                Новая вакансия.
                <% } else { %>
                Редактирование вакансии.
                <% } %>
            </div>
            <div class="card-body">
                <form action="<%=request.getContextPath()%>/posts.do?id=<%=post.getId()%>" method="post">
                    <div class="form-group">
                        <label>Имя
                            <input type="text" class="form-control" id="postName" name="name" placeholder="Название вакансии">
                        </label>
                        <label>Описание
                            <input type="text" class="form-control" id="postDesc" name="description" placeholder="Описание вакансии">
                        </label>
                    </div>
                    <button type="submit" class="btn btn-primary" onclick="return validateInput()">Сохранить</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>