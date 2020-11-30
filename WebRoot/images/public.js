//楠岃瘉閭
function isEmail(strEmail) { 
	if (strEmail.search(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/) != -1) 	
		return true; 	
	else{	
		alert("璇疯緭鍏ユ湁鏁堥偖绠憋紒");
		return false;
		} 
} 
//楠岃瘉閭
function   checkIdcard(idcard){   
	  var   Errors=new   Array(   
	  "楠岃瘉閫氳繃!",   
	  "韬唤璇佸彿鐮佷綅鏁颁笉瀵�",   
	  "韬唤璇佸彿鐮佸嚭鐢熸棩鏈熻秴鍑鸿寖鍥存垨鍚湁闈炴硶瀛楃!",   
	  "韬唤璇佸彿鐮佹牎楠岄敊璇�",   
	  "韬唤璇佸湴鍖洪潪娉�"   
	  );   
	  var   area={11:"鍖椾含",12:"澶╂触",13:"娌冲寳",14:"灞辫タ",15:"鍐呰挋鍙",21:"杈藉畞",22:"鍚夋灄",23:"榛戦緳姹",31:"涓婃捣",32:"姹熻嫃",33:"娴欐睙",34:"瀹夊窘",35:"绂忓缓",36:"姹熻タ",37:"灞变笢",41:"娌冲崡",42:"婀栧寳",43:"婀栧崡",44:"骞夸笢",45:"骞胯タ",46:"娴峰崡",50:"閲嶅簡",51:"鍥涘窛",52:"璐靛窞",53:"浜戝崡",54:"瑗胯棌",61:"闄曡タ",62:"鐢樿們",63:"闈掓捣",64:"瀹佸",65:"xingjiang",71:"鍙版咕",81:"棣欐腐",82:"婢抽棬",91:"鍥藉"}     
	    
	  var   idcard,Y,JYM;   
	  var   S,M;   
	  var   idcard_array   =   new   Array();   
	  idcard_array   =   idcard.split("");   
	  //鍦板尯妫�獙   
	  if(area[parseInt(idcard.substr(0,2))]==null){
	  	alert(Errors[4]);
	  	return false;
	  }      
	  //韬唤鍙风爜浣嶆暟鍙婃牸寮忔楠�  
	  switch(idcard.length){   
	  case   15:   
	  if   (   (parseInt(idcard.substr(6,2))+1900)   %   4   ==   0   ||   ((parseInt(idcard.substr(6,2))+1900)   %   100   ==   0   &&   (parseInt(idcard.substr(6,2))+1900)   %   4   ==   0   )){   
	  ereg=/^[1-9][0-9]{5}[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))[0-9]{3}$/;//娴嬭瘯鍑虹敓鏃ユ湡鐨勫悎娉曟�   
	  }   else   {   
	  ereg=/^[1-9][0-9]{5}[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))[0-9]{3}$/;//娴嬭瘯鍑虹敓鏃ユ湡鐨勫悎娉曟�   
	  }   
	  if(ereg.test(idcard)){
	  	return  true;
	  }      
	  else{
	  	alert(Errors[2]);
	  	return  false;
	  }      
	  break;   
	  case   18:   
	  //18浣嶈韩浠藉彿鐮佹娴�  
	  //鍑虹敓鏃ユ湡鐨勫悎娉曟�妫�煡     
	  //闂板勾鏈堟棩:((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))   
	  //骞冲勾鏈堟棩:((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))   
	  if   (   parseInt(idcard.substr(6,4))   %   4   ==   0   ||   (parseInt(idcard.substr(6,4))   %   100   ==   0   &&   parseInt(idcard.substr(6,4))%4   ==   0   )){   
	  ereg=/^[1-9][0-9]{5}19[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))[0-9]{3}[0-9Xx]$/;//闂板勾鍑虹敓鏃ユ湡鐨勫悎娉曟�姝ｅ垯琛ㄨ揪寮�  
	  }   else   {   
	  ereg=/^[1-9][0-9]{5}19[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))[0-9]{3}[0-9Xx]$/;//骞冲勾鍑虹敓鏃ユ湡鐨勫悎娉曟�姝ｅ垯琛ㄨ揪寮�  
	  }   
	  if(ereg.test(idcard)){//娴嬭瘯鍑虹敓鏃ユ湡鐨勫悎娉曟�   
	  //璁＄畻鏍￠獙浣�  
	  S   =   (parseInt(idcard_array[0])   +   parseInt(idcard_array[10]))   *   7   
	  +   (parseInt(idcard_array[1])   +   parseInt(idcard_array[11]))   *   9   
	  +   (parseInt(idcard_array[2])   +   parseInt(idcard_array[12]))   *   10   
	  +   (parseInt(idcard_array[3])   +   parseInt(idcard_array[13]))   *   5   
	  +   (parseInt(idcard_array[4])   +   parseInt(idcard_array[14]))   *   8   
	  +   (parseInt(idcard_array[5])   +   parseInt(idcard_array[15]))   *   4   
	  +   (parseInt(idcard_array[6])   +   parseInt(idcard_array[16]))   *   2   
	  +   parseInt(idcard_array[7])   *   1     
	  +   parseInt(idcard_array[8])   *   6   
	  +   parseInt(idcard_array[9])   *   3   ;   
	  Y   =   S   %   11;   
	  M   =   "F";   
	  JYM   =   "10X98765432";   
	  M   =   JYM.substr(Y,1);//鍒ゆ柇鏍￠獙浣�  
	  if(M   ==   idcard_array[17]){
	  	 //alert(Errors[0]);   //妫�祴ID鐨勬牎楠屼綅 
	  	 return   true;  
	  }  
	  else{
	  	alert(Errors[3]);
	  	return false;
	  }        
	  }   
	  else {
	  	alert(Errors[2]);
	  	return false;
	  }   
	  break;   
	  default:   
	  	 alert(Errors[1]);
	 	 return false;   
	  break;   
	  }   
  }   
