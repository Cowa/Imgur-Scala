package me.verticale.imgur

import me.verticale.imgur.model._

/** Responses API format
  */
case class ImageResponse(data: Image, success: Boolean, status: Int)
case class ImagesResponse(data: List[Image], success: Boolean, status: Int)
case class AlbumResponse(data: Album, success: Boolean, status: Int)
case class AlbumImagesResponse(data: List[Image], success: Boolean, status: Int)
