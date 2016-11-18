<%@ page import="com.noisyle.crowbar.constant.AdminConstant"%>
<%@ page contentType="text/html; charset=utf-8"%>
<div class="container">
	<div class="row">
		<div class="col-sm-2" style="padding-top:20px;">
			<div class="list-group">
				<a href="" class="list-group-item active"><i class="fa fa-address-book"></i>&nbsp; 员工简历</a>
				<a href="" class="list-group-item"><i class="fa fa-book"></i>&nbsp; 专业知识</a>
				<a href="" class="list-group-item"><i class="fa fa-briefcase"></i>&nbsp; 业务能力</a>
				<a href="" class="list-group-item"><i class="fa fa-gavel"></i>&nbsp; 行为标准</a>
				<a href="" class="list-group-item"><i class="fa fa-flag"></i>&nbsp; 创新经验</a>
				<a href="" class="list-group-item"><i class="fa fa-search"></i>&nbsp; 综合能力</a>
				<a href="" class="list-group-item"><i class="fa fa-check-square"></i>&nbsp; 评估鉴定</a>
			</div>
		</div>

		<div class="col-sm-8 col-sm-offset-1">
			<h2><i class="fa fa-address-book"></i> 员工简历 <small>人员基本信息</small></h2>
			<hr />
			<div class="row detail-section">
				<div class="col-md-4 text-center">
                    <img class="img-responsive img-circle" ng-src="${ctx}/static/site/img/admin/avatar.jpg" alt="" ng-if="employee.avatarId == null">
                    <img class="img-responsive " width="160" ng-src="${ctx}/admin/employee/avatar/{{employee.avatarId}}" alt="" ng-if="employee.avatarId != null">
				</div>
				<div class="col-md-4">
					<div class="row">
						<div class="col-md-12">
							<h1 class="" ng-bind="employee.employeeName"></h1>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<span class="text-muted">SAP编码:</span> {{employee.sapCode}}<br>
							<span class="text-muted">出生日期:</span> {{employee.dateOfBirth}}<br>
							<span class="text-muted">性别:</span> {{employee.sexual_text}}<br>
							<span class="text-muted">部门:</span> {{employee.department}}<br>
							<span class="text-muted">岗位:</span> {{employee.post}}<br>
							<!-- <span class="text-muted">身份证号:</span> 123456789012<br> -->
						</div>
					</div>
				</div>
				<div class="col-md-3 col-md-offset-1">
					<div class="panel panel-default">
						<div class="panel-heading"><strong>分值</strong></div>
						<div class="panel-body">
							<div class="text-center detail-score" ng-bind="employee.score"></div>
						</div>
					</div>
					<div class="panel panel-default">
						<div class="panel-heading"><strong>评级</strong></div>
						<div class="panel-body">
							<div class="text-center detail-rating" ng-bind="employee.rating_text"></div>
						</div>
					</div>
				</div>
			</div>
			<!-- <div class="row detail-section">
				<div class="col-md-12">
					<table class="table table-bordered detail-table">
						<tbody>
							<tr>
								<td>所在部门</td>
								<td>部门部门部门部门</td>
								<td>岗位</td>
								<td>岗位岗位岗位岗位</td>
								<td>政治面貌</td>
								<td>群众</td>
							</tr>
							<tr>
								<td>健康状况</td>
								<td>健康</td>
								<td>婚姻状况</td>
								<td>已婚</td>
								<td>户口所在地</td>
								<td>xx县</td>
							</tr>
							<tr>
								<td>户口性质</td>
								<td>非农业</td>
								<td>邮政编码</td>
								<td>xxxxxx</td>
								<td>家庭地址</td>
								<td>地址地址地址地址</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div> -->
			<div class="row detail-section">
				<div class="col-md-12">
					<h2><i class="fa fa-book"></i> 专业知识 <small>专项考试</small></h2>
					<hr />
					<table class="table table-striped table-bordered table-hover detail-table">
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
						<tbody>
							<tr ng-repeat="knowledge in employee.knowledges">
								<td ng-bind="knowledge.date"></td>
								<td ng-bind="knowledge.safe1"></td>
								<td ng-bind="knowledge.theory1"></td>
								<td ng-bind="knowledge.practice1"></td>
								<td ng-bind="knowledge.safe2"></td>
								<td ng-bind="knowledge.theory2"></td>
								<td ng-bind="knowledge.practice2"></td>
								<td ng-bind="knowledge.theory3"></td>
								<td ng-bind="knowledge.safe3"></td>
								<td ng-bind="knowledge.score"></td>
								<td ng-bind='knowledge.rating | id2text:<%=AdminConstant.Rating.getJSONString(false, false) %>'></td>
								<td ng-bind="knowledge.winter"></td>
								<td ng-bind="knowledge.risk"></td>
								<td ng-bind="knowledge.standard"></td>
								<td ng-bind="knowledge.flood"></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="row detail-section">
				<div class="col-md-12">
					<h2><i class="fa fa-briefcase"></i> 业务能力 <small>培训记录</small></h2>
					<hr />
					<table class="table table-striped table-bordered table-hover detail-table">
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
							</tr>
						</thead>
						<tbody>
							<tr ng-repeat="ability in employee.abilitys">
								<td ng-bind='ability.catalog | id2text:<%=AdminConstant.TrainingCatalog.getJSONString(false, false) %>'></td>
								<td ng-bind="ability.name"></td>
								<td ng-bind="ability.startDate"></td>
								<td ng-bind="ability.endDate"></td>
								<td ng-bind='ability.mode | id2text:<%=AdminConstant.TrainingMode.getJSONString(false, false) %>'></td>
								<td ng-bind="ability.goal"></td>
								<td ng-bind="ability.content"></td>
								<td ng-bind="ability.score"></td>
								<td ng-bind='ability.issue | id2text:<%=AdminConstant.YesOrNo.getJSONString(false, false) %>'></td>
								<td ng-bind="ability.certificate"></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="row detail-section">
				<div class="col-md-12">
					<h2><i class="fa fa-gavel"></i> 行为标准</h2>
				</div>
				<div class="col-md-12">
					<h3>考核情况</h3>
					<hr />
					<table class="table table-striped table-bordered table-hover detail-table">
						<thead>
							<tr>
								<th rowspan="2"></th>
								<th colspan="2">1月</th>
								<th colspan="2">2月</th>
								<th colspan="2">3月</th>
								<th colspan="2">4月</th>
								<th colspan="2">5月</th>
								<th colspan="2">6月</th>
								<th colspan="2">7月</th>
								<th colspan="2">8月</th>
								<th colspan="2">9月</th>
								<th colspan="2">10月</th>
								<th colspan="2">11月</th>
								<th colspan="2">12月</th>
							</tr>
							<tr>
								<th>单位业绩</th>
								<th>个人业绩</th>
								<th>单位业绩</th>
								<th>个人业绩</th>
								<th>单位业绩</th>
								<th>个人业绩</th>
								<th>单位业绩</th>
								<th>个人业绩</th>
								<th>单位业绩</th>
								<th>个人业绩</th>
								<th>单位业绩</th>
								<th>个人业绩</th>
								<th>单位业绩</th>
								<th>个人业绩</th>
								<th>单位业绩</th>
								<th>个人业绩</th>
								<th>单位业绩</th>
								<th>个人业绩</th>
								<th>单位业绩</th>
								<th>个人业绩</th>
								<th>单位业绩</th>
								<th>个人业绩</th>
								<th>单位业绩</th>
								<th>个人业绩</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>2015</td>
								<td>A</td>
								<td>B</td>
								<td>A</td>
								<td>A</td>
								<td>B</td>
								<td>B</td>
								<td>A</td>
								<td>A</td>
								<td>B</td>
								<td>A</td>
								<td>B</td>
								<td>A</td>
								<td>C</td>
								<td>B</td>
								<td>A</td>
								<td>A</td>
								<td>A</td>
								<td>A</td>
								<td>B</td>
								<td>B</td>
								<td>B</td>
								<td>A</td>
								<td>A</td>
								<td>A</td>
							</tr>
							<tr>
								<td>2014</td>
								<td>B</td>
								<td>B</td>
								<td>A</td>
								<td>B</td>
								<td>A</td>
								<td>A</td>
								<td>B</td>
								<td>A</td>
								<td>A</td>
								<td>A</td>
								<td>B</td>
								<td>B</td>
								<td>A</td>
								<td>B</td>
								<td>B</td>
								<td>B</td>
								<td>B</td>
								<td>B</td>
								<td>B</td>
								<td>B</td>
								<td>A</td>
								<td>B</td>
								<td>B</td>
								<td>C</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="col-md-12">
					<h3>奖励情况</h3>
					<hr />
					<table class="table table-striped table-bordered table-hover detail-table">
						<thead>
							<tr>
								<th>奖励日期</th>
								<th>奖励名称</th>
								<th>奖励机构</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>2009-01-01</td>
								<td>先进工作者</td>
								<td>朔黄铁路发展有限责任公司</td>
							</tr>
							<tr>
								<td>2010-12-01</td>
								<td>先进个人</td>
								<td>朔黄铁路肃宁分公司</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="row detail-section">
				<div class="col-md-12">
					<h2><i class="fa fa-flag"></i> 经验创新 <small>创新成果</small></h2>
					<hr />
					<table class="table table-striped table-bordered table-hover detail-table">
						<thead>
							<tr>
								<th>创新日期</th>
								<th>创新名称</th>
								<th>创新成果</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td></td>
								<td></td>
								<td></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="row detail-section">
				<div class="col-md-12">
					<h2><i class="fa fa-search"></i> 综合能力 <small>基层工作经历</small></h2>
					<hr />
					<table class="table table-striped table-bordered table-hover detail-table">
						<thead>
							<tr>
								<th>履历起始时间</th>
								<th>履历终止时间</th>
								<th>工作单位</th>
								<th>所在部门</th>
								<th>担当职务</th>
								<th>岗位</th>
								<th>主要业绩</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>2007-07-10</td>
								<td>2013-07-10</td>
								<td>朔黄铁路肃宁分公司</td>
								<td>北港农场电务电力工队</td>
								<td></td>
								<td>电务工</td>
								<td>2006年9月，参加肃宁分公司黄万线电务专业信号设备开通验收，2007年10月至11月参加肃宁分公司组织的通信专业知识培训，2008年9月，参加肃宁分公司黄万线2.5 G信息化设备验收，</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="row detail-section">
				<div class="col-md-12">
					<h2><i class="fa fa-check-square"></i> 评估鉴定 <small>评估成绩</small></h2>
					<hr />
					<table class="table table-striped table-bordered table-hover detail-table">
						<thead>
							<tr>
								<th>考试时间</th>
								<th>评估等级</th>
								<th>考试内容</th>
								<th>理论成绩</th>
								<th>实作成绩</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td></td>
								<td>初级</td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td></td>
								<td>中级</td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td></td>
								<td>高级</td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td></td>
								<td>小能手</td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>

		</div>

	</div>

</div>
