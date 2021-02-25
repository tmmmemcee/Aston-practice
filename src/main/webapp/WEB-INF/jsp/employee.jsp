<%@include file="includes/header.jsp"%>
<%@include file="includes/navbar.jsp"%>

<c:url value="/static/js/employee.js" var="employee" />
<script src="${employee}"></script>
<script>
    $(document).ready(function() {
        buildTable();
        deleteModal();
    })
</script>

<div class="container">
    <h2>Employee List</h2>
    <button onclick="insertEmployee()" class="btn btn-default">Add New Employee</button>
    <table class="table table-striped table-hover" id="employee-table">
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Background</th>
            <th>Projects</th>
            <th>Edit</th>
            <th>Delete</th>

        </tr>

        </thead>
        <tbody>

        </tbody>
    </table>
    <div class="modal" id="employeeModal">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">

                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <h5 class="modal-title">Employee Details</h5>
                </div>
                <div class="modal-body">

                    <form>
                        <fieldset>
                            <hidden id="employeeId" />
                            <hidden id="employeeVersion" />
                            <div class="form-group">
                                <label for="inputFirstName">First Name</label>
                                <input type="text" class="form-control" id="inputFirstName" placeholder="First Name">

                            </div>
                            <div class="form-group">
                                <label for="inputLastName">Last Name</label>
                                <input type="text" class="form-control" id="inputLastName" placeholder="Last Name">

                            </div>

                            <div class="form-group">
                                <label for="background">Background</label>
                                <textarea class="form-control" id="background" rows="3"></textarea>
                            </div>


                        </fieldset>
                    </form>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" onclick="saveEmployee()">Save changes</button>
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>
    <div class="modal" id="confirmDeleteModal">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">

                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <h5 class="modal-title">Confirm Delete</h5>
                </div>
                <div class="modal-body">
                    <p>Are you sure you want to delete?</p>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-danger btn-ok" data-dismiss="modal" id="confirmDelete">Delete</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                </div>
            </div>
        </div>
    </div>

</div>