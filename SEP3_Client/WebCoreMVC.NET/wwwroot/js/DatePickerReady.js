$(function () {
    $(".datefield").datepicker();
});
var dateFormat = $(".selector").datepicker("option", "dateFormat");

// Setter
$(".selector").datepicker("option", "dateFormat", "yy-mm-dd");
