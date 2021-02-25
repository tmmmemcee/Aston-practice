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

    <%@include file="vehicle_sidebar.jsp"%>
    <div class="col-sm-10">
        <div class="col-sm-8">
            <form:form cssClass="form-horizontal" modelAttribute="vehicleVO" action="/admin/vehicle/add" method="post">
                <fieldset>
                    <legend>Vehicle Management</legend>
                    <div class="form-group">
                        <label for="vehicleMakeName" class="col-lg-2 control-label">Vehicle Make</label>
                        <div class="col-lg-10">
                            <form:input path="vehicleMakeName" type="text"  class="form-control" id="vehicleMakeName"
                                        placeholder="Vehicle Make" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="vehicleModelName" class="col-lg-2 control-label">Vehicle Model</label>
                        <div class="col-lg-10">
                            <form:input path="vehicleModelName" type="text" class="form-control" id="vehicleModelName"
                                        placeholder="Vehicle Model" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="vehicleYear" class="col-lg-2 control-label">Vehicle Year</label>
                        <div class="col-lg-10">
                            <form:input path="vehicleYear" type="number" min="1960" max="2022" class="form-control" id="vehicleYear"
                                        placeholder="Vehicle Year" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="licensePlate" class="col-lg-2 control-label">License Plate</label>
                        <div class="col-lg-10">
                            <form:input path="licensePlate" class="form-control" type="text" id="licensePlate" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="VIN" class="col-lg-2 control-label">VIN Number</label>
                        <div class="col-lg-10">
                            <form:input path="VIN" class="form-control" type="text" id="VIN" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="color" class="col-lg-2 control-label">Color</label>
                        <div class="col-lg-10">
                            <form:input path="color" class="form-control" type="text" id="color" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Is purchased</label>
                        <div class="col-sm-8 ">
                                <form:checkbox path="purchased" id="purdchased" onclick="togglePurchase()" />
                        </div>
                    </div>
                    <div id="purchased-group" style="display: none">
                        <div class="form-group purchased-group">
                            <label for="purchasePrice" class="col-lg-2 control-label">Purchase Price</label>
                            <div class="col-sm-4">
                                <form:input path="purchasePrice" type="number" class="form-control" id="purchasePrice"
                                            placeholder="Purchase Price" />
                            </div>
                        </div>
                        <div class="form-group purchased-group" >
                            <label for="purchaseDate" class="col-lg-2 control-label">Purchase Date</label>
                            <div class="col-sm-4">
                                <form:input path="purchaseDate" type="date" class="form-control" id="purchaseDate" value="2000-01-01" />
                            </div>
                        </div>

                    </div>

                    <div class="form-group">
                        <div class="col-lg-10 col-lg-offset-2">
                            <form:button type="reset" value="cancel" class="btn btn-default">Cancel</form:button>
                            <form:button type="submit" value="save" class="btn btn-primary">Save</form:button>
                        </div>
                    </div>
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
                    <strong>Oh snap!</strong> <a href="#" class="alert-link">${errorMessage}</a> and try submitting again.
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