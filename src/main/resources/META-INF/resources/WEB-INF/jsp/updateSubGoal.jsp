<%@include file="common/header.jspf"%>
    <%@include file="common/navigation.jspf"%>

    <div class="container" >

        <h1>update current sub goal of: </h1>
        <h2> "${subGoal.description}"</h2>
        <hr>

        <form:form method="post" modelAttribute="subGoal" >

            <fieldset class="mb-3">
                <form:label path="description">update sub goal</form:label>
                <form:input type="text" path="description"/>
                <form:errors path="description" cssClass="alert-danger" />
            </fieldset>

            <form:input type="hidden" path="id"/>
            <form:input type="hidden" path="goal"/>

            <input type = "submit" class="btn btn-success btn-primary btn-block btn-outline-dark"/>

        </form:form>

    </div>
<%@include file="common/footer.jspf"%>


