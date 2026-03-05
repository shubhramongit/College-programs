

import { createServer } from 'node:http';

// Create server directly using the imported function
const server = createServer((req, res) => {
  res.writeHead(200, { 'Content-Type': 'text/html' });
  res.end('<h1>Hello Students</h1>');
});

server.listen(4000, () => {
  console.log('Server is running at http://localhost:4000/');
});
