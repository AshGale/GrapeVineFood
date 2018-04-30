function switchLayout() {
	//change layout when switched
	var newIngredient = document.getElementById('switch').checked;

	if (newIngredient == 1) {
		IngredientTitle.innerText = "Create or Update New Ingredient";
		submitIngredient.innerText = "Save or update ingredient";
	} else {
		IngredientTitle.innerText = "Fetch Ingredient Details From Database By Name";
		submitIngredient.innerText = "Check if ingredient exists in database";
	}
}

$(document).ready(function() {

  var path = "ingredient";

  $('#submitIngredient').click(function(event) {
				event.preventDefault(); //prevents the default action
				
      var newIngredient = document.getElementById('switch').checked;
				
      if (newIngredient == 1) {
        var data = null;
        var url = "http://localhost:8080/GrapeVine/api/" + path;

        var Ingredient = new Object();
        Ingredient.id = null;
        Ingredient.name = $('#name').val();
        Ingredient.allergy = $('#allergy').val();
        Ingredient.singleWeight = $('#singleWeight').val();
        Ingredient.nutritionalValue = $('#nutritionalValue').val();
        Ingredient.detailedLink = $('#ReadOn').val();
        Ingredient.image = null; //TODO implement image selct

        data = JSON.stringify(Ingredient);

        console.log(data);

        $.ajax({
          method: "POST",
          url: url,
          contentType: "application/json; charset=utf-8",
          data: data,
          success: function(data) {
            console.log("Responce body from Server: \n" + JSON.stringify(data));
            $("#responce").html(JSON.stringify(data, null, 4));
          },
          error: function(jqXHR, textStatus, errorThrown) {
            console.log(jqXHR);
            console.log(textStatus);
            console.log('Error: ' + errorThrown);
            $("#responce").html("errorThrown");
          }
        });
      } else { //if get

        var data = null;
        var url = "http://localhost:8080/GrapeVine/api/" + path;

        //get
        var myForm = document.getElementById('ingredient');
        var allInputs = myForm.getElementsByTagName('input');
        url += '?';
        for (var i = 0; i < allInputs.length; i++) {
          var input = allInputs[i];
          if (input.value != "") {
              url += input.id + '=' + input.value + '&';
           }
        }
        console.log(url); //TODO tidy last &;

        $.ajax({
          method: "GET",
          url: url,
          contentType: "application/json; charset=utf-8",
          //data : data,
          success: function(data) {
            console.log("Responce body from Server: \n" + JSON.stringify(data));
            $("#responce").html(JSON.stringify(data, null, 4));
          },
          error: function(jqXHR, textStatus, errorThrown) {
            console.log(jqXHR);
            console.log(textStatus);
            console.log('Error: ' + errorThrown);
            $("#responce").html("errorThrown");
          }
        });
      }
    });
});
