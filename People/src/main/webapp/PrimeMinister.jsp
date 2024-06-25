<%@ page  isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>PrimeMinister </title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">

<body>
${pMDto}
<nav class="navbar navbar-dark bg-primary">
    <div class="container-fluid">
        <div class="navbar-header">

    <!-- Add your logo here -->
                            <a class="navbar-brand" href="#">
                                <img src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png" alt="xworkz" width="140" height="70" >
                            </a>
                            <!-- End of logo -->

        <a class="navbar-brand  text-dark" href="index.jsp"><b>Home</b></a>
        <a class="navbar-brand  text-dark" href="PrimeMinisterSearch.jsp"><b>PMSearch</b></a>

  </div>

</nav>



<%---card---%>


<div class="container mt-5 mb-5 d-flex justify-content-center">
    <div class="card p-4 ">
        <div class="card-body">


            <form action="pm"  method="post">
            <input type="hidden" name="id" value="${pMDto.id  != null? pMDto.id : ''}"/>

                                <h3><b>PrimeMinister Form</b></h3>

                    <div class="text-primary">${name}</div>
                    <span style="color:red;">
                        <c:forEach items="${errors}" var="dtoError">
                        ${dtoError.defaultMessage}<br/>
                        </c:forEach>
                        </span>





        <div class="  row mb-3 ">

                    <label for="name" class="form-label  "><b>Name:</b></label>
                    <input type="text" class="form-control "  value="${pMDto.name}" id="name" name="name"/>
                </div>


        <div class="  row mb-3 ">

                            <label for="country" class="form-label  "><b>Country:</b></label>
                            <input type="text" class="form-control "  value="${pMDto.country}" id="country" name="country"/>
                        </div>                                          </div>
        <div class="  row mb-3 ">

                                    <label for="dob" class="form-label  "><b>DOB:</b></label>
                                    <input type="date" class="form-control "  value="${pMDto.dob}" id="dob" name="dob"/>
                                </div>

     <div class="  row mb-3 ">

                                        <label for="alive" class="form-label  "><b>Alive:</b></label>
                                        <input type="text" class="form-control "  value="${pMDto.alive}" id="alive" name="alive"/>
                                    </div>


		<input class="btn btn-primary" type="submit" value="Submit"/>
        <input class="btn btn-primary" type="reset" value="clear"/>

</form>

 </div>
    </div>
</div>

</body>
</html>
