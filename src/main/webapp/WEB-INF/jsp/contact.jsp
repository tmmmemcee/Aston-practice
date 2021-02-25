<%@include file="includes/header.jsp"%>
<%@include file="includes/navbar.jsp"%>

<c:url value="/static/js/contact.js" var="contact" />
<script src="${contact}"></script>
<script>
    $(document).ready(function() {
        buildTable();
        deleteModal();
    })
</script>

<div class="container">
    <h2>Contact List</h2>
    <button onclick="insertContact()" class="btn btn-default">Add New Contact</button>
    <table class="table table-striped table-hover" id="contact-table">
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Address Name</th>
            <th>Street</th>
            <th>Street 2</th>
            <th>City</th>
            <th>State</th>
            <th>Edit</th>
            <th>Delete</th>

        </tr>

        </thead>
        <tbody>

        </tbody>
    </table>
    <div class="modal" id="contactModal">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">

                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <h5 class="modal-title">Contact Details</h5>
                </div>
                <div class="modal-body">

                    <%--@elvariable id="contactVO" type="contactVO"--%>
                    <form:form modelAttribute="contactVO" cssClass="form-horizontal" action="/api/contact/" method="post">
                        <fieldset>
                            <form:hidden path="contactId"/>
                            <form:hidden path="contactVersion"/>
                            <form:hidden path="addressId"/>
                            <div class="form-group">
                                <label for="contactName">Contact Name</label>
                                <form:input type="text" class="form-control" path="contactName" placeholder="Contact Name" />
                            </div>

                            <div class="form-group">
                                <label for="addressName">Address Name</label>
                                <form:input class="form-control" path="addressName" />
                            </div>

                            <div class="form-group">
                                <label for="street">Street</label>
                                <form:input class="form-control" path="street" />
                            </div>

                            <div class="form-group">
                                <label for="street2">Street 2</label>
                                <form:input class="form-control" path="street2" />
                            </div>
                            <div class="form-group">
                                <label for="city">City</label>
                                <form:input class="form-control" path="city" />
                            </div>
                            <div class="form-group">
                                <label for="state">State</label>
                                <form:input class="form-control" path="state" />
                            </div>

                        </fieldset>
                    </form:form>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" onclick="saveContact()">Save changes</button>
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