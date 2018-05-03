var serverData = null;
var currentPage = 0;

function switchLayout() {
  //change layout when switched
  var newIngredient = document.getElementById('switch').checked;

  if (newIngredient == 1) {
    IngredientTitle.innerText = "Create or Update New Ingredient";
    submitIngredient.innerText = "Save or update ingredient";
    $("#pages").hide();//test display:none;
  } else {
    IngredientTitle.innerText = "Fetch Ingredient Details From Database By Name";
    submitIngredient.innerText = "Check if ingredient exists in database";
    if(serverData != null)$("#pages").show();
  }
}

/**************************pagination*****************************************/

function nextPage() {
  if (serverData == null) {

  } else {
    if (currentPage >= serverData.length) {
      //at last page
    } else {
      if (currentPage < (serverData.length - 1)) {
        currentPage++;
        var ingredient = serverData[currentPage]; //pre increment
        fillForm(ingredient);
      }
    }
  }
}

function previousPage() {
  if (serverData == null) {

  } else {
    if (currentPage >= 1) {
      currentPage--;
      var ingredient = serverData[currentPage]; //pre increment
      fillForm(ingredient);
    }
  }
}

function fillForm( ingredient) {
	console.log("fillForm: "+JSON.stringify(ingredient));
  document.getElementById("idIngredient").value = ingredient.idIngredient;
  document.getElementById("name").value = ingredient.name;
  document.getElementById("singleWeight").value = ingredient.singleWeight;
  document.getElementById("ReadOn").value = ingredient.detailedLink;
  //document.getElementById("image").value = ingredient.image;
  document.getElementById("idNutrition").value = ingredient.nutritionalValue.idNutrition;
  document.getElementById("weight").value = ingredient.nutritionalValue.weight;
  document.getElementById("energy").value = ingredient.nutritionalValue.energy;
  document.getElementById("energyJ").value = ingredient.nutritionalValue.energyJ;
  document.getElementById("protein").value = ingredient.nutritionalValue.protein;
  document.getElementById("carbohydrate").value = ingredient.nutritionalValue.carbohydrate;
  document.getElementById("sugar").value = ingredient.nutritionalValue.sugar;
  document.getElementById("fiber").value = ingredient.nutritionalValue.fiber;
  document.getElementById("fat").value = ingredient.nutritionalValue.fat;
  document.getElementById("saturatedFat").value = ingredient.nutritionalValue.saturatedFat;
  document.getElementById("cholesterol").value = ingredient.nutritionalValue.cholesterol;
  document.getElementById("calcium").value = ingredient.nutritionalValue.calcium;
  document.getElementById("iron").value = ingredient.nutritionalValue.iron;
  document.getElementById("sodium").value = ingredient.nutritionalValue.sodium;

  document.getElementById("idAllergy").value = ingredient.allergy.idAllergy;
  $('#nut').prop('checked', ingredient.allergy.nut);
  $('#seafood').prop('checked', ingredient.allergy.seafood);
  $('#shellfish').prop('checked', ingredient.allergy.shellfish);
  $('#soy').prop('checked', ingredient.allergy.soy);
  $('#milk').prop('checked', ingredient.allergy.milk);
  $('#wheat').prop('checked', ingredient.allergy.wheat);
  $('#gluten').prop('checked', ingredient.allergy.gluten);
  $('#eggs').prop('checked', ingredient.allergy.eggs);
  $('#fruit').prop('checked', ingredient.allergy.fruit);
  $('#garlic').prop('checked', ingredient.allergy.garlic);
  $('#hotPeppers').prop('checked', ingredient.allergy.hotPeppers);
  $('#meat').prop('checked', ingredient.allergy.meat);
  $('#rice').prop('checked', ingredient.allergy.rice);
  $('#sesame').prop('checked', ingredient.allergy.sesame);
  $('#sulfites').prop('checked', ingredient.allergy.sulfites);
  $('#tartrazine').prop('checked', ingredient.allergy.tartrazine);

  $("#displayPage").html((currentPage + 1) + " of " + serverData.length);
}

