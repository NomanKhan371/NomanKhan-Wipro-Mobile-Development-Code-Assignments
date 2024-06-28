function sum(a,b){
    console.log("Sum",a + b);
}

sum(4,5)

// let name1 = "Noman"
// let name2 = "Suleman"
// let name3 = "Ahmed"

// // string interpoliation
// let names = `Danish, Mahira, Musharraf, ${name1}, ${name2}, ${name3}`
// console.log(names);


// // conditional statement
// let a = 5;
// let b = 6;
// if (a<b) {
//     console.log("a is smaller");
// }else if (a>b) {
//     console.log("a is bigger");
// }else{
//     console.log("both are equal");
// }


// //loops
// for (let i = 0; i < 5; i++) {
//     console.log(i);
// }

// Arrays

let arr = [1, 3, "Noman", true, false, "suleman", 45]
// arr.push(56)
// console.log(arr);
// // for "in" loop for indexes
// for (const key in arr) {
//     console.log(key);
// }

// // for "of" loop for values 
// for (const key of arr) {
//     console.log(key);
// }

// filter in js
// arr.filter(e => e % 2 == 0).forEach(e => console.log(e))

// map in js
// arr.map(e => e * 2).forEach(e => console.log(e))

// reverse of array
// arr.reverse().forEach(e => console.log(e))

// let arr2 = ["second"]

// // Task : arr2 --> [arr, "second"]
// // ... is spread operator
// arr2 = [...arr, "middle",...arr2]
// console.log(arr2);


// JSON or Objects in js
let obj = {
    name: "noman",
    role: "dev",
    exp: 9,
    salary: 0
}

// console.log(obj.name);

let a, middle, b;
[a, b, ...middle] = ["Aaryan", "bla", "bla", "bla", "Arush"];
// console.log(middle);

// let { name } = {name : "khan"}
// console.log(name);