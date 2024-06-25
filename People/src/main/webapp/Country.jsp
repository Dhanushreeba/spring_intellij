<%@ page  isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Country </title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">

<body>
${countryDto}
<nav class="navbar navbar-dark bg-primary">
    <div class="container-fluid">
        <div class="navbar-header">

    <!-- Add your logo here -->
                            <a class="navbar-brand" href="#">
                                <img src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png" alt="xworkz" width="140" height="70" >
                            </a>
                            <!-- End of logo -->

        <a class="navbar-brand  text-dark" href="index.jsp"><b>Home</b></a>
                <a class="navbar-brand  text-dark" href="CountrySearch.jsp"><b>CountrySearch</b></a>

  </div>

</nav>



<%---card---%>


<div class="container mt-5 mb-5 d-flex justify-content-center">
    <div class="card p-4 ">
        <div class="card-body">


            <form action="country"  method="post">
            <input type="hidden" name="id" value="${countryDto.id != null? countryDto.id : ''}"/>

                                <h3><b>Country Form</b></h3>

            <div class="text-primary">${msg}</div>
                                <span style="color:red;">
                                    <c:forEach items="${errors}" var="countryDtoError">
                                    ${countryDtoError.defaultMessage}<br/>
                                    </c:forEach>
                                    </span>

        <div class="  row mb-3 ">

                    <label for="name" class="form-label  "><b>Name:</b></label>
                    <input type="text" class="form-control "  value="${countryDto.name}" id="name" name="name"/>
                </div>


     <div class="  row mb-3 ">
                                          <label for="population" class="form-label  "><b>Population:</b></label>
                                          <input type="text" class="form-control "  value="${countryDto.population}" id="population" name="population"/>
                                        </div>



               <div class="  row mb-3 ">

                                   <label for="capitalCity" class="form-label  "><b>CapitalCity:</b></label>
                                   <input type="text" class="form-control "  value="${countryDto.capitalCity}" id="capitalCity" name="capitalCity"/>
                               </div>

<div class="  row mb-3 ">
                                          <label for="noOfStates" class="form-label  "><b>NoOfStates:</b></label>
                                          <input type="text" class="form-control "  value="${countryDto.noOfStates}" id="noOfStates" name="noOfStates"/>
                                        </div>

		<input class="btn btn-primary" type="submit" value="Submit">
        <input class="btn btn-primary" type="reset" value="clear">

</form>

 </div>
    </div>
</div>

</body>
</html>
