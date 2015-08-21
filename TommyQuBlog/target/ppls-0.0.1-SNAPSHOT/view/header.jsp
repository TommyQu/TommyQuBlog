<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Tommy Qu's Blog</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li><a href="page/showIndexPage.do">Home</a></li>
				<li><a href="page/showBlogPage.do">Blog</a></li>
				<li><a href="#">Page 2</a></li>
				<li><a href="#">Page 3</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li>
					<a href="page/showNewPostPage.do"><span class="glyphicon glyphicon-new-window"></span> New Post</a>
				</li>
				<li>
					<a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a>
				</li>
				<li>
					<a href="#" data-toggle="modal" data-target="#loginModal"><span class="glyphicon glyphicon-log-in"></span> Login</a>
				</li>
			</ul>
		</div>
	</div>
</nav>

<div class="container">
	<h1>It's my daydream here!</h1>
</div>

<!-- Login Popup Modal -->
<div id="loginModal" class="modal fade" role="dialog">
  <div class="modal-dialog">
    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">User Login</h4>
      </div>
      <div class="modal-body">
      	<form class="form-horizontal" role="form" action="user/login.do">
			<div class="form-group">
				<label class="control-label col-sm-3" for="login-name">Login Name:</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" id="login-name"
						placeholder="Enter login name">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-3" for="pwd">Password:</label>
				<div class="col-sm-9">
					<input type="password" class="form-control" id="pwd"
						placeholder="Enter password">
				</div>
			</div>
<!-- 			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<div class="checkbox">
						<label><input type="checkbox"> Remember me</label>
					</div>
				</div>
			</div> -->
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="button" class="btn btn-default login-btn" data-dismiss="modal">Cancel</button>
					<button type="submit" class="btn btn-default login-btn" id="login-submit-btn">Submit</button>
				</div>
			</div>
		</form>
      </div>
    </div>
  </div>
</div>