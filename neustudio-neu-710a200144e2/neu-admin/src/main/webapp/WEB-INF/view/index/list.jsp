<%@ page contentType="text/html; charset=utf-8"%>
<!-- Page Content -->
<div class="container">

    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">黄骅港电务工队
                <small>员工培养追踪评价系统</small>
            </h1>
        </div>
    </div>

    <div ng-repeat="item in items">
        <div class="row list-item">
            <div class="col-md-2">
                <a href="#">
                    <img class="img-responsive" ng-src="${ctx}/static/site/img/admin/avatar.jpg" alt="" ng-if="item.avatarId == null">
                    <img class="img-responsive" width="150" ng-src="${ctx}/admin/employee/avatar/{{item.avatarId}}" alt="" ng-if="item.avatarId != null">
                </a>
            </div>
            <div class="col-md-9">
                <h3 ng-bind="item.employeeName"></h3>
                <h4>SAP编号: {{item.sapCode}}</h4>
                <p>出生日期: {{item.dateOfBirth}}</p>
                <a class="btn btn-primary pull-right" ui-sref="detail({id:item.id})">查看 <span class="glyphicon glyphicon-chevron-right"></span></a>
            </div>
        </div>
        <hr>
    </div>

    <div class="row text-center">
        <div class="col-lg-12">
            <uib-pagination total-items="totalItems" ng-model="currentPage" max-size="maxSize" items-per-page="perPage" boundary-links="true" rotate="false" previous-text="&lsaquo;" next-text="&rsaquo;" first-text="&laquo;" last-text="&raquo;" ng-change="pageChanged()"></uib-pagination>
        </div>
    </div>

</div>
