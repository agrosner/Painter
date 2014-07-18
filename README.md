Painter
=======

This library enables you to color a view, image icons, and text in a very simple way. 

## Usage


### Painting 

Painting is the simple way of changing the color of an object (ActionBar, MenuItem, or Views) without much hassle. 
<br />
Let *Painter* handle coloring your wonderful visual elements.

#### Icon Painting

Icon painting is a very simple way to change the color of any Imaged-backed object you want. Note: this works well on small icons, but larger images I would refrain from using. 
<br />
Example 1:
<br />
```java

  // "object" applies to a MenuItem, ImageView image, or TextView compound drawable. 
  new IconPainter(Color.BLACK).paint(object);

  //can reuse object for different paints if you wish
  new IconPainter().paint(object, Color.Black);
```

#### Background Painting

Background painting will take the background of the item you pass in (namely it's background drawable) and change the color as well.

<br />
Example 1:
<br />
```java

  //in this case, the "object" applies to a View, MenuItem's action view, or ActionBar
  new BackgroundPainter(Color.BLUE).paint(object);
  
  //can use different paints if you want
  new BackgroundPainter().paint(object, Color.Blue);

```

### Sliders
