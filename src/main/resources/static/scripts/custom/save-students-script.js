var curStudents = [];

function saveStudents() {
let studentValue = parseInt($("#studentInput").val());

$.ajax({
type: "GET",
url: "/students",
success: data => {
let maxId;
 if(data && data.length) {
 maxId = data.map(item => item.id).reduce(function(a, b) {
 return Math.max(a, b);
             });
 } else {
 maxId = 0;
 }

let body = [];
for(let i = maxId; i < maxId + studentValue; i++) {
body.push({name : "" + i});
}
$.ajax({
    type: "POST",
    url: "/students/bulk",
    // The key needs to match your method's input parameter (case-sensitive).
    data: JSON.stringify(body),
    contentType: "application/json; charset=utf-8",
    dataType: "json"
});
}
});
}

function loadStudents() {
$.ajax({
type: "GET",
url: "/students",
success: data => {
curStudents = data;
}
});
}