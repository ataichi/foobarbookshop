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

function adminEditPassword() {
    var pass1 = admincheckcurrentpass();
    var pass2 = adminpasscheck();
    var pass3 = adminpasscheck();
    if (pass1 == false || pass2 == false || pass3 == false) {
        return false;
    }
    else {
        return true;
    }
}

function admincheckcurrentpass() {
    var pass1 = document.forms["admincheck"]["currpass"].value;
    if (pass1 == "" || pass1 == null) {
        document.forms["admincheck"]["currpass"].style.backgroundColor = "pink";
        return false;
    }
    else {
        document.forms["admincheck"]["currpass"].style.backgroundColor = "white";
        return true;
    }
}

function adminpasscheck() {
    var pass1 = document.forms["admincheck"]["pass1"].value;
    var pass2 = document.forms["admincheck"]["pass2"].value;
    
    if (!(/^[A-Za-z0-9!@#$%^&*()_]{8,20}$/.test(pass1))//!pass1.match(/(.[!,@,#,$,%,\^,&,*,?,_,~])/) 
            || pass1 == "" || pass1 == null || pass2 == "" || pass2 == null || pass1 != pass2) {
        document.forms["admincheck"]["pass1"].style.backgroundColor = "pink";
        document.forms["admincheck"]["pass2"].style.backgroundColor = "pink";
        return false;
    }
    else {
        document.forms["admincheck"]["pass1"].style.backgroundColor = "white";
        document.forms["admincheck"]["pass2"].style.backgroundColor = "white";
        return true;
    }
    
}

function backWhite(x) {
    x.style.background = "white";
}