package me.verticale.imgur.model

case class Image(
  id         : String,
  title      : String,
  description: String,
  datetime   : String,
  `type`     : String,
  animated   : Boolean,
  width      : Int,
  heigth     : Option[Int],
  views      : Int,
  size       : Int,
  bandwidth  : Int,
  deletehash : Option[String],
  name       : Option[String],
  section    : String,
  link       : String,
  gifv       : Option[String],
  mp4        : Option[String],
  webm       : Option[String],
  looping    : Option[Boolean],
  favorite   : Boolean,
  nsfw       : Option[Boolean],
  vote       : String,
  account_url: String
)
