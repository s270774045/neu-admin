<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

	<title>员工培养追踪评价</title>
	<link rel="shortcut icon" href="${ctx}/static/site/img/favicon.ico" />
	<link href="${ctx}/static/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="${ctx}/static/font-awesome/css/font-awesome.min.css" rel="stylesheet">
	<link href="${ctx}/static/bootstrapvalidator/css/bootstrapValidator.min.css" rel="stylesheet">
	<link href="${ctx}/static/site/css/login.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="${ctx}/static/html5shiv.min.js}"></script>
        <script src="${ctx}/static/respond.min.js}"></script>
    <![endif]-->

</head>

<body style="background-image: url('${ctx}/static/site/img/admin/login-bg.jpg')">
<script>
if(window.parent!=window){
	window.parent.location.href="${ctx}/admin/login";
}
</script>
<%-- <div id="login-carousel" class="carousel slide" data-ride="carousel" data-interval="4000" data-pause="null">
  <ol class="carousel-indicators">
    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
  </ol>
  <div class="carousel-inner" role="listbox">
    <div class="item active">
      <div class="image" style="background-image: url('${ctx}/static/site/img/admin/carousel1.jpg')"></div>
        <div class="carousel-caption">
          <h3>员工培养追踪评价系统</h3>
        </div>
    </div>
    <div class="item">
      <div class="image" style="background-image: url('${ctx}/static/site/img/admin/carousel2.jpg')"></div>
        <div class="carousel-caption">
          <h3>员工培养追踪评价系统</h3>
        </div>
    </div>
  </div>
</div> --%>

<div id="login-box" class="container">
   <div class="center-block">
       <div class="login-panel panel panel-default">
           <div class="panel-heading">
               <h3 class="panel-title">
               <%-- <spring:message code="login.boxTitle" /> --%>
                                              员工培养追踪评价系统
               </h3>
           </div>
           <div class="panel-body">
					<form role="form" id="loginForm" action="${ctx}/admin/login">
						<fieldset>
							<div class="form-group">
								<div class="input-group">
									<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span> 
									<input class="form-control" placeholder="<spring:message code="login.username" />" name="loginname" type="text" value="" required data-bv-notempty-message="<spring:message code="login.requireUsername" />" autofocus />
								</div>
							</div>
							<div class="form-group">
								<div class="input-group">
									<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>  
									<input class="form-control " placeholder="<spring:message code="login.password" />" name="password" type="password" value="" required data-bv-notempty-message="<spring:message code="login.requirePassword" />" />
								</div>
							</div>
							<div class="alert alert-danger" id="msg" style="display:none; padding:5px 15px;"></div>
							<div class="checkbox">
								<label> <input name="rememberMe" type="checkbox">
								<spring:message code="login.remember" />
								</label>
							</div>
							<!-- Change this to a button or input when using this as a form -->
							<button type="submit" class="btn btn-primary">
								<spring:message code="login.btnLogin" />
							</button>
						</fieldset>
					</form>
				</div>
        </div>
    </div>
</div>

<script src="${ctx}/static/jquery/jquery-1.11.2.min.js"></script>
<script src="${ctx}/static/bootstrap/js/bootstrap.min.js"></script>
<script src="${ctx}/static/bootstrapvalidator/js/bootstrapValidator.min.js"></script>
<script src="${ctx}/static/utils.js"></script>
<script>
$(function(){
    $('#loginForm').bootstrapValidator().on('success.form.bv', function(e) {
        e.preventDefault();
        var form = e.target;
		var data = $(form).serializeObject();
		data.password = $.md5(data.password).toUpperCase();
		data.rememberMe = $('[name=rememberMe]').prop("checked");
		$.post(form.action, data, function(r){
			if(r.status=='SUCCESS'){
				window.location.href="${ctx}/admin";
			}else{
				$("#msg").text(r.message).show();
			}
		}, 'json');
    });
});
</script>
</body>

</html>
