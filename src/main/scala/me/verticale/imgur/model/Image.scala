package me.verticale.imgur.model

case class Image(
  id         : Option[String],
  title      : Option[String],
  description: Option[String],
  datetime   : Option[String],
  `type`     : Option[String],
  animated   : Option[Boolean],
  width      : Option[Int],
  heigth     : Option[Int],
  views      : Option[Int],
  size       : Option[Int],
  bandwidth  : Option[Int],
  deletehash : Option[String],
  name       : Option[String],
  section    : Option[String],
  link       : Option[String],
  gifv       : Option[String],
  mp4        : Option[String],
  webm       : Option[String],
  looping    : Option[Boolean],
  favorite   : Option[Boolean],
  nsfw       : Option[Boolean],
  vote       : Option[String],
  account_url: Option[String]
)
