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
		"phone":false,
		"cost":false,
		"noOfPeople":false,
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
        error.innerHTML = "Invalid phonenumber. number should be  exact 10 digit  ";
        error.style.color="red"
        fieldsChecks["phone"] = false;

}
    validateAndEnableSubmit();
}

    function costValidation()

        {
            let element = document.getElementById("cost");
            let error = document.getElementById("errorcost");
            console.log(element);
            console.log(element.value);
            console.log(error);

            if(element.value.length >=100000 )

            {
                error.innerHTML = "";
                fieldsChecks["cost"] = true;
            }
            else
            {
                error.innerHTML = "Invalid cost  ";
                error.style.color="red"
                fieldsChecks["cost"] = false;

        }
            validateAndEnableSubmit();
        }

    function noOfPeopleValidation()

        {
            let element = document.getElementById("noOfPeople");
            let error = document.getElementById("noOfPeople");
            console.log(element);
            console.log(element.value);
            console.log(error);

            if(element.value.length >=5 )

            {
                error.innerHTML = "";
                fieldsChecks["noOfPeople"] = true;
            }
            else
            {
                error.innerHTML = "Invalid noOfPeople  ";
                error.style.color="red"
                fieldsChecks["noOfPeople"] = false;

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
                <a class="navbar-brand  text-dark" href="WeddingMakeup.jsp"><b>WeddingMakeup</b></a>

  </div>
</nav>



<%---card---%>


<div class="container mt-5 mb-5 d-flex justify-content-center">
    <div class="card p-4 ">
        <div class="card-body">


            <form action="makeup"  method="post">

                                <h3><b>WeddingMakeup</b></h3>

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
                                               <span id="errorphone" ></span><br>
                                              <label for="phone" class="form-label  "><b>Phone:</b></label>
                                              <input type="text" class="form-control " value="${dto.phone}" id="phone" name="phone" onblur="phoneValidation()">
                                          </div>

<div class="  row mb-3 ">
                                <span id="errorcost" ></span><br>
                                                <label for="cost" class="form-label  "><b>Cost:</b></label>
                                                  <input type="text" class="form-control " value="${dto.cost}" id="cost" name="cost" onblur="costValidation()">
                                         </div>

 <div class="  row mb-3 ">
                                 <span id="errornoOfPeople" ></span><br>
                                                 <label for="noOfPeople" class="form-label  "><b>NoOfPeople:</b></label>
                                                   <input type="text" class="form-control " value="${dto.noOfPeople}" id="noOfPeople" name="noOfPeople" onblur="noOfPeopleValidation()">
                                          </div>

                                       <div class="mb-3">
                                                                                               <span id="erroraddress"></span><br>
                                                                                               <b>Address</b>
                                                                                               <label for="address" class="form-floating"></label>
                                                                                               <textarea class="form-control" placeholder="Leave a comment here"  value="${dto.address}" id="address" style="height: 100px" name="address" onblur="addressValidation()"></textarea>
                                                                                           </div>

                                                                       <div class="  row mb-3 ">


		<input type="Submit"   id="Submit" type="Apply">

</form>


 </div>
    </div>
</div>

</body>
</html>