//楠岃瘉鎵嬫満鍙风爜
function isPhone(value)
{
	if(/^13\d{9}$/g.test(value)||(/^15[0-35-9]\d{8}$/g.test(value))|| (/^18[05-9]\d{8}$/g.test(value)))
		return true;
	else{
		alert("璇疯緭鍏ユ纭殑鎵嬫満鍙风爜锛");
		return false;
		}
}
//楠岃瘉鐢佃瘽鍙风爜
function isTel(tel){
        var p1 = /^(([0\+]\d{2,3}-)?(0\d{2,3})-)?(\d{7,8})(-(\d{3,}))?$/;
        var me = false;
        if (p1.test(tel))me=true;
        if (!me){
            alert('瀵逛笉璧凤紝鎮ㄨ緭鍏ョ殑鐢佃瘽鍙风爜鏈夐敊璇�鍖哄彿鍜岀數璇濆彿鐮佷箣闂磋鐢�鍒嗗壊');
            return false;
        }else
       		return true;
	
}
//楠岃瘉鏁板瓧
function isNumber(inputlabel,inputname){
  if(isNaN(inputname.value)){
  	alert("璇峰湪"+inputlabel+"杈撳叆鏁板瓧!"); 
  	inputname.removeAttribute(inputname.value);
    inputname.focus();
    return false;
  }
}
/*
 *灏嗙敵鎶ラ」鐩殑state鐢辨暟瀛楄浆涓虹姸鎬佽鍙� */
function stateNumToStr(stateNum) {
	switch (stateNum) {
	  case 0:
		return "椤圭洰鏈彁浜";
	  case 1:
		return "寰呬富绠″崟浣嶅鏍";
	  case 2:
		return "涓荤鍗曚綅閫�洖";
	  case 3:
		return "寰呯鏁欏瀹℃牳";
	  case 4:
		return "绉戞暀澶勫凡鍙楃悊";
	  case 5:
		return "绉戞暀澶勯�鍥";
	  default:
		return "鏁版嵁鍑虹幇寮傚父";
	}
}
/*
 * 鎵撳紑鏂扮獥鍙�f:閾炬帴鍦板潃 n:绐楀彛鐨勫悕绉�w:绐楀彛鐨勫搴�h:绐楀彛鐨勯珮搴�s:绐楀彛鏄惁鏈夋粴鍔ㄦ潯锛�锛氭湁婊氬姩鏉★紱0锛氭病鏈夋粴鍔ㄦ潯
 */
