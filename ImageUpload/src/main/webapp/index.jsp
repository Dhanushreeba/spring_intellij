<!DOCTYPE html>
<html>
<head>
    <title>Upload Form</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
    <h2>Upload File</h2>
    <form method="post" enctype="multipart/form-data" action="upload">
        <input type="file" name="file"/>
        <input type="submit" value="Upload file"/>
    </form>

<form method="get" action="download">
<label for="fileName">Enter File Name</label>
<input type="text"  id="fileName" name="fileName"/>
<input type="submit" value="download"/>
</form>
</body>
</html>
