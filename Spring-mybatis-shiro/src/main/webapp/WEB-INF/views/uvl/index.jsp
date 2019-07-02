<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="org.apache.shiro.web.filter.authc.FormAuthenticationFilter"%>
<%@ page import="org.apache.shiro.authc.ExcessiveAttemptsException"%>
<%@ page import="org.apache.shiro.authc.IncorrectCredentialsException"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
	<title>紫外线强度及等级预报</title>
</head>

<body>
	<div class="row">
		<form:form id="uvlForecastForm" class="breadcrumb form-search">
		<div class="col-md-12">
	        <div class="panel panel-default">
	            <div class="panel-heading">
	                <div class="bootstrap-admin-box-title"><strong>紫外线强度及等级录入<span id="shpwtimeliness" style="color:red"></span></strong>
	                	<span>&nbsp;</span>
	                	<input type="button" id="createFile" class="btn btn-primary" value="生成上传文件">
	                	<input type="button" id="upload" class="btn btn-primary" value="上传">
	                	<input type="button" id="addBtn" class="btn btn-primary" value="新建录入数据">
	                	&nbsp;&nbsp;<span id="tip"></span>
	                </div>
	            </div>
	            <div class="bootstrap-admin-panel-content bap-content" id="position-uvlforecast-table">
	            
	            </div>
	        </div>
		</div>
		</form:form>
	</div>
	
	<script>
		//当前时间 下午
		var time="forenoon";
		var dateTime="";
		var fileName="";
		
		$(document).ready(function() {
			//未加载完全部元素按钮不可点击
			initDisableButtons();
			//获取时间
			time=getTime();
			//获取时次
			dateTime=getDateTime(time);
			//获取文件名
			fileName=getFileName(time);
			//根据时间初始化界面
			initTimeBody(time);
		});
		
		//添加按钮事件 新建
		$('#addBtn').click(function(){
			add(time);
		})
		
		//添加紫外线预报
		function add(time){
			
			var html = render('#template-add-afternoon');
			$('#table-body-afternoon').append(html);
			
			//保存按钮
			$('.receiver-save-action').unbind("click");
			$('.receiver-save-action').click(function(){
				/* $(this).attr("disabled",true);
					
					var stationCode=$(this).parent().parent().find('td .newStationCodeAddAfternoon').val();
					var uvLevel=$(this).parent().parent().find('td .newUVLevelAddAfternoon').val();
					
					var stationCodeFlag=checkStationCode(stationCode);
					if(stationCodeFlag==false){
						alert("站号:请输入5位站号!");
						$(this).attr("disabled",false);
						return false;
					}
					
					var uvLevelflag=checkUVLevel(uvLevel);
					if(uvLevelflag==false){
						alert("紫外线预报等级：请输入0-5的整数!");
						$(this).attr("disabled",false);
						return false;
					}
					
					var thisTr=$(this).parent().parent();
					
					//保存ultravioletlightforecast记录
					$.ajax({
						url : "${ctx}/base/ultravioletlightforecast/save",
					    data:{
					    	dateTime:dateTime,
					    	status:'0',
					    	fileName:fileName,
					    	stationCode:stationCode,
					    	forecastLevel:uvLevel
					    },
					    type : "POST",
					    dataType:'json',
						cache:false,
					    success : function(data){
					    	console.log(data);
					    	var html = render('#template-default-afternoon',data);
					    	thisTr.after(html);
					    	thisTr.remove();
							showTip("保存","info",2000); 
							checkUploadTip(dateTime,fileName);
					    },
					    error:function(){
					    	
					    }
					}); */
				
			})

			//取消按钮
			$('.receiver-cancel-action').unbind("click");
			$('.receiver-cancel-action').click(function(){
				$(this).parent().parent().remove();
			})
			
		}
		
		//根据时间初始化界面
		function initTimeBody(time){
			//查询当前时次ultravioletlightforecast记录
			$.ajax({
				url : "${ctx}/uvl/getUVLForecastsByDateTime",
			    data:{
			    	dateTime:dateTime
			    },
			    type : "POST",
			    dataType:'json',
				cache:false,
			    success : function(data){
			    	var html = render('#template-uvlForecastAfternoon-table', data);
					$('#position-uvlforecast-table').html(html);
					allowCheckButtons();
			    },
			    error:function(){
			    	
			    }
			});

		}
		
		//获取文件名
		function getFileName(time){
			//HT122802.URP HT122808.URP
			var prefix="HT";
			var suffix=".URP";
			var date=new Date();
			var dateStr=date.Format("MMdd");
			var fileName;
			fileName=prefix+dateStr+"08"+suffix;
			console.log(fileName);
			return fileName;
		}
		
		//获取时次
		function getDateTime(time){
			var date=new Date();
			var dateTime=date.Format("yyyyMMdd");
			dateTime+="080000";
			console.log(dateTime);
			return dateTime;
		}
		
		//返回当前时间 上午 下午
		function getTime(){
			console.log("下午");
			return "afternoon";
		}
		
		//未加载完全部元素按钮不可点击
		function initDisableButtons(){
			$('#createFile').attr("disabled",true);
			$('#upload').attr("disabled",true);
			$('#addBtn').attr("disabled",true);
		}
		
		//设置按钮可以点击
		function allowCheckButtons(){
			$('#createFile').attr("disabled",false);
			$('#upload').attr("disabled",false);
			$('#addBtn').attr("disabled",false);
		}
		
		// 对Date的扩展，将 Date 转化为指定格式的String  
		// 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，   
		// 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)   
		Date.prototype.Format = function (fmt) { //author: meizz   
		    var o = {  
		        "M+": this.getMonth() + 1, //月份   
		        "d+": this.getDate(), //日   
		        "H+": this.getHours(), //小时   
		        "m+": this.getMinutes(), //分   
		        "s+": this.getSeconds(), //秒   
		        "q+": Math.floor((this.getMonth() + 3) / 3), //季度   
		        "S": this.getMilliseconds() //毫秒   
		    };  
		    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));  
		    for (var k in o)  
		    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));  
		    return fmt;  
		}  
	</script>
	
	<!-- 下午界面 -->
	<script id="template-uvlForecastAfternoon-table" type="x-handlebars-template">
		<table class="table table-bordered">
            <thead>
                <tr>
					<th style="width:20%">站号</th>
					<th style="width:20%">紫外线预报级别</th>
						<th style="width:60%">操作</th>
				</tr>
			</thead>
			<tbody id="table-body-afternoon">
				{{#each this}}
					<tr id="template-uvlForecastAfternoon-table-item-{{id}}">
                        <td>{{stationCode}}</td>
                        <td>{{forecastLevel}}</td>	
						<td>
							<button id="btn-edit-{{id}}" class="btn btn-xs btn-primary" type="button" onclick="edit('{{id}}')">修改</button>
							<button id="btn-delete-{{id}}" class="btn btn-xs btn-danger" type="button" onclick="deletez('{{id}}')">删除</button>
						</td>
					</tr>
				{{/each}}
			</tbody>
		</table>
	</script>
	
	<!-- 添加紫外线数据记录 下午-->
   	<script id="template-add-afternoon" type="x-handlebars-template">
		<tr>
			<td><input class="newStationCodeAddAfternoon" type="text" placeholder="请输入站号"></td>
			<td><input class="newUVLevelAddAfternoon" type="text" placeholder="请输入紫外线预报级别"></td>
			<td>
				<button class="btn btn-primary btn-xs receiver-save-action"> 保存</button>
				<button class="btn btn-default btn-xs receiver-cancel-action"> 取消</button>
			</td>
		</tr>
	</script>
</body>
</html>
