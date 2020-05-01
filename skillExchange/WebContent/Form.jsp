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
	<jsp:include page="/fragment/left.jsp" />
	<div id="layoutSidenav_content">
		<main>
			<div class="container" style="margin-top:70px;">
				<div
					class="container border border-info mt-3 p-3 rounded-lg w-75 bg-light shadow-sm">
					<h3>意見回饋表</h3>
					<p>為了提升網站的服務品質，麻煩填寫下列表單 謝謝!</p>
					<p>(1:非常不好, 10:非常好)</p>
					<form action="InsertComment" method="post">
						<!-- radio button-->
						<div>
							<div>網站使用流暢度</div>
							<c:forEach var="n" begin="1" end="10" step="1">
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio" name="speed"
										id="speed${n}" value="${n}"> <label
										class="form-check-label" for="speed${n}">${n}</label>
								</div>
							</c:forEach>
						</div>
						<div>
							<div>推薦給他人意願</div>
							<c:forEach var="n" begin="1" end="10" step="1">
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio" name="rec"
										id="rec${n}" value="${n}"> <label
										class="form-check-label" for="rec${n}">${n}</label>
								</div>
							</c:forEach>
						</div>
						<div>
							<div>交換滿意度</div>
							<c:forEach var="n" begin="1" end="10" step="1">
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio" name="ex"
										id="ex${n}" value="${n}"> <label
										class="form-check-label" for="ex${n}">${n}</label>
								</div>
							</c:forEach>
						</div>
						<div>
							<div>對網站總體評分</div>
							<c:forEach var="n" begin="1" end="10" step="1">
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio" name="rating"
										id="rating${n}" value="${n}"> <label
										class="form-check-label" for="rating${n}">${n}</label>
								</div>
							</c:forEach>
						</div>
						<div>
							<div>對網站的建議(100字以內)</div>
							<textarea cols="40" rows="5" id="susg" name="susg"
								style="resize: none">	  
						</textarea>
						</div>
						<hr>

						<div>
							<div>給交換對方的評價</div>
							<c:forEach var="n" begin="1" end="10" step="1">
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio" name="rat"
										id="rat${n}" value="${n}" required> <label
										class="form-check-label" for="rat${n}">${n}</label>
								</div>
							</c:forEach>
							<div>
								<div>交換心得分享(100字以內)</div>
								<textarea cols="40" rows="5" id="susg" name="susg1"
									style="resize: none">	  
						</textarea>
							</div>
						</div>
						<input type="submit" name="submit" id="submit" value="submit" />
					</form>
				</div>

			</div>

		</main>
	</div>

	<footer class="py-4 bg-light mt-auto">
		<div class="container-fluid">
			<div class="d-flex align-items-center justify-content-between small">
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
</body>
</html>