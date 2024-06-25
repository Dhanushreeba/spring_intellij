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
                                <img src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png" alt="xworkz" width="140" height="70" >
                            </a>
                            <!-- End of logo -->

        <a class="navbar-brand  text-dark" href="index.jsp"><b>Home</b></a>
                <a class="navbar-brand  text-dark" href="ContactSearch.jsp"><b>ContactSearch</b></a>

  </div>

</nav>



<%---card---%>


<div class="container  justify-content-center">
    <div class="card p-4 ">
        <div class="card-body">

           ${dto}

            <form action="contact"  method="post">

            <input type="hidden" name="id" value="${dto.id  != null? dto.id : ''}"/>

                                <h3><b>Contact Form</b></h3>

                    <div class="text-primary">${name}</div>
                    <span style="color:red;">
                        <c:forEach items="${errors}" var="dtoError">
                        ${dtoError.defaultMessage}<br/>
                        </c:forEach>
                        </span>





        <div class="  row mb-3 ">

                    <label for="name" class="form-label  "><b>Name:</b></label>
                    <input type="text" class="form-control "  value="${dto.name}" id="name" name="name"/>
                </div>


        <div class="  row mb-3 ">

                            <label for="email" class="form-label  "><b>Email:</b></label>
                            <input type="text" class="form-control "  value="${dto.email}" id="email" name="email"/>
                        </div>                                          </div>
        <div class="  row mb-3 ">

                                    <label for="mobile" class="form-label  "><b>Mobile:</b></label>
                                    <input type="text" class="form-control "  value="${dto.mobile}" id="mobile" name="mobile"/>
                                </div>

        <!-- Textarea -->
                                                <div class="form-group">

                                                    <label for="comments">Comments:</label>
                                                    <textarea class="form-control" id="comments" value="${dto.comments}"  name="comments" rows="3" required>${dto.comments}</textarea>
                                                </div>



		<input class="btn btn-primary" type="submit" value="Submit">
        <input class="btn btn-primary" type="reset" value="clear">

</form>

 </div>
    </div>
</div>

</body>
</html>
