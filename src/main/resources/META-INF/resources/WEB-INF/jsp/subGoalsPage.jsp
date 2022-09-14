<%@include file="common/header.jspf"%>
<%@include file="common/navigation.jspf"%>

    <div class = "container">

        <h1> Your current Goal is : ${goal.goalTitle}</h1>
        <table class ="table"
               bgcolor="#778899">
            <thead>
                <tr>
                    <th>Sub-Goals</th>
                </tr>
            </thead>

            <tbody>
                <c:forEach items="${subGoals}" var="subGoal">
                    <tr>
                        <td>${subGoal.description}</td>
                    </tr>

<%--                            <a href="deleteGoal?id=${goal.id}" class="btn-warning">Delete</a>--%>
<%--                        </td>--%>
<%--                        <td>--%>
<%--                            <a href="updateGoal?id= ${goal.id}" class="btn-info"> Update</a>--%>
<%--                        </td>--%>
<%--                        <td>--%>
<%--                            <a href="addSubGoal?id= ${goal.id}" class="btn-info" style="text-decoration-color: blueviolet"> add Sub Goal</a>--%>
<%--                        </td>--%>
<%--                    </tr>--%>
                </c:forEach>
            </tbody>
        </table>
<%--        <a href="addGoal" class="btn btn-success">add goal</a>--%>
    </div>

<%@include file="common/footer.jspf"%>