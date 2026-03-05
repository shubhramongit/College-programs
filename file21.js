import  { createServer } from 'node:http'
import { MongoClient } from 'mongodb'

 const url='mongodb://localhost:27017/'
 const dbName='School'
 const client=new MongoClient(url)
   
 try{
    await client.connect()
        console.log("successfully connected to database")
    }
 catch(err){
    console.log("error connection")
 }
 const server=createServer(async (requestAnimationFrame,res)=>{
    const db=client.db(dbName);
    const student=db.collection('Student')
    const studentList=await student.find().toArray()
    const statusCode=200
    res.setHeader('Content-Type','application/json')
    res.end(JSON.stringify(studentList))
 })
 const host='localhost'
 const port=6400
 server.listen(port,host,()=>{
    console.log(`Server is listening at http://${host}:${port}`)
 })