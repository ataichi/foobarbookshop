function editmanagercheck() {
    var first = fnameAdminCheck();
    var middle = mnameAdminCheck();
    var last = lnameAdminCheck();
    var user = unameAdminCheck();
    var email = emailAdminCheck();
    //var pass = passAdminCheck();

    if (first == false || last == false || middle == false || user == false || email == false) {
        return false;
    }
    else {
        return true;
    }
}

function fnameManagerCheck() {
    var first = document.forms["editmanager"]["editfirst"].value;
    if (first == "" || first == null || !(/^[A-z ]+$/.test(first))) {
        document.forms["editmanager"]["editfirst"].style.backgroundColor = "pink";
        return false;
    }
    else {
        document.forms["editmanager"]["editfirst"].style.backgroundColor = "white";
        return true;
    }
}

function mnameManagerCheck() {
    var middle = document.forms["editmanager"]["editmiddle"].value;
    if (middle == "" || middle == null || !(/^[A-z ]+$/.test(middle))) {
        document.forms["editmanager"]["editmiddle"].style.backgroundColor = "pink";
        return false;
    }
    else {
        document.forms["editmanager"]["editmiddle"].style.backgroundColor = "white";
        return true;
    }
}

function lnameManagerCheck() {
    var last = document.forms["editmanager"]["editlast"].value;
    if (last == "" || last == null || !(/^[A-z ]+$/.test(last))) {
        document.forms["editmanager"]["editlast"].style.backgroundColor = "pink";
        return false;
    }
    else {
        document.forms["editmanager"]["editlast"].style.backgroundColor = "white";
        return true;
    }
}

function unameManagerCheck() {
    var user = document.forms["editmanager"]["edituser"].value;
    if (user == "" || user == null) {
        document.forms["editmanager"]["edituser"].style.backgroundColor = "pink";
        return false;
    }
    else {
        document.forms["editmanager"]["edituser"].style.backgroundColor = "white";
        return true;
    }
}

function emailManagerCheck() {
    var email = document.forms["editmanager"]["editemail"].value;
    var atpos = email.indexOf("@");
    var dotpos = email.lastIndexOf(".");
    if (email == "" || email == null || atpos < 1 || dotpos < atpos + 2 || dotpos + 2 >= email.length) {
        document.forms["editmanager"]["editemail"].style.backgroundColor = "pink";
        return false;
    }
    else {
        document.forms["editmanager"]["editemail"].style.backgroundColor = "white";
        return true;
    }
}
function backWhite(x) {
    x.style.background = "white";
}