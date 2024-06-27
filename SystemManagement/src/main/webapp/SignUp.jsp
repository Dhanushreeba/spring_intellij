<%@ page  isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>System Management </title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">

<script>

let fieldsChecks=
{
		"firstName":false,
		"lastName":false,
		"email":false,
		"contactNumber":false,
		"alternateNumber":false,
		"address":false,


}

function validateAndEnableSubmit()
{
    let flag = false;

    for(let [key, value] of Object.entries(fieldsChecks))
    {

        if(value === false)
        {
            flag = true;
            break;
        }
    }

    if(!flag)
    {
        document.getElementById("submit").removeAttribute("disabled");
    }
    else
    {
        document.getElementById("submit").setAttribute("disabled","");
    }
}

function firstNameValidation()

{
    let element = document.getElementById("firstName");
    let error = document.getElementById("errorfirstName");

    let firstNameRegex = /^[A-Za-z\s]+$/;

    console.log(element);
    console.log(element.value);
    console.log(error);

    if(element.value.length >3 && element.value.length <30 && firstNameRegex.test(element.value))
    {
        error.innerHTML = "";
        fieldsChecks["firstName"] = true;
    }
    else
    {
        error.innerHTML = "Invalid firstName. Characters should be greater 3 and lessthan 30 ";
        error.style.color="red"
        fieldsChecks["firstName"] = false;

}
    validateAndEnableSubmit();
}

function lastNameValidation()

{
    let element = document.getElementById("lastName");
    let error = document.getElementById("errorlastName");

    let lastNameRegex = /^[A-Za-z\s]+$/;

    console.log(element);
    console.log(element.value);
    console.log(error);

    if(element.value.length >=1 && element.value.length <20 && lastNameRegex.test(element.value))
    {
        error.innerHTML = "";
        fieldsChecks["lastName"] = true;
    }
    else
    {
        error.innerHTML = "Invalid lastName. Characters should be greaterthan or equalto 1 and lessthan 20 ";
        error.style.color="red"
        fieldsChecks["lastName"] = false;

}
    validateAndEnableSubmit();
}


function emailValidation()

{
    let element = document.getElementById("email");
    let error = document.getElementById("erroremail");
    console.log(element);
    console.log(element.value);
    console.log(error);


        const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        if (element.value.length > 3 && element.value.length < 30 && emailRegex.test(element.value))
    {
        error.innerHTML = "";
        fieldsChecks["email"] = true;
    }
    else
    {
        error.innerHTML = "Invalid email. Characters should be greater 3 and lessthan 30 ";
        error.style.color="red"
        fieldsChecks["email"] = false;

}
    validateAndEnableSubmit();
}


function contactNumberValidation()

{
    let element = document.getElementById("contactNumber");
    let error = document.getElementById("errorcontactNumber");
    console.log(element);
    console.log(element.value);
    console.log(error);

    //if(element.value.length ==10 )
    if (/^\d{10}$/.test(element.value))
    {
        error.innerHTML = "";
        fieldsChecks["contactNumber"] = true;
    }
    else
    {
        error.innerHTML = "Invalid contactNumber. number should be  exact 10 digit  ";
        error.style.color="red"
        fieldsChecks["contactNumber"] = false;

}
    validateAndEnableSubmit();
}

function alternateNumberValidation()

{
    let element = document.getElementById("alternateNumber");
    let error = document.getElementById("erroralternateNumber");
    console.log(element);
    console.log(element.value);
    console.log(error);

    //if(element.value.length ==10 )
    if (/^\d{10}$/.test(element.value))
    {
        error.innerHTML = "";
        fieldsChecks["alternateNumber"] = true;
    }
    else
    {
        error.innerHTML = "Invalid alternateNumber. alternateNumber should be  exact 10 digit  ";
        error.style.color="red"
        fieldsChecks["alternateNumber"] = false;

}
    validateAndEnableSubmit();
}

function addressValidation() {
                    let element = document.getElementById("address");
                    let error = document.getElementById("erroraddress");

                    if (element.value.length > 5 && element.value.length < 300) {
                        error.innerHTML = "";
                        fieldsChecks["address"] = true;
                    } else {
                        error.innerHTML = "address should be greater than 5 and less than 300";
                        error.style.color = "red";
                        fieldsChecks["address"] = false;
                    }

                    validateAndEnableSubmit();
                }


</script>
</head>
<body>
<nav class="navbar navbar-dark bg-info">
    <div class="container-fluid">
        <div class="navbar-header">


        <a class="navbar-brand  text-dark" href="index.jsp"><b>Home</b></a>
         <a class="navbar-brand  text-dark" href="Login.jsp"><b>LoginPage</b></a>

  </div>
</nav>



<%---card---%>


<div class="container mt-5 mb-5 d-flex justify-content-center">
    <div class="card p-4 ">
        <div class="card-body">


            <form action="signup"  method="post">

                                <h3><b>SignUp page</b></h3>

                    <div class="text-primary">${name}</div>
                    <span style="color:red;">
                        <c:forEach items="${errors}" var="dtoError">
                        ${dtoError.defaultMessage}<br/>
                        </c:forEach>
                        </span>





        <div class="  row mb-3 ">
        <span id="errorfirstName" ></span><br>
                    <label for="firstName" class="form-label  "><b>FirstName:</b></label>
                    <input type="text" class="form-control "  value="${dto.firstName}" id="firstName" name="firstName" onblur="firstNameValidation()">
                </div>

        <div class="  row mb-3 ">
                <span id="errorlastName" ></span><br>
                            <label for="lastName" class="form-label  "><b>LastName:</b></label>
                            <input type="text" class="form-control "  value="${dto.lastName}" id="lastName" name="lastName" onblur="lastNameValidation()">
                        </div>


                <div class="  row mb-3 ">
                        <span id="erroremail" ></span><br>
                                    <label for="email" class="form-label  "><b>Email:</b></label>
                                    <input type="email" class="form-control "  value="${dto.email}" id="email" name="email" onblur="emailValidation()">
                                </div>

              <div class="  row mb-3 ">
                                     <span id="errorcontactNumber" ></span><br>
                                                 <label for="contactNumber" class="form-label  "><b>ContactNumber:</b></label>
                                                 <input type="text" class="form-control " value="${dto.contactNumber}" id="contactNumber" name="contactNumber" onblur="contactNumberValidation()">
                                             </div>

              <div class="  row mb-3 ">
                                                   <span id="erroralternateNumber" ></span><br>
                                                               <label for="alternateNumber" class="form-label  "><b>AlternateNumber:</b></label>
                                                               <input type="text" class="form-control " value="${dto.alternateNumber}" id="alternateNumber" name="alternateNumber" onblur="alternateNumberValidation()">
                                                           </div>

              <div class="mb-3">
                                            <span id="erroraddress"></span><br>
                                            <b>Address</b>
                                            <label for="address" class="form-floating"></label>
                                            <textarea class="form-control" placeholder="Leave a Adrress here"  value="${dto.address}" id="address" style="height: 100px" name="address" onblur="addressValidation()"></textarea>
                                            </div>

                                      <br><div class="list-group">


                                  <span  id="erroragree"></span>
                                        <label  for="agree" class="list-group-item">
                                              <input name="agree"  id="agree"  name="agree"   onchange="agreeValidation()"  class="form-check-input me-1" type="checkbox"  value="yes"   ${dto.agree eq 'yes' ? 'checked' : ''}>
                                                    Agree
                                                   </label>
                                             </div></br>



		<input class="btn btn-info" type="submit" value="SignUp">


</form>


 </div>
    </div>
</div>

</body>
</html>