function openWin(f, n, w, h, s) {
	sb = s == "1" ? "1" : "0";
	l = (screen.width - w) / 2;
	t = (screen.height - h) / 2;
	sFeatures = "left=" + l + ",top=" + t + ",height=" + h + ",width=" + w + ",center=1,scrollbars=" + sb + ",status=0,directories=0,channelmode=0";
	openwin = window.open(f, n, sFeatures);
	if (!openwin.opener) {
		openwin.opener = self;
	}
	openwin.focus();
	return openwin;
}
/*
 * 鎵撳紑鍒犻櫎绐楀彛
 */
function openDeleteDialog(url, confirmString) {
	var c = confirmString;
	if (c == null || c == "") {
		c = "\u4f60\u786e\u8ba4\u8981\u5220\u9664\u8bb0\u5f55\u5417\uff1f";
	}
	if (confirm(c)) {
		/*
		 * window.showModalDialog鍐嶆鎵撳紑绐楀彛浼氭湁缂撳瓨 
		 * 瑙ｅ喅鏂规硶锛氬甫涓�釜闅忔満鐨勫弬鏁扳�鈥攖ime
		 */
		var time = new Date();
		return window.showModalDialog(url + "&time=" + time, "window123", "dialogHeight:234px;dialogWidth:271px;resizable:no;help:yes;status:no;scroll:no");
		/*return window.open(url + '&time=' + time)*/
	}
	return false;
}
/*
 * 鍒犻櫎璁板綍
 */
function del(url, info) {
	if (openDeleteDialog(url, info)) {
		window.location.reload(true);
	}
}
function openSubmitDialog(url, confirmString) {
	var c = confirmString;
	if (c == null || c == "") {
		c = "\u4f60\u786e\u8ba4\u8981\u63d0\u4ea4\u5417\uff1f";
	}
	if (confirm(c)) {
		var time = new Date();
		return window.showModalDialog(url + "&time=" + time, "window123", "dialogHeight:234px;dialogWidth:271px;resizable:no;help:yes;status:no;scroll:no");
		/*return window.open(url + '&time=' + time)*/
	}
	return false;
}
function submit(url, info) {
	if (openSubmitDialog(url, info)) {
		window.location.reload(true);
	}
}



/***************************************************
 * 鏍￠獙鏄惁鏁板瓧@auther#shu(璇锋偍涓嶈淇敼瀹冿級

 **************************************************/
function checkNumber(name, nullMsg, max_length, lengthMsg) {
	var TempS = document.getElementById(name).value;
	if (chkNumber(name, TempS) == false) {
		return false;
	}
	return chkElements(name, nullMsg, max_length, lengthMsg);
}
/*
 * 鏍￠獙鏄惁鏁板瓧
 */
function chkNumber(name, TempS) {
	for (Count = 0; Count < TempS.length; Count++) {
		TempChar = TempS.substring(Count, Count + 1);
		RefString = "0123456789.";
		if (RefString.indexOf(TempChar, 0) == -1) {
			alert("\u8bf7\u8f93\u5165\u6570\u5b57");
			document.getElementById(name).focus();
			return false;
		}
	}
	return true;
}
/***************************************************
 * 鏍￠獙鏄惁鏁存暟@auther#shu(璇锋偍涓嶈淇敼瀹冿級
 **************************************************/
function checkIntNumber(name, nullMsg, max_length, lengthMsg) {
	var TempS = document.getElementById(name).value;
	if (chkIntNumber(name, TempS) == false) {
		return false;
	}
	return chkElements(name, nullMsg, max_length, lengthMsg);
}


function chkIntNumber(name, TempS) {
	for (Count = 0; Count < TempS.length; Count++) {
		TempChar = TempS.substring(Count, Count + 1);
		RefString = "0123456789";
		if (RefString.indexOf(TempChar, 0) == -1) {
			alert("\u8bf7\u8f93\u5165\u6570\u5b57");
			document.getElementById(name).focus();
			return false;
		}
	}
	return true;
}
function chkElements(name, nullMsg, max_length, lengthMsg) {
	var el_name = document.getElementById(name);
	var v = el_name.value;
	//楠岃瘉鏄惁涓虹┖
	if (checkNullStr(name, nullMsg) == false) {
		return false;
	}
	//楠岃瘉鏈�ぇ闀垮害
	if (fucCheckLength(v) > max_length) {
		el_name.focus();
		alert(lengthMsg);
		return false;
	}
	return true;
}
function fucCheckLength(strTemp) {
	var i, sum;
	sum = 0;
	for (i = 0; i < strTemp.length; i++) {
		if ((strTemp.charCodeAt(i) >= 0) && (strTemp.charCodeAt(i) <= 255)) {
			sum = sum + 1;
		} else {
			sum = sum + 2;
		}
	}
	return sum;
}

