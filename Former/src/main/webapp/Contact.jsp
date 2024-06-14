<%@ page  isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Matrimony Contact Form</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">

<script>

let fieldsChecks=
{
		"name":false,
		"email":false,
		"mobile":false,
		 "comment":false
}
//id.. same as form..id
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

//name.................
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

//email.............
function emailValidation()

{
    let element = document.getElementById("email");
    let error = document.getElementById("erroremail");
    console.log(element);
    console.log(element.value);
    console.log(error);

// Regular expression for validating email
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


//mobile.............
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


//comments.............
function commentsValidation()

{
    let element = document.getElementById("comment");
    let error = document.getElementById("errorcomments");
    console.log(element);
    console.log(element.value);
    console.log(error);


        if(element.value.length >3 && element.value.length <300)
        {
        error.innerHTML = "";
        fieldsChecks["comment"] = true;
    }
    else
    {
        error.innerHTML = "Invalid comments. Characters should be greater 3 and lessthan 300 ";
        error.style.color="red"
        fieldsChecks["comment"] = false;

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
                <a class="navbar-brand  text-dark" href="MatrimonyRegisterForm.jsp"><b>MatrimonyForm</b></a>


  </div>
</nav>


        </div>
    </div>
</nav>

<%---card---%>


<div class="container mt-5 mb-5 d-flex justify-content-center">
    <div class="card p-4 ">
        <div class="card-body">


            <form action="contact"   method="post">

                                <h3><b>Contact Registration Form</b></h3>

                    <div class="text-primary">${name}</div>





        <div class="  row mb-3 ">
        <span id="errorname" ></span><br>
                    <label for="name" class="form-label  "><b>Name:</b></label>
                    <input type="text" class="form-control " id="name" name="name" onblur="nameValidation()">
                </div>

                <div class="  row mb-3 ">
                        <span id="erroremail" ></span><br>
                                    <label for="email" class="form-label  "><b>Email:</b></label>
                                    <input type="email" class="form-control " id="email" name="email" onblur="emailValidation()">
                                </div>

              <div class="  row mb-3 ">
                                     <span id="errormobile" ></span><br>
                                                 <label for="mobile" class="form-label  "><b>Mobile:</b></label>
                                                 <input type="text" class="form-control " id="mobile" name="mobile" onblur="mobileValidation()">
                                             </div>




<div >
                  <span id="errorcomments"></span><br> <b> Comments</b> <label
                   for="comment" class="form-floating"></label>
                   <textarea class="form-control" placeholder="Leave a comment here" id="comment" style="height: 100px" name="comments" onblur="commentsValidation()"></textarea>
                 </div>
                 </br>






		<input type="submit"   id="submit" type="Apply" disabled >

</form>


 </div>
    </div>
</div>

</body>
</html>