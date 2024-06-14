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
		"gender":false,
		"dateOfBirth":false,
		"fatherName":false,
		"motherName":false,
        "placeOfBirth":false,
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

        function fatherNameValidation()

        {
            let element = document.getElementById("fatherName");
            let error = document.getElementById("errorfatherName");
            console.log(element);
            console.log(element.value);
            console.log(error);

            if(element.value.length >3 && element.value.length <40)
            {
                error.innerHTML = "";
                fieldsChecks["fatherName"] = true;
            }
            else
            {
                error.innerHTML = "Invalid fatherName. Characters should be greater 3 and lessthan 40 ";
                error.style.color="red"
                fieldsChecks["fatherName"] = false;

        }
            validateAndEnableSubmit();
        }

        function nameValidation()

        {
            let element = document.getElementById("motherName");
            let error = document.getElementById("errormotherName");
            console.log(element);
            console.log(element.value);
            console.log(error);

            if(element.value.length >3 && element.value.length <50)
            {
                error.innerHTML = "";
                fieldsChecks["motherName"] = true;
            }
            else
            {
                error.innerHTML = "Invalid motherName. Characters should be greater 3 and lessthan 50 ";
                error.style.color="red"
                fieldsChecks["motherName"] = false;

        }
            validateAndEnableSubmit();
        }

        function placeOfBirthValidation()

        {
            let element = document.getElementById("placeOfBirth");
            let error = document.getElementById("errorplaceOfBirth");
            console.log(element);
            console.log(element.value);
            console.log(error);

            if(element.value.length >3 && element.value.length <80)
            {
                error.innerHTML = "";
                fieldsChecks["placeOfBirth"] = true;
            }
            else
            {
                error.innerHTML = "Invalid placeOfBirth. Characters should be greater 3 and lessthan 80 ";
                error.style.color="red"
                fieldsChecks["placeOfBirth"] = false;

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
                <a class="navbar-brand  text-dark" href="BirthCerft.jsp"><b>Birth</b></a>

  </div>
</nav>



<%---card---%>


<div class="container mt-5 mb-5 d-flex justify-content-center">
    <div class="card p-4 ">
        <div class="card-body">


            <form action="go"  method="post">

                                <h3><b>Birth Certificate Form</b></h3>

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


                    <div class="row mb-3">
                        <span id="errordate"></span><br>
                        <label for="dates" class="form-label"><b>Date of birth:</b></label>
                        <input type="date" class="form-control" id="dates" value="${dto.dateOfBirth}" onblur="dateofbirthValidation()" name="dateOfBirth">
                    </div>


          <div class="  row mb-3 ">
                        <span id="errorfatherName" ></span><br>
                                    <label for="fatherName" class="form-label  "><b>FatherName:</b></label>
                                    <input type="text" class="form-control "  value="${dto.fatherName}" id="fatherName" name="fatherName" onblur="fatherNameValidation()">
                                </div>

                      <div class="  row mb-3 ">
                                    <span id="errormotherName" ></span><br>
                                                <label for="motherName" class="form-label  "><b>MotherName:</b></label>
                                                <input type="text" class="form-control "  value="${dto.motherName}" id="motherName" name="motherName" onblur="motherNameValidation()">
                                            </div>

                       <div class="  row mb-3 ">
                                      <span id="errorplaceOfBirth" ></span><br>
                                                  <label for="placeOfBirth" class="form-label  "><b>PlaceOfBirth:</b></label>
                                                  <input type="text" class="form-control "  value="${dto.placeOfBirth}" id="placeOfBirth" name="placeOfBirth" onblur="placeOfBirthValidation()">
                                              </div>


                                       <div class="mb-3">
                                                                                               <span id="erroraddress"></span><br>
                                                                                               <b>Address</b>
                                                                                               <label for="address" class="form-floating"></label>
                                                                                               <textarea class="form-control" placeholder="Leave a comment here"  value="${dto.address}" id="address" style="height: 100px" name="address" onblur="addressValidation()"></textarea>
                                                                                           </div>

                                                                       <div class="  row mb-3 ">



                                      <br><div class="list-group">

                                  <span  id="errorconfirm"></span>
                                        <label  for="confirm" class="list-group-item">
                                              <input name="confirm"  id="confirm"  name="confirm"   onchange="confirmValidation()"  class="form-check-input me-1" type="checkbox"  value="yes"   ${dto.confirm eq 'yes' ? 'checked' : ''}>
                                                    confirm
                                                   </label>
                                             </div>
                                             </br>


		<input type="Submit"   id="Submit" type="Apply">

</form>


 </div>
    </div>
</div>

</body>
</html>
