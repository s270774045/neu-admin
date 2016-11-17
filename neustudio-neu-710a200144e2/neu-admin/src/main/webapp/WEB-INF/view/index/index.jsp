<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE HTML>
<html lang="zh-CN" ng-app="myApp" ng-controller="MainCtrl">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<meta name="renderer" content="webkit">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title ng-bind="title"></title>
<link rel="shortcut icon" href="favicon.ico" />
<link href="static/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!--[if lt IE 9]>
  <script src="static/html5shiv.min.js"></script>
  <script src="static/respond.min.js"></script>
<![endif]-->
<link href="static/font-awesome/css/font-awesome.min.css" rel="stylesheet">
<link href="static/site/css/index/index.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
     <!--  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button> -->
      <img class="img-responsive navbar-left" width="80" ng-src="${ctx}/static/site/img/admin/SRLOGO.png" alt="">
      <a class="navbar-brand" ui-sref="list" ui-sref-opts="{reload: true}">员工培养追踪评价系统</a>
    </div>
    <div id="navbar" class="navbar-collapse collapse">
      <ul class="nav navbar-nav">
        <li ui-sref-active="active"><a ui-sref="list" ui-sref-opts="{reload: true}">首页</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="${ctx}/admin">管理登录</a></li>
      </ul>
    </div><!--/.nav-collapse -->
  </div>
</nav>

<div class="main" ui-view></div>

<footer>
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
				<hr />
				<p>Copyright &copy; 黄骅港电务工队 2016</p>
			</div>
		</div>
	</div>
</footer>
<script src="static/angular/angular.min.js"></script>
<script src="static/angular-animate/angular-animate.min.js"></script>
<script src="static/angular-ui-router/angular-ui-router.min.js"></script>
<script src="static/angular-ui-router-styles/ui-router-styles.js"></script>
<script src="static/angular-ui-bootstrap/ui-bootstrap-tpls.js"></script>
<script src="static/angular-scroll/angular-scroll.min.js"></script>
<script src="static/site/js/index/controller.js"></script>
<script src="static/site/js/index/app.js"></script>
</script>
</body>
</html>
