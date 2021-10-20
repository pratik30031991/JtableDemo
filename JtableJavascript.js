

function reset_feedback_form(){
    $("#userInput").find("input[type='text']").val("");
    alert("Inside reset form method");
}

function showEmployeeList(){
    $('#JtableDisplay').removeClass('d-none');
    $('#JtableDisplay').addClass('d-block');
    

    $.ajax({
        url: 'http://localhost:8070/getAllEmployees',
        method: 'GET',
        dataType: 'json',
        success: function(data) {
            $('#jtable').DataTable({
                data: data,
                columns: [{
                        data: 'empId'
                    },
                    {
                        data: 'empName'
                    },
                    {
                        data: 'empDept'
                    },
                    {
                        data: 'empEmail'
                    },
                   
                ]

            });
        }          
    });
}

  
function saveDetailsMethod(){
   alert("inside savedetailsmethod ");

   var inputId = document.getElementById("empId").value;
    var inputName = document.getElementById("name").value;
   
    var inputEmail = document.getElementById("email").value;
    var inputDepartment = document.getElementById("department").value;
   
    
    let empData ={
                'empId': inputId,
                'empName':inputName,
                'empEmail': inputEmail,
                'empDept': inputDepartment
                };
console.log(empData);
       
    if(inputName != '' && inputEmail !=''){
         alert("inside ajax method");
        $.ajax({
            
            url: "http://localhost:8070/saveEmployee",
            type: "POST",
            contentType: "application/json",
            data:  JSON.stringify(empData),
            success: function(response){ console.log(response);
            if(response=='success'){
                  //  alert("inside ajax success");
                  console.log(response);
                    reset_feedback_form();
                    $('#alert-success-register').removeClass('d-none');
                    $('#alert-success-register').addClass('d-block');
                    setTimeout(function() {
                    $('#alert-success-register').removeClass('d-block');
                    $('#alert-success-register').addClass('d-none');
                    }, 4000);
                } else{
                    alert("inside ajax failed");
                    reset_feedback_form();
                    $('#alert-error-register').removeClass('d-none');
                    $('#alert-error-register').addClass('d-block');
                    setTimeout(function() {
                    $('#alert-error-register').removeClass('d-block');
                    $('#alert-error-register').addClass('d-none');
                    }, 4000);
                }
            },
          
        });
    
    }
   
} //here main function ends




