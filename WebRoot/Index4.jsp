 <%@ page language="java" contentType="text/html; charset=UTF-8" 
 pageEncoding="UTF-8"%>
 <%@ page import="checkModule.*" %>

 <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>主页面</title>
    <link rel="stylesheet" type="text/css" href="css/basic.css" />
    <link type="text/css" rel="Stylesheet" href="css/StyleSheet.css" /> 
    <script type="text/javascript" src="js/jquery-1.8.0.js"></script>

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
            height: 24px;
            text-align: left;
            font-weight: bold;
            background: url(images/titleback_2.jpg);
        }
        .atd
        {
            line-height: 40px;
            text-align: left;
            font-size:24px;
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
        #result_progress{
        	width:1080px;
        }
        #progress{
        	position:absolute;
        	left:45%;
        }
        #begin_check1{
        	position:absolute;
        	left:80%;
        	font-size:25px;
        	font-weight:bold;
        }
        #result_total{
        	font-size:23px;
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
    		width:100px;
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
    <table cellspacing="0" cellpadding="0" border="0" width="100%" align="center" style="font-size: 13px;">
        <tr>
            <td>
               <b>位置：校验结果</b>
            </td>
        </tr>
        <tr>
            <td style="background: url(Images/dot.JPG)">&nbsp;
                
            </td>
        </tr>
    </table>
    <table class="alerttable">
            <tbody>
                <tr>
                    <td class="atitle" id="result_total">
                        &nbsp;&nbsp;校验汇总结果
                    </td>
                </tr>
                <tr>
                    <td class="atd" id="sum_check">
                    	*校验数据的文件总数：
                    </td>
                    
                </tr>
                <tr>
                    <td class="atd" id="sum_record">
                    	*校验错误的记录数目：
                    </td>
                    
                </tr>
                 <tr>
                    <td class="atd" id="sum_parse">
                        *校验错误的字段数：
                    </td>
                    
                </tr>

            </tbody>
        </table>
        <!-- <div class="sbody">
        <table class="alerttable" style="margin-top: 2px;">
            <tbody>
                <tr>
                    <td class="atitle">
                        &nbsp;&nbsp;校验详细结果
                    </td>
                </tr>
                <tr>
                    <td class="atd">
                    <style type="text/css">b{font-weight:normal} span{padding-left:70px}</style>
                        <p id="p1" runat="server">
                            <b>基础信息：</b><br />
                            <span style="text-indent:10px"> 校验错误的记录数目：</span><br />
                            <span>校验错误的字段数：</span><br /></p>
                            <div style="width: 100%; height: 2px; margin: 4px auto; border-top: 1px #ccc dashed">
                        </div>
                        <p id="p2" runat="server">
                            <b>交易信息：</b><br />
                            <span> 校验错误的记录数目：</span><br />
                            <span>校验错误的字段数：</span><br /></p>
                            <div style="width: 100%; height: 2px; margin: 4px auto; border-top: 1px #ccc dashed">
                        </div>
                        <p id="p3" runat="server">
                            <b>跨省交易数据：</b><br />
                            <span> 校验错误的记录数目：</span><br />
                            <span>校验错误的字段数：</span><br /></p>
                            <div style="width: 100%; height: 2px; margin: 4px auto; border-top: 1px #ccc dashed">
                        </div>
                    </td>
                </tr>
            </tbody>
        </table>
         -->
         	<div> <br></br> </div>
         <div>
        <form  method="post" action="returnManage" id ="passForm1"> 
        <input type="submit" value="返  回" id="begin_check1" />
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
     	document.getElementById("lalala").style.top=((htmlHeight*0.99-290).toString()+"px");	
     	//alert(htmlHeight);
        	display_results();
        	function display_results(){
        	<%
        		String sum_total = (String)request.getAttribute("sum_total");
        		String sum_record_num = (String)request.getAttribute("result_total");
        		String sum_parse_num = (String)request.getAttribute("result_parse");
//            	String file_path_record = (String)request.getAttribute("result_path");
//            	String file_path_record1 = file_path_record.replaceAll("\\\\","\\\\\\\\");
            	//System.out.println("pppppp----" + file_path_record1);
			%>
				var test0 = "<%=sum_total%>";
				var test1 = "<%=sum_record_num%>";
				var test2 = "<%=sum_parse_num%>";
				<%--var test3 = "<%=file_path_record1%>";--%>
				//alert("校验结果文件存放于:"+test3);
        		$("#sum_check").html(" *校验数据的文件总数：" + test0);
        		$("#sum_record").html(" *校验错误的记录数目：" + test1);
        		$("#sum_parse").html(" *校验错误的字段数：" + test2);
        		// $("#file_path").html(" *校验结果文件路径：" + test3);
        		
        	}
        	
        </script>
    
</body>
</html>
