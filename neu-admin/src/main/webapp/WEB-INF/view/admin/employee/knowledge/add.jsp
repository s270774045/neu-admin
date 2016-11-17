<%@ page import="com.noisyle.crowbar.constant.AdminConstant"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/WEB-INF/view/admin/common/header.jsp"></jsp:include>

<div class="container-fluid">
	<div class="row">
	    <div class="col-lg-12">
	        <h1 class="page-header">专业知识新增</h1>
	    </div><!-- /.col-lg-12 -->
	</div><!-- /.row -->
	<div class="row">
	    <div class="col-lg-12">
	        <div class="panel panel-default">
	            <div class="panel-heading">
	            	<div class="panel-title">专业知识</div>
	            </div><!-- /.panel-heading -->
	            <div class="panel-body">
                    <form id="form" role="form" class="form-horizontal">
                        <input type="hidden" id="employeeId" name="employeeId" value="${param.employeeId}">
				       	<div class="row">
				            <div class="col-sm-4">
				                <div class="form-group">
				                    <label for="date" class="col-sm-6 control-label">时间</label>
				                    <div class="col-sm-6">
										<input class="form-control" id="date" name="date" value="1900-01-01" required="true">
				                    </div>
				                </div>
				            </div>
				        </div>
				       	<div class="row">
			            	<h5>岗位大练兵上半年</h5>
			            	<hr />
				            <div class="col-sm-4">
				                <div class="form-group">
				                    <label for="safe1" class="col-sm-6 control-label">安全</label>
				                    <div class="col-sm-6">
				                        <input type="number" class="form-control" name="safe1">
				                    </div>
				                </div>
				            </div>
				            <div class="col-sm-4">
				                <div class="form-group">
				                    <label for="theory1" class="col-sm-6 control-label">理论</label>
				                    <div class="col-sm-6">
				                        <input type="number" class="form-control" name="theory1">
				                    </div>
				                </div>
				            </div>
				            <div class="col-sm-4">
				                <div class="form-group">
				                    <label for="practice1" class="col-sm-6 control-label">实作</label>
				                    <div class="col-sm-6">
				                        <input type="number" class="form-control" name="practice1">
				                    </div>
				                </div>
				            </div>
				        </div>
				       	<div class="row">
			            	<h5>岗位大练兵下半年</h5>
			            	<hr />
				            <div class="col-sm-4">
				                <div class="form-group">
				                    <label for="safe2" class="col-sm-6 control-label">安全</label>
				                    <div class="col-sm-6">
				                        <input type="number" class="form-control" name="safe2">
				                    </div>
				                </div>
				            </div>
				            <div class="col-sm-4">
				                <div class="form-group">
				                    <label for="theory2" class="col-sm-6 control-label">理论</label>
				                    <div class="col-sm-6">
				                        <input type="number" class="form-control" name="theory2">
				                    </div>
				                </div>
				            </div>
				            <div class="col-sm-4">
				                <div class="form-group">
				                    <label for="practice2" class="col-sm-6 control-label">实作</label>
				                    <div class="col-sm-6">
				                        <input type="number" class="form-control" name="practice2">
				                    </div>
				                </div>
				            </div>
				        </div>
				       	<div class="row">
			            	<h5>上岗证考试</h5>
			            	<hr />
				            <div class="col-sm-4">
				                <div class="form-group">
				                    <label for="theory3" class="col-sm-6 control-label">理论</label>
				                    <div class="col-sm-6">
				                        <input type="number" class="form-control" name="theory3">
				                    </div>
				                </div>
				            </div>
				            <div class="col-sm-4">
				                <div class="form-group">
				                    <label for="safe3" class="col-sm-6 control-label">安全</label>
				                    <div class="col-sm-6">
				                        <input type="number" class="form-control" name="safe3">
				                    </div>
				                </div>
				            </div>
				        </div>
				       	<div class="row">
			            	<h5>述职评测</h5>
			            	<hr />
				            <div class="col-sm-4">
				                <div class="form-group">
				                    <label for="score" class="col-sm-6 control-label">成绩</label>
				                    <div class="col-sm-6">
				                        <input type="number" class="form-control" name="score">
				                    </div>
				                </div>
				            </div>
				            <div class="col-sm-4">
				                <div class="form-group">
				                    <label for="rating" class="col-sm-6 control-label">等级</label>
				                    <div class="col-sm-6">
				                        <input type="hidden" class="form-control" id="rating" name="rating" value="<%=AdminConstant.Rating.A.getId() %>">
				                    </div>
				                </div>
				            </div>
				        </div>
				       	<div class="row">
			            	<h5>其他</h5>
			            	<hr />
				            <div class="col-sm-4">
				                <div class="form-group">
				                    <label for="winter" class="col-sm-6 control-label">防寒过冬考试</label>
				                    <div class="col-sm-6">
				                        <input type="number" class="form-control" name="winter">
				                    </div>
				                </div>
				            </div>
				            <div class="col-sm-4">
				                <div class="form-group">
				                    <label for="risk" class="col-sm-6 control-label">风险预控成绩</label>
				                    <div class="col-sm-6">
				                        <input type="number" class="form-control" name="risk">
				                    </div>
				                </div>
				            </div>
				            <div class="col-sm-4">
				                <div class="form-group">
				                    <label for="winter" class="col-sm-6 control-label">技规</label>
				                    <div class="col-sm-6">
				                        <input type="number" class="form-control" name="standard">
				                    </div>
				                </div>
				            </div>
				            <div class="col-sm-4">
				                <div class="form-group">
				                    <label for="flood" class="col-sm-6 control-label">防洪</label>
				                    <div class="col-sm-6">
				                        <input type="number" class="form-control" name="flood">
				                    </div>
				                </div>
				            </div>
				        </div>
		                <div class="row">
		                    <div class="col-xs-12">
			                    <div class="pull-right">
		                        <button class="btn btn-primary">保存</button>
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
	$('#date').datetimepicker({format:'yyyy-mm-dd', minView:"month", autoclose:true, language:'zh-CN'});
	$("#rating").select2({data: <%=AdminConstant.Rating.getJSONString(true, false) %>});
	
	$("#btnBack").on("click", function(){
		window.location.href="${ctx}/admin/employee/knowledge/list?employeeId=${param.employeeId}";
	});
	
	$("#form").submit(function(){
		$.ajax({
			url:"${ctx}/admin/employee/knowledge/save",
			method:"post",
			data:$("#form").serializeObject(),
			dataType:"json",
			success:function(r){
				alert(r.message);
				if(r.status=="SUCCESS"){
					window.location.href="${ctx}/admin/employee/knowledge/list?employeeId=${param.employeeId}";
				}
			}
		});
		return false;
	});
	
});
</script>
<jsp:include page="/WEB-INF/view/admin/common/footer.jsp"></jsp:include>
