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


<script src="js/echarts.min.js"></script>
<!-- e chart CDN -->
<style>
* {
	font-family: 微軟正黑體;
}

#main {
	display: none;
}

#second {
	display: none;
}
</style>
</head>
<body class="sb-nav-fixed">
	<div id="layoutSidenav">
		<jsp:include page="/fragment/left.jsp" />
		<div id="layoutSidenav_content">
			<main>
				<div class="container-fluid">
					<h1 class="mt-4" style="text-shadow: 1px 1px gray">網站使用回饋分析</h1>
					<div class="card mb-4">
						<div class="card-body">
							<h3 class="text-center bg-light py-2">報表查詢</h3>
						</div>

						<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
						<!-- 						<div style="display: flex; flex-direction: row; justify-content:space-evenly" > -->
						<div>
							<div style="float: left">
								<div id="main" style="width: 750px; height: 500px;"></div>

								<select name="year" id="year" class="btn border border-primary">
									<c:forEach var="n" begin="2019" end="2021">
										<option value="${n}">${n}</option>
									</c:forEach>
								</select> <select name="mon" id="mon" class="btn border border-primary">
									<c:forEach var="n" begin="1" end="12">
										<option value="${n}">${n}</option>
									</c:forEach>
								</select> <input type="submit" class="btn btn-primary" id="querydate"
									value="查詢月報表">

							</div>
							<div style="float: right">
								<div id="second" style="width: 750px; height: 500px;"></div>
								<input style="float: left" class="btn btn-primary" type="submit"
									id="queryyear" value="查詢年報表"> <select name="yearmonths"
									id="yearmonths" class="btn border border-primary">
									<c:forEach var="n" begin="2019" end="2021">
										<option value="${n}">${n}</option>
									</c:forEach>
								</select>

							</div>
						</div>




					</div>
					<div class="card mb-4">
						<div class="card-header">
							<i class="fa fa-table mr-1"></i>報表後臺管理
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
											<th>對網站評分</th>
											<th>網站使用流暢度</th>
											<th>交換滿意度</th>
											<th>推薦意願度</th>
											<th>對網站建議</th>
											<th>資料處理</th>

										</tr>
									</thead>
									<tbody>
										<c:forEach var='data' items='${webcomments}'>
											<tr>

												<td><c:out value="${data.commentNo}" default="無" /></td>
												<td><c:out value="${data.commentorNo}" default="無" /></td>
												<td><c:out value="${data.memberName}" default="無" /></td>
												<td><c:out value="${data.msgTime}" default="無" /></td>
												<td><c:out value="${data.webGrading}" default="無" /></td>
												<td><c:out value="${data.webFluency}" default="無" /></td>
												<td><c:out value="${data.webSatis}" default="無" /></td>
												<td><c:out value="${data.webRecommend}" default="無" /></td>
												<td><c:out value="${data.webSugg}" default="無" /></td>
												<td><a
													href='DeleteCommontServlet?key=${data.commentNo}'>刪除</a></td>
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
	<script type="text/javascript">
		// 基于准备好的dom，初始化echarts实例
		var myChart = echarts.init(document.getElementById('main'));
		var myChart1 = echarts.init(document.getElementById('second'));

		// 指定图表的配置项和数据
		function getbar() {
			let year = $("#year").val();
			let mon = $("#mon").val();

			myChart.clear();
			myChart.showLoading({
				text : '努力讀取數據中...'
			});
			$.getJSON("OutputBarChart", {
				year : year,
				mon : mon
			}, function(react) {
				// 指定图表的配置项和数据(既定格式)
				var option = {
					title : {
					// 						text : react.title.text,
					// 						// 						subtext : react.title.subtext,
					// 						x : react.title.x,
					// 						y : react.title.y,
					},
					"toolbox" : {
						"show" : true,
						"feature" : {
							"restore" : {
								"show" : true,
								"title" : "還原"
							},
							"magicType" : {
								"show" : true,
								"title" : {
									"line" : "折線圖",
									"stack" : "堆積",
									"bar" : "柱狀圖切換",
								// 				                    "tiled": "平铺"
								},
								"type" : [ "line", "bar" ]
							},
							"dataView" : {
								"show" : true,
								"title" : "數據視圖",
								"readOnly" : false,
								"lang" : [ "Data View", "close", "refresh" ]
							},
							"mark" : {
								"show" : true,
								"title" : {
									"mark" : "輔助線開關",
									"markClear" : "清空輔助線",
									"markUndo" : "删除輔助線"
								},
								"lineStyle" : {
									"color" : "#1e90ff",
									"type" : "dashed",
									"width" : 2
								}
							},
							"saveAsImage" : {
								"show" : true,
								"title" : "保存為圖片",
								"type" : "png",
								"lang" : [ "點擊保存" ]
							}
						}
					},
					grid : {
						left : '6%',
						right : '4%',
						bottom : '5%',
						containLabel : true
					},
					tooltip : {},
					legend : {
						data : react.legend.data,
						// 					   x : react.legend.x,
						x : "center",
						y : '7%'
					},
					xAxis : {
						data : react.xAxis[0].data,
						type : react.xAxis[0].type
					},
					yAxis : {},
					series : {
						name : react.series[0].name,
						type : react.series[0].type,
						data : react.series[0].data,
						showBackground : true,
						backgroundStyle : {
							color : 'rgba(220, 220, 220, 0.8)'
						}
					}
				}
				console.log(option)
				// 		// 使用刚指定的配置项和数据显示图表。
				// 		myChart.setOption(option);		
				myChart.setOption(option);
				myChart.hideLoading();
			});
		}
		function getline() {
			let yearmonths = $("#yearmonths").val();
			myChart1.clear();
			myChart1.showLoading({
				text : '努力讀取數據中...'
			});
			$.getJSON("OutputLineChart", {
				yearmonths : yearmonths,
			}, function(react) {
				console.log(react);
				var axis = [];
				var webf = [];
				var webr = [];
				var webs = [];
				var webg = [];
				var webdata_list = [];
				var i;
				for (i = 0; i < react.length; i++) {
					axis.push(react[i].mon + "月");
					webf.push(react[i].webFluency);
					webr.push(react[i].webRecommend);
					webs.push(react[i].webSatis);
					webg.push(react[i].webgrading);

				}
				webdata_list = [ webf, webr, webs, webg ];
				//                 console.log(webdata_list);
				//                 console.log(axis);
				series_list = [];
				var legend1 = [ "網站流暢度", "推薦意願度", "交換滿意度", "對網站評分" ];
				var y;
				for (y = 0; y < axis.length; y++) {
					var webdata = {
						name : legend1[y],
						type : 'line',
						stack : '總量',
						areaStyle : {},
						data : webdata_list[y]
					}
					series_list.push(webdata);
				}
				//                 var n;
				//                 for (n)
				var option1 = {
					title : {
					//                 	        text: '評分趨勢追蹤'
					},
					tooltip : {
						trigger : 'axis',
						axisPointer : {
							type : 'cross',
							label : {
								backgroundColor : '#6a7985'
							}
						}
					},
					legend : {
						data : legend1,
						x : "center",
						y : '7%'
					//圖例
					},
					toolbox : {
						"show" : true,
						"feature" : {
							"restore" : {
								"show" : true,
								"title" : "還原"
							},
							"magicType" : {
								"show" : true,
								"title" : {
									"line" : "折線圖",
									"stack" : "堆積",
									"bar" : "柱狀圖切換",
									"tiled" : "並排"
								},
								"type" : [ "line", "bar", 'stack', 'tiled' ]
							},
							"dataView" : {
								"show" : true,
								"title" : "數據視圖",
								"readOnly" : false,
								"lang" : [ "Data View", "close", "refresh" ]
							},
							"mark" : {
								"show" : true,
								"title" : {
									"mark" : "輔助線開關",
									"markClear" : "清空輔助線",
									"markUndo" : "删除輔助線"
								},
								"lineStyle" : {
									"color" : "#1e90ff",
									"type" : "dashed",
									"width" : 2
								}
							},
							"saveAsImage" : {
								"show" : true,
								"title" : "保存為圖片",
								"type" : "png",
								"lang" : [ "點擊保存" ]
							}
						}
					},
					grid : {
						left : '6%',
						right : '4%',
						bottom : '5%',
						containLabel : true
					},
					xAxis : [ {
						type : 'category',
						boundaryGap : false,
						data : axis
					//                 	            	['周一', '周二', '周三', '周四', '周五', '周六', '周日']
					} ],
					yAxis : [ {
						type : 'value'
					} ],
					series : series_list
				};

				console.log(option1);
				// 		// 使用刚指定的配置项和数据显示图表。
				// 		myChart.setOption(option);		
				myChart1.setOption(option1);
				myChart1.hideLoading();
			});
		}
		//载入图表
		$("#querydate").click(function() {
			$("#main").css("display", "block");
			getbar();
		})

		$("#queryyear").click(function() {
			$("#second").css("display", "block");
			getline();
		})
	</script>
</body>
</html>