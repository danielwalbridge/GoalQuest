<%@include file="common/header.jspf"%>
<%@include file="common/navigation.jspf"%>

    <div class = "container">

        <h1> Your current Goal is : ${goal.goalTitle}</h1>
        <hr>
        <h3> The target date for this goal is: ${goal.targetCompletionDate}</h3>
        <table class ="table"
               bgcolor="#778899">
            <thead>
                <tr>
                    <th>Sub-Goals</th>
                    <th>Delete Sub-Goal</th>
                    <th>Update Sub-goal</th>
                </tr>
            </thead>

            <tbody>
                <c:forEach items="${subGoals}" var="subGoal">
                    <tr>
                        <td>${subGoal.description}</td>

                <td>
                    <a href="deleteSubGoal?id=${subGoal.id}" class="btn btn-sm btn-danger btn-block btn-outline-dark ">Delete</a>
                </td>
                <td>
                    <a href="updateSubGoal?id= ${subGoal.id}" class="btn btn-sm btn-warning btn-block btn-outline-dark "> Update</a>
                </td>
                <td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="addSubGoal?id= ${goal.id}" class="btn btn-success btn-primary btn-block btn-outline-dark"> add Sub Goal</a>
    </div>

<%@include file="common/footer.jspf"%>