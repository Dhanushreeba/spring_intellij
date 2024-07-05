<%@ page  isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>System Management</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">

 <script>
                    let fieldsChecks =
                    {

                           "email": false,

                    }

                   function validateAndEnableSubmit() {
                   let flag = false;

                   for (let [key, value] of Object.entries(fieldsChecks)) {

                   if (value === false) {
                       flag = true;
                       break;
                   }
                       }

                   if (!flag) {
                        document.getElementById("submit").removeAttribute("disabled");
                         }
                         else {
                document.getElementById("submit").setAttribute("disabled", "");
                   }
               }

                 function emailValidation() {
                     let element = document.getElementById("email");
                     let error = document.getElementById("emailError");
                     console.log(element);
                     console.log(element.value);
                     console.log(error);

                     const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
                    if (element.value.length > 3 && element.value.length < 30 && emailRegex.test(element.value)) {
                         error.innerHTML = "";
                         fieldsChecks["email"] = true;
                   }
                   else {
                       error.innerHTML = "Invalid email. Characters should be greater 3 and lessthan 30 ";                      error.style.color = "red"
                                  fieldsChecks["email"] = false;

                        }
                       validateAndEnableSubmit();
                   }


               <!-- ajax email validation-->

               function emailValidation() {
                           console.log("Validate email");
                           let email = document.getElementById("email").value;
                           console.log(email);
                           let error = document.getElementById("emailError");
                           const request = new XMLHttpRequest();
                           request.open("GET", "http://localhost:8080/SystemManagement/validateEmail/" + email);
                           request.send();
                           console.log(request);
                           request.onload = function () {
                           var ref = this.responseText;
                           console.log(ref);
                           error.innerHTML = ref;

          <!--enable and disable submit button for ajaxemail validation-->
                           if (ref === "") {
                           fieldsChecks["email"] = true;
                           } else {
                           fieldsChecks["email"] = false;
                           }

                           validateAndEnableSubmit();
                           }
                       }

  </script>


</head>

<body>
              <nav class="navbar navbar-dark bg-info">
                <div class="container-fluid">
                <div class="navbar-header">

                <!-- Add your logo here -->
                <a class="navbar-brand" href="#">
                <img src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png" alt="xworkz"
                    width="140" height="70">
                    <img src="..." class="rounded float-end" alt="...">
                     </a>
                <!-- End of logo -->

                <a class="navbar-brand  text-dark" href="index.jsp"><b>Home</b></a>

                </div>
                </div>
            </nav>

                     <%---card---%>

        <div class="container mt-5 mb-5 d-flex justify-content-center">
              <div class="card p-4 ">
              <div class="card-body">

                 <form action="reset" method="post">

                  <h3><b>Reset Password</b></h3>

                  <div class="text-primary">${name}</div>
                    <span style="color:red;">
                                    <c:forEach items="${errors}" var="dtoError">
                                     ${dtoError.defaultMessage}</br>
                                   </c:forEach>
                                </span>

                    <div class="  row mb-3 ">
                    <span id="emailError"></span><br>
                    <label for="email" class="form-label  "><b>Email:</b></label>
                       <input type="email" class="form-control " value="${dto.email}" id="email"
                            name="email" onblur="emailValidation()" />
                       </div>

    <div class="  row mb-3 ">
              <label for="password" class="form-label  "><b>NewPassword:</b></label>
                <input type="password" class="form-control " value="${dto.password}" id="password"
                                       name="password" />
                          </div>
              <div class="  row mb-3 ">
               <label for="password" class="form-label  "><b>ConfirmPassword:</b></label>
                      <input type="password" class="form-control " value="${dto.password}" id="password"
                               name="password" />
                      </div>

                     </br>

                 <input class="btn btn-info" type="submit" id="submit" value="Reset"/>

         </form>

         </div>
          </div>
            </div>
</body>
</html>

