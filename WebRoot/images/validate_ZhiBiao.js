
function validateZhiBiao(){
	if(isNaN(document.getElementById("zhiBiaoYear").value)){
		alert("璇峰湪骞翠唤杈撳叆鏁存暟");
		return false;
	}
	if(isNaN(document.getElementById("score").value)){
		alert("璇峰湪鎬诲垎杈撳叆鏁存暟");
		return false;
	}
	return checkEmptyAny('addForm','zhiBiaoYear-name');
}

function validateZhiBiaoItem(){
	if(isNaN(document.getElementById("itemOrder").value)){
		alert("璇峰湪椤哄簭杈撳叆鏁存暟");
		return false;
	}
	if(isNaN(document.getElementById("itemScore").value)){
		alert("璇峰湪鍒嗗�杈撳叆鏁存暟");
		return false;
	}
	return checkEmptyAny('addForm','itemOrder-itemName');
}

function yingyong(id){
	new Ajax.Updater(id,'listZhiBiao!yingyong.action?zhiBiao.zhiBiaoId='+id);
}

function validateZhiBiaoScore(){
	var score=document.getElementById("scores");
	var ju=document.getElementById("juBoJingFei");
	if(score.value == null || score.value == ""){
		alert("1");
		return false;
	}
	if(ju.value==null || ju.value==""){
		alert("璇峰～鍐欏眬鎷ㄧ粡璐");
		return false;
	}
}
