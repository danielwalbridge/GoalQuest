<%@include file="common/header.jspf"%>
<%@include file="common/navigation.jspf"%>

    <div class = "container">

        <h1> Your current Goal Quests are </h1>
        <hr>
        <table class ="table"
               bgcolor="#778899">
            <thead>
                <tr>
                    <th>Goal Name</th>
                    <th>Target Date</th>
                    <th>Is Done</th>
                    <th>Delete Goal</th>
                    <th>Update Goal</th>
                    <th>Add Sub Goal</th>
                    <th>view Sub Goals</th>
                </tr>
            </thead>

            <tbody>
                <c:forEach items="${userGoals}" var="goal">
                    <tr>
                        <td>${goal.goalTitle}</td>
                        <td>${goal.targetCompletionDate}</td>
                        <td>${goal.done}</td>
                        <td>
                            <a href="deleteGoal?id=${goal.id}" class="btn btn-sm btn-danger btn-block btn-outline-dark ">Delete</a>
                        </td>
                        <td>
                            <a href="updateGoal?id= ${goal.id}" class="btn btn-sm btn-warning btn-block btn-outline-dark "> Update</a>
                        </td>
                        <td>
                            <a href="addSubGoal?id= ${goal.id}" class="btn btn-sm btn-block btn-info btn-outline-dark" > add Sub Goal</a>
                        </td>

                        <td>
                            <a href="viewSubGoals?id= ${goal.id}" class="btn btn-sm btn-block btn-info btn-outline-dark" > view Sub Goal</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="addGoal" class="btn btn-success btn-outline-dark">add goal</a>
    </div>

<%@include file="common/footer.jspf"%>