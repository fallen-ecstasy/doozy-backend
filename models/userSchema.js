const mongoose = require('mongoose')

const userSchema = mongoose.Schema({
    dp : { type: String, },
    fName : { type : String, required: true},
    lName : { type : String, required: true},
    email : { type : String, required: true},
    phone : { type: Number },
    dob : { type: date },
    hash : { type: String }
})

module.exports = mongoose.model(userSchema, 'userModel')