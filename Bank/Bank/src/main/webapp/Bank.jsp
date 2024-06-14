<%@ page  isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Bank </title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">

<script>

let fieldsChecks=
{
		"name":false,
		"age":false,
		"email":false,
		"mobile":false,

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
        document.getElementById("submit").removeAttribute("disabled");//valuse empty idre disabled
    }
    else
    {
        document.getElementById("submit").setAttribute("disabled","");//valuse iddaga enable agirutte
    }
}

function nameValidation()

{
    let element = document.getElementById("name");
    let error = document.getElementById("errorname");
    console.log(element);
    console.log(element.value);
    console.log(error);

    if(element.value.length >3 && element.value.length <30)
    {
        error.innerHTML = "";
        fieldsChecks["name"] = true;
    }
    else
    {
        error.innerHTML = "Invalid name. Characters should be greater 3 and lessthan 30 ";
        error.style.color="red"
        fieldsChecks["name"] = false;

}
    validateAndEnableSubmit();
}

function ageValidation()

{
    let element = document.getElementById("age");
    let error = document.getElementById("errorage");
    console.log(element);
    console.log(element.value);
    console.log(error);

    //if(element.value.length <=2 )
    if (/^\d{2}$/.test(element.value))
    {
        error.innerHTML = "";
        fieldsChecks["age"] = true;
    }
    else
    {
        error.innerHTML = "Invalid age  ";
        error.style.color="red"
        fieldsChecks["mobile"] = false;

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


function mobileValidation()

{
    let element = document.getElementById("mobile");
    let error = document.getElementById("errormobile");
    console.log(element);
    console.log(element.value);
    console.log(error);

    //if(element.value.length ==10 )
    if (/^\d{10}$/.test(element.value))
    {
        error.innerHTML = "";
        fieldsChecks["mobile"] = true;
    }
    else
    {
        error.innerHTML = "Invalid mobilenumber. number should be  exact 10 digit  ";
        error.style.color="red"
        fieldsChecks["mobile"] = false;

}
    validateAndEnableSubmit();
}

//gender
        function genderValidation() {
            let genders = document.getElementsByName("gender");
            let error = document.getElementById("errorregender");
            let selected = false;

            for (let gender of genders) {
                if (gender.checked) {
                    selected = true;
                    break;
                }
            }

            if (selected) {
                error.innerHTML = "";
                fieldsChecks["gender"] = true;
            } else {
                error.innerHTML = "Please select a gender";
                error.style.color = "red";
                fieldsChecks["gender"] = false;
            }
            validateAndEnableSubmit();
        }

</script>
</head>
<body>
<nav class="navbar navbar-dark bg-info">
    <div class="container-fluid">
        <div class="navbar-header">

    <!-- Add your logo here -->
                            <a class="navbar-brand" href="#">
                                <img src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png" alt="xworkz" width="140" height="70" >
                            </a>
                            <!-- End of logo -->

        <a class="navbar-brand  text-dark" href="index.jsp"><b>Home</b></a>
                <a class="navbar-brand  text-dark" href="Bank.jsp"><b>BankForm</b></a>

  </div>
</nav>



<%---card---%>


<div class="container mt-5 mb-5 d-flex justify-content-center">
    <div class="card p-4 ">
        <div class="card-body">


            <form action="open"  method="post">

                                <h3><b>Contact Registration Form</b></h3>

                    <div class="text-primary">${name}</div>
                    <span style="color:red;">
                        <c:forEach items="${errors}" var="dtoError">
                        ${dtoError.defaultMessage}<br/>
                        </c:forEach>
                        </span>





        <div class="  row mb-3 ">
        <span id="errorname" ></span><br>
                    <label for="name" class="form-label  "><b>Name:</b></label>
                    <input type="text" class="form-control "  value="${bankDto.name}" id="name" name="name" onblur="nameValidation()">
                </div>

        <div class="  row mb-3 ">
        <span id="errorage" ></span><br>
                        <label for="age" class="form-label  "><b>Age:</b></label>
                          <input type="text" class="form-control " value="${bankdto.age}" id="age" name="age" onblur="ageValidation()">
                 </div>

                <div class="  row mb-3 ">
                        <span id="erroremail" ></span><br>
                                    <label for="email" class="form-label  "><b>Email:</b></label>
                                    <input type="email" class="form-control "  value="${bankDto.email}" id="email" name="email" onblur="emailValidation()">
                                </div>

              <div class="  row mb-3 ">
                                     <span id="errormobile" ></span><br>
                                                 <label for="mobile" class="form-label  "><b>Mobile:</b></label>
                                                 <input type="text" class="form-control " id="mobile" name="mobile" onblur="mobileValidation()">
                                             </div>

               <div>
              <span id="errorregender"></span>
                  </div>
                   <b>Gender:</b>
                   <div class="container">
                   <div class="row mb-3">
                  <div class="col-auto">
                  <div class="form-check">
                          <input class="form-check-input" type="radio" name="gender" value="Male" id="flexRadioDefault1" onclick="genderValidation()"   ${bankDto.gender eq 'male' ? 'checked' : ''}>
                             <label class="form-check-label" for="flexRadioDefault1">Male</label>
                             </div>
                           </div>
                         <div class="col-auto">
                          <div class="form-check">
                         <input class="form-check-input" type="radio" name="gender" value="Female" id="flexRadioDefault2" onclick="genderValidation()" ${bankDto.gender eq 'female' ? 'checked' : ''}>
                        <label class="form-check-label" for="flexRadioDefault2">Female</label>
                          </div>
                           </div>
                        <div class="col-auto">
                        <div class="form-check">
                        <input class="form-check-input" type="radio" name="gender" value="Others" id="flexRadioDefault3" onclick="genderValidation()" ${bankDto.gender eq 'others' ? 'checked' : ''}>
                            <label class="form-check-label" for="flexRadioDefault3">Others</label>
                                           </div>
                                           </div>
                                       </div>
                                   </div>

                                      <br><div class="list-group">

                                  <span  id="erroraccepted"></span>
                                        <label  for="acpt" class="list-group-item">
                                              <input name="accept"  id="acpt"  name="accept"   onchange="acceptValidation()"  class="form-check-input me-1" type="checkbox"  value="yes"   ${bankDto.accept eq 'yes' ? 'checked' : ''}>
                                                    Accept
                                                   </label>
                                             </div>


gender
		<input type="submit"   id="submit" type="Apply">

</form>


 </div>
    </div>
</div>

</body>
</html>
