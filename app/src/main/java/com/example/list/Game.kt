package com.example.list


data class Hero (
     val name: String,
     val images:Image,
     val powerstats: Powerstats
     )
data class Image (
val xs: String,
val sm: String,
val md: String,
val lg: String
)

data class Powerstats(
     val intelligence: Long,
     val strength: Long,
     val speed: Long,
     )



