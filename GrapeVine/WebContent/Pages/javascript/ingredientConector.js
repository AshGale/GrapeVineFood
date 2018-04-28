$(document).ready(function() {
	
	var path = "ingredient";
	
	//Ingredient Exist
	$('#submitIngredientExist').click(function(event) {
		event.preventDefault(); //prevents the default action

		var data = null;
		var url = "http://localhost:8080/GrapeVine/api/"+path;
		
		url += "?name=";
		url += $('#ingredientName').val();		
		
		console.log(url);

		$.ajax({
			method : "GET",
			url : url,
			contentType: "application/json; charset=utf-8",
			//data : data,
			success : function(data) {
				console.log("Responce body from Server: \n" + JSON.stringify(data));
				$("#responce").html(JSON.stringify(data, null, 4));
			},
			error : function(jqXHR, textStatus, errorThrown) {
				console.log(jqXHR);
				console.log(textStatus);
				console.log('Error: ' + errorThrown);
				$("#responce").html("errorThrown");
			}
		});
	});//END

	//New Ingredient
	$('#submitNewIngredient').click(function(event) {
		event.preventDefault(); //prevents the default action

		var data = null;
		var url = "http://localhost:8080/GrapeVine/api/"+path;
		
		var Ingredient = new Object();
		Ingredient.id = null;
		Ingredient.name = $('#name').val();
		Ingredient.allergy = $('#allergy').val();
		Ingredient.singleWeight = $('#singleWeight').val();
		Ingredient.nutritionalValue = $('#nutritionalValue').val();
		Ingredient.detailedLink = $('#ReadOn').val();
		Ingredient.image = null;	
			
		data = JSON.stringify(Ingredient);

		console.log(data);

		$.ajax({
			method : "POST",
			url : url,
			contentType: "application/json; charset=utf-8",			
			data : data,
			success : function(data) {
				console.log("Responce body from Server: \n" + JSON.stringify(data));
				$("#responce").html(JSON.stringify(data, null, 4));
			},
			error : function(jqXHR, textStatus, errorThrown) {
				console.log(jqXHR);
				console.log(textStatus);
				console.log('Error: ' + errorThrown);
				$("#responce").html("errorThrown");
			}
		});
	});//END
});
