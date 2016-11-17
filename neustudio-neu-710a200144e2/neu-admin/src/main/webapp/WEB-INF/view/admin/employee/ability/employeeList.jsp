<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/WEB-INF/view/admin/common/header.jsp"></jsp:include>

<div class="container-fluid">
	<div class="row">
	    <div class="col-lg-12">
	        <h1 class="page-header">员工信息管理</h1>
	    </div><!-- /.col-lg-12 -->
	</div><!-- /.row -->
	<div class="row">
	    <div class="col-lg-12">
	        <div class="panel panel-default">
	            <div class="panel-heading">
			        <div class="btn-group btn-group-sm pull-right" role="group" aria-label="...">
			          <button type="button" class="btn btn-default" id="btnReload">刷新列表</button>
			        </div>
			        <div class="panel-title">员工信息列表</div>
	            </div><!-- /.panel-heading -->
	            <div class="panel-body">
		            <table id="table" class="table table-hover table-striped table-bordered table-condensed" cellspacing="0" width="100%">
		              <thead>
		                <tr>
		                  <th>员工姓名</th>
		                  <th>SAP编码</th>
		                  <th>出生日期</th>
		                  <th>性别</th>
		                  <th>分值</th>
		                  <th>评级</th>
		                  <th></th>
		                </tr>
		              </thead>
		            </table>
	   			</div><!-- /.panel-body -->
	        </div><!-- /.panel -->
	    </div><!-- /.col-lg-12 -->
	</div><!-- /.row -->
</div><!-- /.container-fluid -->

<script>
var table;
$(function() {
	table = $('#table').DataTable({
		ajax : {
			url: '${ctx}/admin/employee/list'
		},
		serverSide: true,
		columns : [
			{data : "employeeName"},
			{data : "sapCode"},
			{data : "dateOfBirth"},
			{data : "sexual"},
			{data : "score"},
			{data : "rating"},
			{data : "id"}
		],
        columnDefs: [{
	        targets: -1,
	        render: function (a, b, c, d) {
	            var html = " ";
	            html += '<button type="button" class="btn btn-primary btn-xs" onclick="view(\'' + c.id + '\')">业务能力</button> ';
	            return html;
	        }
	    }]
	});
	
	$("#btnReload").on("click", function(){
		table.ajax.reload(null, false);
	});
	
});

function view(id){
	window.location.href="${ctx}/admin/employee/ability/list?employeeId="+id;
}

</script>
<jsp:include page="/WEB-INF/view/admin/common/footer.jsp"></jsp:include>
