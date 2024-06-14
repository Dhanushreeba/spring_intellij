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
		"participantName":false,
		"age":false,
		"phone":false,
		"fatherName":false,
		"participationLevel":false,

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

function participantNameValidation()

{
    let element = document.getElementById("participantName");
    let error = document.getElementById("errorparticipantName");
    console.log(element);
    console.log(element.value);
    console.log(error);

    if(element.value.length >3 && element.value.length <30)
    {
        error.innerHTML = "";
        fieldsChecks["participantName"] = true;
    }
    else
    {
        error.innerHTML = "Invalid participantName. Characters should be greater 3 and lessthan 30 ";
        error.style.color="red"
        fieldsChecks["participantName"] = false;

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

        function fatherNameValidation()

        {
            let element = document.getElementById("fatherName");
            let error = document.getElementById("errorfatherName");
            console.log(element);
            console.log(element.value);
            console.log(error);

            if(element.value.length >3 && element.value.length <30)
            {
                error.innerHTML = "";
                fieldsChecks["fatherName"] = true;
            }
            else
            {
                error.innerHTML = "Invalid fatherName. Characters should be greater 3 and lessthan 30 ";
                error.style.color="red"
                fieldsChecks["fatherName"] = false;

        }
            validateAndEnableSubmit();
        }

        function participationLevelValidation()

        {
            let element = document.getElementById("participationLevel");
            let error = document.getElementById("errorparticipationLevel");
            console.log(element);
            console.log(element.value);
            console.log(error);

            if(element.value.length >3 && element.value.length <30)
            {
                error.innerHTML = "";
                fieldsChecks["participationLevel"] = true;
            }
            else
            {
                error.innerHTML = "Invalid participationLevel;
                error.style.color="red"
                fieldsChecks["participationLevel"] = false;

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
                <a class="navbar-brand  text-dark" href="ThrowBall.jsp"><b>ThrowBall</b></a>

  </div>
</nav>



<%---card---%>


<div class="container mt-5 mb-5 d-flex justify-content-center">
    <div class="card p-4 ">
        <div class="card-body">


            <form action="throw"  method="post">

                                <h3><b>ThrowBall Registration Form</b></h3>

                    <div class="text-primary">${name}</div>
                    <span style="color:red;">
                        <c:forEach items="${errors}" var="dtoError">
                        ${dtoError.defaultMessage}<br/>
                        </c:forEach>
                        </span>


        <div class="  row mb-3 ">
        <span id="errorparticipantName" ></span><br>
                    <label for="participantName" class="form-label  "><b>ParticipantName:</b></label>
                    <input type="text" class="form-control "  value="${dto.participantName}" id="participantName" name="participantName" onblur="participantNameValidation()">
                </div>

               <div class="  row mb-3 ">
                       <span id="errorage" ></span><br>
                                       <label for="age" class="form-label  "><b>Age:</b></label>
                                         <input type="text" class="form-control " value="${dto.age}" id="age" name="age" onblur="ageValidation()">
                                </div>

                                 <div class="  row mb-3 ">
                                            <span id="errorphone" ></span><br>
                                           <label for="phone" class="form-label  "><b>Phone:</b></label>
                                           <input type="text" class="form-control " id="phone" name="phone" onblur="phoneValidation()">
                                       </div>

                                 <div class="list-group">

               <div class="  row mb-3 ">
                       <span id="errorfatherName" ></span><br>
                                   <label for="fatherName" class="form-label  "><b>FatherName:</b></label>
                                   <input type="text" class="form-control "  value="${dto.fatherName}" id="fatherName" name="fatherName" onblur="fatherNameValidation()">
                               </div>

       <div class="row mb-3">
                               <span id="participationLevelerror"></span>
                               <label for="participationLevel" class="form-label"><b>participationLevel Of Participant:</b></label>
                               <select class="form-select custom-select-width" id="participationLevel" onblur="participationLevelValidation()" name="participationLevel" aria-label="Select participationLevel">
                                   <option selected value="">select</option>
                                   <option value="College Level">College Level</option>
                                   <option value="District Level">District Level</option>
                                   <option value="State Level">State Level</option>
                                   <option value="National Level">National Level</option>
                               </select>
                           </div></br>



		<input type="submit"   id="submit" type="Apply">

</form>


 </div>
    </div>
</div>

</body>
</html>
