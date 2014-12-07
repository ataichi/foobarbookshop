function customerCheck() {
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

function editCustomerCheck() {
    var first = fnameCheck();
    var middle = mnameCheck();
    var last = lnameCheck();
    var user = unameCheck();
    var email = emailCheck();

    if (first == false || last == false || middle == false || user == false || email == false) {
        return false;
    }
    else {
        return true;
    }
}

function editPassword() {
    var pass1 = checkcurrentpass();
    var pass2 = passCheck();
    var pass3 = passCheck();
     if (pass1 == false || pass2 == false || pass3 == false) {
        return false;
    }
    else {
        return true;
    }
}

function billingCheck() {
    var apartmentnoBA = apartmentnoBACheck();
    var streetBA = streetBACheck();
    var subBA = subdivisionBACheck();
    var cityBA = cityBACheck();
    var countryBA = countryBACheck();
    var postalcodeBA = postalcodeBACheck();
    var apartmentnoDA = apartmentnoDACheck();
    var streetDA = streetDACheck();
    var subDA = subdivisionDACheck();
    var cityDA = cityDACheck();
    var countryDA = countryDACheck();
    var postalcodeDA = postalcodeDACheck();
    
    if (apartmentnoBA == false || streetBA == false || subBA == false || cityBA == false || cityBA == false || cityBA == false || countryBA == false || postalcodeBA == false || apartmentnoDA == false || streetDA == false || subDA == false || cityDA == false || countryDA == false || postalcodeDA == false) {
        return false;
    }
    else {
        return true;
    }
    
}

function fnameCheck() {
    var first = document.forms["customercheck"]["fname"].value;
    if (first == "" || first == null || !(/^[A-z ]+$/.test(first))) {
        document.forms["customercheck"]["fname"].style.backgroundColor = "pink";
        return false;
    }
    else {
        document.forms["customercheck"]["fname"].style.backgroundColor = "white";
        return true;
    }
}

function mnameCheck() {
    var middle = document.forms["customercheck"]["mname"].value;
    if (middle == "" || middle == null || !(/^[A-Za-z ]{1,2}$/.test(middle))) { ///^(?:[A-z ]\d{0})$/
        document.forms["customercheck"]["mname"].style.backgroundColor = "pink";
        return false;
    }
    else {
        document.forms["customercheck"]["mname"].style.backgroundColor = "white";
        return true;
    }
}

function lnameCheck() {
    var last = document.forms["customercheck"]["lname"].value;
    if (last == "" || last == null || !(/^[A-z ]+$/.test(last))) {
        document.forms["customercheck"]["lname"].style.backgroundColor = "pink";
        return false;
    }
    else {
        document.forms["customercheck"]["lname"].style.backgroundColor = "white";
        return true;
    }
}

function unameCheck() {
    var user = document.forms["customercheck"]["uname"].value;
    if (user == "" || user == null || !(/^[0-9a-zA-Z_-]+$/.test(user))) {
        document.forms["customercheck"]["uname"].style.backgroundColor = "pink";
        return false;
    }
    else {
        document.forms["customercheck"]["uname"].style.backgroundColor = "white";
        return true;
    }
}

function emailCheck() {
    var email = document.forms["customercheck"]["email"].value;
    var atpos = email.indexOf("@");
    var dotpos = email.lastIndexOf(".");
    if (email == "" || email == null || atpos < 1 || dotpos < atpos + 2 || dotpos + 2 >= email.length) {
        document.forms["customercheck"]["email"].style.backgroundColor = "pink";
        return false;
    }
    else {
        document.forms["customercheck"]["email"].style.backgroundColor = "white";
        return true;
    }
}

function passCheck() {
    var pass1 = document.forms["customercheck"]["pass1"].value;
    var pass2 = document.forms["customercheck"]["pass2"].value;
    if (!(/^[A-Za-z0-9!@#$%^&*()_]{8,20}$/.test(pass1))//!pass1.match(/(.[!,@,#,$,%,\^,&,*,?,_,~])/) 
            || pass1 == "" || pass1 == null || pass2 == "" || pass2 == null || pass1 != pass2) {
        document.forms["customercheck"]["pass1"].style.backgroundColor = "pink";
        document.forms["customercheck"]["pass2"].style.backgroundColor = "pink";
        return false;
    }
    else {
        document.forms["customercheck"]["pass1"].style.backgroundColor = "white";
        document.forms["customercheck"]["pass2"].style.backgroundColor = "white";
        return true;
    }
}

function checkcurrentpass(){
    var pass1 = document.forms["customercheck"]["currpass"].value;
     if (pass1 == "" || pass1 == null) {
        document.forms["customercheck"]["currpass"].style.backgroundColor = "pink";
        return false;
    }
    else {
        document.forms["customercheck"]["currpass"].style.backgroundColor = "white";
        return true;
    }
}
function apartmentnoBACheck() {
    var aptnoBA = document.forms["customercheck"]["apartmentnoBA"].value;
    if (aptnoBA == "" || aptnoBA == null ) { //|| !(/^[A-z ]+$/.test(aptnoBA))
        document.forms["customercheck"]["apartmentnoBA"].style.backgroundColor = "pink";
        return false;
    }
    else {
        document.forms["customercheck"]["apartmentnoBA"].style.backgroundColor = "white";
        return true;
    }
}

function streetBACheck() {
    var streetBA = document.forms["customercheck"]["streetBA"].value;
    if (streetBA == "" || streetBA == null || !(/^[A-z ]+$/.test(streetBA))) {
        document.forms["customercheck"]["streetBA"].style.backgroundColor = "pink";
        return false;
    }
    else {
        document.forms["customercheck"]["streetBA"].style.backgroundColor = "white";
        return true;
    }
}

function subdivisionBACheck() {
    var subBA = document.forms["customercheck"]["subdivisionBA"].value;
    if (subBA == "" || subBA == null ) {// !(/^[A-z ]+$/.test(subBA))
        document.forms["customercheck"]["subdivisionBA"].style.backgroundColor = "pink";
    }
    else {
        document.forms["customercheck"]["subdivisionBA"].style.backgroundColor = "white";
    }
}

function cityBACheck() {
    var cityBA = document.forms["customercheck"]["cityBA"].value;
    if (cityBA == "" || cityBA == null || !(/^[A-Za-z0-9 ]{3,20}$/.test(cityBA))) {
        document.forms["customercheck"]["cityBA"].style.backgroundColor = "pink";
        return false;
    }
    else {
        document.forms["customercheck"]["cityBA"].style.backgroundColor = "white";
        return true;
    }
}

function countryBACheck() {
    var countryBA = document.forms["customercheck"]["countryBA"].value;
    if (countryBA == "" || countryBA == null || !(/^[A-Za-z0-9 ]{3,20}$/.test(countryBA))) {
        document.forms["customercheck"]["countryBA"].style.backgroundColor = "pink";
        return false;
    }
    else {
        document.forms["customercheck"]["countryBA"].style.backgroundColor = "white";
        return true;
    }
}

function postalcodeBACheck() {
    var postalcodeBA = document.forms["customercheck"]["postalcodeBA"].value;
    if (postalcodeBA == "" || postalcodeBA == null || !(/^(?:[0-9]\d{3})$/.test(postalcodeBA))) { //kulang pa ng pag check kung digit
        document.forms["customercheck"]["postalcodeBA"].style.backgroundColor = "pink";
        return false;
    }
    else {
        document.forms["customercheck"]["postalcodeBA"].style.backgroundColor = "white";
        return true;
    }
}

function apartmentnoDACheck() {
    var aptnoDA = document.forms["customercheck"]["apartmentnoDA"].value;
    if (aptnoDA == "" || aptnoDA == null) { //!(/^[A-z ]+$/.test(aptnoDA))
        document.forms["customercheck"]["apartmentnoDA"].style.backgroundColor = "pink";
        return false;
    }
    else {
        document.forms["customercheck"]["apartmentnoDA"].style.backgroundColor = "white";
        return true;
    }
}

function streetDACheck() {
    var streetDA = document.forms["customercheck"]["streetDA"].value;
    if (streetDA == "" || streetDA == null || !(/^[A-z ]+$/.test(streetDA))) {
        document.forms["customercheck"]["streetDA"].style.backgroundColor = "pink";
        return false;
    }
    else {
        document.forms["customercheck"]["streetDA"].style.backgroundColor = "white";
        return true;
    }
}

function subdivisionDACheck() {
    var subDA = document.forms["customercheck"]["subdivisionDA"].value;
    if (subDA == "" || subDA == null) { //!(/^[A-z ]+$/.test(subDA))
        document.forms["customercheck"]["subdivisionDA"].style.backgroundColor = "pink";
    }
    else {
        document.forms["customercheck"]["subdivisionDA"].style.backgroundColor = "white";
    }
}

function cityDACheck() {
    var cityDA = document.forms["customercheck"]["cityDA"].value;
    if (cityDA == "" || cityDA == null || !(/^[A-Za-z0-9 ]{3,20}$/.test(cityDA))) {
        document.forms["customercheck"]["cityDA"].style.backgroundColor = "pink";
        return false;
    }
    else {
        document.forms["customercheck"]["cityDA"].style.backgroundColor = "white";
        return true;
    }
}

function countryDACheck() {
    var countryDA = document.forms["customercheck"]["countryDA"].value;
    if (countryDA == "" || countryDA == null || !(/^[A-Za-z0-9 ]{3,20}$/.test(countryDA))) {
        document.forms["customercheck"]["countryDA"].style.backgroundColor = "pink";
        return false;
    }
    else {
        document.forms["customercheck"]["countryDA"].style.backgroundColor = "white";
        return true;
    }
}

function postalcodeDACheck() {
    var postalcodeDA = document.forms["customercheck"]["postalcodeDA"].value;
    if (postalcodeDA == "" || postalcodeDA == null || !(/^(?:[0-9]\d{3})$/.test(postalcodeDA))) { //kulang pa ng pag check kung digit
        document.forms["customercheck"]["postalcodeDA"].style.backgroundColor = "pink";
        return false;
    }
    else {
        document.forms["customercheck"]["postalcodeDA"].style.backgroundColor = "white";
        return true;
    }
}
function backWhite(x) {
    x.style.background = "white";
}