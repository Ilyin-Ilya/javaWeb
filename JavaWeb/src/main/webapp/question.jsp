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
    <title>Question</title>
</head>
<body>
<div class="container">

    <info:header/>

    <br>
    <div class="question-info">
        <div class="row">
            <div class="col-10">
                <h3>${question.question_name}</h3>
            </div>
            <div class="col">
                <button type="button" class="btn btn-primary">Ask your question</button>
            </div>
        </div>
        <br>
        <p>
          ${question.question_body}
        </p>
    </div>
    <div>
        <h4>${answers.size()} Answers</h4>
    </div>
    <br>
    <div class="answer-list">
    <c:if "${answers}.size() > 0}">
          <c:forEach var="answer" items="${answers}">
            <div class="answer">
                <div class="row">
                    <div class="col-3">${answer}+1</div>
                    <div class="col-9">${answers.get(answer).answer_body}
                    </div>
                </div>
                <div class="row align-items-center">
                    <div class="col-3">
                        <svg xmlns="http://www.w3.org/2000/svg" width="50" height="50" fill="currentColor"
                             class="bi bi-check check-flag" viewBox="0 0 16 16">
                            <path d="M10.97 4.97a.75.75 0 0 1 1.07 1.05l-3.99 4.99a.75.75 0 0 1-1.08.02L4.324 8.384a.75.75 0 1 1 1.06-1.06l2.094 2.093 3.473-4.425a.267.267 0 0 1 .02-.022z"></path>
                        </svg>
                    </div>
                    <div class="col-9">
                        <div class="date-info">Date <strong>${answers.get(answer).date_answered}</strong></div>
                        <div class="author-answer">Author: ${answers.get(answer).findAuthor().login}</div>
                    </div>
                </div>
            </div>
               </c:forEach>
                    </c:if>
        <div class="answer">
            <div class="row">
                <div class="col-3">2</div>
                <div class="col-9">
                    Thanks you for this answer. The problem is that I have no list of files, so the "samples=
                    will not work. The only input for this worflow is a directory containing the fastq
                    files. I also tried to use "os.listdir(Raw_calling/)" in the function or as an input for my
                    rule. but snakemake told me that the repertory "Raw_calling" does not exists. I think it is
                    because the python code is executed before the workflow run and so it's true that the repertory
                    has not been created yet. Or maybe because he can't connect the merging rule with the previous
                    one
                </div>
            </div>
            <div class="row align-items-center">
                <div class="col-3"></div>
                <div class="col-9">
                    <div class="date-info">Date <strong>19.01.2020 19:27</strong></div>
                    <div class="author-answer">Author: adas</div>
                </div>
            </div>
        </div>
        <div class="answer">
            <div class="row">
                <div class="col-3">3</div>
                <div class="col-9">
                    It could be that snakemake thinks your target rule is convert_ab1_to_fastq and not all. By default,
                    snakemake takes the first rule as target rule. Declare all first, and see whether this solves your
                    problem.
                </div>
            </div>
            <div class="row align-items-center">
                <div class="col-3"></div>
                <div class="col-9">
                    <div class="date-info">Date <strong>19.01.2020 20:27</strong></div>
                    <div class="author-answer">Author: Otto</div>
                </div>
            </div>
        </div>
        <div class="answer">
            <div class="row">
                <div class="col-3">4</div>
                <div class="col-9">
                    You don't define variables in input sections. You use variables to build the concrete names of the
                    files that the rule instance will need (or, more precisely, that you say you want to exist before
                    the rule instance can be run: the rule does not need to actually use those files). Those variables
                    are those defined outside the scope of the rules, directly at the ground level of the snakefile, in
                    pure Python mode, and the local wildcards object. By default, the {attribute_name} placeholders will
                    be substituted by the attributes of the local wildcards object ("{sample}" becomes
                    "Corces2016_4983.7A_Mono"), but if you want to do more complicated stuff to build the file names,
                    you need to do this via a function that will have to explicitly handle this wildcards object (lambda
                    wildcards: f"{wildcards.sample}" becomes "Corces2016_4983.7A_Mono").
                </div>
            </div>
            <div class="row align-items-center">
                <div class="col-3"></div>
                <div class="col-9">
                    <div class="date-info">Date <strong>19.01.2020 21:27</strong></div>
                    <div class="author-answer">Author: Qwerty</div>
                </div>
            </div>
        </div>
        <div class="answer">
            <div class="row">
                <div class="col-3">5</div>
                <div class="col-9">
                    For the A part of your question, I would suggest using tab-delimited files in order to store sample
                    information, ID, etc, whatever amount of samples you have. You can then store the path to this file
                    in your config file, and access it by using column identifiers with the pandas library. See this
                    thread for more detail.
                </div>
            </div>
            <div class="row align-items-center">
                <div class="col-3"></div>
                <div class="col-9">
                    <div class="date-info">Date <strong>19.01.2020 22:27</strong></div>
                    <div class="author-answer">Author: Alexa</div>
                </div>
            </div>
        </div>
    </div>
    <form class="answer-form" method='post' action='${pageContext.request.contextPath}/answer'>
        <div class="form-group">
            <label for="textarea-answer">Your Answer</label>
            <textarea class="form-control" id="textarea-answer" rows="3" name="userAnswer"></textarea>
        </div>
        <div class="form-group">
            <div class="col-8">
                <button type="submit" class="btn btn-primary">Post Your Answer</button>
            </div>
        </div>
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
        crossorigin="anonymous"></script>
</body>
</html>