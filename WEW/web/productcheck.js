/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function editproductcheck() {
    var title = titleCheck();
    var price = priceCheck();
    var summary = summaryCheck();
    var genre = genreCheck();
    var year = yearCheck();
    var stocks = stocksChecl();
    
    if (title == false || price == false || summary == false || genre == false || year == false || stocks == false) {
        return false;
    }
    else {
        return true;
    }
    
}

function titleCheck() {
    var title = document.forms["editproduct"]["productTitle"].value;
    if (title == "" || title == null || !(/^[A-z ]+$/.test(title))) {
        document.forms["editproduct"]["productTitle"].style.backgroundColor = "pink";
        return false;
    }
    else {
        document.forms["editproduct"]["productTitle"].style.backgroundColor = "white";
        return true;
    }
}

function priceCheck() {
    return true; //hindi ko pa alam regex pag numbers :(
}

function summaryCheck() {
    var summary = document.forms["editproduct"]["productSummary"].value;
    if (summary == "" || summary == null || !(/^[A-z ]+$/.test(summary))) {
        document.forms["editproduct"]["productSummary"].style.backgroundColor = "pink";
        return false;
    }
    else {
        document.forms["editproduct"]["productSummary"].style.backgroundColor = "white";
        return true;
    }
}

function genreCheck() {
    var genre = document.forms["editproduct"]["productGenre"].value;
    if (genre == "" || genre == null || !(/^[A-z ]+$/.test(genre))) {
        document.forms["editproduct"]["productGenre"].style.backgroundColor = "pink";
        return false;
    }
    else {
        document.forms["editproduct"]["productGenre"].style.backgroundColor = "white";
        return true;
    }
}

function yearCheck() {
    return true; //hindi ko pa alam regex pag numbers :(
}

function stocksCheck() {
    return true; //hindi ko pa alam regex pag numbers :(
}