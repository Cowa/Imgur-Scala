package me.verticale.imgur

import dispatch._
import Defaults._
import org.json4s._
import me.verticale.imgur.model._
import org.json4s.native.JsonMethods._

/** Imgur API client
  *
  * @constructor Create new Imgur API client
  * @param clientId Client identifier
  * @param baseUrl API's base URL, default "api.imgur.com/3/
  */
class Imgur(clientId: String, baseUrl: String = "api.imgur.com/3") {

  implicit val formats = DefaultFormats

  /** Base request host
    *
    * @return A request with the request host
    */
  def baseRequest: Req = host(baseUrl).secure

  /** Add the Authorization header to the request
    *
    * @param request The request to authorize
    * @return The authorized request
    */
  def addAuthorization(request: Req): Req = {
    request.addHeader("Authorization", "Client-ID " + clientId)
  }

  /** Retrieve an image
    *
    * @param imageId Image identifier
    * @return The image
    */
  def image(imageId: String): Image = {
    def request = baseRequest / "image" / imageId
    def authorizedRequest = addAuthorization(request)

    val album = Http(authorizedRequest OK as.String)
    val json = parse(album()).extract[ImageResponse]

    json.data
  }

  /** Retrieve an album
    *
    * @param albumId The album identifier
    * @return The album
    */
  def album(albumId: String): Album = {
    def request = baseRequest / "album" / albumId
    def authorizedRequest = addAuthorization(request)

    val album = Http(authorizedRequest OK as.String)
    val json = parse(album()).extract[AlbumResponse]

    json.data
  }

  /** Retrieve an image from an album
    *
    * @param albumId The album identifier
    * @param imageId The image identifier
    * @return The image
    */
  def albumImage(albumId: String, imageId: String): Image = {
    def request = baseRequest / "album" / albumId / "image" / imageId
    def authorizedRequest = addAuthorization(request)

    val album = Http(authorizedRequest OK as.String)
    val json = parse(album()).extract[ImageResponse]

    json.data
  }

  /** Retrieve all images for the given album
    *
    * @param albumId The album identifier
    * @return Images of the album
    */
  def albumImages(albumId: String): List[Image] = {
    def request = baseRequest / "album" / albumId / "images"
    def authorizedRequest = addAuthorization(request)

    val images = Http(authorizedRequest OK as.String)
    val json = parse(images()).extract[AlbumImagesResponse]

    var result = List[Image]()

    for (image <- json.data)
      result = image :: result

    result
  }

  /** Retrieve all default memes
    *
    * @return Images of default memes
    */
  def memes: List[Image] = {
    def request = baseRequest / "memegen" / "defaults"
    def authorizedRequest = addAuthorization(request)

    val images = Http(authorizedRequest OK as.String)
    val json = parse(images()).extract[ImagesResponse]

    var result = List[Image]()

    for (image <- json.data)
      result = image :: result

    result
  }
}
