<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<style type="text/css">
body{
margin: 0;
	padding: 0;
}
.container11 {
	display: flex;
	align-items: center;
	justify-content: center;
	background:
		url('https://images.pexels.com/photos/41257/pexels-photo-41257.jpeg');
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
	width:100%;
	height: 100vh;
	font-family: 'Roboto', sans-serif;
}
input{
 accent-color: red;
}
 
.form-2-wrapper {
	background: #4169e1;
	padding: 50px;
	border-radius: 8px;
	height: auto;
}

input.form-control {
	padding: 11px;
	border: none;
	border: 2px solid #405c7cb8;
	border-radius: 30px;
	background-color: transparent;
	font-family: Arial, Helvetica, sans-serif;
}

input.form-control:focus {
	box-shadow: none !important;
	outline: 0px !important;
	background-color: transparent;
}

button.login-btn {
	background: #b400ff;
	color: #fff;
	border: none;
	padding: 10px;
	border-radius: 30px;
}

.register-test a {
	color: #000;
}

.social-login button {
	border-radius: 30px;
}
/* --------- navbar -----*/
    .navbar {
      background: #4169e1;
    }

    .navbar-brand {
      color: #ffffff;
      font-weight: bold;
    }

    .navbar-nav .nav-item .nav-link {
      color: #fff;
      position: relative; 
      transition: 0.3s;
      font-weight: 400;
      color:#fff;
    }

    .navbar-nav .nav-item .nav-link::before {
      content: '';
      position: absolute;
      width: 0%;
      height: 2px;
      bottom: 0;
      left: 0;
      background-color: #f8b739;
      transition: 0.3s;
      color:#fff;
    }

    .navbar-nav .nav-item .nav-link:hover::before {
      width: 100%; 
      color: #fff;
    }
</style>
</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark">
  <div class="container">
    <!-- Brand/logo -->
    <a class="navbar-brand" href="#">
      <i class="fas fa-code"></i><b>IPL</b>
    </a>

    <!-- Toggler/collapsibe Button -->
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
      <span class="navbar-toggler-icon"></span>
    </button>

    <!-- Navbar links -->
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
      <ul class="navbar-nav ml-auto">
        <li class="nav-item">
          <a class="nav-link" href="#">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">About</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Services</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Contact</a>
        </li>
      </ul>
    </div>
  </div>
</nav>
	<div class="container11">
		<div class="row">
			<!-- Left Blank Side -->
			<div class="col-lg-6"></div>

			<!-- Right Side Form -->
			<div
				class="col-lg-6 d-flex align-items-center justify-content-center right-side">
				<div class="form-2-wrapper">
					<div class="form">
						<form action="signup" method="post">
							<h1 style="color: #fff;">Chose Your Role</h1>
							<br> <input type="radio" name="role" value="Management"> Management <br> <br> 
							<input type="radio" name="role" value="Team"> Team <br> <br> 
							<input type="radio" name="role" value="Player"> Player <br>
							<br>
							<button type="submit" class="btn btn-danger">
								<span>SUBMIT</span>
							</button>
						</form>
						<br> <a href="Management_login.jsp"><button type="button"
								class="btn btn-success">Account_already_exist</button></a>
					</div>

					<!-- Register Link -->
				</div>
			</div>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>