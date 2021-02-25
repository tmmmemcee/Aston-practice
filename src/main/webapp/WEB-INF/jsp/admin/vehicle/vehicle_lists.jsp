<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/navbar.jsp"%>
<%@include file="../../includes/subnav_admin.jsp"%>

<div class="wrapper">

    <%@include file="vehicle_sidebar.jsp"%>

    <div id="main-wrapper" class="col-sm-10">
        <div class="col-sm-12">
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Make</th>
                    <th>Model</th>
                    <th>Year</th>
                    <th>License Plate</th>
                    <th>VIN</th>
                    <th>Color</th>
                    <th>Purchased</th>
                    <th>Purchase Price</th>
                    <th>Purchase Date</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="vehicle" items="${vehicleList}">
                    <tr>
                        <td>${vehicle.id}</td>
                        <td>${vehicle.vehicleModel.vehicleMake.vehicleMakeName}</td>
                        <td>${vehicle.vehicleModel.vehicleModelName}</td>
                        <td>${vehicle.vehicleYear}</td>
                        <td>${vehicle.licensePlate}</td>
                        <td>${vehicle.VIN}</td>
                        <td>${vehicle.color}</td>
                        <td>${vehicle.purchased}</td>
                        <td>${vehicle.purchasePrice}</td>
                        <td>${vehicle.purchaseDate}</td>
                        <td><a href="/admin/vehicle/edit/${vehicle.id}">Edit</a> </td>
                        <td><a href="/admin/vehicle/delete/${vehicle.id}">Delete </a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<%@include file="../../includes/footer.jsp"%>