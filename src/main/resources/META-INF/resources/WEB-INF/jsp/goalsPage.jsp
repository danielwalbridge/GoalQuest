<%@include file="common/header.jspf"%>
<%@include file="common/navigation.jspf"%>

    <div class = "container">

        <h1> Your current Goal Quests are </h1>
        <table class ="table">
            <thead>
                <tr>
                    <th>Goal Name</th>
                    <th>Target Date</th>
                    <th>Is Done</th>
                    <th>Delete Goal</th>
                    <th>Update Goal</th>
                </tr>
            </thead>

            <tbody>
                <c:forEach items="${userGoals}" var="goal">
                    <tr>
                        <td>${goal.goalTitle}</td>
                        <td>${goal.targetCompletionDate}</td>
                        <td>${goal.done}</td>
                        <td>
                            <a href="deleteGoal?id=${goal.id}" class="btn-warning">Delete</a>
                        </td>
                        <td>
                            <a href="updateGoal?id= ${goal.id}" class="btn-info"> Update</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="addGoal" class="btn btn-success">add goal</a>
    </div>

<%@include file="common/footer.jspf"%>