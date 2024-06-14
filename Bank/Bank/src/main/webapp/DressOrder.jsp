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
		"address":false,
		"paymentType":false,
        "totalPrice":false,


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

                function paymentTypeValidation() {
                    let paymentTypes = document.getElementsByName("paymentType");
                    let error = document.getElementById("errorrpaymentType");
                    let selected = false;

                    for (let paymentType of paymentTypes) {
                        if (paymentType.checked) {
                            selected = true;
                            break;
                        }
                    }

                    if (selected) {
                        error.innerHTML = "";
                        fieldsChecks["paymentType"] = true;
                    } else {
                        error.innerHTML = "Please select a paymentType";
                        error.style.color = "red";
                        fieldsChecks["paymentType"] = false;
                    }
                    validateAndEnableSubmit();
                }

        function totalPriceValidation()

                                {
                                    let element = document.getElementById("totalPrice");
                                    let error = document.getElementById("errortotalPrice");
                                    console.log(element);
                                    console.log(element.value);
                                    console.log(error);

                                    if(element.value.length >30 && element.value.length <10000 )
                                    {
                                        error.innerHTML = "";
                                        fieldsChecks["totalPrice"] = true;
                                    }
                                    else
                                    {
                                        error.innerHTML = "Invalid totalPrice.the price should be greater than 30 and less than 10000";
                                        error.style.color="red"
                                        fieldsChecks["totalPrice"] = false;

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
                <a class="navbar-brand  text-dark" href="DressOrder.jsp"><b>DressOrder</b></a>

  </div>
</nav>



<%---card---%>


<div class="container mt-5 mb-5 d-flex justify-content-center">
    <div class="card p-4 ">
        <div class="card-body">


            <form action="order"  method="post">

                                <h3><b>Dress Order Form</b></h3>

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
               <input type="text" class="form-control " id="phone" name="phone" onblur="phoneValidation()">
             </div>

          <div>

          <div class="mb-3">
                    <span id="erroraddress"></span><br>
                    <b>Address</b>
                    <label for="address" class="form-floating"></label>
                    <textarea class="form-control" placeholder="Leave a comment here"  value="${dto.address}" id="address" style="height: 100px" name="address" onblur="addressValidation()"></textarea>
                          </div>

                        <div>

                      <span id="errorrpaymentType"></span>
                          </div>
                           <b>PaymentType:</b>
                           <div class="container">
                           <div class="row mb-3">
                          <div class="col-auto">
                          <div class="form-check">
                                  <input class="form-check-input" type="radio" name="paymentType" value="Online" id="flexRadioDefault1" onclick="paymentTypeValidation()"   ${dto.paymentType eq 'online' ? 'checked' : ''}>
                                     <label class="form-check-label" for="flexRadioDefault1">Online</label>
                                     </div>
                                   </div>
                                 <div class="col-auto">
                                  <div class="form-check">
                                 <input class="form-check-input" type="radio" name="paymentType" value="Offline" id="flexRadioDefault2" onclick="paymentTypeValidation()" ${dto.paymentType eq 'offline' ? 'checked' : ''}>
                                <label class="form-check-label" for="flexRadioDefault2">Offline</label>
                                  </div>
                                   </div>

          <div class="  row mb-3 ">
                       <span id="errortotalPrice" ></span><br>
                       <label for="phone" class="form-label  "><b>totalPrice:</b></label>
                       <input type="text" class="form-control "  value="${dto.totalPrice}" id="totalPrice" name="totalPrice" onblur="totalPriceValidation()">
                     </div>
                      </div>
                      </div>


                           <br><div class="list-group">

                                <span  id="errorconfirm"></span>
                                <label  for="confirm" class="list-group-item">
                                <input name="confirm"  id="confirm"  name="confirm" onchange="confirmValidation()"  class="form-check-input me-1" type="checkbox"  value="yes"   ${dto.confirm eq 'yes' ? 'checked' : ''}>
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
