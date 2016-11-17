<%@ page import="com.noisyle.crowbar.constant.AdminConstant"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/WEB-INF/view/admin/common/header.jsp"></jsp:include>

<div class="container-fluid">
	<div class="row">
	    <div class="col-lg-12">
	        <h1 class="page-header">业务能力新增</h1>
	    </div><!-- /.col-lg-12 -->
	</div><!-- /.row -->
	<div class="row">
	    <div class="col-lg-12">
	        <div class="panel panel-default">
	            <div class="panel-heading">
	            	<div class="panel-title">业务能力</div>
	            </div><!-- /.panel-heading -->
	            <div class="panel-body">
                    <form id="form" role="form" class="form-horizontal">
                        <input type="hidden" id="employeeId" name="employeeId" value="${param.employeeId}">
				       	<div class="row">
				            <div class="col-sm-6">
				                <div class="form-group">
				                    <label for="catalog" class="col-sm-6 control-label">培训类别</label>
				                    <div class="col-sm-6">
				                        <input type="hidden" class="form-control" id="catalog" name="catalog" value="<%=AdminConstant.TrainingCatalog.SAFETY.getId() %>">
				                    </div>
				                </div>
				            </div>
				            <div class="col-sm-6">
				                <div class="form-group">
				                    <label for="name" class="col-sm-6 control-label">培训名称</label>
				                    <div class="col-sm-6">
				                        <input class="form-control" id="name" name="name">
				                    </div>
				                </div>
				            </div>
				        </div>
				        <div class="row">
				            <div class="col-sm-6">
				                <div class="form-group">
				                    <label for="startDate" class="col-sm-6 control-label">培训开始时间</label>
				                    <div class="col-sm-6">
				                        <input class="form-control" id="startDate" name="startDate" value="1900-01-01">
				                    </div>
				                </div>
				            </div>
				            <div class="col-sm-6">
				                <div class="form-group">
				                    <label for="endDate" class="col-sm-6 control-label">培训结束时间</label>
				                    <div class="col-sm-6">
				                        <input class="form-control" id="endDate" name="endDate" value="1900-01-01">
				                    </div>
				                </div>
				            </div>
				        </div>
				        <div class="row">
				            <div class="col-sm-6">
				                <div class="form-group">
				                    <label for="mode" class="col-sm-6 control-label">培训方式</label>
				                    <div class="col-sm-6">
				                        <input type="hidden" class="form-control" id="mode" name="mode" value="<%=AdminConstant.TrainingMode.INTERNAL.getId() %>">
				                    </div>
				                </div>
				            </div>
				            <div class="col-sm-6">
				                <div class="form-group">
				                    <label for="goal" class="col-sm-6 control-label">培训目标</label>
				                    <div class="col-sm-6">
				                        <input class="form-control" id="goal" name="goal">
				                    </div>
				                </div>
				            </div>
				        </div>
				        <div class="row">
				            <div class="col-sm-6">
				                <div class="form-group">
				                    <label for="content" class="col-sm-6 control-label">培训内容</label>
				                    <div class="col-sm-6">
				                        <input class="form-control" id="content" name="content">
				                    </div>
				                </div>
				            </div>
				            <div class="col-sm-6">
				                <div class="form-group">
				                    <label for="score" class="col-sm-6 control-label">培训成绩</label>
				                    <div class="col-sm-6">
				                        <input class="form-control" id="score" name="score">
				                    </div>
				                </div>
				            </div>
				        </div>
				        <div class="row">
				            <div class="col-sm-6">
				                <div class="form-group">
				                    <label for="issue" class="col-sm-6 control-label">是否发证</label>
				                    <div class="col-sm-6">
				                        <input type="hidden" class="form-control" id="issue" name="issue" value="<%=AdminConstant.YesOrNo.YES.getId() %>">
				                    </div>
				                </div>
				            </div>
				            <div class="col-sm-6">
				                <div class="form-group">
				                    <label for="issue" class="col-sm-6 control-label">发证名称</label>
				                    <div class="col-sm-6">
				                        <input class="form-control" id="certificate" name="certificate">
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
	$('#startDate').datetimepicker({format:'yyyy-mm-dd', minView:"month", autoclose:true, language:'zh-CN'});
	$('#endDate').datetimepicker({format:'yyyy-mm-dd', minView:"month", autoclose:true, language:'zh-CN'});
	$("#catalog").select2({data: <%=AdminConstant.TrainingCatalog.getJSONString(false, false) %>});
	$("#mode").select2({data: <%=AdminConstant.TrainingMode.getJSONString(false, false) %>});
	$("#issue").select2({data: <%=AdminConstant.YesOrNo.getJSONString(false, false) %>});
	
	$("#btnBack").on("click", function(){
		window.location.href="${ctx}/admin/employee/ability/list?employeeId=${param.employeeId}";
	});
	
	$("#form").submit(function(){
		$.ajax({
			url:"${ctx}/admin/employee/ability/save",
			method:"post",
			data:$("#form").serializeObject(),
			dataType:"json",
			success:function(r){
				alert(r.message);
				if(r.status=="SUCCESS"){
					window.location.href="${ctx}/admin/employee/ability/list?employeeId=${param.employeeId}";
				}
			}
		});
		return false;
	});
	
});
</script>
<jsp:include page="/WEB-INF/view/admin/common/footer.jsp"></jsp:include>
