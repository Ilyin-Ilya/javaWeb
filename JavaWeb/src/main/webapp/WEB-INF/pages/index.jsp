<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <link rel="stylesheet" href="./styles/styles.css">
    <title>Authentication</title>
</head>
<body>
<div class="container">

    <div class="box">
        <h3 class="h3">Authentication</h3>

        <form action="${pageContext.request.contextPath}/login" method="post">
            <div class="form-group">
                <div class="row">
                    <div class="col-4">
                        <label for="input-username">Username</label>
                    </div>
                    <div class="col-8">
                        <input type="text" class="form-control" id="input-username" name="username">
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="row">
                    <div class="col-4">
                        <label for="input-password">Password</label>
                    </div>
                    <div class="col-8">
                        <input type="password" class="form-control" id="input-password" name="password">
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-8 ml-auto">
                    <button type="submit" class="btn btn-primary">Log in</button>
                    <a href="./register">Create an account?</a>
                </div>
            </div>
        </form>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
        crossorigin="anonymous"></script>

</body>
</html>