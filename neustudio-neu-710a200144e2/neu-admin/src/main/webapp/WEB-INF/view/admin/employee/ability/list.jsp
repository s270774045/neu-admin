<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/WEB-INF/view/admin/common/header.jsp"></jsp:include>

<div class="container-fluid">
	<div class="row">
	    <div class="col-lg-12">
	        <h1 class="page-header">业务能力</h1>
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
			        <div class="panel-title">业务能力</div>
	            </div><!-- /.panel-heading -->
	            <div class="panel-body">
					<table id="table" class="table table-hover table-striped table-bordered table-condensed" cellspacing="0" width="100%">
						<thead>
							<tr>
								<th>培训类别</th>
								<th>培训名称</th>
								<th>培训开始时间</th>
								<th>培训结束时间</th>
								<th>培训方式</th>
								<th>培训目标</th>
								<th>培训内容</th>
								<th>培训成绩</th>
								<th>是否发证</th>
								<th>证书名称</th>
								<th></th>
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
			url: '${ctx}/admin/employee/ability/list?employeeId=${param.employeeId}'
		},
		serverSide: true,
	    columns: [
            { "data": "catalog" },
            { "data": "name" },
            { "data": "startDate" },
            { "data": "endDate" },
            { "data": "mode" },
            { "data": "goal" },
            { "data": "content" },
            { "data": "score" },
            { "data": "issue" },
            { "data": "certificate" },
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
		window.location.href="${ctx}/admin/employee/ability/add?employeeId=${param.employeeId}";
	});
	
	$("#btnReload").on("click", function(){
		table.ajax.reload(null, false);
	});
	
	$("#btnBack").on("click", function(){
		window.location.href="${ctx}/admin/employee/ability/employeeList";
	});
	
});

function view(id){
	window.location.href="${ctx}/admin/employee/ability/view?employeeId=${param.employeeId}&id="+id;
}

function del(obj){
	$.ajax({
		url:"${ctx}/admin/employee/ability/del",
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
