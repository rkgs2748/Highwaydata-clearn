 <%@ page language="java" contentType="text/html; charset=UTF-8" 
 pageEncoding="UTF-8"%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>主页面</title>
    <link rel="stylesheet" type="text/css" href="css/basic.css" />
    <link type="text/css" rel="Stylesheet" href="css/StyleSheet.css" />    

    <style type="text/css">
        body
        {
            margin: 8px;
        }
        .sbody
        {
            margin: 0 auto;
            text-align: left;
            position:relative;
        }
        .alerttable
        {
            margin-top: 4px;
            border: 0px;
            border-spacing: 1px;
            font-size: 12px;
            background-color: #cccccc;
            width:100%;
        }
        .atitle
        {
        	font-size:23px;
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
        #begin_check{
        	font-size:25px;
        	font-weight:bold;
        }
        .sp{
        	font-size:20px;
        }
        #begin_check {    /*对submit按钮用css进行修饰 */
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
		#begin_check:hover, input#button3:focus {
    		background:-moz-radial-gradient(bottom, #656565, #404040 80%);
    		background:-webkit-gradient(radial, center bottom, 0, center 230, 250, from(#656565), to(#404040));
		}
		#begin_check:active {
    		-moz-box-shadow:0px 0px 2px #000;
    		-webkit-box-shadow:0px 0px 2px #000;
    		box-shadow:0px 0px 2px #000;
    		text-shadow:0px 0px 8px rgba(255, 255,255, 1);
		}
		#pagehead{
			width:100%;
		}
		#sub{
			position:absolute;
			left:80%;
		}
		#province{
			appearance:none;
		}
		#provinceDiv{
			position:relative;
			width:100%;
			height:100px;
		}
		#provinceLable{
		    margin-top:5px;
			font-size:22px;
			font:bold;
			color:red;
		}
		#proDiv{
			position:down;
		}
		#lalala{
			position:absolute;
			left:38%;
			font-size:13px;
			font-family: arial;
			color:#98a1a5;
		}
    </style>
</head>
<body> 
    <table cellspacing="0" cellpadding="0" border="0" width="100%" align="center" style="font-size: 13px;">
        <tr>
            <td>
                <b>位置：首页</b>
            </td>
        </tr>
        <tr>
            <td style="background: url(Images/dot.JPG)">&nbsp;
                
            </td>
        </tr>
    </table>
    <div class="sbody">
    	<div id="pagehead">
        <table class="alerttable" style="margin-top: 2px;">
            <tbody>
                <tr>
                    <td class="atitle">
                        &nbsp;&nbsp;操作引导
                    </td>
                </tr>
                <tr>
                    <td class="atd">
                        <p id="p1" runat="server">
                            <b class="sp">1.</b>
                            <span class="sp">请将待检测某类数据的json文件放至文件夹C:\test（若无该文件夹，请自行新建）；<br /></span>
                            <div style="width: 100%; height: 2px; margin: 4px auto; border-top: 1px #ccc dashed">
                        </div>
                            <b class="sp">2.</b>
                            <span class="sp">在指定目录下准备好待校验数据文件后，可以点击本页面右下方的开始校验按钮，跳转至确认接口数据界面；</span>
                            <div style="width: 100%; height: 2px; margin:4px auto; border-top: 1px #ccc dashed">
                        </div>
                            <b class="sp">3.</b>
                            <span class="sp">在确认接口数据界面点击确认校验按钮后，会显示处理的进度，当处理完成后自动跳转到结果页面。</span></p>
                            <div style="width: 100%; height:20px; margin:4px auto; border-top: 1px #ccc dashed">
                        </div>
                    </td>
                </tr>
            </tbody>
        </table>
        </div>
	</div>
    <!--  <div class="sbody">
        <table class="alerttable" style="margin-top: 2px;">
            <tbody>
                <tr>
                    <td class="atitle">
                        &nbsp;&nbsp;操作步骤图文详解
                    </td>
                </tr>
                </tbody>
        </table>
       <div style=" float:left; width:100px; height:40%;"></div>
        <div style=" width:100%; height:40%;">
        <img src="images\make.png" height=100% width=100% ></img>
        </div>
    </div> 
    <div class="sbody">
        <table class="alerttable" style="margin-top: 2px;">
            <tbody>
                <tr>
                    <td class="atitle">
                        &nbsp;&nbsp;请您选择要校验的省份
                    </td>
                </tr>
                </tbody>
        </table>-->
 <div> <br></br> </div>
 <div id="provinceDiv" align="center">
 	<div id="proDic">
    <label id="provinceLable">请选择接口数据所属省份：</label>
    <select id="province">
    	<option>未选择省份</option>
        <option>北京市</option>
        <option>天津市</option>
        <option>上海市</option>
        <option>重庆市</option>
        <option>河北省</option>
        <option>山西省</option>
        <option>辽宁省</option>
        <option>吉林省</option>
        <option>黑龙江省</option>
        <option>江苏省</option>
        <option>浙江省</option>
        <option>安徽省</option>
        <option>福建省</option>
        <option>江西省</option>
        <option>山东省</option>
        <option>河南省</option>
        <option>湖北省</option>
        <option>湖南省</option>
        <option>广东省</option>
        <option>海南省</option>
        <option>四川省</option>
        <option>贵州省</option>
        <option>云南省</option>
        <option>陕西省</option>
        <option>甘肃省</option>
        <option>青海省</option>
        <option>内蒙古自治区</option>
        <option>广西壮族自治区</option>
        <option>西藏自治区</option>
        <option>宁夏回族自治区</option>
        <option>新疆维吾尔自治区</option>
    </select>
    </div>
</div>
        	<div> <br></br> </div>
        <div id="sub">
        <form  method="post" action="TestServlet" id ="passForm"> 
    	<input type="hidden" id="sendPro" name="sendHide"></input>                      
        <input type="submit" value="开始校验" id="begin_check" onclick="chooseProvince()"/>
		</form>
		</div>
		
	
 	<div> <br></br> </div>	
  	<div id="lalala">
  		<p>Copyright&nbsp;@2017&nbsp;&nbsp;交通运输部路网监测与应急处置中心监制</p>
  	</div>
     <script type="text/javascript">
     	var htmlHeight = document.body.scrollHeight;
     	var screenHeight = window.screen.height;
     	if (htmlHeight < screenHeight){
     		htmlHeight = screenHeight;
     	}
     	document.getElementById("lalala").style.position="absolute";
     	document.getElementById("lalala").style.top=((htmlHeight*0.99-290).toString()+"px");
     	//alert(htmlHeight);
     	function chooseProvince(){
     		var sel = document.getElementById("province");
     		var choose = sel.options[sel.selectedIndex].value;
     		alert(choose + "—请确认test文件夹已放置同一类待校验数据");
     		document.getElementById("sendPro").value = choose;
     		
     	}
     </script>
</body>
</html>
