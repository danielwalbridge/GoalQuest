<%@include file="common/header.jspf"%>
    <%@include file="common/navigation.jspf"%>

    <div class="container">
        <h1>Lets update your current goal: ${goal.goalTitle} </h1>
        <hr>

        <form:form method="post" modelAttribute="goal">

            <fieldset class="mb-3">
                <form:label path="goalTitle">Goal</form:label>
                <form:input type="text" path="goalTitle"/>
                <form:errors path="goalTitle" cssClass="alert-danger" />
            </fieldset>

            <fieldset class="mb-3">
                <form:label path="targetCompletionDate">Target Date </form:label>
                <form:input type="text" path="targetCompletionDate"/>
                <form:errors path="targetCompletionDate" cssClass="alert-danger" />
            </fieldset>

            <fieldset>
                <form:label path="done"> Click the box if You've completed the goal!</form:label>
                <form:checkbox  cssClass="ui-icon-check btn-lg" path="done"></form:checkbox>
                <hr>
            </fieldset>

            <form:input type="hidden" path="id"/>
            <input type = "submit" class="btn btn-success btn-outline-dark"/>

        </form:form>

    </div>
<%@include file="common/footer.jspf"%>

<script type="text/javascript">
    $('#targetCompletionDate').datepicker({
        format: 'yyyy-mm-dd',

    });
</script>
