package me.verticale.imgur

import dispatch._
import Defaults._
import spray.json._

/** Imgur API client
  *
  * @constructor Create new Imgur API client
  * @param clientId Client identifier
  * @param baseUrl API's base URL, default "api.imgur.com/3/
  */
class Imgur(clientId: String, baseUrl: String = "api.imgur.com/3") {

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
  def albumImages(albumId: String): Unit = {
    def request = baseRequest / "album" / albumId / "images"
    def authorizedRequest = addAuthorization(request)

    val images = Http(authorizedRequest OK as.String)

    val json = images().parseJson
    println(json.prettyPrint)
  }
}
