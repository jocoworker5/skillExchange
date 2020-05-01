<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>1
<html lang="zt-TW">
<c:set var='jspPath' value='${pageContext.request.contextPath}' />
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>首頁-Skill Exchange</title>
<link href="css/styles.css" rel="stylesheet" />
<link
	href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css"
	rel="stylesheet" crossorigin="anonymous" />
<link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
<script src="../font-awesome/css/font-awesome.min.css"
	crossorigin="anonymous"></script>

<style>
.wrap {
	width: 83%;
	margin: 25px;
	padding-top: 15px;
	padding-bottom: 15px;
	padding-left:25px;
	padding-right: 25px;
	border: 1.5px solid #5B5B5B;
	border-radius: 10px;
}

.searchbar-text {
	width: 350px;
}

.searchbar {
	width: 150px;
	text-align: center;
}

.otext {
	text-align: center;
}

.wrapper {
	position: relative;
	width: 100vw;
	height: 100vh;
	overflow: hidden;
	/* 把超出去的照片隱藏起來 */
}

.form {
	position: absolute;
	width: 70%;
	z-index: 2;
	left: 40%;
	top: 15%;
	transform: translate(-50%, -50%);
}

ul {
	margin: 0;
	padding: 0;
	position: absolute;
}

li {
	margin: 0;
	padding: 0;
	list-style: none;
}

ul.slides {
	width: 400vw;
	left: 0px; /*移動+-800px*/
	transition: all 0.5s;
	height: 100vh;
}

ul.slides li {
	width: 98.7vw;
	height: 100vh;
	/* 	height: 300px; */
	float: left;
	overflow: hidden
}

ul.slides li img {
	opacity: 0.6;
	height: 100vh;
	object-fit: cover;
	width: 100%;
	/* 	width: 100vw; */
}

.title {
   font-family:微軟正黑體;
   border:none !important;
   font-weight:1000;
   padding:0;
   
}
</style>

</head>

<body class="sb-nav-fixed">
	<div id="layoutSidenav">
		<jsp:include page="/fragment/left.jsp" />
		<div id="layoutSidenav_content">
			<main>
				<div class="wrapper">
					<div class="form">
						<h2 class="title input-group wrap">想學什麼技能嗎?</h2>
						<form action="KeywordServlet1" method="GET">
							<div class="input-group wrap">
								<div class="input-group-prepend">
									<input type="text" class="form-control searchbar-text"
										name="keyword" placeholder="關鍵字...">
								</div>
								<div class="input-group-append">
									<select name="area1" id="area" class="btn btn-light searchbar"
										style="text-align: center; text-align-last: center;">
										<option value="地區" selected disabled>地區</option>
										<c:forEach var='area' items='${areaList}'>
											<option value="${area.publishAreaCN}">${area.publishAreaCN}</option>
										</c:forEach>
									</select>
								</div>
								<div class="input-group-append">
									<select name="skill1" id="skill" class="btn btn-light searchbar"
										style="text-align: center; text-align-last: center;">
										<option value="技能類別" selected disabled>技能類別</option>
										<c:forEach var='skill' items='${skillList}'>
											<option value="${skill.skillNameCN}">${skill.skillNameCN}</option>
										</c:forEach>
									</select>
								</div>
								<div class="input-group-append">
									<button type="submit" class="btn btn-secondary btn-sm searchbar">
										<i class="fa fa-search"></i>搜尋
									</button>
								</div>
							</div>
						</form>
					</div>

					<ul class="slides">
						<li><img src="images/home1.jpg" alt="" /></li>
						<li><img src="images/home2.jpg" alt="" /></li>
						<li><img src="images/home3.jpg" alt="" /></li>
						<li><img src="images/home4.jpg" alt="" /></li>
					</ul>
				</div>

			</main>
			<footer class="py-4 bg-light mt-auto">
				<div class="container-fluid">
					<div
						class="d-flex align-items-center justify-content-between small">
						<div class="text-muted">Copyright &copy; Your Website 2020</div>
						<div>
							<a href="#">Privacy Policy</a> &middot; <a href="#">Terms
								&amp; Conditions</a>
						</div>
					</div>
				</div>
			</footer>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"
		crossorigin="anonymous"></script>
	<script>
		$(function() {
			let set = setInterval(carousal, 12000);

			let slideNum = 0; //目前的li index
			let slideCount = $(".slides li").length; //有幾張img
			let lastIndex = slideCount - 1;
			$(".dot li").eq(0).css("background", "white");
			$(".dot li").mouseenter(function() {
				slideNum = $(this).index();
				show();
			});

			function show() {
				$(".dot li").eq(slideNum).css("background", "white").siblings()
						.css("background", "transparent");
				var width = $(window).width();
				console.log(width);
				let slideMove = -width * slideNum;
				$("ul.slides").css("left", slideMove);
			}

			function carousal() {
				slideNum++;
				if (slideNum % 4 == 0) {
					slideNum = 0;
				}
				show();
			}
		});
	</script>

	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script src="js/scripts.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"
		crossorigin="anonymous"></script>
</body>

</html>
