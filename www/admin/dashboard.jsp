<%--
  Created by IntelliJ IDEA.
  User: bushuai
  Date: 7/12/15
  Time: 11:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet" href="../assets/css/house.css">
<link rel="stylesheet" href="../assets/css/bootstrap.css">
</head>

<body>
	<div class="wrapper">
		<div id="sidebar">
			<header>
				<div class="profile">
					<a href="#"> <img class="avator" src="../assets/images/bg.jpg"
						width="50px" height="50px" alt="">
					</a>

					<p>${sessionScope.currentUser.loginId}</p>

					<p>Administrator</p>
				</div>
			</header>
			<hr>
			<ul>
				<li>
					<button id="customer-manager" class="btn btn-block">用户管理</button>
				</li>
				<li>
					<button id="car-manager" class="btn btn-block">车辆管理</button>
				</li>
				<li>
					<button id="notice-manager" class="btn btn-block">公告管理</button>
				</li>
				<li>
					<button id="fee-manager" class="btn btn-block">缴费管理</button>
				</li>
				<li>
					<button id="system-manager" class="btn btn-block">系统设置</button>
				</li>
			</ul>
			<hr>
			<footer>
				&copy;2015 <br /> 红鲤鱼与绿鲤鱼与驴
			</footer>
		</div>
		<div id="main">
			<div class="container">
				<div class="row">
					<div class="col-md-8 col-md-offset-2">
						<div id="customer" class="details">
							<header>
								<button class="btn btn-primary btn-sm" data-toggle="modal"
									data-target="#new-customer">+</button>
								<input type="text" class="input-sm s" placeholder="search">
								<button class="btn btn-success  btn-sm btn-search"
									data-table="customer">Search</button>
							</header>
							<div class="details-main">
								<table class="table text-center customer">
									<thead>
										<tr>
											<td>#</td>
											<td>姓名</td>
											<td>账号</td>
											<td>操作</td>
										</tr>
									</thead>
									<tbody>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-8 col-md-offset-2">
						<div id="car" class="details">
							<header>
								<div action="" class="form-inline text-center">
									<div class="form-group">
										<label for=""></label> <input type="text"
											class="form-control s" placeholder="search">
									</div>
									<div class="form-group">
										<button class="btn btn-success btn-search" data-table="car">Search</button>
									</div>
								</div>
							</header>
							<div class="details-main">
								<table class="table  text-center car">
									<thead>
										<tr>
											<td>#</td>
											<td>业主编号</td>
											<td>房间编号</td>
											<td>车位号</td>
										</tr>
									</thead>
									<tbody>

									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>


				<div class="row">
					<div class="col-md-10 col-md-offset-1">
						<div id="notice" class="details">
							<header>
								<div action="" class="form-inline text-center">
									<div class="form-group">
										<label for=""></label> <input type="text" class="form-control s"
											placeholder="search">
									</div>
									<div class="form-group">
										<button class="btn btn-success btn-search" data-table="notice">Search</button>
									</div>
								</div>
							</header>
							<div class="details-main">
								<table class="table  text-center notice">
									<thead>
										<tr>
											<td>#</td>
											<td>标题</td>
											<td>内容</td>
											<td>发表时间</td>
											<td>发布人</td>
										</tr>
									</thead>
									<tbody>

									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
		<div class="modal fade" id="new-customer" tabindex="-1" role="dialog"
			aria-labelledby="" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="">新增业主</h4>
					</div>
					<div class="modal-body">
						<div class="form">
							<div class="form-group">
								<label for="new-customer-loginId" class="control-label">用户名</label>
								<input type="text" class="form-control"
									id="new-customer-loginId" />
							</div>
							<div class="form-group">
								<label for="new-customer-password" class="control-label">密码</label>
								<input type="text" class="form-control"
									id="new-customer-password" />
							</div>
							<div class="form-group">
								<label for="new-customer-name" class="control-label">姓名</label>
								<input type="text" class="form-control" id="new-customer-name" />
							</div>
							<div class="form-group">
								<button class="btn btn-info btn-block btn-add-customer">确定</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="modal fade" id="edit-customer" tabindex="-1" role="dialog"
			aria-labelledby="" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="">修改业主信息</h4>
					</div>
					<div class="modal-body">
						<div>
							<div class="form-group">
								<label for="edit-customer-name" class="form-label">姓名</label> <input
									type="text" class="form-control" id="edit-customer-name" />
							</div>
							<div class="form-group">
								<label for="edit-customer-loginId" class="form-label">用户名</label>
								<input type="text" class="form-control"
									id="edit-customer-loginId" />
							</div>
							<div class="form-group">
								<label for="edit-customer-password" class="form-label">密码</label>
								<input type="text" class="form-control"
									id="edit-customer-password" />
							</div>
							<div class="form-group">
								<label for="edit-customer-age" class="form-label">年龄</label> <input
									type="text" class="form-control" id="edit-customer-age" />
							</div>
							<div class="form-group">
								<label for="edit-customer-phone" class="form-label">电话</label> <input
									type="text" class="form-control" id="edit-customer-phone" />
							</div>
							<div class="form-group">
								<label for="edit-customer-address" class="form-label">联系地址</label>
								<input type="text" class="form-control"
									id="edit-customer-address" />
							</div>
							<div class="form-group">
								<button class="btn btn-info btn-block btn-edit-customer"
									data-table="customer">确定</button>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>

	</div>

	<script src="../assets/js/jquery.js" type="text/javascript"></script>
	<script src="../assets/js/bootstrap.js" type="text/javascript"></script>
	<script>
		$(function() {
			var slice = Array.prototype.slice;
			$('.btn-search').click(function() {
								var $table = $(this).attr('data-table');

								var d = {
									act : 'query',
									type : 'single'
								};

								if ($table == 'customer') {
									d.loginId = $('#customer .s').val();
									d.type='loginId';
								}
								if ($table == 'car') {
									d.id = $('#car .s').val();

								}
								if ($table == 'notice') {
									d.id = $('#notice .s').val();
								}
								$('.details').hide();
								$.ajax({
											url : '../' + $table + '.action',
											dataType : 'json',
											type : 'post',
											data : d,
											success : function(data) {
												generateTable(data,$table);

											},
											beforeSend : function() {
												$('#loading-modal')
														.fadeIn(1500);
												$("." + $table + " tbody")
														.empty();
											},
											complete : function() {
												$('#' + $table).fadeIn(1000);
												$('#loading-modal').fadeOut(
														1000);
											},
											error : function() {
												console.log('error');
											}
										});
							});
			$('.btn-add-customer').on('click', function() {
				var $loginId = $('#new-customer-loginId').val();
				var $password = $('#new-customer-password').val();
				var $name = $('#new-customer-name').val();
				$.ajax({
					url : '../customer.action',
					dataType : 'json',
					type : 'post',
					data : {
						loginId : $loginId,
						password : $password,
						name : $name,
						act : 'insert'
					},
					success : function(data) {
						requestData('customer');
						$('#new-customer .form-control').val("");
						$('#new-customer').modal('hide');
					},
					error : function() {
						console.log('error');
					}
				});
			});

			$('button[id$="manager"]').on('click', function(event) {
				event.preventDefault();
				var $id = $(this).attr('id');
				var $table = $id.substr(0, $id.indexOf('-'));

				$('.details').hide();
				requestData($table);
			});
			$('table').delegate(
					'button',
					'click',
					function() {
						var $tb = $(this).attr('data-table');
						console.log('table====' + $tb);
						var $id = $(this).attr('data-id');
						if ($(this).attr('data-mode') == 'edit') {
							$.ajax({
								url : '../' + $tb + '.action',
								dataType : 'json',
								type : 'post',
								data : {
									act : 'query',
									id : $id,
									type : 'id'
								},
								success : function(data) {
									console.log(data[0].loginId);
									$('#edit-customer-name').val(data[0].name);
									$('#edit-customer-loginId').val(
											data[0].loginId);
									$('#edit-customer-password').val(
											data[0].password);
									$('#edit-customer-age').val(data[0].age);
									$('#edit-customer-phone')
											.val(data[0].phone);
									$('#edit-customer-address').val(
											data[0].address);
									$('.btn-edit-customer').attr('data-id',
											data[0].id);
								},
								error : function() {
									console.log('error');
								}
							});
						} else {
							if (confirm('确定删除该用户吗？')) {
								$.ajax({
									url : '../' + $tb + '.action',
									type : 'post',
									data : {
										act : 'remove',
										id : $id
									},
									dataType : 'json',
									success : function(data) {
										console.log('delete success');
										requestData($tb);
									},
									error : function() {
										console.log('delete error');
									}
								});
							}
						}
					});

			$('.btn-edit-customer').on('click', function() {
				var $table = $(this).attr('data-table');
				var $name = $('#edit-customer-name').val();
				var $loginId = $('#edit-customer-loginId').val();
				var $password = $('#edit-customer-password').val();
				var $age = $('#edit-customer-age').val();
				var $phone = $('#edit-customer-phone').val();
				var $address = $('#edit-customer-address').val();
				var $id = $(this).attr('data-id');
				$.ajax({
					url : '../' + $table + '.action',
					dataType : 'json',
					type : 'post',
					data : {
						act : 'update',
						name : $name,
						loginId : $loginId,
						password : $password,
						age : $age,
						phone : $phone,
						address : $address,
						id : $id
					},
					success : function(data) {
						requestData($table);
						$('#edit-customer .from-control').val("");
						$('#edit-customer').modal('hide');
					},
					error : function() {
						console.log('aaaerror');
					}
				});
			});

			function requestData(table) {
				$('.details').hide();
				$
						.ajax({
							url : '../' + table + '.action',
							type : 'post',
							data : {
								act : 'query',
								type : 'all'
							},
							dataType : 'JSON',
							success : function(data) {
								generateTable(data,table);
						/* 		if (table == "car") {
									for ( var i = 0, len = data.length; i < len; i++) {
										var $tr = $('<tr class="items"><td>'
												+ data[i].id + '</td><td>'
												+ data[i].customerId
												+ '</td><td>' + data[i].roomId
												+ '</td><td>'
												+ data[i].car_position_num
												+ '</td></tr>');
										$("." + table + " tbody").append($tr);
									}
								}
								if (table == "customer") {
									for ( var i = 0, len = data.length; i < len; i++) {
										var $tr = $('<tr class="items"><td>'
												+ data[i].id
												+ '</td><td>'
												+ data[i].name
												+ '</td><td>'
												+ data[i].loginId
												+ '</td><td><button role="button" class="btn btn-success" data-table="' + table + '" data-mode="edit" data-toggle="modal" data-target="#edit-' + table + '"  data-id="' + data[ i ].id + '">编辑</button>&nbsp;<button role="button" class="btn btn-success btn-del"  data-table="' + table + '"   data-mode="delete"  data-id="' + data[ i ].id + '">删除</button></td></tr>');
										$("." + table + " tbody").append($tr);
									}
								}
								if (table == "notice") {
									for ( var i = 0, len = data.length; i < len; i++) {
										var $tr = $('<tr class="items"><td>'
												+ data[i].id + '</td><td>'
												+ data[i].title + '<td>'
												+ data[i].content + '</td><td>'
												+ data[i].publish_date
												+ '</td><td>' + data[i].adminId
												+ '</td></tr>');
										$("." + table + " tbody").append($tr);
									}
								} */
							},
							beforeSend : function() {
								$('#loading-modal').fadeIn(1500);
								$("." + table + " tbody").empty();
							},
							complete : function() {
								$('#' + table).fadeIn(1000);
								$('#loading-modal').fadeOut(1000);
							},
							error : function() {
								console.log('error');
							}
						});
			}

			function generateLoading() {
				var $loading = $('<div id="loading-modal"><div class="loading"> <span></span> <span></span> <span></span> <span></span> <span></span> </div> </div>');
				var $wrapper = $('.wrapper');
				$($loading).insertBefore($wrapper);
			}

			function generateTable(data,table){
				console.log('generate data==='+data);
				console.log('generate table =='+table);
				if (table == "car") {
					for ( var i = 0, len = data.length; i < len; i++) {
						var $tr = $('<tr class="items"><td>'
								+ data[i].id + '</td><td>'
								+ data[i].customerId
								+ '</td><td>' + data[i].roomId
								+ '</td><td>'
								+ data[i].car_position_num
								+ '</td></tr>');
						$("." + table + " tbody").append($tr);
					}
				}
				if (table == "customer") {
					for ( var i = 0, len = data.length; i < len; i++) {
						var $tr = $('<tr class="items"><td>'
								+ data[i].id
								+ '</td><td>'
								+ data[i].name
								+ '</td><td>'
								+ data[i].loginId
								+ '</td><td><button role="button" class="btn btn-success" data-table="' + table + '" data-mode="edit" data-toggle="modal" data-target="#edit-' + table + '"  data-id="' + data[ i ].id + '">编辑</button>&nbsp;<button role="button" class="btn btn-success btn-del"  data-table="' + table + '"   data-mode="delete"  data-id="' + data[ i ].id + '">删除</button></td></tr>');
						$("." + table + " tbody").append($tr);
					}
				}
				if (table == "notice") {
					for ( var i = 0, len = data.length; i < len; i++) {
						var $tr = $('<tr class="items"><td>'
								+ data[i].id + '</td><td>'
								+ data[i].title + '<td>'
								+ data[i].content + '</td><td>'
								+ data[i].publish_date
								+ '</td><td>' + data[i].adminId
								+ '</td></tr>');
						$("." + table + " tbody").append($tr);
					}
				}
			}
			generateLoading();
		});
	</script>
</body>

</html>
