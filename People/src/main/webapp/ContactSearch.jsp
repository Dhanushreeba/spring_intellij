<%@ page  isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Contact </title>

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
        <a class="navbar-brand  text-dark" href="Contact.jsp"><b>Contact</b></a>


  </div>

</nav>



<%---card---%>


<div class="container mt-5 mb-5 d-flex justify-content-center">
    <div class="card p-4 ">
        <div class="card-body">


            <form action="search"  method="get">

                                <h3><b>Contact Form</b></h3>

                    <div class="text-primary">${name}</div>
                    <span style="color:red;">
                        <c:forEach items="${errors}" var="dtoError">
                        ${dtoError.defaultMessage}<br/>
                        </c:forEach>
                        </span>





        <div class="  row mb-3 ">

                    <label for="name" class="form-label  "><b>Name:</b></label>
                    <input type="text" class="form-control "   id="name" value="${dto.name}" name="name"/>
                </div>




		<input class="btn btn-primary" type="submit" value="Submit"/>



 </div>
    </div>
</div>

<div class="d-flex justify-content-center mt-3 mb-2 align-items-center vh-80">
<div class="card" ">
  <div class="card-body">
    <strong style="color:green;">Search result for , ${name}</strong>
<table class="table">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Name</th>
      <th scope="col">Email</th>
      <th scope="col">Mobile</th>
      <th scope="col">Comments</th>
      <th scope="col">Edit</th>
      <th scope="col">Delete</th>
    </tr>
  </thead>
  <tbody>
       <c:forEach items="${listOfName}" var="contact">
              <tr>
              <td>${contact.id}</td>
              <td>${contact.name}</td>
              <td>${contact.email}</td>
              <td>${contact.mobile}</td>
              <td>${contact.comments}</td>
              <td><a href="contact-edit?pk=${contact.id}">Edit</a></td>
              <td><a href="contact-delete?pk=${contact.id}">Delete</a></td>
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
