const mongoose = require('mongoose')
const express = require('express')
const router = express.Router()

router.post('/register', (req,res)=>{
    const newUser = {
        fName: req.body.fName,
        lName: req.body.lName,
        email: req.body.email,
        phone: req.body.phone,
        dob: req.body.dob
    }
    // TODO: EMAIL VALIDATE
    // TODO: PHONE NUMBER VALIDATE
    // TODO: VERIFY EMAIL
    // TODO: VERIFY PHONE
})