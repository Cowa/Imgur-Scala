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

// Print images' link (easy way)
for (image <- album.images)
  println(image.link.get)

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

// Or with pattern matching
album.images match {
  case Some(images) => images foreach {
    _.link match {
      case Some(link) => println(link)
      case None => Unit
    }
  }
  case None => Unit
}
```

## Tests

To run tests, you have to set some environment variables :

- `IMGUR_KEY`, your Imgur API key
- `IMGUR_ALBUM`, an Imgur album ID

No mock, only real world.

Then run :

`sbt test`
