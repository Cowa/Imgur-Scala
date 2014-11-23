package me.verticale.imgur.model

case class Image(
  id: String,
  title: String,
  description: String,
  datetime: String,
  `type`: String,
  animated: Boolean,
  width: Int,
  //heigth: Int,
  views: Int,
  size: Int,
  bandwidth: Int,
  //deletehash: String,
  //name: String,
  section: String,
  link: String,
  gifv: String,
  mp4: String,
  webm: String,
  looping: Boolean,
  favorite: Boolean,
  //nsfw: Boolean,
  vote: String,
  account_url: String
)
