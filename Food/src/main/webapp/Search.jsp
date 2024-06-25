<%@ page  isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Food </title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<nav class="navbar navbar-dark bg-primary">
    <div class="container-fluid">
        <div class="navbar-header">

    <!-- Add your logo here -->
                            <a class="navbar-brand" href="#">
                                <img src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png" alt="xworkz" width="140" height="70" />
                            </a>
                            <!-- End of logo -->

        <a class="navbar-brand  text-dark" href="index.jsp"><b>Home</b></a>
                <a class="navbar-brand  text-dark" href="Search.jsp"><b>Search</b></a>


  </div>
</div>
</nav>

<%---card---%>


<div class="container mt-5 mb-5 d-flex justify-content-center">
    <div class="card p-4 ">
        <div class="card-body">


            <form action="search"  method="post">

                                <h3><b>Food Order Form</b></h3>

                    <div class="text-primary">${name}</div>
                    <span style="color:red;">
                        <c:forEach items="${errors}" var="dtoError">
                        ${dtoError.defaultMessage}<br/>
                        </c:forEach>
                        </span>


<div class="row mb-group">
                                               <span id="orderSelectionerror"></span>
                                               <label for="orderSelection" class="form-label"><b>Order Selection:</b></label>
                                               <select class="form-select custom-select-width"
                                               value="${dto.orderSelection}" id="orderSelection" onblur="orderSelectionValidation()" name="name" aria-label="Select order">
                                                   <option selected value="">select</option>
                                                   <option value="BabyCorn Manchurian">BabyCorn Manchurian</option>
                                                   <option value="Biriyani">Biriyani</option>
                                                   <option value="Egg Rice">Egg Rice</option>
                                                   <option value="Lime Juice">Lime Juice</option>
                                                   <option value="Ghee Rice">Ghee Rice</option>
                                                   <option value="Veg Panner Roll">Veg Panner Roll</option>
                                               </select>
                                           </div>


		<input class="btn btn-primary" type="submit" value="Submit"/>





 </div>
    </div>
</div>




<div class="d-flex justify-content-center mt-3 mb-2 align-items-center vh-80">
<div class="card" style="width: 25rem;">
  <div class="card-body">
    <strong style="color:green;">Search result for , ${foodType}</strong>
<table class="table">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Name</th>
      <th scope="col">Food Type</th>
      <th scope="col">Order Selection</th>
      <th scope="col">Address</th>
      <th scope="col">Total Price</th>
    </tr>
  </thead>
  <tbody>
       <c:forEach items="${orderSelection}" var="food">
              <tr>
              <td>${food.id}</td>
              <td>${food.name}</td>
              <td>${food.foodType}</td>
              <td>${food.orderSelection}</td>
              <td>${food.address}</td>
              <td>${food.totalPrice}</td>
              </tr>


       </c:forEach>

  </tbody>
</table>

</form>
    </div>
  </div>
</div>

</body>
</html>