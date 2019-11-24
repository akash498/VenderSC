<!DOCTYPE html>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href = "Login.css">
<link href="https://fonts.googleapis.com/css?family=Merriweather&display=swap" rel="stylesheet">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
</head>
<body class = "text-center" >

<div class="container">
  <img src="vendorSClogo.png" id = "logo"class="img-fluid" alt="Responsive image">
  <br>
  <br>
  <h2 style=" font-family: 'Merriweather', serif;">Register Your Business Here</h2>
  <br>
  <br>
  <form>
    <div class="form-group">
      <label for="text" style=" font-family: 'Merriweather', serif;">Business/Organization Name:</label>
      <input type="text" class="form-control" id="name" placeholder="Enter Name">
    </div>
    <div class="form-group">
      <label for="email" style=" font-family: 'Merriweather', serif;">Email:</label>
      <input type="email" class="form-control" id="email" placeholder="Enter email">
    </div>
 
  <div class="form-group">
    <label for="exampleFormControlFile1" style=" font-family: 'Merriweather', serif;">Upload your logo here:</label>
    <input type="file" class="form-control-file" id="exampleFormControlFile1">
  </div>

    <div class="form-group">
      <label for="text" style=" font-family: 'Merriweather', serif;">Username:</label>
      <input type="text" class="form-control" id="name" placeholder="Enter Username">
    </div>
    <div class="form-group">
      <label for="pwd" style=" font-family: 'Merriweather', serif;">Password:</label>
      <input type="password" class="form-control" id="pwd" placeholder="Enter password">
    </div>
   
    <button type="submit" class="btn btn-light" style=" font-family: 'Merriweather', serif;">Submit</button>
  </form>
</div>

</body> 
</html>