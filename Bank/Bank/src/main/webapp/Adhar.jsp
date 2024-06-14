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
		"dateOfBirth":false,
		"gender":false,
		"phone":false,
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
                fieldsChecks["age"] = false;

        }
            validateAndEnableSubmit();
        }

     //gender
             function genderValidation() {
                 let genders = document.getElementsByName("gender");
                 let error = document.getElementById("errorrgender");
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

           //dateofbirth
                        function dateofbirthValidation() {
                            let element = document.getElementById("dates");
                            let error = document.getElementById("errordate");

                            if (element.value.length != "0") {
                                error.innerHTML = "";
                                fieldsChecks["dates"] = true;
                            } else {
                                error.innerHTML = "Please enter date of birth";
                                error.style.color = "red";
                                fieldsChecks["dates"] = false;
                            }
                            validateAndEnableSubmit();
                        }
function phoneValidation()

{
    let element = document.getElementById("phone");
    let error = document.getElementById("errorphone");
    console.log(element);
    console.log(element.value);
    console.log(error);

    //if(element.value.length ==10 )
    if (/^\d{10}$/.test(element.value))
    {
        error.innerHTML = "";
        fieldsChecks["phone"] = true;
    }
    else
    {
        error.innerHTML = "Invalid phone. number should be  exact 10 digit  ";
        error.style.color="red"
        fieldsChecks["phone"] = false;

}
    validateAndEnableSubmit();
}

      function addressValidation() {
                    let element = document.getElementById("address");
                    let error = document.getElementById("erroraddress");

                    if (element.value.length > 3 && element.value.length < 300) {
                        error.innerHTML = "";
                        fieldsChecks["address"] = true;
                    } else {
                        error.innerHTML = "Characters should be greater than 3 and less than 300";
                        error.style.color = "red";
                        fieldsChecks["address"] = false;
                    }
                    genderValidation()
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
                <a class="navbar-brand  text-dark" href="Adhar.jsp"><b>Adhar</b></a>

  </div>
</nav>



<%---card---%>


<div class="container mt-5 mb-5 d-flex justify-content-center">
    <div class="card p-4 ">
        <div class="card-body">


            <form action="card"  method="post">

                                <h3><b>Adhar Form</b></h3>

                    <div class="text-primary">${name}</div>
                    <span style="color:red;">
                        <c:forEach items="${errors}" var="dtoError">
                        ${dtoError.defaultMessage}<br/>
                        </c:forEach>
                        </span>





        <div class="  row mb-3 ">
                <span id="errorname" ></span><br>
                            <label for="name" class="form-label  "><b>Name:</b></label>
                            <input type="text" class="form-control "  value="${dto.name}" id="name" name="name" onblur="nameValidation()">
                        </div>

         <div class="  row mb-3 ">
                                <span id="errorage" ></span><br>
                                                <label for="age" class="form-label  "><b>Age:</b></label>
                                                  <input type="text" class="form-control " value="${dto.age}" id="age" name="age" onblur="ageValidation()">
                                         </div>


                    <div class="row mb-3">
                        <span id="errordate"></span><br>
                        <label for="dates" class="form-label"><b>Date of birth:</b></label>
                        <input type="date" class="form-control" id="dates" value="${dto.dateOfBirth}" onblur="dateofbirthValidation()" name="dateOfBirth">
                    </div>

          <div>
                      <span id="errorregender"></span>
                          </div>
                           <b>Gender:</b>
                           <div class="container">
                           <div class="row mb-3">
                          <div class="col-auto">
                          <div class="form-check">
                                  <input class="form-check-input" type="radio" name="gender" value="Male" id="flexRadioDefault1" onclick="genderValidation()"   ${dto.gender eq 'male' ? 'checked' : ''}>
                                     <label class="form-check-label" for="flexRadioDefault1">Male</label>
                                     </div>
                                   </div>
                                 <div class="col-auto">
                                  <div class="form-check">
                                 <input class="form-check-input" type="radio" name="gender" value="Female" id="flexRadioDefault2" onclick="genderValidation()" ${dto.gender eq 'female' ? 'checked' : ''}>
                                <label class="form-check-label" for="flexRadioDefault2">Female</label>
                                  </div>
                                   </div>
                                               </div>
                                           </div>

 <div class="  row mb-3 ">
                                            <span id="errorphone" ></span><br>
                                           <label for="phone" class="form-label  "><b>Phone:</b></label>
                                           <input type="text" class="form-control " id="phone" name="phone" onblur="phoneValidation()">
                                       </div>


                                       <div class="mb-3">
                                                  <span id="erroraddress"></span><br>
                                                  <b>Address</b>
                                                  <label for="address" class="form-floating"></label>
                                                  <textarea class="form-control" placeholder="Leave a comment here"  value="${dto.address}" id="address" style="height: 100px" name="address" onblur="addressValidation()"></textarea>
                                                </div></br>




		<input type="Submit"   id="Submit" type="Apply">

</form>


 </div>
    </div>
</div>

</body>
</html>
