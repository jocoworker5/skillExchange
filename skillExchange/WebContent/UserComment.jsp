<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>SkillExchange</title>
<link href="css/styles.css" rel="stylesheet" />
<link
	href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css"
	rel="stylesheet" crossorigin="anonymous" />
<link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
<script src="../font-awesome/css/font-awesome.min.css"
	crossorigin="anonymous"></script>
<style>
</style>
</head>
<body class="sb-nav-fixed">
	<div id="layoutSidenav">
		<jsp:include page="/fragment/left.jsp" />
		<div id="layoutSidenav_content">
			<main>
				<div class="container-fluid">
					<h1 class="mt-4" style="text-shadow: 1px 1px gray">使用者互評分析</h1>
					<div class="rounded-lg ">
						<div class="card-body">
							<form action="WatchingListServlet" method="get">
								<label style="background-color: #C4E1FF" class="rounded p-2">被評分低於<span
									class="lgtwo p-2">${param.grade}</span>的次數
								</label> <input style="background-color: #C4E1FF; margin-top: 10px;"
									type="range" min='2' max='10' step='1' name="grade" id="grade1">
								<input type="submit" id="grade" value="Search " class="btn"
									style="background-color: #C4E1FF" />

							</form>
							<div class="table-responsive tableshow"
								style="width: 35%; max-height: 300px;">
								<table class="table table-bordered" id="dataTable1"
									cellspacing="0">
									<thead>
										<tr>
											<th>被評價會員編號</th>
											<th id="tcount">低於<span>${param.grade}</span>的次數
											</th>
											<th>會員處理</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var='watch' items='${watching}'>
											<tr>

												<td><c:out value="${watch.memCommented}" default="無" /></td>
												<td><c:out value="${watch.exGrading}" default="無" /></td>
												<td><c:choose>
														<c:when test="${param.grade-1<2}">
															<c:choose>
																<c:when test="${watch.exGrading>=4}">
																	<a href="#" class='btn btn-danger'>永久停權</a>
																</c:when>
																<c:when test="${watch.exGrading>=2}">
																	<a href="#" class='btn'
																		style="background-color: #FFE153">水桶一個月</a>
																</c:when>
																<c:otherwise>
																	<button class="btn btn-secondary" disabled>
																		紀錄良好</button>
																</c:otherwise>
															</c:choose>
														</c:when>
														<c:when test="${param.grade-1<3}">
															<c:choose>
																<c:when test="${watch.exGrading>=7}">
																	<a href="#" class='btn btn-danger'>永久停權</a>
																</c:when>
																<c:when test="${watch.exGrading>=5}">
																	<a href="#" class='btn'
																		style="background-color: #FFE153">水桶三個月</a>
																</c:when>
																<c:when test="${watch.exGrading>=3}">
																	<a href="#" class='btn'
																		style="background-color: #FFE153">水桶一個月</a>
																</c:when>
																<c:otherwise>
																	<button class="btn btn-secondary" disabled>
																		紀錄良好</button>
																</c:otherwise>
															</c:choose>
														</c:when>
														<c:when test="${param.grade-1<4}">
															<c:choose>
																<c:when test="${watch.exGrading>=10}">
																	<a href="#" class='btn btn-danger'>永久停權</a>
																</c:when>
																<c:when test="${watch.exGrading>=7}">
																	<a href="#" class='btn'
																		style="background-color: #FF9224">水桶三個月</a>
																</c:when>
																<c:when test="${watch.exGrading>=5}">
																	<a href="#" class='btn'
																		style="background-color: #FFE153">水桶一個月</a>
																</c:when>
																<c:otherwise>
																	<button class="btn btn-secondary" disabled>
																		紀錄良好</button>
																</c:otherwise>
															</c:choose>
														</c:when>
													</c:choose></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>


					</div>

					<div class="card mb-4">
						<div class="card-header">
							<i class="fa fa-table mr-1"></i>使用者互評管理
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-bordered" id="dataTable" width="100%"
									cellspacing="0">
									<thead>
										<tr>
											<th>評價編號</th>
											<th>評價者編號</th>
											<th>評價者姓名</th>
											<th>評價時間</th>
											<th>給對方評分</th>
											<th>被評價者編號</th>
											<th>對另一方評價內容</th>
											<th>資料處理</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var='data' items='${usercomments}'>
											<tr>

												<td><c:out value="${data.commentNo}" default="無" /></td>
												<td><c:out value="${data.commentorNo}" default="無" /></td>
												<td><c:out value="${data.memberName}" default="無" /></td>
												<td><c:out value="${data.msgTime}" default="無" /></td>
												<td><c:out value="${data.exGrading}" default="無" /></td>
												<td><c:out value="${data.memCommented}" default="無" /></td>
												<td><c:out value="${data.msgDetail}" default="無" /></td>
												<td style="width: 180px"><a class="btn btn-danger"
													href='DeleteCommontServlet?key=${data.commentNo}'>刪除</a> <c:choose>
														<c:when test="${data.stat==1}">
															<a class='btn btn-light'
																href='UpdateCommentStatus?key=${data.commentNo}&stat=${data.stat}'><span>已發布</span></a>
														</c:when>
														<c:otherwise>
															<a class='btn btn-primary'
																href='UpdateCommentStatus?key=${data.commentNo}&stat=${data.stat}'><span>未發布</span></a>

														</c:otherwise>

													</c:choose></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</main>
			<footer class="py-4 bg-light mt-auto">
				<div class="container-fluid">
					<div
						class="d-flex align-items-center justify-content-between small">
						<div class="text-muted">Copyright &copy; Exchange platform</div>
					</div>
				</div>
			</footer>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script src="js/scripts.js"></script>
	<script
		src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"
		crossorigin="anonymous"></script>
	<script src="assets/demo/datatables-demo.js"></script>
	<script>
		$(document).ready(function() {
			var value;
			$("#grade1").change(function() {
				value = $("#grade1").val();
				console.log(value);
				$(".lgtwo").text(value);
			})

		})
	</script>
</body>
</html>