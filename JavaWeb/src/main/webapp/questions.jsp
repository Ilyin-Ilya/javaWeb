<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">Forum</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText"
                aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarText">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Questions <span class="sr-only">(current)</span></a>
                </li>
            </ul>
            <span class="navbar-text">
                Welcome, John Doe
            </span>
        </div>
    </nav>
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
        <tr>
            <th scope="row">1</th>
            <td><a href="question/1">Snakemake qsub rule for multiple wildcards</a></td>
            <td>Otto</td>
            <td>5</td>
            <td>Closed</td>
        </tr>
        <tr>
            <th scope="row">2</th>
            <td><a href="question/2">How to filter a field by its belonging to the model defined
                in the original model in Django?</a></td>
            <td>AlexPicker</td>
            <td>0</td>
            <td>Open</td>
        </tr>
        <tr>
            <th scope="row">3</th>
            <td><a href="question/3">Firefox :animate SVG radius only works with percentages</a></td>
            <td>geoM</td>
            <td>15</td>
            <td>Open</td>
        </tr>
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