function fetchFormData(){
	//TODO change to for each in form see get function
	var allergy = new Object();
  allergy.idAllergy = $('#idAllergy').val();
	allergy.nut = $('#nut').is( ':checked' ) ? 1: 0;
	allergy.seafood = $('#seafood').is( ':checked' ) ? 1: 0;
	allergy.shellfish = $('#shellfish').is( ':checked' ) ? 1: 0;
	allergy.soy = $('#soy').is( ':checked' ) ? 1: 0;
	allergy.milk = $('#milk').is( ':checked' ) ? 1: 0;
	allergy.wheat = $('#wheat').is( ':checked' ) ? 1: 0;
	allergy.gluten = $('#gluten').is( ':checked' ) ? 1: 0;
	allergy.eggs = $('#eggs').is( ':checked' ) ? 1: 0;
	allergy.fruit = $('#fruit').is( ':checked' ) ? 1: 0;
	allergy.garlic = $('#garlic').is( ':checked' ) ? 1: 0;
	allergy.hotPeppers = $('#hotPeppers').is( ':checked' ) ? 1: 0;
	allergy.meat = $('#meat').is( ':checked' ) ? 1: 0;
	allergy.rice = $('#rice').is( ':checked' ) ? 1: 0;
	allergy.sesame = $('#sesame').is( ':checked' ) ? 1: 0;
	allergy.sulfites = $('#sulfites').is( ':checked' ) ? 1: 0;
	allergy.tartrazine = $('#tartrazine').is( ':checked' ) ? 1: 0;

	var nutritionalValue = new Object();
  nutritionalValue.idNutrition = $('#idNutrition').val();
	nutritionalValue.weight = $('#weight').val();
	nutritionalValue.energy = $('#energy').val();
	nutritionalValue.energyJ = $('#energyJ').val();
	nutritionalValue.protein = $('#protein').val();
	nutritionalValue.carbohydrate = $('#carbohydrate').val();
	nutritionalValue.sugar = $('#sugar').val();
	nutritionalValue.fiber = $('#fiber').val();
	nutritionalValue.fat = $('#fat').val();
	nutritionalValue.saturatedFat = $('#saturatedFat').val();
	nutritionalValue.cholesterol = $('#cholesterol').val();
	nutritionalValue.calcium = $('#calcium').val();
	nutritionalValue.iron = $('#iron').val();
	nutritionalValue.sodium = $('#sodium').val();

	var Ingredient = new Object();
	Ingredient.idIngredient = $('#idIngredient').val();
	Ingredient.name = $('#name').val();
	Ingredient.image = null; //TODO implement image selct
	Ingredient.singleWeight = $('#singleWeight').val();
	Ingredient.detailedLink = $('#ReadOn').val();
	Ingredient.allergy = allergy;
	Ingredient.nutritionalValue = nutritionalValue;

	console.log("fetchFormData"+JSON.stringify(Ingredient));
	return Ingredient;
}

$(document).ready(function() {
	if(serverData == null)$("#pages").hide();//prevent pagination showing

  var path = "ingredient";

  $('#submitIngredient').click(function(event) {
    event.preventDefault(); //prevents the default action

    var newIngredient = document.getElementById('switch').checked;

    if (newIngredient == 1) {
			$("#pages").hide();

      var data = null;
      var url = "http://localhost:8080/GrapeVine/api/" + path;
			var Ingredient = fetchFormData();
      var method ='POST';

      if(Ingredient.idIngredient != null)
      {
        method = 'PUT';
      }

      console.log("method: " + method + " id: "+Ingredient.idIngredient + "|");


			data = JSON.stringify(Ingredient);
      console.log(data);

      $.ajax({
        method: method,
        url: url,
        contentType: "application/json; charset=utf-8",
        data: data,
        success: function(data) {
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
			$("#pages").show();

      var data = null;
      var url = "http://localhost:8080/GrapeVine/api/" + path;

      //get filled paramiters from Form
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
        success: function(fromServer) {
          $("#responce").html(JSON.stringify(fromServer, null, 4));
          $("#displayPage").html("1 of " + fromServer.length);
					$("#pages").slideDown(1000);

          if (JSON.stringify(fromServer) == "[]") {
            //serber returned nothing
            $("#displayPage").html("0 of 0");
          } else {
            //TODO show pagination section
            $("#displayPage").html("1 of " + fromServer.length);
            serverData = fromServer;
            var ingredient = serverData[0];
            fillForm(ingredient) //set first page
          }

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
