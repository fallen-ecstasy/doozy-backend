const express = require('express')
const cors = require('cors')
const bodyParser = require('body-parser')

const db = require('./config/db');

const PORT = 3000
const server = express()

// *Middlewares
server.use(bodyParser.json())

server.use(cors())

db.dbConnect()




// *Listen Call
server.listen(PORT)