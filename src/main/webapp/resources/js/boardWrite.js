/**
 * 
 */
 
 $("#btn").click(function(){
		var t = $("#title").val().length;
		var w =  $("#writer").val().length;
		
		var ch1 =false;
		var ch2=false;
		if(t!=0){
			ch1=true;
		}
		if(w!=0){
			ch2=true;
		}
		
		if(ch1&&ch2){
			$("#frm").submit();
		}else{
			alert("필수 항목을 입력하세요");
		}
		
	});