const http = require('http');
const server = http.createServer((req, res) => {
  res.writeHead(200, { 'Content-Type': 'application/json' });
  const student = {
    name: "Shubh",
    marks: 85
  };
  res.end(JSON.stringify(student));
});
server.listen(5000, () => {
  console.log('Server is running at http://localhost:5000/');
});
