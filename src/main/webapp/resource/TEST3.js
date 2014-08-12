/**
 * Created by rom4 on 07.08.14.
 */

var user = {
    firstName: "",
    lastName: "",
    age: 0
};


var users = [];
var userId;


function addUser(firstName, lastName, age) {
    user.firstName = firstName;
    user.lastName = lastName;
    user.age = age;
    users[userId] = user;
    userId += 1;
}

function showUser(userId) {
    alert("User FIO is " + users[userId].lastName + " " + users[userId].firstName);
}

addUser("Ivan", "Ivanov" , 21);
showUser(1);