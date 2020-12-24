export const formatDate = (date, separator) => {
    // var monthNames = [
    //   "January", "February", "March",
    //   "April", "May", "June", "July",
    //   "August", "September", "October",
    //   "November", "December"
    // ];

    var day = date.getDate();
    var monthIndex = date.getMonth();
    var year = date.getFullYear();

    // return day + ' ' + monthNames[monthIndex] + ' ' + year;
    if (separator) {
        return ("0" + (monthIndex + 1)).slice(-2) + separator + ("0" + day).slice(-2) + separator + year;
    } else {
        return ("0" + (monthIndex + 1)).slice(-2) + '/' + ("0" + day).slice(-2) + '/' + year;
    }
}