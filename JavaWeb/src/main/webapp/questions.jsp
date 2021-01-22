<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="info" tagdir="/WEB-INF/tags" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <link rel="stylesheet" href="./styles/styles.css">
    <title>Questions</title>
</head>
<body>
<div class="container">
    <info:header/>
    <br>
        <div class="row">
        <div class="col-10">
            <h3>Questions</h3>
        </div>
        <div class="col">
            <button type="button" class="btn btn-primary">Ask your question</button>
        </div>
    </div>
    <br>

    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Question title</th>
            <th scope="col">Author</th>
            <th scope="col">Answers</th>
            <th scope="col">Status</th>
        </tr>
        </thead>
        <tbody>


      <c:forEach var="question" items="${questions}">
                      <tr>
                          <th scope="row">${questions.get(question).sequence_number}</th>
                          <td><a href="${pageContext.request.contextPath}/info?id=${questions.get(question).sequence_number}">${questions.get(question).question_title}</a></td>
                          <td>${questions.get(question).author}</td>
                          <td>${questions.get(question).answers_number}</td>
                          <td>${questions.get(question).status}</td>
                      </tr>
              </c:forEach>

        </tbody>
    </table>

</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
        crossorigin="anonymous"></script>
</body>
</html>