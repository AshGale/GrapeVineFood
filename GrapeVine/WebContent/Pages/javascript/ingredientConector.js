var serverData = null;
var currentPage = 0;

function switchLayout() {
  //change layout when switched
  var newIngredient = document.getElementById('switch').checked;

  if (newIngredient == 1) {
    IngredientTitle.innerText = "Create or Update New Ingredient";
    submitIngredient.innerText = "Save or update ingredient";
    $("#pages").slideToggle(1000);
  } else {
    IngredientTitle.innerText = "Fetch Ingredient Details From Database By Name";
    submitIngredient.innerText = "Check if ingredient exists in database";
    $("#pages").slideToggle(1000);
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

function fillForm(ingredient) {

  document.getElementById("name").value = ingredient.name;
  document.getElementById("allergy").value = ingredient.allergy;
  document.getElementById("singleWeight").value = ingredient.singleWeight;
  document.getElementById("nutritionalValue").value = ingredient.nutritionalValue;
  document.getElementById("ReadOn").value = ingredient.detailedLink;
  $("#displayPage").html((currentPage + 1) + " of " + serverData.length);
}

$(document).ready(function() {

  var path = "ingredient";
	$("#pages").slideUp(0);//revise minior visual bug

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
