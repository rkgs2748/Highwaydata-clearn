 <%@ page language="java" contentType="text/html; charset=UTF-8" 
 pageEncoding="UTF-8"%> 
<%@ page import="checkModule.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
	<base href="<%=basePath%>">
    <title>主页面</title>
    <link rel="stylesheet" type="text/css" href="css/basic.css" />
    <link type="text/css" rel="Stylesheet" href="css/StyleSheet.css" />   
     <link rel="stylesheet" type="text/css" href="js/themes/default/easyui.css">   
	<link rel="stylesheet" type="text/css" href="js/icon.css">
 	<link rel="stylesheet" type="text/css" href="js/demo.css">
 	<script type="text/javascript" src="js/jquery.min.js"></script>
 	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>  
    <style type="text/css">
        body
        {
            margin: 8px;
        }
        .sbody
        {
            margin: 0 auto;
            text-align: left;
        }
        .alerttable
        {
            width: 98%;
            margin-top: 4px;
            border: 0px;
            border-spacing: 1px;
            font-size: 12px;
            background-color: #cccccc;
        }
        
		#lalala{
			position:absolute;
			left:38%;
			font-size:13px;
			font-family: arial;
			color:#98a1a5;
		}
        .atitle
        {
            height: 23px;
            text-align: left;
            font-weight: bold;
            background: url(images/titleback_2.jpg);
        }
        .atd
        {
            line-height: 24px;
            text-align: left;
            background-color: #ffffff;
        }
        .atd p
        {
            margin: 0 auto;
        }
        .atd b
        {
            color: #333;
            margin-left: 15px;
        }
        .red
        {
            color: Red;
            font-weight: bold;
        }
        .grey
        {
            color: #aaa;
        }
        .dShen
        {
            color: #e50000;
        }
        .download
        {
            color: #eb7350;
        }
        #begin_check1{
        	position:absolute;
        	left:75%;
        	font-size:25px;
        	font-weight:bold;
        }
        .sp{
        	color:red;
        	font-size:20px;
        }
        #begin_check{
        	position:absolute;
        	left:80%;
        	font-size:25px;
        	font-weight:bold;
        }
        .sp{
        	font-size:20px;
        }
        #begin_check1 {
    		/* General Properties */
    		height:34px;
    		width:130px;
    		border:1px solid #494949;
    		background:#034895;
    		/* CSS3 Styling */
    		background:-moz-radial-gradient(bottom, #656565, #404040 60%);
    		background:-webkit-gradient(radial, center bottom, 0, center 230, 230, from(#656565), to(#404040));
    		-moz-border-radius:3px;
    		-webkit-border-radius:3px;
    		border-radius:3px;
    		-moz-box-shadow:0px 0px 3px #000;
    		-webkit-box-shadow:0px 0px 3px #000;
    		box-shadow:0px 0px 3px #000;
    		/* Text Styling */
    		color:#fff;
    		text-shadow:0px 0px 5px rgba(255, 255,255, 0.5);
    		font-family:'NotethisRegular', Verdana, Arial;
    		font-size:24px;
    		padding-top:1px;
		}
		/* Pseudo-classes for interactivity */
		#begin_check1:hover, input#button3:focus {
    		background:-moz-radial-gradient(bottom, #656565, #404040 80%);
    		background:-webkit-gradient(radial, center bottom, 0, center 230, 250, from(#656565), to(#404040));
		}
		#begin_check1:active {
    		-moz-box-shadow:0px 0px 2px #000;
    		-webkit-box-shadow:0px 0px 2px #000;
    		box-shadow:0px 0px 2px #000;
    		text-shadow:0px 0px 8px rgba(255, 255,255, 1);
		}
    </style>
</head>
<body>
<form  method="post" action="testChooseOption" id ="passForm1" onsubmit="set_progress()" >
     <table cellspacing="0" cellpadding="0" border="0" width="100%" align="center" style="font-size: 13px;">
        <tr>
            <td>
                <b>位置：确认接口数据</b>
            </td>
        </tr>
        <tr>
            <td style="background: url(Images/dot.JPG)">&nbsp;
                
            </td>
        </tr>
    </table>
    <span class="sp">注意：已勾选的待校验接口类型是从test文件夹中解析出的，对于超出以下范围或非单类的接口数据，不允许进行操作，请确认要校验的接口数据。</span>
     <div id="div_progress" >
     <table class="alerttable" style="margin-top: 2px; width="100%"; display:none" id="table_progress">
            <tbody>
                <tr>
                    <td class="atitle" width="100%">
                        &nbsp;校验状态
                    </td>
                </tr>
                <tr>
                    <td class="atd">
                            <label id="progress_label"> &nbsp;校验进度：</label>
                            <div id="p" class="easyui-progressbar" style="width:100%; color:#00008B; display:none;"></div>
                        
                    </td>
                </tr>
            </tbody>
        </table> 
     </div>
     
    <div class="sbody">
        <table class="alerttable" style="margin-top: 2px;">
            <tbody>
                <tr>
                    <td class="atitle">
                        &nbsp;待校验的接口数据
                    </td>
                </tr>
                <tr>
                    <td class="atd">
                        <div class="content">
                               <div>
                                    <div class="layer_setup_followlists follow_success" style="width: 100%">
                                    <style type="text/css">#Div3,#Div4,#Div5{float:left} </style>
                                        <div id="Div3" class="lsfl_listsBox" style="width:30%;height:370px; background: #f7f7f7; overflow-y: scroll;padding-left: 3%;">
                                            
                                            <p style="margin-top:5px;"> <b>基础数据 </b></p>
                                                <p><input type="checkbox" name="checkbox1" id="1_1" value="1_1" /><label>发行方信息上传及变更</label></p>
                                                <p><input type="checkbox" name="checkbox1" id="1_2" value="1_2" /><label>客服合作机构上传及变更</label></p>
                                                <p><input type="checkbox" name="checkbox1" id="1_3" value="1_3" /><label>服务网点信息上传及变更</label></p>
                                                <p><input type="checkbox" name="checkbox1" id="1_4" value="1_4" /><label for="">流动服务网点信息上传及变更</label></p>
                                                <p><input type="checkbox" name="checkbox1" id="1_5" value="1_5" /><label for="">自助服务终端信息上传及变更</label></p>
                                                <p><input type="checkbox" name="checkbox1" id="1_6" value="1_6" /><label for="">线上服务渠道信息上传及变更</label></p>
                                                <p><input type="checkbox" name="checkbox1" id="1_7" value="1_7" /><label for="">车牌唯一性验证</label></p>
                                                <p><input type="checkbox" name="checkbox1" id="1_8" value="1_8" /><label for="">客户信息上传及变更</label></p>
                                                <p><input type="checkbox" name="checkbox1" id="1_9" value="1_9" /><label for="">客户车辆信息上传及变更</label></p>
                                                <p><input type="checkbox" name="checkbox1" id="1_10" value="1_10" /><label for="">用户卡信息上传及变更</label></p>
                                                <p><input type="checkbox" name="checkbox1" id="1_11" value="1_11" /><label for="">用户卡帐余额上传</label></p>
                                                <p><input type="checkbox" name="checkbox1" id="1_12" value="1_12" /><label for="">OBU信息上传及变更</label></p>
                                                <p><input type="checkbox" name="checkbox1" id="1_13" value="1_13" /><label for="">用户卡黑名单上传及变更</label></p>
                                                <p><input type="checkbox" name="checkbox1" id="1_14" value="1_14" /><label for="">OBU黑名单上传及变更</label></p>
                                                <p><input type="checkbox" name="checkbox1" id="1_15" value="1_15" /><label for="">收费公路经营管理单位信息上传及变更</label></p>
                                                <p><input type="checkbox" name="checkbox1" id="1_16" value="1_16" /><label for="">收费公路上传及变更</label></p>
                                                <p><input type="checkbox" name="checkbox1" id="1_17" value="1_17" /><label for="">收费路段上传及变更</label></p>
                                                <p><input type="checkbox" name="checkbox1" id="1_18" value="1_18" /><label for="">收费站上传及变更</label></p>
                                                <p><input type="checkbox" name="checkbox1" id="1_19" value="1_19" /><label for="">收费广场上传及变更</label></p>
                                                <p><input type="checkbox" name="checkbox1" id="1_20" value="1_20" /><label for=""></label>收费车道上传及变更</p>
                                        </div>
                                        <div id="Div4" class="lsfl_listsBox" style="width:30%;height: 370px; background: #f7f7f7; overflow-y: scroll;
                                            padding-left: 3%;">
                                            
                                            <p style="margin-top:5px;"> <b>交易数据 </b></p>
                                                <p><input type="checkbox" name="checkbox1" id="2_1" value="2_1" /><label>入口交易信息上传</label></p>
                                                <p><input type="checkbox" name="checkbox1" id="2_2" value="2_2" /><label>出口交易信息上传</label></p>
                                                <p><input type="checkbox" name="checkbox1" id="2_3" value="2_3" /><label>充值交易上传</label></p>
                                                <p><input type="checkbox" name="checkbox1" id="2_4" value="2_4" /><label>冲正交易上传</label></p>
                                                <p><input type="checkbox" name="checkbox1" id="2_5" value="2_5" /><label>退费交易上传</label></p>
                                                <p><input type="checkbox" name="checkbox1" id="2_6" value="2_6" /><label>非现金补交交易上传</label></p>
                                                <p><input type="checkbox" name="checkbox1" id="2_7" value="2_7" /><label>其他补交交易上传</label></p>
                                                <p><input type="checkbox" name="checkbox1" id="2_8" value="2_8" /><label>退费补交交易拆分指令</label></p>
                                                <p><input type="checkbox" name="checkbox1" id="2_9" value="2_9" /><label>退款交易上传</label></p>
                                        </div>
                                        <div id="Div5" class="lsfl_listsBox" style="width:30%;height: 370px; background: #f7f7f7; overflow-y: scroll;
                                            padding-left: 3%;">
                                            
                                            <p style="margin-top:5px;"><b>跨省清分数据</b></p>
                                                <p><input type="checkbox" name="checkbox1" id="3_1" value="3_1" /><label>跨省交易上传</label></p>
                                                <p><input type="checkbox" name="checkbox1" id="3_2" value="3_2" /><label>记账交易上传</label></p>
                                        </div>
                                    </div> 
                                </div> 
                                <!--inner -->
                            </div>
                       
                    </td>
                </tr>
            </tbody>
        </table>
        
    </div>

    <div><input type="submit" value="确认校验" id="begin_check1" class="send"/></div>
    
  	<div id="lalala">
  		<p>Copyright&nbsp;@2017&nbsp;&nbsp;交通运输部路网监测与应急处置中心监制</p>
  	</div>
	</form>
    <script type="text/javascript">
     	var htmlHeight = document.body.scrollHeight;
     	var screenHeight = window.screen.height;
     	if (htmlHeight < screenHeight){
     		htmlHeight = screenHeight;
     	}
     	document.getElementById("lalala").style.top=((htmlHeight*0.99-270).toString()+"px");
     	//alert(htmlHeight);
     	
    	set_option();
		function array_contain(all_array,wait_string){
    		for (var i=0;i<all_array.length;i++) {
    			if (all_array[i] == wait_string){
    				return true;
    			}
    		}
    		return false;
    	}
		function set_option(){
		    <% 
		    String init=(String)request.getAttribute("wait_check_option"); 
		    %>
    		var all_choose_option = new Array("1_1","1_2","1_3","1_4","1_5","1_6","1_7","1_8","1_9",
		    	"1_10","1_11","1_12","1_13","1_14","1_15","1_16","1_17",
		    	"1_18","1_19","1_20",
				"2_1","2_2","2_3","2_4","2_5","2_6","2_7","2_8","2_9",
				"3_1","3_2");
    		var init_str = "<%=init%>";
    		
    		//alert(init_str);
    		if (init_str == "NONE"){
    			alert("待校验文件尚未放入指定文件夹中");
    			window.history.back(-1);
    		}
    		else{
    			split_init_str = init_str.split(",");
    			for (var i=0;i<all_choose_option.length;i++) {
    				var begin_set_checkbox = document.getElementById(all_choose_option[i]);
    				if (array_contain(split_init_str,all_choose_option[i])){
    					begin_set_checkbox.checked = true;
    				}
    				else{
    					begin_set_checkbox.disabled = true;
    				}
    			}
    		}
		}
		
    	var timerId;
    	function set_progress(){
    		//var subButton = doucument.getElementById("begin_check1");
    		//subButton.style.display='none';
    		$('#begin_check1').attr('disabled', true);
 			//每隔n秒自动调用方法，实现进度条的实时更新
			timerId=window.setInterval(getForm,50);
			document.getElementById("p").style.display = "block";
			document.getElementById("table_progress").style.display = "block";
			}
 
 		function getForm(){
 		//alert("here");
	   	//使用JQuery从后台获取JSON格式的数据
	   		$.ajax({
	    		type:"post",//请求方式
	    		url:"ProgressBarServlet",//发送请求地址
	    		timeout:10000,//超时时间
	    		dataType:"json",//设置返回数据的格式
	    		//请求成功后的回调函数 data为json格式
	    		success:function(data){
	     			if(data.progressValue>=100){
	     				//alert(data.progressValue);
	     				window.clearInterval(timerId);
	     				window.location.href="RedirectServlet";	      					      				
	     			}
	     		$('#p').progressbar('setValue',data.progressValue);
	    		},
	    		//请求出错的处理
	    		error:function(){
	     			//window.clearInterval(timerId);
	     			alert("正在校验中，请耐心等待，关注后台运行情况");
	    		}
	   		});
	 	}
    	
    	
    	
    </script>
 
</body>
</html>
