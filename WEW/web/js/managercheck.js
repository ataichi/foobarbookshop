function managerCheck() {
    var first = fnameManagerCheck();
    var middle = mnameManagerCheck();
    var last = lnameManagerCheck();
    var user = unameManagerCheck();
    var email = emailManagerCheck();
    var pass = verifyPassCheck();
    var pass2 = passManagerCheck();

    if (first == false || last == false || middle == false || user == false || email == false || pass == false || pass2 == false) {
        return false;
    }
    else {
        return true;
    }
}

function editManagerCheck() {
    var first = fnameManagerCheck();
    var middle = mnameManagerCheck();
    var last = lnameManagerCheck();
    var user = unameManagerCheck();
    var email = emailManagerCheck();
    //var pass = verifyPassCheck();

    if (first == false || last == false || middle == false || user == false || email == false) {
        return false;
    }
    else {
        return true;
    }
}

function managerEditPassword() {
    var pass1 = managercheckcurrentpass();
    var pass2 = managerpasscheck();
    var pass3 = managerpasscheck();
    if (pass1 == false || pass2 == false || pass3 == false) {
        return false;
    }
    else {
        return true;
    }
}

function managercheckcurrentpass() {
    var pass1 = document.forms["managercheck"]["currpass"].value;
    if (pass1 == "" || pass1 == null) {
        document.forms["managercheck"]["currpass"].style.backgroundColor = "pink";
        return false;
    }
    else {
        document.forms["managercheck"]["currpass"].style.backgroundColor = "white";
        return true;
    }
}

function managerpasscheck() {
    var pass1 = document.forms["managercheck"]["pass1"].value;
    var pass2 = document.forms["managercheck"]["pass2"].value;
    
    if (!(/^[A-Za-z0-9!@#$%^&*()_]{8,20}$/.test(pass1))//!pass1.match(/(.[!,@,#,$,%,\^,&,*,?,_,~])/) 
            || pass1 == "" || pass1 == null || pass2 == "" || pass2 == null || pass1 != pass2) {
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

function fnameManagerCheck() {
    var first = document.forms["managercheck"]["fname"].value;
    if (first == "" || first == null || !(/^[A-z ]+$/.test(first))) {
        document.forms["managercheck"]["fname"].style.backgroundColor = "pink";
        return false;
    }
    else {
        document.forms["managercheck"]["fname"].style.backgroundColor = "white";
        return true;
    }
}

function mnameManagerCheck() {
    var middle = document.forms["managercheck"]["mname"].value;
    if (middle == "" || middle == null ||  !(/^[A-Za-z ]{1,2}$/.test(middle))) {
        document.forms["managercheck"]["mname"].style.backgroundColor = "pink";
        return false;
    }
    else {
        document.forms["managercheck"]["mname"].style.backgroundColor = "white";
        return true;
    }
}

function lnameManagerCheck() {
    var last = document.forms["managercheck"]["lname"].value;
    if (last == "" || last == null || !(/^[A-z ]+$/.test(last))) {
        document.forms["managercheck"]["lname"].style.backgroundColor = "pink";
        return false;
    }
    else {
        document.forms["managercheck"]["lname"].style.backgroundColor = "white";
        return true;
    }
}

function unameManagerCheck() {
    var user = document.forms["managercheck"]["uname"].value;
    if (user == "" || user == null || !(/^[0-9a-zA-Z_-]+$/.test(user))) {
        document.forms["managercheck"]["uname"].style.backgroundColor = "pink";
        return false;
    }
    else {
        document.forms["managercheck"]["uname"].style.backgroundColor = "white";
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
    if (!(/^[A-Za-z0-9!@#$%^&*()_]{8,20}$/.test(pass1)) || pass1 == "" || pass1 == null) {
        document.forms["managercheck"]["pass1"].style.backgroundColor = "pink";
        return false;
    }
    else {
        document.forms["managercheck"]["pass1"].style.backgroundColor = "white";
        return true;
    }
}

function verifyPassCheck() {
    var pass1 = document.forms["managercheck"]["pass1"].value;
    var pass2 = document.forms["managercheck"]["pass2"].value;
    if(pass1 != pass2 || pass2 == "" || pass2 == null || !(/^[A-Za-z0-9!@#$%^&*()_]{8,20}$/.test(pass2))) {
        document.forms["managercheck"]["pass2"].style.backgroundColor = "pink";
        return false;
    }
    else {
        document.forms["managercheck"]["pass2"].style.backgroundColor = "white";
        return true;
    }
}

function backWhite(x) {
    x.style.background = "white";
}