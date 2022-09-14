<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Welcome to NUIG Student Assessment System</title>
</head>
<body>
<div class="container">
    <form>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">User ID</label>
            <input type="userId" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
            <div id="userId" class="form-text">Make sure the user ID is correct</div>
        </div>
        <div class="mb-3">
            <label for="exampleInputPassword1" class="form-label">Password</label>
            <input type="password" class="form-control" id="exampleInputPassword1">
        </div>
        <div class="mb-3 form-check">
            <input type="checkbox" class="form-check-input" id="exampleCheck1">
            <label class="form-check-label" for="exampleCheck1">Check me out</label>
        </div>
        <select class="form-select" aria-label="Default select example">
            <option selected>Choose the user type</option>
            <option value="1">HOD</option>
            <option value="2">Instructor</option>
            <option value="3">Student</option>
        </select>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>

</div>

</body>
</html>
