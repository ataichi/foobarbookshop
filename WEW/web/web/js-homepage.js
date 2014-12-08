		$(document).ready(function() {
			var x=0;
			$('body').css({"background-image":"url('./images/bg.png')"});
		
			$('#bgImg').css({"height":"400px", "width":"700px", 
				"margin-top":"10px", "margin-left":"10px", "margin-top":"30px",
				"border-color":"pink", "border-style":"solid", "border-width":"5px"
				});
			
			$('#title').css({"background":"#FD97BE","font-family":"forte", "font-size":"80px", 
							"color":"white", "margin":"-10px", "height":"100px"
			});
			
			$('#1').mouseover(function () {
				$('#bgImg').fadeIn(1000);
				$('#bgImg').attr('src', 'images/bg1.jpg');
			});
			
			$('#2').mouseover(function () {
				$('#bgImg').fadeIn(1000);
				$('#bgImg').attr('src', 'images/bg2.jpg');
			});
			
			$('#3').mouseover(function () {
				$('#bgImg').fadeIn(1000);
				$('#bgImg').attr('src', 'images/bg3.jpg');
				
			});
			
			$('td').css({"height":"20px", "width":"150px", "font-family":"Corbel", "font-size":"20px",
			});
				
			$('input').css({"font-family":"Corbel", "font-size":"20px"});
			
			$('#member').css({"margin-top":"-350px", "margin-left":"750px", "margin-right":"10px",
							"font-family":"Georgia", "font-size":"30px", "background":"mistyrose",
							"color":"purple"
			});
			
			$('#loginbutton').mouseover(function() {
				$('#loginform').slideDown("slow")
								.css({"text-align":"center", "background":"mistyrose", "margin-left":"50px",
									"margin-right":"10px"})
								.mouseleave(function() {
									$('#loginform').slideUp();
									$('#loginbutton').val("login"); })
				$('#loginbutton').val("");
			});
			
			$('#login').css({"padding-left":"20px", "padding-top":"20px", "padding-right":"20px"});
			$('#signup').css({"padding":"20px"});
			
			$('#signupbutton').mouseover(function() {
				$('#signupform').slideDown("slow")
								.css({"text-align":"center", "background":"mistyrose", "margin-left":"50px",
									"margin-right":"10px"})
								.mouseleave(function() {
									$('#signupform').slideUp(); 
									$('#signupbutton').val("signup"); })
				$('#signupbutton').val("");
			});
			
		}); //end of ready
