/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function(){
   $('#signupform_productmanager').css({
       "position":"center",
       "backgroud-color":"bisque",
       "margin-top":"100px",
       "margin-left":"300px"
   }); 
   $('#signupform_accountingmanager').css({
       "position":"center",
       "backgroud-color":"bisque",
       "margin-top":"100px",
       "margin-left":"20px"
   }); 
});
function logcheck() {
    var user = usernameCheck();
    var pass = passwordCheck();
    if (user == false || pass == false) {
        return false;
    }
    else {
        return true;
    }
}

function signcheck() {
    var first = fnameCheck();
    var middle = mnameCheck();
    var last = lnameCheck();
    var user = unameCheck();
    var email = emailCheck();
    var pass = passCheck();

    if (first == false || last == false || middle == false || user == false || email == false || pass == false) {
        return false;
    }
    else {
        return true;
    }
}

function fnameCheck() {
    var first = document.forms["signin"]["fname"].value;
    if (first == "" || first == null || !(/^[A-z ]+$/.test(first))) {
        document.forms["signin"]["fname"].style.backgroundColor = "pink";
        return false;
    }
    else {
        document.forms["signin"]["fname"].style.backgroundColor = "white";
        return true;
    }
}

function mnameCheck() {
    var middle = document.forms["signin"]["mname"].value;
    if (middle == "" || middle == null || !(/^[A-z ]+$/.test(middle))) {
        document.forms["signin"]["mname"].style.backgroundColor = "pink";
        return false;
    }
    else {
        document.forms["signin"]["mname"].style.backgroundColor = "white";
        return true;
    }
}

function lnameCheck() {
    var last = document.forms["signin"]["lname"].value;
    if (last == "" || last == null || !(/^[A-z ]+$/.test(last))) {
        document.forms["signin"]["lname"].style.backgroundColor = "pink";
        return false;
    }
    else {
        document.forms["signin"]["lname"].style.backgroundColor = "white";
        return true;
    }
}

function unameCheck() {
    var user = document.forms["signin"]["uname"].value;
    if (user == "" || user == null) {
        document.forms["signin"]["uname"].style.backgroundColor = "pink";
        return false;
    }
    else {
        document.forms["signin"]["uname"].style.backgroundColor = "white";
        return true;
    }
}

function emailCheck() {
    var email = document.forms["signin"]["email"].value;
    var atpos = email.indexOf("@");
    var dotpos = email.lastIndexOf(".");
    if (email == "" || email == null || atpos < 1 || dotpos < atpos + 2 || dotpos + 2 >= email.length) {
        document.forms["signin"]["email"].style.backgroundColor = "pink";
        return false;
    }
    else {
        document.forms["signin"]["email"].style.backgroundColor = "white";
        return true;
    }
}

function passCheck() {
    var pass1 = document.forms["signin"]["pass1"].value;
    var pass2 = document.forms["signin"]["pass2"].value;
    if (pass1 == "" || pass1 == null || pass2 == "" || pass2 == null || pass1 != pass2) {
        document.forms["signin"]["pass1"].style.backgroundColor = "pink";
        document.forms["signin"]["pass2"].style.backgroundColor = "pink";
        return false;
    }
    else {
        document.forms["signin"]["pass1"].style.backgroundColor = "white";
        document.forms["signin"]["pass2"].style.backgroundColor = "white";
        return true;
    }
}

function apartmentnoBACheck() {
    var aptnoBA = document.forms["signin"]["apartmentnoBA"].value;
    if (aptnoBA == "" || aptnoBA == null) { //kulang pa ng pag check kung digit
        document.forms["signin"]["apartmentnoBA"].style.backgroundColor = "pink";
        return false;
    }
    else {
        document.forms["signin"]["apartmentnoBA"].style.backgroundColor = "white";
        return true;
    }
}

function streetBACheck() {
    var streetBA = document.forms["signin"]["streetBA"].value;
    if (streetBA == "" || streetBA == null || !(/^[A-z ]+$/.test(streetBA))) {
        document.forms["signin"]["streetBA"].style.backgroundColor = "pink";
        return false;
    }
    else {
        document.forms["signin"]["streetBA"].style.backgroundColor = "white";
        return true;
    }
}

