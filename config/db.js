const mongo = require('mongoose')

module.exports.dbConnect = async()=>{
    try{
        await mongo.connect('mongodb://localhost:27017/Doozy')
        console.log("Database Connected Successfully!")
    }catch(err){
        console.log(err);
    }
}