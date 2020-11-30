// JScript 文件
function Switch(obj,objNum){
  var mainDiv = $("#main" + obj);
  var subDiv = $("#sub" + obj);
  
  if(subDiv.css("display") == "none")
  {
      subDiv.css("display","block");
  }else{
      subDiv.css("display","none");
  }
}
