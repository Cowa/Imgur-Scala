package me.verticale.imgur.model

case class Album(
  id: String,
  title: String,
  description: String,
  datetime: String,
  cover: String,
  cover_width: Int,
  //cover_heigth: Int,
  account_url: String,
  privacy: String,
  layout: String,
  views: Int,
  link: String,
  favorite: Boolean,
  //nsfw: Boolean,
  section: String,
  //order: Int,
  //deletehash: String,
  images_count: Int,
  images: List[Image]
)
