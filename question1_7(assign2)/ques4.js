import {appendFileSync} from 'node:fs';

const time=new Date();
appendFileSync("log.txt",time + "\n")
console.log("time updated");