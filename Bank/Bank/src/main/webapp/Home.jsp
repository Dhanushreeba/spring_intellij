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
		"fullName":false,
		"kindOfProperty":false,
		"floorLevel":false,
		"noOfBedrooms":false,
		"address":false,
		"phone":false,

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

function fullNameValidation()

{
    let element = document.getElementById("fullName");
    let error = document.getElementById("errorfullName");
    console.log(element);
    console.log(element.value);
    console.log(error);

    if(element.value.length >3 && element.value.length <30)
    {
        error.innerHTML = "";
        fieldsChecks["fullName"] = true;
    }
    else
    {
        error.innerHTML = "Invalid name. Characters should be greater 3 and lessthan 30 ";
        error.style.color="red"
        fieldsChecks["fullName"] = false;

}
    validateAndEnableSubmit();
}

function kindOfPropertyValidation()

{
    let element = document.getElementById("kindOfProperty");
    let error = document.getElementById("errorkindOfProperty");
    console.log(element);
    console.log(element.value);
    console.log(error);

    if(element.value.length >3 && element.value.length <30)
    {
        error.innerHTML = "";
        fieldsChecks["kindOfProperty"] = true;
    }
    else
    {
        error.innerHTML = "Invalid Field. Characters should be greater 3 and lessthan 50 ";
        error.style.color="red"
        fieldsChecks["kindOfProperty"] = false;

}
    validateAndEnableSubmit();
}


function floorLevelValidation()

