function productcheck() {
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

function productTitleCheck() {
    var title = document.forms["productcheck"]["productTitle"].value;
    if (title == "" || title == null || !(/^[A-z ]+$/.test(title))) {
        document.forms["productcheck"]["productTitle"].style.backgroundColor = "pink";
        return false;
    }
    else {
        document.forms["productcheck"]["productTitle"].style.backgroundColor = "white";
        return true;
    }
}

function productPriceCheck() {
    return true; //hindi ko pa alam regex pag numbers :(
}

function productSummaryCheck() {
    var summary = document.forms["productcheck"]["productSummary"].value;
    if (summary == "" || summary == null || !(/^[A-z ]+$/.test(summary))) {
        document.forms["productcheck"]["productSummary"].style.backgroundColor = "pink";
        return false;
    }
    else {
        document.forms["productcheck"]["productSummary"].style.backgroundColor = "white";
        return true;
    }
}

function productGenreCheck() {
    var genre = document.forms["productcheck"]["productGenre"].value;
    if (genre == "" || genre == null || !(/^[A-z ]+$/.test(genre))) {
        document.forms["productcheck"]["productGenre"].style.backgroundColor = "pink";
        return false;
    }
    else {
        document.forms["productcheck"]["productGenre"].style.backgroundColor = "white";
        return true;
    }
}

function productYearCheck() {
    var year = documet.forms["productcheck"]["productYear"].value;
    if (year == "" || year == null || !(/^d{4}$/.test(year))) {
        document.forms["productcheck"]["productYear"].style.backgroundColor = "pink";
        return false;
    } else {
        document.forms["productcheck"]["productYear"].style.backgroundColor="white";
        return true; //hindi ko pa alam regex pag numbers :(
    }
}

function productStocksCheck() {
    return true; //hindi ko pa alam regex pag numbers :(
}