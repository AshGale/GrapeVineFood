$(document).ready(function() {

	//Create Profile
	$('#submitLogin').click(function(event) {
		event.preventDefault(); //prevents the default action

		//var operation = "POST";
		//var url = "http://localhost:8080/GrapeVine/api/profile";
		//var messageFormat ="application/json; charset=utf-8";
		var data = null;
		var url = "http://localhost:8080/GrapeVine/api/profile/0?username=";
		
		url += $('#loginUserName').val();
		
		console.log(url);

		$.ajax({
			method : "GET",
			url : url,
			contentType: "application/json; charset=utf-8",
			//data : data,
			success : function(data) {
				console.log("Responce body from Server: \n" + JSON.stringify(data));
				//window.alert("ok");
			},
			error : function(jqXHR, textStatus, errorThrown) {
				console.log(jqXHR);
				console.log(textStatus);
				console.log('Error: ' + errorThrown);
				$("#responce").html("errorThrown");
			}
		});
	});//END $('#submitForm').click(function() {

	//Create Profile
	$('#submitRegister').click(function(event) {
		event.preventDefault(); //prevents the default action

		//var operation = "POST";
		//var url = "http://localhost:8080/GrapeVine/api/profile";
		//var messageFormat ="application/json; charset=utf-8";
		var data = null;
		
		var profile = new Object();
		profile.id = null;
		profile.role = null;
		profile.name = null;
		profile.userName = $('#userName').val();
		profile.email = $('#email').val();
		profile.password = $('#password').val();
		profile.allergys = null;
		profile.preferances = null;
		profile.dislikes = null;
		profile.diet = null;
		profile.defaultLocation =$('#usualCity').val();
		
		
		data = JSON.stringify(profile);

		console.log(data);

		$.ajax({
			method : "POST",
			url : "http://localhost:8080/GrapeVine/api/profile",
			contentType: "application/json; charset=utf-8",			
			data : data,
			success : function(data) {
				console.log("Responce body from Server: \n" + JSON.stringify(data));
				//window.alert("ok");
			},
			error : function(jqXHR, textStatus, errorThrown) {
				console.log(jqXHR);
				console.log(textStatus);
				console.log('Error: ' + errorThrown);
				$("#responce").html("errorThrown");
			}
		});
	});//END $('#submitForm').click(function() {
});
