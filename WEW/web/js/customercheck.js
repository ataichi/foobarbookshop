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
<<<<<<< HEAD
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
        if (apartmentnoBA == false || streetBA == false || subBA == false || cityBA == false ||
                countryBA == false || postalcodeBA == false ||
                apartmentnoDA == false || streetDA == false || subDA == false || cityDA == false ||
                countryDA == false || postalcodeDA == false) {
return false;
}
else {
return true;
}
=======
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

    if (apartmentnoBA == false || streetBA == false || subBA == false || cityBA == false ||
            countryBA == false || postalcodeBA == false ||
            apartmentnoDA == false || streetDA == false || subDA == false || cityDA == false ||
            countryDA == false || postalcodeDA == false) {
        return false;
    }
    else {
        return true;
    }
>>>>>>> 32422cbe40594b7c44f5b635a4c1e69b5e923413

}

function fnameCheck() {
<<<<<<< HEAD
var first = document.forms["customercheck"]["fname"].value;
        if (first == "" || first == null || !(/^[A-z ]+$/.test(first))) {
document.forms["customercheck"]["fname"].style.backgroundColor = "pink";
=======
    var first = document.forms["customercheck"]["fname"].value;
    if (first == "" || first == null || !(/^[A-z ]{2,20}$/.test(first))) {
        document.forms["customercheck"]["fname"].style.backgroundColor = "pink";
>>>>>>> 32422cbe40594b7c44f5b635a4c1e69b5e923413
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
<<<<<<< HEAD
var last = document.forms["customercheck"]["lname"].value;
        if (last == "" || last == null || !(/^[A-z ]+$/.test(last))) {
document.forms["customercheck"]["lname"].style.backgroundColor = "pink";
=======
    var last = document.forms["customercheck"]["lname"].value;
    if (last == "" || last == null || !(/^[A-z ]{2,20}$/.test(last))) {
        document.forms["customercheck"]["lname"].style.backgroundColor = "pink";
>>>>>>> 32422cbe40594b7c44f5b635a4c1e69b5e923413
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
<<<<<<< HEAD
var pass1 = document.forms["customercheck"]["pass1"].value;
        var pass2 = document.forms["customercheck"]["pass2"].value;
        if (!(/^[A-Za-z0-9!@#$%^&*()_]{8,20}$/.test(pass1))//!pass1.match(/(.[!,@,#,$,%,\^,&,*,?,_,~])/) 
                || pass1 == "" || pass1 == null || pass2 == "" || pass2 == null || pass1 != pass2) {
document.forms["customercheck"]["pass1"].style.backgroundColor = "pink";
        document.forms["customercheck"]["pass2"].style.backgroundColor = "pink";
=======
    var pass1 = document.forms["customercheck"]["pass1"].value;
    var pass2 = document.forms["customercheck"]["pass2"].value;
    var uname = document.forms["customercheck"]["uname"].value;
    var fname = document.forms["customercheck"]["fname"].value;
    var lname = document.forms["customercheck"]["lname"].value;
    

    if (!(/^[A-Za-z0-9!@#$%^&*()_]{8,20}$/.test(pass1)) ||
            pass1.indexOf(uname) != -1 || pass1.indexOf(fname) != -1 || pass1.indexOf(lname) != -1 ){//!pass1.match(/(.[!,@,#,$,%,\^,&,*,?,_,~])/) 
        document.forms["customercheck"]["pass1"].style.backgroundColor = "pink";
        //document.forms["customercheck"]["pass2"].style.backgroundColor = "pink";
        return false;
    }
    
    else {
        document.forms["customercheck"]["pass1"].style.backgroundColor = "white";
        document.forms["customercheck"]["pass2"].style.backgroundColor = "white";
        return true;
    }
}

function passCheck2(){
    var pass1 = document.forms["customercheck"]["pass1"].value;
    var pass2 = document.forms["customercheck"]["pass2"].value;
 
    if (pass1 != pass2) {
        document.forms["customercheck"]["pass1"].style.backgroundColor = "white";
        document.forms["customercheck"]["pass2"].style.backgroundColor = "pink";        
>>>>>>> 32422cbe40594b7c44f5b635a4c1e69b5e923413
        return false;
}
else {
document.forms["customercheck"]["pass1"].style.backgroundColor = "white";
        document.forms["customercheck"]["pass2"].style.backgroundColor = "white";
        return true;
}
}

function checkcurrentpass() {
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
        if (aptnoBA == "" || aptnoBA == null || !(/^[0-9a-zA-Z]+$/.test(aptnoBA))) { //|| !(/^[A-z ]+$/.test(aptnoBA))
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
        if (subBA == "" || subBA == null || !(/^[0-9a-zA-Z]+$/.test(subBA))) {// !(/^[A-z ]+$/.test(subBA))
document.forms["customercheck"]["subdivisionBA"].style.backgroundColor = "pink";
        return false;
}
else {
document.forms["customercheck"]["subdivisionBA"].style.backgroundColor = "white";
        return true;
}
}

function cityBACheck() {
var cityBA = document.forms["customercheck"]["cityBA"].value;
        if (cityBA == "" || cityBA == null || !(/^[A-Za-z ]{3,20}$/.test(cityBA))) {
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
        if (countryBA == "" || countryBA == null || !(/^[A-Za-z ]{3,20}$/.test(countryBA))) {
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
        if (postalcodeBA == "" || postalcodeBA == null || !(/^[0-9]{2,20}$/.test(postalcodeBA))) { //kulang pa ng pag check kung digit
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
        if (aptnoDA == "" || aptnoDA == null || !(/^[0-9a-zA-Z]+$/.test(aptnoBA))) { //!(/^[A-z ]+$/.test(aptnoDA))
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
        if (subDA == "" || subDA == null || !(/^[0-9a-zA-Z]+$/.test(subDA))) { //!(/^[A-z ]+$/.test(subDA))
document.forms["customercheck"]["subdivisionDA"].style.backgroundColor = "pink";
        return false;
}
else {
document.forms["customercheck"]["subdivisionDA"].style.backgroundColor = "white";
        return true;
}
}

function cityDACheck() {
var cityDA = document.forms["customercheck"]["cityDA"].value;
        if (cityDA === "" || cityDA === null || !(/^[A-Za-z ]{3,20}$/.test(cityDA))) {
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
        if (countryDA === "" || countryDA === null || !(/^[A-Za-z ]{3,20}$/.test(countryDA))) {
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
        if (postalcodeDA === "" || postalcodeDA === null || !(/^[0-9]{2,20}$/.test(postalcodeDA))) { //kulang pa ng pag check kung digit
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

function BACheck() {
    var BA = document.forms["customercheck"]["BA"].value;
    if (BA == "" || BA == null || !(/^[0-9a-zA-Z. ',]{10,60}$/.test(BA))) {
        document.forms["customercheck"]["BA"].style.backgroundColor = "pink";
        return false;
    }
    else {
        document.forms["customercheck"]["BA"].style.backgroundColor = "white";
        return true;
    }
}

function DACheck() {
    var DA = document.forms["customercheck"]["DA"].value;
    if (DA == "" || DA == null || !(/^[0-9a-zA-Z. ',]{10,60}$/.test(DA))) {
        document.forms["customercheck"]["DA"].style.backgroundColor = "pink";
        return false;
    }
    else {
        document.forms["customercheck"]["DA"].style.backgroundColor = "white";
        return true;
    }
}

function customerCheck() {
<<<<<<< HEAD
var first = fnameCheck();
        var middle = mnameCheck();
        var last = lnameCheck();
        var user = unameCheck();
        var email = emailCheck();
        var pass = passCheck();
        var aptnoBA = apartmentnoBACheck();
        var streetBA = streetBACheck();
        var subdivisionBA = subdivisionBACheck();
        var cityBA = cityBACheck();
        var countryBA = countryBACheck();
        var postalcodeBA = postalcodeBACheck();
        var aptnoDA = apartmentnoDACheck();
        var streetDA = streetDACheck();
        var subdivisionDA = subdivisionDACheck();
        var cityDA = cityDACheck();
        var countryDA = countryDACheck();
        var postalcodeDA = postalcodeDACheck();
        var billing = billingCheck();
        if (first === false || last === false || middle === false || user === false || email === false || pass === false
                || aptnoBA === false || streetBA === false || subdivisionBA === false || cityBA === false || countryBA === false || postalcodeBA === false
                || aptnoDA === false || streetDA === false || subdivisionDA === false || cityDA === false || countryDA === false || postalcodeDA === false
                || billing === false) {
return false;
}
else {
return true;
}
}

function creditCardNoCheck() {
var cardType = document.forms["creditcardcheck"]["cardType"].value;
        var cardNo = document.forms["creditcardcheck"]["cardNo"].value;
        if (cardType === "Visa"){ // american express
            if (/^4[0-9]{12}(?:[0-9]{3})?$/.test(cardNo)) {
            document.forms["creditcardcheck"]["cardNo"].style.backgroundColor = "white";
            return true;
            } else {
            document.forms["creditcardcheck"]["cardNo"].style.backgroundColor = "pink";
            return false;
        }
        } else if (cardType === "AmericanExpress"){
            if (/^3[47][0-9]{13}$/.test(cardNo)){
            document.forms["creditcardcheck"]["cardNo"].style.backgroundColor = "white";
            return true;
            }else{
                document.forms["creditcardcheck"]["cardNo"].style.backgroundColor = "green";
                return false;
            }
        } else if (cardType === "MasterCard") {
            if(/^5[1-5][0-9]{14}$/.test(cardNo)){
                document.forms["creditcardcheck"]["cardNo"].style.backgroundColor="white";
                return true;
                
            }else{
                document.forms["creditcardcheck"]["cardNo"].style.backgroundColor="yellow";
                return false;
            }
        }
=======
    var first = fnameCheck();
    var middle = mnameCheck();
    var last = lnameCheck();
    var user = unameCheck();
    var email = emailCheck();
    var pass = passCheck();
    var pass2 = passCheck2();
    var BA = BACheck();
    var DA = DACheck();
    

    if (first == false || last == false || middle == false ||
            user == false || email == false || pass == false || pass2 == false ||
            BA == false || DA == false) {
        return false;
    }
    else {
        return true;
    }
>>>>>>> 32422cbe40594b7c44f5b635a4c1e69b5e923413
}

function creditCardCheck() {
var cardNo = creditCardNoCheck();
        if (cardNo == false) {

return false;
} else {
return true;
}
}
