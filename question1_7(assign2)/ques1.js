import {writeFileSync} from 'node:fs'
// Data to be stored
const csvContent = "Student Name,Marks\nVivek Mansingh,85\nSwayam Kar,92\nRitesh Mohanty,78";

try {
  // Creating and writing to the file synchronously
  writeFileSync('./data.csv', csvContent);
  console.log("File 'data.csv' has been created successfully!");
} catch (err) {
  console.error("An error occurred while writing the file:", err);
}
