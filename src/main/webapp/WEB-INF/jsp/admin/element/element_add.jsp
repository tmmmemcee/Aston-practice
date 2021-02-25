<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/navbar.jsp"%>
<%@include file="../../includes/subnav_admin.jsp"%>

<script>
    $(document).ready(function() {
        $('#successAlert').delay(8000).fadeOut(2000);
        $('#warningAlert').delay(10000).fadeOut(2000);
        $('#errorAlert').delay(10000).fadeOut(2000);
    });
</script>

<div class="wrapper">

    <%@include file="element_sidebar.jsp"%>>
    <div class="col-sm-10">
        <div class="col-sm-8">
            <form:form cssClass="form-horizontal" modelAttribute="elementVO" action="/admin/element/add" method="post">
                <fieldset>
                    <legend>Element Management</legend>
                    <div class="form-group">
                        <label for="inputNewElementType" class="col-lg-2 control-label">Element Type</label>
                        <div class="col-lg-10">
                            <form:input path="newElementType" type="text" class="form-control" id="inputNewElementType" placeholder="Element Type" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputNewElement" class="col-lg-2 control-label">Element Type</label>
                        <div class="col-lg-10">
                            <form:textarea path="newElements"  class="form-control" rows="3" id="inputNewElement"/>
                            <span class="help-block">Enter each new Element on a new line</span>
                        </div>
                    </div>

                    <dvi class="form-group">
                        <div class="col-lg-10 col-lg-offset-2">
                            <form:button type="reset" value="cancel" class="btn btn-default">Cancel</form:button>
                            <form:button type="submit" value="save" class="btn btn-primary">Save</form:button>
                        </div>
                    </dvi>
                </fieldset>

            </form:form>
        </div>

        <div class="col-sm-4">
            <%--            ALERTS--%>
            <div id="warningAlert" class=${warningAlert == null ? 'hidden' : warningAlert}>
                <div class="alert alert-dismissible alert-warning">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <h4 class="alert-heading">Be Advised!</h4>
                    <p class="mb-0">All fields are required. Please enter an ElementType and Element <a href="#" class="alert-link">vel scelerisque nisl consectetur et</a>.</p>
                </div>
            </div>
            <div id="errorAlert" class=${errorAlert == null ? 'hidden' : errorAlert}>
                <div class="alert alert-dismissible alert-danger">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <strong>Oh snap!</strong> <a href="#" class="alert-link">Change a few things up</a> and try submitting again.
                </div>
            </div>
            <div id="successAlert" class=${successAlert == null ? 'hidden' : successAlert}>
                <div class="alert alert-dismissible alert-success">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <strong>Element added successfully to the database!</strong> You successfully read <a href="#" class="alert-link">this important alert message</a>.
                </div>
            </div>
        </div>
    </div>


</div>

<%@include file="../../includes/footer.jsp"%>