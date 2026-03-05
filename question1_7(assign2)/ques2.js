import fs from 'fs';
const data=fs.readFileSync("./data.csv",'utf-8');
console.log("content of data.csv");
console.log(data);