package me.verticale.imgur

import dispatch._
import Defaults._
import org.json4s._
import me.verticale.imgur.model._
import org.json4s.native.JsonMethods._

case class Response(data: List[Map[String, _]], success: Boolean, status: Int)

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

  /** Retrieve all images for the given album
    *
    * @param albumId The album identifier
    */
  def albumImages(albumId: String): List[Image] = {
    def request = baseRequest / "album" / albumId / "images"
    def authorizedRequest = addAuthorization(request)

    val images = Http(authorizedRequest OK as.String)
    val json = parse(images()).extract[Response]

    var result = List[Image]()

    for (image <- json.data)
      result = new Image(image) :: result

    result
  }
}
