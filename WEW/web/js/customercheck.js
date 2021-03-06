function editCustomerCheck() {
    var first = fnameCheck();
    var middle = mnameCheck();
    var last = lnameCheck();
    var user = unameCheck();
    var email = emailCheck();
    if (first === false || last === false || middle === false || user === false || email === false) {
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
    if (pass1 === false || pass2 === false || pass3 === false) {
        return false;
    }
    else {
        return true;
    }
}

function fnameCheck() {
    var first = document.forms["customercheck"]["fname"].value;

    if (first === "" || first === null || !(/^[A-z ]{2,20}$/.test(first))) {
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
    if (middle === "" || middle === null || !(/^[A-Za-z ]{1,2}$/.test(middle))) { ///^(?:[A-z ]\d{0})$/
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

    if (last === "" || last === null || !(/^[A-z ]{2,20}$/.test(last))) {
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
    if (user === "" || user === null || !(/^[0-9a-zA-Z_-]+$/.test(user))) {
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
    if (email === "" || email === null || atpos < 1 || dotpos < atpos + 2 || dotpos + 2 >= email.length) {
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
 

        var pass1 = document.forms["customercheck"]["pass1"].value;
        var pass2 = document.forms["customercheck"]["pass2"].value;
        var uname = document.forms["customercheck"]["uname"].value;
        var fname = document.forms["customercheck"]["fname"].value;
        var lname = document.forms["customercheck"]["lname"].value;


        if (!(/^[A-Za-z0-9!@#$%^&*()_]{8,20}$/.test(pass1)) ||
                pass1.indexOf(uname) !== -1 || pass1.indexOf(fname) !== -1 || pass1.indexOf(lname) !== -1) {//!pass1.match(/(.[!,@,#,$,%,\^,&,*,?,_,~])/) 
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


function passCheck2() {
    var pass1 = document.forms["customercheck"]["pass1"].value;
    var pass2 = document.forms["customercheck"]["pass2"].value;

    if (pass1 !== pass2) {
        document.forms["customercheck"]["pass1"].style.backgroundColor = "white";
        document.forms["customercheck"]["pass2"].style.backgroundColor = "pink";

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
    if (pass1 === "" || pass1 === null) {
        document.forms["customercheck"]["currpass"].style.backgroundColor = "pink";
        return false;
    }
    else {
        document.forms["customercheck"]["currpass"].style.backgroundColor = "white";
        return true;
    }
}

function BACheck() {
    var BA = document.forms["customercheck"]["BA"].value;
    if (BA === "" || BA === null || !(/^[0-9a-zA-Z. ',]{10,60}$/.test(BA))) {
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
    if (DA === "" || DA === null || !(/^[0-9a-zA-Z. ',]{10,60}$/.test(DA))) {
        document.forms["customercheck"]["DA"].style.backgroundColor = "pink";
        return false;
    }
    else {
        document.forms["customercheck"]["DA"].style.backgroundColor = "white";
        return true;
    }
}

function customerCheck() {

    var first = fnameCheck();
    var middle = mnameCheck();
    var last = lnameCheck();
    var user = unameCheck();
    var email = emailCheck();
    var pass = passCheck();
    var BA = BACheck();
    var DA = DACheck();

    if (first === false || last === false || middle === false || user === false || email === false || pass === false
            || BA === false || DA === false) {
        return false;
    }
    else {
        return true;
    }
}

function creditCardNoCheck() {
    var cardType = document.forms["creditcardcheck"]["cardType"].value;
    var cardNo = document.forms["creditcardcheck"]["cardNo"].value;
    if (cardType === "Visa") { // Visa
        if (/^4[0-9]{12}(?:[0-9]{3})?$/.test(cardNo)) {
            document.forms["creditcardcheck"]["cardNo"].style.backgroundColor = "white";
            return true;
        } else {
            document.forms["creditcardcheck"]["cardNo"].style.backgroundColor = "pink";
            return false;
        }
    } else if (cardType === "AmericanExpress") {
        if (/^3[47][0-9]{13}$/.test(cardNo)) {
            document.forms["creditcardcheck"]["cardNo"].style.backgroundColor = "white";
            return true;
        } else {
            document.forms["creditcardcheck"]["cardNo"].style.backgroundColor = "pink";
            return false;
        }
    } else if (cardType === "MasterCard") {
        if (/^5[1-5][0-9]{14}$/.test(cardNo)) {
            document.forms["creditcardcheck"]["cardNo"].style.backgroundColor = "white";
            return true;

        } else {
            document.forms["creditcardcheck"]["cardNo"].style.backgroundColor = "pink";
            return false;
        }
    }
}
function customerCheck() {

    var first = fnameCheck();
    var middle = mnameCheck();
    var last = lnameCheck();
    var user = unameCheck();
    var email = emailCheck();
    var pass = passCheck();
    var pass2 = passCheck2();
    var BA = BACheck();
    var DA = DACheck();


    if (first === false || last === false || middle === false ||
            user === false || email === false || pass === false || pass2 === false ||
            BA === false || DA === false) {
        return false;
    }
    else {
        return true;
    }

}

function creditCardCheck() {
    var cardNo = creditCardNoCheck();
    if (cardNo === false) {

        return false;
    } else {
        return true;
    }
}

function setCookie(cname, cvalue, exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
    var expires = "expires=" + d.toUTCString();
    document.cookie = cname + "=" + cvalue + ";" + expires;
}

function getCookie(cname){
    var name=cname+"=";
    var ca=document.cookie.split(';');
    for(var i=0;i<ca.length;i++){
        var c=ca[i];
        while(c.charAt(0)===' ') c=c.subString(1);
        if(c.indexOf(name) !== -1 ) return c.substring (name.length, c.length);
    }
    return "";
}

function checkCookie(){
    var user=getCookie("username");
    if(user!==""){
        alert("Welcome again " + user);
    }else{
        user = prompt("Please enter your name: ","");
        if(user!=="" && user!==null){
            setCookie("username", user, 30);
        }
    }
}
