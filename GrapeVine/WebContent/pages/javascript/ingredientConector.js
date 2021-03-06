// root variables
var path = "ingredient";
var url = "http://localhost:8080/GrapeVine/api/" + path;
var serverData = null;
var currentPage = 0;

function clearIds() {
  //prevent overriding existing ingredients
  document.getElementById("idIngredient").value = null;
  document.getElementById("idAllergy").value = null;
  document.getElementById("idNutrition").value = null;
  serverData = null;
  currentPage = 0;
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
  console.log("fillForm: " + JSON.stringify(ingredient));
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

  if (serverData) {
    $("#displayPage").html((currentPage + 1) + " of " + serverData.length);
  }
}

function fetchFormData() {
  //TODO change to for each in form see get function
  var allergy = new Object();
  allergy.idAllergy = $('#idAllergy').val();
  allergy.nut = $('#nut').is(':checked') ? 1 : 0;
  allergy.seafood = $('#seafood').is(':checked') ? 1 : 0;
  allergy.shellfish = $('#shellfish').is(':checked') ? 1 : 0;
  allergy.soy = $('#soy').is(':checked') ? 1 : 0;
  allergy.milk = $('#milk').is(':checked') ? 1 : 0;
  allergy.wheat = $('#wheat').is(':checked') ? 1 : 0;
  allergy.gluten = $('#gluten').is(':checked') ? 1 : 0;
  allergy.eggs = $('#eggs').is(':checked') ? 1 : 0;
  allergy.fruit = $('#fruit').is(':checked') ? 1 : 0;
  allergy.garlic = $('#garlic').is(':checked') ? 1 : 0;
  allergy.hotPeppers = $('#hotPeppers').is(':checked') ? 1 : 0;
  allergy.meat = $('#meat').is(':checked') ? 1 : 0;
  allergy.rice = $('#rice').is(':checked') ? 1 : 0;
  allergy.sesame = $('#sesame').is(':checked') ? 1 : 0;
  allergy.sulfites = $('#sulfites').is(':checked') ? 1 : 0;
  allergy.tartrazine = $('#tartrazine').is(':checked') ? 1 : 0;

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

  console.log("fetchFormData:\n" + JSON.stringify(Ingredient));
  return JSON.stringify(Ingredient);
}

function queryParamiters(url) {
  //get filled paramiters from Form
  var myForm = document.getElementById('ingredient');
  var allInputs = myForm.getElementsByTagName('input');
  url += '?'; //start query paramiter section;
  for (var i = 0; i < allInputs.length; i++) { //TODO add foreach $each;
    var input = allInputs[i];
    if (input.value != "") {
      url += input.id + '=' + input.value + '&';
    }
  }
  url.slice(0, -1); //tody last & character;
  console.log(url);
  return url;
}

function ajaxcall(method, url, data) {

  $.ajax({
    method: method,
    url: url,
    contentType: "application/json; charset=utf-8",
    data: data,
    success: function(fromServer) {
      handleResponce(fromServer);
    },
    error: function(jqXHR, textStatus, errorThrown) {
      console.log(jqXHR);
      console.log(textStatus);
      console.log('Error: ' + errorThrown);
      $("#responce").html("errorThrown");
    }
  });
}

function handleResponce(responce) {

  $("#responce").html(JSON.stringify(responce, null, 4));

  if($.isEmptyObject(responce)){
    console.log("no data returned!!!");
  }
  else{
    if(responce.constructor === [].constructor){
      console.log("returned as array");
      $("#displayPage").html("1 of " + responce.length);
      serverData = responce;
      var ingredient = serverData[0];
      fillForm(ingredient); //set first page
    }else if (responce.constructor === {}.constructor){
      console.log("returned as single instance");
      fillForm(responce);
    }else if (responce.constructor === "string".constructor){
      console.log("returned as string");
    }else{
      console.log(responce.constructor);
    }
  }
}

$(document).ready(function() {
  if (serverData == null) $(".pages").hide(); //prevent pagination showing

  // radio button on change action
  $('input[name=method]').change(function() {

    var method = $(this).val();
    if (method == "POST") {
      $(".method, .title").html("Create Ingredient"); // = "Create or Update New Ingredient";
      submitIngredient.innerText = "Save Ingredient";
      $("#pages").hide(); //test display:none;
    } else if (method == "GET") {
      $('.method.title').html("Fetch Ingredient");
      $("#submitIngredient").html("Query Ingredient");
      if (serverData != null) $("#pages").show();
    } else if (method == "PUT") {
      $(".method, .title").html("Update Ingredient"); // = "Create or Update New Ingredient";
      submitIngredient.innerText = "Change Ingredient";
      $("#pages").hide(); //test display:none;
    } else if (method == "DELETE") {
      $('.method.title').html("Delete Ingredient");
      $("#submitIngredient").html("Remove Ingredient");
      if (serverData != null) $("#pages").show();
    }
  });

  $('#submitIngredient').click(function(event) {
    event.preventDefault(); //prevents the default action

    var method = $('input[name=method]:checked').val();
    console.log(method);
    if (method == 'GET') {
      $("#pages").show();
      ajaxcall('GET', queryParamiters(url), null);
    } else if (method == "PUT") {
      $("#pages").hide();
      ajaxcall('PUT', url, fetchFormData());
    } else if (method == "POST") {
      $("#pages").hide();
      ajaxcall('POST', url, fetchFormData());
    } else if (method == "DELETE") {
      $("#pages").hide();
      ajaxcall('DELETE', url, fetchFormData());
    }

  });
});
