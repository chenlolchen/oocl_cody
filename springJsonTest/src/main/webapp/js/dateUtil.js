/**
 * Created by CHENCO7 on 8/7/2017.
 */
function formatDate(now) {
    var year = now.getFullYear();
    var month = now.getMonth() + 1;
    var date = now.getDate();
    month = (month > 9 ? '' : '0') + month;
    date = (date > 9 ? '' : '0') + date;
    return year + "-" + month + "-" + date;
}