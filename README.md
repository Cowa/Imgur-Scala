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

// Create an Imgur client
val imgur = new Imgur("myClientId")

// Get an album
val album = imgur.album("anAlbumId")

// Get an image
val image = imgur.image("anImageId")

// Get an image from an album
val albumImage = imgur.albumImage("anAlbumId", "anImageId")

// Get every image from an album
val albumImages = imgur.albumImages("anAlbumId")

// Get memes image
val memes = imgur.memes()
```

## Tests

To run tests, you have to set some environment variables :

- `IMGUR_KEY`, your Imgur API key
- `IMGUR_ALBUM`, an Imgur album ID

No mock, only real world.

Then run :

`sbt test`
