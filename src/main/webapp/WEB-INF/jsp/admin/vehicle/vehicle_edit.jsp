<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/navbar.jsp"%>
<%@include file="../../includes/subnav_admin.jsp"%>


<div class="wrapper">

    <%@include file="vehicle_sidebar.jsp"%>

    <div id="main-wrapper" class="col-sm-10">
        <div class="col-sm-8">
            <c:set var="idx" value="0" scope="page" />
            <form:form class="form-hrizontal" modelAttribute="vehicle" action="/admin/vehicle/update" method="post">
                <form:hidden path="id" />
                <form:hidden path="version" />
                <div class="row">
                    <div class="form-group">
                        <label for="vehicleMakeName" class="col-lg-2 control-label">Vehicle Make</label>
                        <div class="col-sm-8">
                            <form:input path="vehicleModel.vehicleMake.vehicleMakeName" type="text"  class="form-control" id="vehicleMakeName"
                                        placeholder="Vehicle Make" />
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group">
                        <label for="vehicleModelName" class="col-lg-2 control-label">Vehicle Model</label>
                        <div class="col-sm-8">
                            <form:input path="vehicleModel.vehicleModelName" type="text" class="form-control" id="vehicleModelName"
                                        placeholder="Vehicle Model" />
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group">
                        <label for="vehicleYear" class="col-sm-2 control-label" >Vehicle Year</label>
                        <div class="col-sm-8">
                            <form:input path="vehicleYear" type="number" min="1960" max="2022" class="form-control"  id="vehicleYear" />
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group">
                        <label for="licensePlate" class="col-sm-2 control-label">License Plate</label>
                        <div class="col-sm-8">
                            <form:input path="licensePlate" class="form-control" type="text" id="licensePlate" />
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group">
                        <label for="vinNumber" class="col-sm-2 control-label">VIN Number</label>
                        <div class="col-sm-8">
                            <form:input path="VIN" class="form-control" type="text" id="vinNumber" />
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group">
                        <label for="color" class="col-sm-2 control-label">Color</label>
                        <div class="col-sm-8">
                            <form:input path="color" class="form-control" type="text" id="color" />
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Is Purchased</label>
                        <div class="col-sm-8">
                            <form:checkbox path="Purchased" onclick="togglePurchase()"/>
                        </div>
                    </div>
                </div>
                <div id="purchase-group" style="display: none">

                </div>
                <div class="row">
                    <div class="form-group">
                        <label for="purchasePrice" class="col-lg-2 control-label">Purchase Price</label>
                        <div class="col-sm-4">
                            <form:input path="purchasePrice" type="number" class="form-control" id="purchasePrice" />
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group">
                        <label for="purchaseDate" class="col-lg-2 control-label">Purchase Date</label>
                        <div class="col-sm-4">
                            <form:input path="purchaseDate" type="date" class="form-control" id="purchaseDate" />
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-lg-10 col-lg-offset-2">
                        <form:button type="reset" value="cancel" class="btn btn-default">Cancel</form:button>
                        <form:button type="submit" value="save" class="btn btn-primary">Save</form:button>
                    </div>
                </div>
            </form:form>
        </div>


    </div>
</div>