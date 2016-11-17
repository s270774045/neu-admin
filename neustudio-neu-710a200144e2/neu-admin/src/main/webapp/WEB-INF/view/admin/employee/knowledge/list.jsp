<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/WEB-INF/view/admin/common/header.jsp"></jsp:include>

<div class="container-fluid">
	<div class="row">
	    <div class="col-lg-12">
	        <h1 class="page-header">专业知识</h1>
	    </div><!-- /.col-lg-12 -->
	</div><!-- /.row -->
    <div class="row">
	    <div class="col-xs-12">
	        <div class="panel panel-default">
	            <div class="panel-heading">
			        <div class="btn-group btn-group-sm pull-right" role="group" aria-label="...">
			          <button type="button" class="btn btn-default" id="btnAdd">新增</button>
			          <button type="button" class="btn btn-default" id="btnReload">刷新列表</button>
			          <button type="button" class="btn btn-default" id="btnBack">返回</button>
			        </div>
			        <div class="panel-title">专业知识</div>
	            </div><!-- /.panel-heading -->
	            <div class="panel-body">
					<table id="table" class="table table-hover table-striped table-bordered table-condensed" cellspacing="0" width="100%">
						<thead>
							<tr>
								<th rowspan="2">时间</th>
								<th colspan="3">岗位大练兵上半年</th>
								<th colspan="3">岗位大练兵下半年</th>
								<th colspan="2">上岗证考试</th>
								<th colspan="2">述职测评</th>
								<th rowspan="2">防寒过冬考试</th>
								<th rowspan="2">风险预控成绩</th>
								<th rowspan="2">技规</th>
								<th rowspan="2">防洪</th>
								<th rowspan="2"></th>
							</tr>
							<tr>
								<th>安全</th>
								<th>理论</th>
								<th>实作</th>
								<th>安全</th>
								<th>理论</th>
								<th>实作</th>
								<th>理论</th>
								<th>安全</th>
								<th>成绩</th>
								<th>等级</th>
							</tr>
						</thead>
					</table>
	   			</div><!-- /.panel-body -->
	        </div><!-- /.panel -->
	    </div><!-- /.col-lg-12 -->
    </div>
</div><!-- /.container-fluid -->

<script>
var table;
$(function() {
	table = $('#table').DataTable({
		ajax : {
			url: '${ctx}/admin/employee/knowledge/list?employeeId=${param.employeeId}'
		},
		serverSide: true,
	    columns: [
            { "data": "date" },
            { "data": "safe1" },
            { "data": "theory1" },
            { "data": "practice1" },
            { "data": "safe2" },
            { "data": "theory2" },
            { "data": "practice2" },
            { "data": "theory3" },
            { "data": "safe3" },
            { "data": "score" },
            { "data": "rating" },
            { "data": "winter" },
            { "data": "risk" },
            { "data": "standard" },
            { "data": "flood" },
            { "data": "id" }
        ],
        columnDefs: [{
	        targets: -1,
	        render: function (a, b, c, d) {
	            var html = " ";
	            html += '<button type="button" class="btn btn-primary btn-xs" onclick="view(' + c.id + ')">修改</button> ';
	            html += '<button type="button" class="btn btn-danger btn-xs" data-id="'+c.id+'" onclick="del(this)">删除</button> ';
	            return html;
	        }
	    }]
	});
	
	$("#btnAdd").on("click", function(){
		window.location.href="${ctx}/admin/employee/knowledge/add?employeeId=${param.employeeId}";
	});
	
	$("#btnReload").on("click", function(){
		table.ajax.reload(null, false);
	});
	
	$("#btnBack").on("click", function(){
		window.location.href="${ctx}/admin/employee/knowledge/employeeList";
	});
	
});

function view(id){
	window.location.href="${ctx}/admin/employee/knowledge/view?employeeId=${param.employeeId}&id="+id;
}

function del(obj){
	$.ajax({
		url:"${ctx}/admin/employee/knowledge/del",
		method:"post",
		data:$(obj).data(),
		dataType:"json",
		success:function(r){
			alert(r.message);
			if(r.status=="SUCCESS"){
				table.ajax.reload(null, false);
			}
		}
	});
	return false;
}

</script>
<jsp:include page="/WEB-INF/view/admin/common/footer.jsp"></jsp:include>