function subdivisionBACheck() {
    var subBA = document.forms["signin"]["subdivisionBA"].value;
    if (subBA == "" || subBA == null || !(/^[A-z ]+$/.test(subBA))) {
        document.forms["signin"]["subdivisionBA"].style.backgroundColor = "pink";
    }
    else {
        document.forms["signin"]["subdivisionBA"].style.backgroundColor = "white";
    }
}

function cityBACheck() {
    var cityBA = document.forms["signin"]["cityBA"].value;
    if (cityBA == "" || cityBA == null || !(/^[A-z ]+$/.test(cityBA))) {
        document.forms["signin"]["cityBA"].style.backgroundColor = "pink";
        return false;
    }
    else {
        document.forms["signin"]["cityBA"].style.backgroundColor = "white";
        return true;
    }
}

function countryBACheck() {
    var countryBA = document.forms["signin"]["countryBA"].value;
    if (countryBA == "" || countryBA == null || !(/^[A-z ]+$/.test(countryBA))) {
        document.forms["signin"]["countryBA"].style.backgroundColor = "pink";
        return false;
    }
    else {
        document.forms["signin"]["countryBA"].style.backgroundColor = "white";
        return true;
    }
}

function postalcodeBACheck() {
    var postalcodeBA = document.forms["signin"]["postalcodeBA"].value;
    if (postalcodeBA == "" || postalcodeBA == null) { //kulang pa ng pag check kung digit
        document.forms["signin"]["postalcodeBA"].style.backgroundColor = "pink";
        return false;
    }
    else {
        document.forms["signin"]["postalcodeBA"].style.backgroundColor = "white";
        return true;
    }
}

function apartmentnoDACheck() {
    var aptnoDA = document.forms["signin"]["apartmentnoDA"].value;
    if (aptnoDA == "" || aptnoDA == null) { //kulang pa ng pag check kung digit
        document.forms["signin"]["apartmentnoDA"].style.backgroundColor = "pink";
        return false;
    }
    else {
        document.forms["signin"]["apartmentnoDA"].style.backgroundColor = "white";
        return true;
    }
}

function streetDACheck() {
    var streetDA = document.forms["signin"]["streetDA"].value;
    if (streetDA == "" || streetDA == null || !(/^[A-z ]+$/.test(streetDA))) {
        document.forms["signin"]["streetDA"].style.backgroundColor = "pink";
        return false;
    }
    else {
        document.forms["signin"]["streetDA"].style.backgroundColor = "white";
        return true;
    }
}

function subdivisionDACheck() {
    var subDA = document.forms["signin"]["subdivisionDA"].value;
    if (subDA == "" || subDA == null || !(/^[A-z ]+$/.test(subDA))) {
        document.forms["signin"]["subdivisionDA"].style.backgroundColor = "pink";
    }
    else {
        document.forms["signin"]["subdivisionDA"].style.backgroundColor = "white";
    }
}

function cityDACheck() {
    var cityDA = document.forms["signin"]["cityDA"].value;
    if (cityDA == "" || cityDA == null || !(/^[A-z ]+$/.test(cityDA))) {
        document.forms["signin"]["cityDA"].style.backgroundColor = "pink";
        return false;
    }
    else {
        document.forms["signin"]["cityDA"].style.backgroundColor = "white";
        return true;
    }
}

function countryDACheck() {
    var countryDA = document.forms["signin"]["countryDA"].value;
    if (countryDA == "" || countryDA == null || !(/^[A-z ]+$/.test(countryDA))) {
        document.forms["signin"]["countryDA"].style.backgroundColor = "pink";
        return false;
    }
    else {
        document.forms["signin"]["countryDA"].style.backgroundColor = "white";
        return true;
    }
}

function postalcodeDACheck() {
    var postalcodeDA = document.forms["signin"]["postalcodeDA"].value;
    if (postalcodeDA == "" || postalcodeDA == null) { //kulang pa ng pag check kung digit
        document.forms["signin"]["postalcodeDA"].style.backgroundColor = "pink";
        return false;
    }
    else {
        document.forms["signin"]["postalcodeDA"].style.backgroundColor = "white";
        return true;
    }
}
function backWhite(x) {
    x.style.background = "white";
}