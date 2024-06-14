<%@ page  isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Food </title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">

<script>

let fieldsChecks=
{
		"name":false,
		"foodType":false,
		"orderSelection":false,
		"address":false,
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

    let nameRegex = /^[A-Za-z\s]+$/;

    console.log(element);
    console.log(element.value);
    console.log(error);

    if(element.value.length >3 && element.value.length <30 && nameRegex.test(element.value))
    {
        error.innerHTML = "";
        fieldsChecks["name"] = true;
    }
    else
    {
        error.innerHTML = "Invalid name.Name should be min 3 character max 30 character";
        error.style.color="red"
        fieldsChecks["name"] = false;

}

    validateAndEnableSubmit();
}

  function foodTypeValidation() {
            let foodTypeElements = document.getElementsByName("foodType");
            let error = document.getElementById("errorfoodType");
            let foodTypeSelected = false;

            for (let i = 0; i < foodTypeElements.length; i++) {
                if (foodTypeElements[i].checked) {
                    foodTypeSelected = true;
                    break;
                }
            }

            if (foodTypeSelected) {
                error.innerHTML = "";
                fieldsChecks["foodType"] = true;
            } else {
                error.innerHTML = "Please select a foodType.";
                error.style.color = "red";
                fieldsChecks["foodType"] = false;
            }

            validateAndEnableSubmit();
        }


function orderSelectionValidation() {
            let element = document.getElementById("orderSelection");
            let error = document.getElementById("orderSelectionerror");

            if (element.value.length != "0") {
                error.innerHTML = "";
                fieldsChecks["orderSelection"] = true;
            } else {
                error.innerHTML = "Please select order";
                error.style.color = "red";
                fieldsChecks["orderSelection"] = false;
            }
            foodTypeValidation();
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

                    orderSelectionValidation();
                    validateAndEnableSubmit();
                }

function totalPriceValidation()

                                {
                                    let element = document.getElementById("totalPrice");
                                    let error = document.getElementById("errortotalPrice");
                                    console.log(element);
                                    console.log(element.value);
                                    console.log(error);

                                    if(element.value >30 && element.value < 10000 )
                                    {
                                        error.innerHTML = "";
                                        fieldsChecks["totalPrice"] = true;
                                    }
                                    else
                                    {
                                        error.innerHTML = "Invalid totalPrice.the price should be greater than 30 rupees and less than to 10000 rupees";
                                        error.style.color="red"
                                        fieldsChecks["totalPrice"] = false;

                                }
                                    validateAndEnableSubmit();
                                }

</script>
</head>
<body>
<nav class="navbar navbar-dark bg-primary">
    <div class="container-fluid">
        <div class="navbar-header">

    <!-- Add your logo here -->
                            <a class="navbar-brand" href="#">
                                <img src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png" alt="xworkz" width="140" height="70" >
                            </a>
                            <!-- End of logo -->

        <a class="navbar-brand  text-dark" href="index.jsp"><b>Home</b></a>
                <a class="navbar-brand  text-dark" href="Food.jsp"><b>FoodOrder</b></a>

  </div>
</nav>



<%---card---%>


<div class="container mt-5 mb-5 d-flex justify-content-center">
    <div class="card p-4 ">
        <div class="card-body">


            <form action="order"  method="post">

                                <h3><b>Food Order Form</b></h3>

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
                             <span id="errorfoodType"></span>
                                 </div>
                                  <b>FoodType:</b>
                                  <div class="container">
                                  <div class="row mb-3">
                                 <div class="col-auto">
                                 <div class="form-check">
                                         <input class="form-check-input" type="radio" name="foodType" value="Vegitarian" id="flexRadioDefault1" onclick="foodTypeValidation()"   ${dto.foodType eq 'Vegitarian' ? 'checked' : ''}>
                                            <label class="form-check-label" for="flexRadioDefault1">Vegitarian</label>
                                            </div>
                                          </div>
                                        <div class="col-auto">
                                         <div class="form-check">
                                        <input class="form-check-input" type="radio" name="foodType" value="Non Vegitarian" id="flexRadioDefault2" onclick="foodTypeValidation()" ${dto.foodType eq 'Non Vegitarian' ? 'checked' : ''}>
                                       <label class="form-check-label" for="flexRadioDefault2">Non Vegitarian</label>
                                         </div>
                                          </div>
                                       <div class="col-auto">
                                       <div class="form-check">
                                       <input class="form-check-input" type="radio" name="foodType" value="Eggitarian" id="flexRadioDefault3" onclick="foodTypeValidation()" ${dto.foodType eq 'Eggitarian' ? 'checked' : ''}>
                                           <label class="form-check-label" for="flexRadioDefault3">Eggitarian</label>
                                                          </div>
                                                          </div>

                                                      </div>
                                                  </div>


                <div class="row mb-3">
                                               <span id="orderSelectionerror"></span>
                                               <label for="orderSelection" class="form-label"><b>Order Selection:</b></label>
                                               <select class="form-select custom-select-width" value="${dto.orderSelection}" id="orderSelection" onblur="orderSelectionValidation()" name="orderSelection" aria-label="Select order">
                                                   <option selected value="">select</option>
                                                   <option value="GheeRice">GheeRice</option>
                                                   <option value="Biriyani">Biriyani</option>
                                                   <option value="Egg Rice">Egg Rice</option>
                                                   <option value="Veg Panner Roll">Veg Panner Roll</option>
                                                   <option value="BabyCorn Manchurian">BabyCorn Manchurian</option>
                                                   <option value="Lime Juice">Lime Juice</option>
                                               </select>
                                           </div>

              <div class="mb-3">
                              <span id="erroraddress"></span><br>
                              <b>Address</b>
                              <label for="address" class="form-floating"></label>
                              <textarea class="form-control" placeholder="Leave a Adrress here"  value="${dto.address}" id="address" style="height: 100px" name="address" onblur="addressValidation()"></textarea>
                              </div>

               <div class="  row mb-3 ">
                                      <span id="errortotalPrice" ></span><br>
                                      <label for="totalPrice" class="form-label  "><b>totalPrice:</b></label>
                                      <input type="text" class="form-control "  value="${dto.totalPrice}" id="totalPrice" name="totalPrice" onblur="totalPriceValidation()">
                                    </div>

                                      <br><div class="list-group">

                                  <span  id="errordone"></span>
                                        <label  for="done" class="list-group-item">
                                              <input name="done"  id="done"  name="accept"   onchange="doneValidation()"  class="form-check-input me-1" type="checkbox"  value="yes"   ${dto.done eq 'yes' ? 'checked' : ''}>
                                                    Done
                                                   </label>
                                             </div></br>



		<input class="btn btn-primary" type="submit" value="Submit">
        <input class="btn btn-primary" type="reset" value="clear">

</form>


 </div>
    </div>
</div>

</body>
</html>