{
    let element = document.getElementById("floorLevel");
    let error = document.getElementById("errorfloorLevel");
    console.log(element);
    console.log(element.value);
    console.log(error);

    if(element.value.length >3 && element.value.length <30)
    {
        error.innerHTML = "";
        fieldsChecks["floorLevel"] = true;
    }
    else
    {
        error.innerHTML = "Invalid name;
        error.style.color="red"
        fieldsChecks["floorLevel"] = false;

}
    validateAndEnableSubmit();
}

        function noOfBedroomsValidation() {
            let noOfBedrooms = document.getElementsByName("noOfBedrooms");
            let error = document.getElementById("errorrnoOfBedrooms");
            let selected = false;

            for (let noOfBedrooms of noOfBedrooms) {
                if (noOfBedrooms.checked) {
                    selected = true;
                    break;
                }
            }

            if (selected) {
                error.innerHTML = "";
                fieldsChecks["noOfBedrooms"] = true;
            } else {
                error.innerHTML = "Please select a noOfBedrooms";
                error.style.color = "red";
                fieldsChecks["noOfBedrooms"] = false;
            }
            validateAndEnableSubmit();
        }

        function addressValidation() {
                    let element = document.getElementById("address");
                    let error = document.getElementById("erroraddress");

                    if (element.value.length > 3 && element.value.length < 30) {
                        error.innerHTML = "";
                        fieldsChecks["address"] = true;
                    } else {
                        error.innerHTML = "Characters should be greater than 3 and less than 30.";
                        error.style.color = "red";
                        fieldsChecks["address"] = false;
                    }
                    genderValidation()
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
                <a class="navbar-brand  text-dark" href="Home.jsp"><b>HomeForm</b></a>

  </div>
</nav>



<%---card---%>


<div class="container mt-5 mb-5 d-flex justify-content-center">
    <div class="card p-4 ">
        <div class="card-body">


            <form action="walk"  method="post">

                                <h3><b>Home Registration Form</b></h3>

                    <div class="text-primary">${name}</div>
                    <span style="color:red;">
                        <c:forEach items="${errors}" var="dtoError">
                        ${dtoError.defaultMessage}<br/>
                        </c:forEach>
                        </span>


        <div class="  row mb-3 ">
        <span id="errorfullName" ></span><br>
                    <label for="name" class="form-label  "><b>FullName:</b></label>
                    <input type="text" class="form-control "  value="${dto.fullName}" id="fullName" name="fullName" onblur="fullNameValidation()">
                </div>

                <div class="  row mb-3 ">
                        <span id="errorkindOfProperty" ></span><br>
                                    <label for="name" class="form-label  "><b>KindOfProperty Buying:</b></label>
                                    <input type="text" class="form-control "  value="${dto.kindOfProperty}" id="kindOfProperty" name="kindOfProperty" onblur="kindOfPropertyValidation()">
                                </div>

       <div class="row mb-3">
                               <span id="floorLevelerror"></span>
                               <label for="floorLevel" class="form-label"><b>FloorLevel Of House:</b></label>
                               <select class="form-select custom-select-width" id="floorLevel" onblur="floorLevelValidation()" name="floorLevel" aria-label="Select floorLevel">
                                   <option selected value="">select</option>
                                   <option value="Any Floor">Any Floor</option>
                                   <option value="Ground Floor">Ground Floor</option>
                                   <option value="First Floor">First Floor</option>
                                   <option value="Second Floor Or Above">Second Floor Or Above</option>
                               </select>
                           </div>

                    <div>
                     <span id="errorrnoOfBedrooms"></span>
                         </div>
                          <b>NoOfBedrooms:</b>
                          <div class="container">
                          <div class="row mb-3">
                         <div class="col-auto">
                         <div class="form-check">
                                 <input class="form-check-input" type="radio" name="noOfBedrooms" value="1 BedRoom" id="flexRadioDefault1" onclick="noOfBedroomsValidation()"   ${dto.noOfBedrooms eq '1 bedRooms' ? 'checked' : ''}>
                                    <label class="form-check-label" for="flexRadioDefault1">1 BedRoom</label>
                                    </div>
                                  </div>
                                <div class="col-auto">
                                 <div class="form-check">
                                <input class="form-check-input" type="radio" name="noOfBedrooms" value="2 BedRooms" id="flexRadioDefault2" onclick="noOfBedroomsValidation()" ${dto.noOfBedrooms eq '2 bedRooms' ? 'checked' : ''}>
                               <label class="form-check-label" for="flexRadioDefault2">2 BedRoom</label>
                                 </div>
                                  </div>
                               <div class="col-auto">
                               <div class="form-check">
                               <input class="form-check-input" type="radio" name="noOfBedrooms" value="3 BedRooms" id="flexRadioDefault3" onclick="noOfBedroomsValidation()" ${dto.noOfBedrooms eq '3 bedRooms' ? 'checked' : ''}>
                                   <label class="form-check-label" for="flexRadioDefault3">3 BedRooms</label>
                                                  </div>
                                                  </div>
                                <div class="col-auto">
                                <div class="form-check">
                               <input class="form-check-input" type="radio" name="noOfBedrooms" value="4 BedRooms" id="flexRadioDefault3" onclick="noOfBedroomsValidation()" ${dto.noOfBedrooms eq '4 bedRooms' ? 'checked' : ''}>
                               <label class="form-check-label" for="flexRadioDefault3">4 BedRooms</label>
                                  </div>
                                      </div>

                                              </div>
                                          </div>

                                <div class="mb-3">
                                                        <span id="erroraddress"></span><br>
                                                        <b>Address</b>
                                                        <label for="address" class="form-floating"></label>
                                                        <textarea class="form-control" placeholder="Leave a comment here"  value="${dTO.address}" id="address" style="height: 100px" name="address" onblur="addressValidation()"></textarea>
                                                    </div>

                                <div class="  row mb-3 ">
                                                                    <span id="errorphone" ></span><br>
                                                                                <label for="phone" class="form-label  "><b>Phone:</b></label>
                                                                                <input type="text" class="form-control " id="phone" name="phone" onblur="phoneValidation()">
                                                                            </div>

                                             <br><div class="list-group">


		<input type="submit"   id="submit" type="Apply">

</form>


 </div>
    </div>
</div>

</body>
</html>
