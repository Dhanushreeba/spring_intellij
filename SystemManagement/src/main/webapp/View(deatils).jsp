<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>System Management</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"/>

    <script>
        function getUserDetails() {
            const email = document.getElementById('email').value;

            fetch(`/getUserByEmail?email=${encodeURIComponent(email)}`)
                .then(response => response.json())
                .then(data => {
                    if (data) {
                        document.getElementById('firstName').value = dto.firstName || '';
                        document.getElementById('lastName').value = dto.lastName || '';
                        document.getElementById('contactNumber').value = dto.contactNumber || '';
                        document.getElementById('alternateNumber').value = dto.alternateNumber || '';
                        document.getElementById('address').value = dto.address || '';
                        // Assuming 'agree' is a checkbox
                        document.getElementById('agree').checked = dto.agree === 'yes';
                    } else {
                        document.getElementById('userDetails').innerHTML = '<p>No user found</p>';
                    }
                })
                .catch(error => {
                    console.error('Error:', error);
                });
        }
    </script>
</head>
<body>
    <nav class="navbar navbar-dark bg-info">
        <div class="container-fluid">
            <div class="navbar-header">
                <!-- Add your logo here -->
                <a class="navbar-brand" href="#">
                    <img src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png" alt="xworkz" width="140" height="70">
                </a>
                <!-- End of logo -->

                <a class="navbar-brand text-dark" href="index.jsp"><b>Home</b></a>
                <a class="navbar-brand text-dark" href="ProfileUpload.jsp"><b>Profile</b></a>
            </div>
        </div>
    </nav>

    <div class="container mt-5 mb-5 d-flex justify-content-center">
        <div class="card p-4">
            <div class="card-body">
                <form action="viewUser" method="post">
                    <input type="hidden" name="id" value="${dto.id != null ? dto.id : ''}"/>

                    <h3><b>SignUp page</b></h3>

                  <!--  <div class="text-primary">${name}</div>
                    <span style="color:red;">
                        <c:forEach items="${errors}" var="dtoError">
                            ${dtoError.defaultMessage}</br>
                        </c:forEach>-->
                    </span>

                    <div class="row mb-3">
                        <label for="firstName" class="form-label"><b>FirstName:</b></label>
                        <input type="text" class="form-control" value="${dto.firstName}"
                        id="firstName" name="firstName"/>
                    </div>

                    <div class="row mb-3">
                        <label for="lastName" class="form-label"><b>LastName:</b></label>
                        <input type="text" class="form-control" value="${dto.lastName}"
                        id="lastName" name="lastName"/>
                    </div>

                    <div class="row mb-3">
                        <label for="email" class="form-label"><b>Email:</b></label>
                        <input type="email" class="form-control" value="${dto.email}"
                        id="email" name="email" onblur="getUserDetails()"/>
                    </div>

                    <div class="row mb-3">
                        <label for="contactNumber" class="form-label"><b>ContactNumber:</b></label>
                        <input type="text" class="form-control" value="${dto.contactNumber}"
                        id="contactNumber" name="contactNumber"/>
                    </div>

                    <div class="row mb-3">
                        <label for="alternateNumber" class="form-label"><b>AlternateNumber:</b></label>
                        <input type="text" class="form-control" value="${dto.alternateNumber}"
                        id="alternateNumber" name="alternateNumber"/>
                    </div>

                    <div class="mb-3">
                        <b>Address</b>
                        <label for="address" class="form-floating"></label>
                        <textarea class="form-control" placeholder="Leave an address here"
                        id="address" style="height: 100px" name="address" value="${dto.address}"></textarea>
                    </div>

                    <div class="list-group">
                        <span id="agreeError"></span>
                        <label for="agree" class="list-group-item">
                            <input name="agree" id="agree" class="form-check-input me-1"
                            type="checkbox" value="yes" ${dto.agree eq 'yes' ? 'checked' : ''}/>
                            Agree
                        </label>
                    </div></br>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
