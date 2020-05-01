<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="zt-TW">
<c:set var='jspPath' value='${pageContext.request.contextPath}'/>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>刊登頁面-Skill Exchange</title>
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
    </style>
	
</head>

<body class="sb-nav-fixed">
	<div id="layoutSidenav">
<jsp:include page="/fragment/left.jsp" />
<div id="layoutSidenav_content">
			<main>
				<div class="container-fluid">
					<form action="${pageContext.request.contextPath}/publishPage.Controller/publishPage" method="POST" enctype="application/x-www-form-urlencoded">

        				<fieldset>
            				<legend>刊登資訊</legend>

            				<div class="st1">
                				<label for="" class="l1">刊登標題:</label>
                				<input type='text' name='publishTitle' value="${publishTitle}">
                				<font color='red' size='-3'>${error.publishTitle}</font>
            				</div>
  
            				<div class="st1">
                				<label for="" class="l1">照片:</label>
               					<input type="file" onchange="readURL(this)" name='publishPic' targetID="prePic"><br>
								<img id = "prePic" src="#" width="200px" name='prePic' value="${publishPic}"/><br>
            				</div>
  							
  							<div class="st1">
  								<label for="" class="l1">刊登內容:</label>
  								<textarea cols="40" row="5"  name='publishDetail' value='${publishDetail}'>${publishDetail}</textarea>
  								<font color='red' size='-3'>${error.publishDetail}</font>
  							</div>
  							
  							<div class="st1">
  								<label for="" class="l1">技能類型:</label>
  								<select id="selSkill" name='skillType' >
									<option value="${skillType}">${skillType}</option>									
									<option value="才藝">才藝</option>
									<option value="運動">運動</option>
									<option value="語言">語言</option>
									<option value="寵物">寵物</option>
									<option value="生活">生活</option>
								</select>
								<font color='red' size='-3'>${error.ownSkill}</font>
  							</div>	  	    	          				
            				
            				<div class="st1">
  								<label for="" class="l1">自己的技能:</label>
  								<select id="selPubArea" name='ownSkill'  >
									<option value="${ownSkill}">${ownSkill}</option>
									<c:forEach varStatus="vs" var="a" items="${skill}">
										<option value="${a.skillNameCN}">${a.skillNameCN}</option>
									</c:forEach>
								</select>
								<font color='red' size='-3'>${error.ownSkill}</font>
  							</div>	  
  							
  							<div class="st1">
  								<label for="" class="l1">想學的技能:</label>
  								<select id="selPubArea" name='wantSkill'>
									<option value="${wantSkill}">${wantSkill}</option>
									<c:forEach varStatus="vs" var="a" items="${skill}">
										<option value="${a.skillNameCN}">${a.skillNameCN}</option>
									</c:forEach>
								</select>
								<font color='red' size='-3'>${error.wantSkill}</font>
  							</div>	  
            				
        				</fieldset>
        
        				<fieldset>
            				<legend>刊登地點</legend>
            				<div class="st1">
  								<label for="" class="l1">刊登地區:</label>
  								<select id="selPubArea" name='publishArea'>
									<option value="${publishArea}">${publishArea}</option>
									<c:forEach var="a" items="${area}">
										<option value="${a.publishAreaCN}">${a.publishAreaCN}</option>
									</c:forEach>
<!-- 									<option value="North">北部</option> -->
<!-- 									<option value="Cen">中部</option> -->
<!-- 									<option value="South">南部</option> -->
<!-- 									<option vlaue="East">東部</option> -->
								</select>
								<font color='red' size='-3'>${error.publishArea}</font>
  							</div>
  							
  							<div class="st1">
  								<label for="" class="l1">刊登城市:</label>
  								<select id="selCity" name='City' >
									<option value="${City}">${City}</option>
									<c:forEach varStatus="vs" var="a" items="${city}">
										<c:if test='${vs.index==0}'><option disabled>---北部---</option></c:if>
										<c:if test='${vs.index==3}'><option disabled>---中部---</option></c:if>
										<c:if test='${vs.index==8}'><option disabled>---南部---</option></c:if>
										<c:if test='${vs.index==12}'><option disabled>---東部---</option></c:if>
										<option value="${a.cityCN}">${a.cityCN}</option>
									</c:forEach>
<!-- 									<option id="N" value="TPE">大台北</option> -->
<!-- 									<option id="C" value="TXG">大台中</option> -->
<!-- 									<option id="S" value="KHH">高雄</option> -->
<!-- 									<option id="E" vlaue="HUA">花蓮</option> -->
								</select>
								<font color='red' size='-3'>${error.City}</font>
  							</div>
  							
  							<div class="st1">
  								<label for="" class="l1">鄉鎮:</label>
  								<input type='text' name='district' value='${district}'><hr>
  								<label for="" class="l1">路名:</label>
  								<input type='text' name='road' value='${road}'>  
  							</div>
  							
  							<div class="st1">
  								<label for="" class="l1">希望地點:</label>
  								<input type='text' name='publishPlace' value='${publishPlace}'><hr>
  								<font color='red' size='-3'>${error.publishPlace}</font>
  							</div>
        				</fieldset>
        				
        				<fieldset>
            				<legend>備註</legend>
  							<div class="st1">
  								<label for="" class="l1">備註:</label>
  								<textarea cols="40" row="5"  name='publishMark' value='${publishMark}'>${publishMark}</textarea> 
  							</div>
        				</fieldset>
        				
        				<input type='submit' value='下一步' >   
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
	<script>
		function readURL(input){
  			if(input.files && input.files[0]){
    			var imageTagID = input.getAttribute("targetID");
    			var reader = new FileReader();
    			reader.onload = function (e) {
       				var img = document.getElementById(imageTagID);
       				img.setAttribute("src", e.target.result)
   		 		}
    			reader.readAsDataURL(input.files[0]);
  			}
		}
		
		
		
	</script>	
<%
	
%>	
</body>

</html>