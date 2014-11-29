package me.verticale.imgur.model

case class Album(
  id          : Option[String],
  title       : Option[String],
  description : Option[String],
  datetime    : Option[String],
  cover       : Option[String],
  cover_width : Option[Int],
  cover_heigth: Option[Int],
  account_url : Option[String],
  privacy     : Option[String],
  layout      : Option[String],
  views       : Option[Int],
  link        : Option[String],
  favorite    : Option[Boolean],
  nsfw        : Option[Boolean],
  section     : Option[String],
  order       : Option[Int],
  deletehash  : Option[String],
  images_count: Option[Int],
  images      : Option[List[Image]]
)
