<%@ page  isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>PrimeMinister </title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">

<body>
<nav class="navbar navbar-dark bg-primary">
    <div class="container-fluid">
        <div class="navbar-header">

    <!-- Add your logo here -->
                            <a class="navbar-brand" href="#">
                                <img src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png" alt="xworkz" width="140" height="70"/ >
                            </a>
                            <!-- End of logo -->

        <a class="navbar-brand  text-dark" href="index.jsp"><b>Home</b></a>
        <a class="navbar-brand  text-dark" href="PrimeMinister.jsp"><b>PrimeMinister</b></a>


  </div>

</nav>



<%---card---%>


<div class="container mt-5 mb-5 d-flex justify-content-center">
    <div class="card p-group ">
        <div class="card-body">


            <form action="pmsearch"  method="get">

                                <h3><b>PrimeMinister Form</b></h3>

                    <div class="text-primary">${name}</div>
                    <span style="color:red;">
                        <c:forEach items="${errors}" var="pMDtoError">
                        ${pMDtoError.defaultMessage}<br/>
                        </c:forEach>
                        </span>





        <div class="  row mb-group ">

                    <label for="name" class="form-label  "><b>Name:</b></label>
                    <input type="text" class="form-control "  value="${pMDto.name}" id="name" name="name"/>
                </div>




		<input class="btn btn-primary" type="submit" value="Submit"/>



 </div>
    </div>
</div>

<div class="d-flex justify-content-center mt-3 mb-2 align-items-center vh-80">
<div class="card" style="width: 25rem;">
  <div class="card-body">
    <strong style="color:green;">Search result for , ${name}</strong>
<table class="table">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Name</th>
      <th scope="col">Country</th>
      <th scope="col">DOB</th>
      <th scope="col">Alive</th>
      <th scope="col">Edit</th>
    </tr>
  </thead>
  <tbody>
       <c:forEach items="${name}" var="pm">
              <tr>
              <td>${pm.id}</td>
              <td>${pm.name}</td>
              <td>${pm.country}</td>
              <td>${pm.dob}</td>
              <td>${pm.alive}</td>
              <td><a href="pm-edit?pk=${pm.id}">Edit</a></td>
              </tr>


       </c:forEach>

  </tbody>
</table>

</form>

</div>
</div>
</div

</body>
</html>
