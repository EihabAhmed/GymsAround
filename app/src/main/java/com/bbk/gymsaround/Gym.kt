package com.bbk.gymsaround

data class Gym(val id: Int, val name: String, val place: String, var isFavourite: Boolean = false)

val listOfGyms = listOf(
    Gym(1, "UpTown Gym", "28 Salah St., Benha, Qalubeya, P.O.: 11511 Egypt"),
    Gym(2, "New Gym", "13 Tarrad El Nile St., Cairo, Qalubeya, P.O.: 11511 Egypt"),
    Gym(3, "Strong Gym", "11 Baghdad St., Alex, Qalubeya, P.O.: 11511 Egypt"),
    Gym(4, "Fitness Gym", "4 Ahmed Fahmy St., Benha, Qalubeya, P.O.: 11511 Egypt"),
    Gym(5, "Mr. Gym", "7 Helwan St., Benha, Qalubeya, P.O.: 11511 Egypt"),
)