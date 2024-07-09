<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Edit Profile</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
    <nav class="navbar navbar-dark bg-info">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">
                    <img src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png" alt="xworkz" width="140" height="70">
                </a>
                <a class="navbar-brand text-dark" href="index.jsp"><b>Home</b></a>
                <a class="navbar-brand text-dark" href="SignIn.jsp"><b>SignIn</b></a>
            </div>
        </div>
    </nav>

    <div class="container mt-5 mb-5 d-flex justify-content-center">
        <div class="card p-4">
            <div class="card-body">
                <form action="edit" method="post">
                    <h3><b>Edit Profile</b></h3>
                    <div class="text-primary">${email}</div>
                    <span style="color:red;">
                        <c:forEach items="${errors}" var="dtoError">
                            ${dtoError.defaultMessage}</br>
                        </c:forEach>
                    </span>

                    <div class="row mb-3">
                        <label for="firstName" class="form-label"><b>FirstName:</b></label>
                        <input type="text" class="form-control" value="${dto.firstName}" id="firstName" name="firstName"/>
                    </div>

                    <div class="row mb-3">
                        <label for="lastName" class="form-label"><b>LastName:</b></label>
                        <input type="text" class="form-control" value="${dto.lastName}" id="lastName" name="lastName"/>
                    </div>

                    <div class="row mb-3">
                        <label for="email" class="form-label"><b>Email:</b></label>
                        <input type="email" class="form-control" value="${dto.email}" id="email" name="email" readonly/>
                    </div>

                    <div class="row mb-3">
                        <label for="contactNumber" class="form-label"><b>ContactNumber:</b></label>
                        <input type="text" class="form-control" value="${dto.contactNumber}" id="contactNumber" name="contactNumber"/>
                    </div>

                    <div class="row mb-3">
                        <label for="alternateNumber" class="form-label"><b>AlternateNumber:</b></label>
                        <input type="text" class="form-control" value="${dto.alternateNumber}" id="alternateNumber" name="alternateNumber"/>
                    </div>

                    <div class="mb-3">
                        <b>Address</b>
                        <label for="address" class="form-floating"></label>
                        <textarea class="form-control" placeholder="Leave a Address here" id="address" style="height: 100px" name="address">${dto.address}</textarea>
                    </div>

                    <br>
                    <div class="list-group">
                        <span id="agreeError"></span>
                        <label for="agree" class="list-group-item">
                            <input name="agree" id="agree" class="form-check-input me-1" type="checkbox" value="yes" ${dto.agree eq 'yes' ? 'checked' : ''}/>
                            Agree
                        </label>
                    </div>
                    <br>

                    <input class="btn btn-info" type="submit" id="submit" value="Update"/>
                </form>
            </div>
        </div>
    </div>
</body>
</html>







