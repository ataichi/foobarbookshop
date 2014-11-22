function editadmincheck() {
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

function fnameAdminCheck() {
    var first = document.forms["editadmin"]["editfirst"].value;
    if (first == "" || first == null || !(/^[A-z ]+$/.test(first))) {
        document.forms["editadmin"]["editfirst"].style.backgroundColor = "pink";
        return false;
    }
    else {
        document.forms["editadmin"]["editfirst"].style.backgroundColor = "white";
        return true;
    }
}

function mnameAdminCheck() {
    var middle = document.forms["editadmin"]["editmiddle"].value;
    if (middle == "" || middle == null || !(/^[A-z ]+$/.test(middle))) {
        document.forms["editadmin"]["editmiddle"].style.backgroundColor = "pink";
        return false;
    }
    else {
        document.forms["editadmin"]["editmiddle"].style.backgroundColor = "white";
        return true;
    }
}

function lnameAdminCheck() {
    var last = document.forms["editadmin"]["editlast"].value;
    if (last == "" || last == null || !(/^[A-z ]+$/.test(last))) {
        document.forms["editadmin"]["editlast"].style.backgroundColor = "pink";
        return false;
    }
    else {
        document.forms["editadmin"]["editlast"].style.backgroundColor = "white";
        return true;
    }
}

function unameAdminCheck() {
    var user = document.forms["editadmin"]["edituser"].value;
    if (user == "" || user == null) {
        document.forms["editadmin"]["edituser"].style.backgroundColor = "pink";
        return false;
    }
    else {
        document.forms["editadmin"]["edituser"].style.backgroundColor = "white";
        return true;
    }
}

function emailAdminCheck() {
    var email = document.forms["editadmin"]["editemail"].value;
    var atpos = email.indexOf("@");
    var dotpos = email.lastIndexOf(".");
    if (email == "" || email == null || atpos < 1 || dotpos < atpos + 2 || dotpos + 2 >= email.length) {
        document.forms["editadmin"]["editemail"].style.backgroundColor = "pink";
        return false;
    }
    else {
        document.forms["editadmin"]["editemail"].style.backgroundColor = "white";
        return true;
    }
}
function backWhite(x) {
    x.style.background = "white";
}