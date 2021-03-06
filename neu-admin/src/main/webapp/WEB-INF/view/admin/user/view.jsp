<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/WEB-INF/view/admin/common/header.jsp"></jsp:include>

<div class="container-fluid">
	<div class="row">
	    <div class="col-lg-12">
	        <h1 class="page-header">用户信息修改</h1>
	    </div><!-- /.col-lg-12 -->
	</div><!-- /.row -->
	<div class="row">
	    <div class="col-lg-12">
	        <div class="panel panel-default">
	            <div class="panel-heading">
	            	<div class="panel-title">用户信息</div>
	            </div><!-- /.panel-heading -->
	            <div class="panel-body">
                    <form role="form" class="form-horizontal">
		                <input type="hidden" id="id" name="id" value="${user.id}">
	                    <div class="row">
		                    <div class="col-sm-6">
		                        <div class="form-group">
		                            <label for="loginname" class="col-sm-4 control-label">登录名</label>
		                            <div class="col-sm-8">
		                                <input class="form-control" id="loginname" name="loginname" value="${user.loginname}" readonly>
		                            </div>
		                        </div>
		                    </div>
		                    <div class="col-sm-6">
		                        <div class="form-group">
		                            <label for="username" class="col-sm-4 control-label">用户名称</label>
		                            <div class="col-sm-8">
		                                <input class="form-control" id="username" name="username" value="${user.username}">
		                            </div>
		                        </div>
		                    </div>
		                </div>
		                <div class="row">
		                    <div class="col-sm-6">
		                        <div class="form-group">
		                            <label for="phone" class="col-sm-4 control-label">电子邮箱</label>
		                            <div class="col-sm-8">
		                                <input type="email" class="form-control" id="email" name="email" value="${user.email}">
		                            </div>
		                        </div>
		                    </div>
		                    <div class="col-sm-6">
		                        <div class="form-group">
		                            <label for="phone" class="col-sm-4 control-label">电话</label>
		                            <div class="col-sm-8">
		                                <input type="tel" class="form-control" id="phone" name="phone" value="${user.phone}">
		                            </div>
		                        </div>
		                    </div>
		                </div>
		                <div class="row">
		                    <div class="col-xs-12">
			                    <div class="pull-right">
		                        <button class="btn btn-primary">保存用户信息</button>
		                        <button type="button" class="btn btn-default" id="btnBack">返回列表</button>
		                        </div>
		                    </div>
	                    </div>
                    </form>
	   			</div><!-- /.panel-body -->
	        </div><!-- /.panel -->
	    </div><!-- /.col-lg-12 -->
	</div><!-- /.row -->
</div><!-- /.container-fluid -->

<script>
$(function() {
	$("#btnBack").on("click", function(){
		window.location.href="${ctx}/admin/user/list";
	});
	
	$("form").submit(function(){
		$.ajax({
			url:"${ctx}/admin/user/save",
			method:"post",
			data:$("form").serializeObject(),
			dataType:"json",
			success:function(r){
				alert(r.message);
				if(r.status=="SUCCESS"){
					window.location.href="${ctx}/admin/userList";
				}
			}
		});
		return false;
	});
});
</script>
<jsp:include page="/WEB-INF/view/admin/common/footer.jsp"></jsp:include>
