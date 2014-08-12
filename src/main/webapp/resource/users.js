/**
 * Created by rom4 on 07.08.14.
 */



var users = [];

function addUser(firstName, lastName, age) {
    var user = {
        firstName: "",
        lastName: "",
        age: 0
    };

    console.log("lastName is " + lastName);
    user.firstName = firstName;
    user.lastName = lastName;
    user.age = age;
    users.push(user);
    console.log(user);

}

function showUser(userId) {
    console.log(userId);
    console.log("User FIO is " + users[userId].lastName + " " + users[userId].firstName);
    console.log("users " + users);
}

function showUsers() {
    console.log("users.length " + users.length);
    for (var i = 0; i < users.length;i++) {
        console.log("UserID = " + i);
        console.log("User FIO is " + users[i].lastName + " " + users[i].firstName);
    }
}

