<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zt-TW">

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
			border-bottom: 2px solid black;
			padding-top: 5px;
			width:300px;
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
					<caption><h3>我的刊登</h3></caption>
					<table>
						<th>刊登編號</th><th>刊登標題</th><th>刊登內容</th><th>刊登地區</th><th></th><th></th>			
						<c:forEach var="my" items="${mypublish}">
							<tr>
							
							<td id='d1'>${my.publishNo}</td><td id='d1'>${my.myTitle}</td><td>${my.myDetail}</td><td>${my.myArea}</td>
							<td>
									<a href='${pageContext.request.contextPath}/MyPublishImfor?publishNo=${my.publishNo}'>刊登資料</a>|
									<a href='${pageContext.request.contextPath}/MyPublishUpDate?publishNo=${my.publishNo}'>修改</a>|
									<a href='${pageContext.request.contextPath}/MyPublishDel?publishNo=${my.publishNo}'>刪除</a>
								</td>
								</tr>
						</c:forEach>					
					</table>
<!-- 					<form action="/skillExchange/PublishPage.jsp" method="POST"> -->
<!-- 						<input type='submit' value='上一步' >  -->
<!-- 					</form> -->
<!-- 					<form action="http://localhost:8080/skillExchange/publishCheckPage.Controller/publishCheckPageServlet" method="POST"> -->
<!-- 						<input type='submit' value='完成' >  -->
<!-- 					</form> -->
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