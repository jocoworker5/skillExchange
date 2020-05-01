<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zt-TW">
<c:set var='jspPath' value='${pageContext.request.contextPath}'/>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>確認刊登-Skill Exchange</title>
 <link href="css/styles.css" rel="stylesheet" />
    <link href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" rel="stylesheet"
        crossorigin="anonymous" />
    <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
    <script src="../font-awesome/css/font-awesome.min.css"
        crossorigin="anonymous"></script>
<style>
        fieldset{
            width: 800px;
            border: 3px solid chocolate;
            border-radius: 30px;
            margin: 20px;
        }
        legend{
            font-size: 30px;
            font-family:fantasy;
            color: lightsteelblue;
        }
        body{
            background-color: seashell;
            margin: 100px;
        }
        .st1{
            width: 450px;
            border-bottom: 1px solid cornflowerblue;
            margin: 10px;
            padding-bottom: 10px;
        }
        .st2{
            width: 450px;
            text-align: center;
        }
        .l1{
            width: 100px;
            float: left;
            text-align: right;
        }
        /* 讓意見表單不可以被拉大小 */
        textarea{
            resize: none;
        }
        tr,td {
			border: 2px solid black;
		}
		.d1{
			text-align: right;
		}
    </style>
	
</head>

<body class="sb-nav-fixed">
	<div id="layoutSidenav">
<jsp:include page="/fragment/left.jsp" />
<div id="layoutSidenav_content">
			<main>
				<div class="container-fluid">
					<caption><h3>確認刊登內容</h3></caption>
					<table>						
							<tr><td id='d1'>刊登標題:</td><td>${publishTitle}</td></tr>
							<tr><td id='d1'>照片:</td><td>${publishPic}</td></tr>
							<tr><td id='d1'>刊登內容:</td><td>${publishDetail}</td></tr>
							<tr><td id='d1'>自己的技能:</td><td>${ownSkill}</td></tr>
							<tr><td id='d1'>想學的技能:</td><td>${wantSkill}</td></tr>
							<tr><td id='d1'>刊登地區:</td><td>${publishArea}</td></tr>
							<tr><td id='d1'>刊登城市:</td><td>${City}</td></tr>
							<tr><td id='d1'>鄉鎮:</td><td>${district}</td></tr>
							<tr><td id='d1'>路名:</td><td>${road}</td></tr>
							<tr><td id='d1'>希望地點:</td><td>${publishPlace}</td></tr>
							<tr><td id='d1'>備註:</td><td>${publishMark}</td></tr>
					</table>
					<a href="/skillExchange/PublishRrev.jsp">上一步</a>
<!-- 					<form action="/skillExchange/src/main/webapp/PublishRrev.jsp" method="POST"> -->
<!-- 						<input type='submit' value='上一步' >  -->
<!-- 					</form> -->
					<form action="${jspPath}/publishCheckPage.Controller/publishCheckPageServlet" method="POST">
						<input type='submit' value='完成' > 
					</form>
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
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script src="js/scripts.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"
		crossorigin="anonymous"></script>
	<script src="assets/demo/chart-area-demo.js"></script>
	<script src="assets/demo/chart-bar-demo.js"></script>
	<script
		src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"
		crossorigin="anonymous"></script>
	<script src="assets/demo/datatables-demo.js"></script>	

</body>

</html>