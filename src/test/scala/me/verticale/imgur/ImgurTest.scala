package me.verticale.imgur

import org.scalatest._
import Matchers._
import scala.util.Properties
import me.verticale.imgur.model._

class ImgurTest extends FlatSpec {
  val imgur = new Imgur(Properties.envOrElse("IMGUR_KEY", "nope"))
  val albumId = Properties.envOrElse("IMGUR_ALBUM", "nope")

  "Retrieving an album" should "returns the album" in {
    val album = imgur.album(albumId)

    album.id should be (Some(albumId))
  }

  "Retrieving images from an album" should "returns a list of images" in {
    val images = imgur.albumImages(albumId)

    images shouldBe a [List[_]]
    images(0) shouldBe a [Image]
  }

  "Retrieving memes" should "returns a list of images" in {
    val memes = imgur.memes()

    memes shouldBe a [List[_]]
    memes(0) shouldBe a [Image]
  }
}
