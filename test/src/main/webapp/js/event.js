/**
 * 
 */
$(document).ready(function() {
	$("#selectOrg").click(function() {
		$.ajax({
			type : "POST",
			url : "http://127.0.0.1:8080/test/bill/queryOrg",
			contentType : "application/json; charset=utf-8",
			data : JSON.stringify(GetJsonData()),
			dataType : "json",
			success : function(data) {
				if (data != null) {
					if(data.orgStatus == "0"){
						alert("根据您提交的组织名称没有查询到系统对应的组织，请精确您的组织名称！");
					}else if(data.orgStatus == "1"){
						alert("根据您提交的组织名称查询查询到系统对应的组织成功！");
						$('#orgName').textbox('textbox').attr('disabled',true);  //设置输入框为禁用
						$("#orgStatus").combobox('select',"1"); 
					}else{
						alert("根据您提交的组织名称查询到系统对应的该组织有多个，请精确您的组织名称！");
					}
				}
			},
			error : function(data) {
				$("#request-process-patent").html("查询数据失败！");
			}
		});
	});
});

function GetJsonData() {
	var json = {
		"orgName" : "1",
		"orgId" : "222",
		"orgStatus" : "1",
		"billName" : "1",
		"billCode" : "1",
		"billNum" : "1",
		"execStatus" : "1"
	};
	return json;
}