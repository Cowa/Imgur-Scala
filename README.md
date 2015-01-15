# Imgur-Scala

> Scala Imgur API client

*Currently made for the [CatFactory team](https://github.com/CatFactoryTeam) needs*

## Progress

It's a very early API client, so far you can make GET requests :
- get images from an album
- get image from an album
- get default memes
- get an album
- get an image

## Usage

```scala
import me.verticale.imgur._

val imgur = new Imgur("myClientId")

val album = imgur.album("anAlbumId")

// Imgur API documentation doesn't specify optional attributes
// So to avoid unexpected errors, every attribute are Option
// Here how you can work with it :

// Print **safely** album link
album.link foreach { link =>
  println(link)
}

// Print **safely** every image link
album.images foreach { images =>
  images foreach { image =>
    image.link foreach { link =>
      println(link)
    }
  }
}

// Or with pattern matching (less safe)
album.images match {
  case Some(images) => images foreach {
    _.link match {
      case Some(link) => println(link)
      case None => Unit
    }
  }
  case None => Unit
}

// Or simply
for (image <- album.images)
  println(image.link.get)
```
