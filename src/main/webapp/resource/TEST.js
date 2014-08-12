/**
 * Created by rom4 on 07.08.14.
 */

var x = prompt("x?",'');
var n = prompt("n?",'');

if (n <= 0) {
    alert('Степень '+n+'не поддерживается, введите целую степень, большую 0');
}
else {
    alert(pow(x, n));
}

function pow(x, n) {
    var result = x;
    for(var i=1;i<n;i++) {
        result*=x;
    }
    return result;
}
