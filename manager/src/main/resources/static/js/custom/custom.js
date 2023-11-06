var userData =
{
//    email : null,
//    userPassword : null
}
var btnVaild = true;
var FN =
{
		login : function(){
			if(btnVaild)
			{
				if(!FN.valid())
				{
					return;
				}
                userData.password = $("#userPassword").val();
                userData.email = $("#email").val();
                btnVaild = false;
                FN.dialogShow();
                FN.insert();
			}
		},
		valid : function(){
			if("" == $("#email").val().trim())
			{
				alert("이메일을 입력해 주세요");
				return false;
			}

			if("" == $("#userPassword").val().trim())
			{
				alert("비밀번호를 입력해 주세요");
				return false;
			}

			return true;
		},

		dialogShow:function(){
			var width = $(document).width();
			var height = $(document).width();

			//화면을 가리는 레이어의 사이즈 조정
			$(".backLayer").width(width);
			$(".backLayer").height(height);

			//화면을 가리는 레이어를 보여준다 (0.4초동안 30%의 농도의 투명도)
			var loadingDivObj = $("#loadingbar");
			loadingDivObj.css("margin-left", width/2);
			loadingDivObj.css("margin-top",height/2);

			$(".backLayer").fadeTo(400, 0.2);
		},

		insert : function()
		{
			FN.dialogShow();
			$.ajax( "/api/login",{
			 	type : "POST", //"POST", "GET"
				dataType :  "json", //전송받을 데이터의 타입
				data : JSON.stringify(userData),
				timeout : 20000, //제한시간 지정
			 	contentType: "application/json; charset=UTF-8",
			 	success: function(data)
			 	{
			 		console.log("success",data);
			 		if( 200 != data.response.header.statusCode)
			 		{
		 				alert(data.response.header.statusMessage);
		 				$(".backLayer").hide();
		 				btnVaild = true;
		 				return;
			 		}
			 		else{
		 			    location.href = "/monitor/dashboard.do";
		 		    }
			 	}
//			 	error: function(result, status)
//			 	{
//			 	    console.log("result error",result)
//		        	if(result.responseText)
//		        	{
//		        	    console.log("result error",result)
//		        		var response = JSON.parse(result.responseText);
//		        		//에러발생을 위한 code페이지
//		            	alert(response.response.header.statusMessage);
//		        	}
//		        	else
//		       		{
//		        		alert("수정 실패하였습니다.");
//		       		}
//		        }
			});
		}
}