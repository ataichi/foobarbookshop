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

function usernameCheck() {
    var user = document.forms["login"]["loguser"].value;
    if (user == "" || user == null) {
        document.forms["login"]["loguser"].style.backgroundColor = "pink";
        return false;
    }
    else {
        document.forms["login"]["loguser"].style.backgroundColor = "white";
        return true;
    }
}

function passwordCheck() {
    var pass = document.forms["login"]["logpass"].value;
    if (pass == "" || pass == null) {
        document.forms["login"]["logpass"].style.backgroundColor = "pink";
        return false;
    }
    else {
        document.forms["login"]["logpass"].style.backgroundColor = "white";
        return true;
    }
}

function signcheck() {
    var first = fnameCheck();
    var last = lnameCheck();
    var user = unameCheck();
    var email = emailCheck();
    var bday = bdayCheck();
    var pass = passCheck();

    if (first == false || last == false || user == false || email == false || bday == false || pass == false) {
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

function bdayCheck() {
    var d = document.getElementById("bday").value;
    var b = d.split('-');
    var a = b[2];
    var day = b[2];
    var month = b[1];
    var year = b[0];

    if (day == "" || day == null || month == "" || month == null || year == "=" || year == null) {
        document.forms["signin"]["bday"].style.backgroundColor = "pink";
        return false;
    }
    else if (day == undefined || month == undefined || year == undefined) {
        document.forms["signin"]["bday"].style.backgroundColor = "white";
        return true;
    }
    else if ((month == 2 && day <= 28)) {
        document.forms["signin"]["bday"].style.backgroundColor = "white";
        return true;
    }
    else if ((month == 0 || month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && day <= 31) {
        document.forms["signin"]["bday"].style.backgroundColor = "white";
        return true;
    }
    else if ((month == 4 || month == 6 || month == 9 || month == 11) && day <= 30) {
        document.forms["signin"]["bday"].style.backgroundColor = "white";
        return true;
    }
    else {
        document.forms["signin"]["bday"].style.backgroundColor = "pink";
        return false;
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

function backWhite(x) {
    x.style.background = "white";
}