function checkNullStr(name, msg) {
	var el_name = document.getElementById(name);
	if (Trim(el_name.value).length == 0) {
		alert(msg);
		if (el_name.disabled != true) {
			el_name.focus();
		}
		return false;
	}
	return true;
}

/************************************************
	鍒犻櫎绌烘牸@auther#shu(璇锋偍涓嶈淇敼瀹冿級
		newSbProject.jsp#chkContact@auther#shu(璇锋偍涓嶈淇敼瀹冿級
************************************************/
function chkContact(name, nullMsg, max_length, lengthMsg) {
	var el_name = document.getElementById(name);
	var v = el_name.value;
	//楠岃瘉鏄惁涓虹┖
	if (checkNullStr(name, nullMsg) == false) {
		return false;
	}
	//楠岃瘉鏈�ぇ闀垮害
	prevLength = prevLength + fucCheckLength(v);
	if (prevLength > max_length) {
		el_name.focus();
		alert(lengthMsg);
		return false;
	}
	return true;
}
/************************************************
************************************************/
/*
 * 鍘绘帀宸﹁竟绌烘牸
 */
function LTrim(str) {
	var whitespace = new String(" \t\n\r");
	var s = new String(str);
	if (whitespace.indexOf(s.charAt(0)) != -1) {
		var j = 0, i = s.length;
		while (j < i && whitespace.indexOf(s.charAt(j)) != -1) {
			j++;
		}
		s = s.substring(j, i);
	}
	return s;
}
/*
 *鍘绘帀鍙宠竟绌烘牸
 */
function RTrim(str) {
	var whitespace = new String(" \t\n\r");
	var s = new String(str);
	if (whitespace.indexOf(s.charAt(s.length - 1)) != -1) {
		var i = s.length - 1;
		while (i >= 0 && whitespace.indexOf(s.charAt(i)) != -1) {
			i--;
		}
		s = s.substring(0, i + 1);
	}
	return s;
}
/*
 *鍘绘帀涓よ竟绌烘牸
 */
function Trim(str) {
	return RTrim(LTrim(str));
}

function goback(action){
	window.location.href=action;
}

function checkAll(name){
	var flag=document.getElementsByName("flag")[0]; 
	var ob=document.getElementsByName(name);
	if(flag.checked==true)
		for(var i=0;i<ob.length;i++){
			var e=ob[i];
			if(e.checked==false)
				e.checked=true;
		}
	else
		for(var i=0;i<ob.length;i++){
			var e=ob[i];
			if(e.checked==true)
				e.checked=false;
		}
	/**/
}

var inputArray=inputnames.split("-"); 
  var inputname,inputvalue; 
  for(i=0;i<inputArray.length;i++){ 
    inputname=document.getElementById(inputArray[i]);
    inputvalue=inputname.value;
    if(inputvalue==""||inputvalue == null){
      
      inputname.focus();
      return false;
    }     
  }
  return true;
}
//鍒ゆ柇textarea涓嶈兘涓虹┖!
function checkEmptyTextArea(formname,inputnames){
 var inputArray=inputnames.split("-"); 
  var inputname,inputvalue; 
  for(i=0;i<inputArray.length;i++){ 
    inputname=eval("document."+formname+"."+inputArray[i]);
    inputvalue=inputname.innerText.length;
    if(inputvalue<=0){
      alert("璇峰～鍐欏甫*鐨勫繀濉」!"); 
      inputname.focus();
      return false;
    }     
  }
  return true;
}
//妫�祴鏄惁娴偣鏁�function checkFloat(str)

{
   if( str.match(/^-?([1-9]\d*\.\d*|0\.\d*[1-9]\d*|0?\.0+|0)$/)== null)
      return true;//闈炴诞鐐规暟
   else
      return false;//娴偣鏁�}
//寰楀埌姹夊瓙瀛楁暟
function DataLength(fData)
{
    var intLength=0
    for (var i=0;i<fData.length;i++)
    {
        if ((fData.charCodeAt(i) < 0) || (fData.charCodeAt(i) > 255))
            intLength=intLength+2
        else
            intLength=intLength+1    
    }
    return intLength
}
