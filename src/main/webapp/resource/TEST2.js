/**
 * Created by rom4 on 07.08.14.
 */

var n = prompt("while iterations:",'');

if (n <= 0) {
    alert('You are free!');
}
else {
    whileTestTrue();
}

function whileTest(n) {
    var i = 0;

    while (i < n) {
        i++;
        alert(i);
    }
}

function whileTestTrue() {
    var n = prompt("Exit?", "");
    alert(n);
    while (n) {
        n = prompt("Exit?", "");
        alert(n);
    }
}

function whileTestTrue() {
        alert("shirt shirt shirt!!");
}

function whileTestTrue() {
    alert("fun fun fun!!");
}
