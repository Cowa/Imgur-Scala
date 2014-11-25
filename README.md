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

val images = imgur.albumImages("albumId")

for (image <- images)
  println(image.link)
```
