 <%@ page language="java" contentType="text/html; charset=UTF-8" 
 pageEncoding="UTF-8"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script type="text/javascript" language="JavaScript">   
  function clock()   
  {   
    now=new Date();  
    document.clock.date.value =now.getFullYear()  + "年" + (now.getMonth() + 1) + "月" + now.getDate() + "日"   ;
  }   
</script>
<style type="text/css">
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.STYLE1 {
	font-size: 12px;
	color: #000000;
}

.STYLE5 {
	font-size: 12
}

.STYLE7 {
	font-size: 12px;
	color: black;
	font-weight: bold;
}

.current{
	color:white;
	text-decoration:none;
}
#title{
	position:absolute;
	left:37%;
	font-size:30px;
	font:bold;
	color:white;
	font-family: "Arial","Microsoft YaHei","宋体",sans-serif;
}
#version{
	position:absolute;
	left:90%;
	font-size:14px;
	color:white;
	font-family: "Arial","Microsoft YaHei","宋体",sans-serif;
}
#NowUser{
	text-decoration:none;	
	color:#0082CD
	}
</style>
  <script type="text/javascript">
    function loginout() {
        window.parent.location.href = "loginUser!logout.action";
    }
  </script>
	</head>
	<body onload="clock()">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			
			<tbody><tr>
				<td height="57" background="images/main_03.gif">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tbody><tr>
							<td>&nbsp;
								<span id="title">数据合规性省内自测工具</span>
								<span id="version">当前版本：1.1.3</span>
							</td>
							<td width="281" valign="bottom">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tbody>
								</tbody></table>
							</td>
						</tr>
					</tbody></table>
				</td>
			</tr>
			<tr>
				<td height="40" background="images/main_10.gif">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tbody><tr>
							<td width="194" height="40" background="images/main_07.jpg">&nbsp; 
							</td>
							<td>
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tbody><tr>
									    <td width="80" class="STYLE7">
										 &nbsp		 
										</td> 
									</tr>
								</tbody></table>
							</td>
							<td width="248" background="images/main_11.gif">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tbody><tr>
										<td width="16%">
											<span class="STYLE5"></span>
										</td>
										<td width="77%" align="center">
										   <form style="display: inline" class="STYLE7" name="clock">
										   <font color="white">今天是 <input style="width:90px" class="STYLE7" type="text" style="border: 0px" name="date" size="8" value="" disabled="disabled"> 
										</font></form></td>
										<td width="7%">&nbsp;
											
										</td>
									</tr>
								</tbody></table>
							</td>
						</tr>
					</tbody></table>
				</td>
			</tr>
			<tr>
				<td height="30" background="images/main_31.gif">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tbody><tr>
							<td width="8" height="30">
								<img src="images/main_28.gif" width="8" height="30">
							</td>
							<td width="147" background="images/main_29.gif">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tbody><tr>
										<td width="24%">&nbsp;
											
										</td>
										<td width="43%" height="20" valign="bottom" class="STYLE1">
											管理菜单
										</td>
										<td width="33%">&nbsp;
											
										</td>
									</tr>
								</tbody></table>
							</td>
							<td>
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tbody>
									<tr>
										<td valign="bottom" class="STYLE1">
											<div align="right">
									
											</div>
										</td>
									</tr>
								</tbody></table>
							</td>
							<td width="17">
								<img src="images/main_32.gif" width="17" height="30">
							</td>
						</tr>
					</tbody></table>
				</td>
			</tr>
		</tbody></table>


</body></html>
