<%@include file="common/header.jspf"%>
    <%@include file="common/navigation.jspf"%>

    <div class="container">
        <h1>Lets add another goal</h1>

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

            <form:input type="hidden" path="id"/>
            <form:input type="hidden" path="done"/>
            <input type = "submit" class="btn btn-success"/>

        </form:form>

    </div>
<%@include file="common/footer.jspf"%>

<script type="text/javascript">
    $('#targetCompletionDate').datepicker({
        format: 'yyyy-mm-dd',

    });
</script>
