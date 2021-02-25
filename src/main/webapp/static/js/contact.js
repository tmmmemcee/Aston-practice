function buildTable() {
    $.getJSON('api/contact/',{
        ajax: true
    }, function(data) {
        $.each(data, function(index, single){

            console.log(single);
            $('#contact-table').find('tbody')
                .append("<tr>"+
                    "<td>" +single.id +"</td>" +
                    "<td>" +single.contactName+"</td>" +
                    "<td>" +single.address.addressName+"</td>" +
                    "<td>" +single.address.street+"</td>" +
                    "<td>" +single.address.street2+"</td>" +
                    "<td>" +single.address.city+"</td>" +
                    "<td>" +single.address.state+"</td>" +
                    "<td>" +"<button onclick='editContact("+single.id+")'>Edit</button>"+"</td>" +
                    "<td>" +"<button data-toggle='modal' data-target='#confirmDeleteModal' data-record-id='"+single.id+"' >Delete</button>"+"</td>"+
                    "</tr>");
        });
    });
}
function insertContact() {
    $('#contactId').val("");
    $('#contactVersion').val("");
    $('#inputName').val("");
    $('#address').val("");


    $('#contactModal').modal('show');

}
function saveContact() {
    var contactVO = {
        contactId : $('#contactId').val(),
        contactVersion : $('#contactVersion').val(),
        addressId : $('#addressId').val(),
        contactName : $('#contactName').val(),
        addressName : $('#addressName').val(),
        street : $('#street').val(),
        street2 : $('#street2').val(),
        city : $('#city').val(),
        state : $('#state').val()

    }
    $.ajax({
        type:   "post",
        data:   contactVO,
        url:    "/api/contact/",
        async:  true,
        dataType:   "json",
        success:    function() {
            window.location.reload();
        }
    })
}
function editContact(id) {
    $.getJSON('/api/contact/'+ id, {
        ajax: 'true'
    }, function(contact) {
        console.log(contact);
        $('#contactId').val(contact.id);
        $('#contactVersion').val(contact.version);
        $('#addressId').val(contact.address.id);
        $('#contactName').val(contact.contactName);
        $('#addressName').val(contact.address.addressName);
        $('#street').val(contact.address.street);
        $('#street2').val(contact.address.street2);
        $('#city').val(contact.address.city);
        $('#state').val(contact.address.state);
        $('#contactModal').modal('show');
    })

}



function deleteModal() {
    $('#confirmDeleteModal').on('click', '.btn-ok', function(e) {
        var $modaldiv = $(e.delegateTarget);
        var id = $(this).data('recordId');
        $.ajax({
            type: "delete",
            url: "/api/contact/"+id,
            async: true,
            dataType: "json",
            success : function() {
                window.location.reload();
            },
            error: function() {
                alert("Error Deleting Contact");
            }
        })
    });
    $('#confirmDeleteModal').on('show.bs.modal', function(e) {
        var data  = $(e.relatedTarget).data();
        $('.btn-ok', this).data('recordId', data.recordId);
    });
}
