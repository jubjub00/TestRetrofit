package com.example.firstco.TestApi

data class User(
    var id:Int,
    var url:String,
    var username:String,
    var first_name:String,
    var last_name:String,
    var email:String,
    var is_active:Boolean,
    var date_joined:String
) {

//
//    "id": 121,
//    "url": "http://api.larntech.net/users/121/",
//    "username": "richardzzzz",
//    "first_name": "first_name",
//    "last_name": "last_name",
//    "email": "user@example.com",
//    "is_active": true,
//    "date_joined": "2020-10-05 04:10:01",
//    "last_login": null
}