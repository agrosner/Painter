Painter
=======

Why use different colors of the same asset when you can include one color and change it to fit your needs? Also how do you handle dynamic changes such as when you use a drawer and want to do some really neat effects? 
<br />
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
  // this is a varg param
  new IconPainter(Color.BLACK).paint(object);

  //can reuse object for different paints if you wish
  new IconPainter().paint(Color.Black, object1, object2, objectn);
```

#### Background Painting

Background painting will take the background of the item you pass in (namely it's background drawable) and change the color as well.

<br />
Example 1:
<br />
```java

  //we can use many View, MenuItem's action view, or ActionBars
  new BackgroundPainter(Color.BLUE).paint(view, actionView, actionBar);
  
  //can use different paints if you want
  new BackgroundPainter().paint(Color.Blue, objects);

```

### Sliders

Sliders describe mutating a property from one value to the next based on a ratio from 0 to 1. 
<br />
Supported Sliders include:
* AlphaSlider
* ColorSlider
* Create your own *PropertySlider* class

#### Alpha Slider

This will set the background alpha on the object you pass in whether its an ActionBar, MenuItem, or View.

```java

  //"slideOffset" is a number from 0...1 and "myObjects" is a varg param that operates on multiple objects
  new AlphaSlider(startFullAlpha).onSlide(slideOffset, myObjects);

```
