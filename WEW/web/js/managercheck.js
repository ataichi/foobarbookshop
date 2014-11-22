function managerCheck() {
    var first = fnameAdminCheck();
    var middle = mnameAdminCheck();
    var last = lnameAdminCheck();
    var user = unameAdminCheck();
    var email = emailAdminCheck();
    //var pass = passManagerCheck();

    if (first == false || last == false || middle == false || user == false || email == false) {
        return false;
    }
    else {
        return true;
    }
}

function fnameManagerCheck() {
    var first = document.forms["managercheck"]["first"].value;
    if (first == "" || first == null || !(/^[A-z ]+$/.test(first))) {
        document.forms["managercheck"]["first"].style.backgroundColor = "pink";
        return false;
    }
    else {
        document.forms["managercheck"]["first"].style.backgroundColor = "white";
        return true;
    }
}

function mnameManagerCheck() {
    var middle = document.forms["managercheck"]["middle"].value;
    if (middle == "" || middle == null || !(/^[A-z ]+$/.test(middle))) {
        document.forms["managercheck"]["middle"].style.backgroundColor = "pink";
        return false;
    }
    else {
        document.forms["managercheck"]["middle"].style.backgroundColor = "white";
        return true;
    }
}

function lnameManagerCheck() {
    var last = document.forms["managercheck"]["last"].value;
    if (last == "" || last == null || !(/^[A-z ]+$/.test(last))) {
        document.forms["managercheck"]["last"].style.backgroundColor = "pink";
        return false;
    }
    else {
        document.forms["managercheck"]["last"].style.backgroundColor = "white";
        return true;
    }
}

function unameManagerCheck() {
    var user = document.forms["managercheck"]["user"].value;
    if (user == "" || user == null) {
        document.forms["managercheck"]["user"].style.backgroundColor = "pink";
        return false;
    }
    else {
        document.forms["managercheck"]["user"].style.backgroundColor = "white";
        return true;
    }
}

function emailManagerCheck() {
    var email = document.forms["managercheck"]["email"].value;
    var atpos = email.indexOf("@");
    var dotpos = email.lastIndexOf(".");
    if (email == "" || email == null || atpos < 1 || dotpos < atpos + 2 || dotpos + 2 >= email.length) {
        document.forms["managercheck"]["email"].style.backgroundColor = "pink";
        return false;
    }
    else {
        document.forms["managercheck"]["email"].style.backgroundColor = "white";
        return true;
    }
}

function passManagerCheck() {
    var pass1 = document.forms["managercheck"]["pass1"].value;
    var pass2 = document.forms["managercheck"]["pass2"].value;
    if (pass1 == "" || pass1 == null || pass2 == "" || pass2 == null || pass1 != pass2) {
        document.forms["managercheck"]["pass1"].style.backgroundColor = "pink";
        document.forms["managercheck"]["pass2"].style.backgroundColor = "pink";
        return false;
    }
    else {
        document.forms["managercheck"]["pass1"].style.backgroundColor = "white";
        document.forms["managercheck"]["pass2"].style.backgroundColor = "white";
        return true;
    }
}

function backWhite(x) {
    x.style.background = "white";
}