[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-Painter-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/735)

![Image](https://github.com/agrosner/Painter/blob/master/palette.jpg?raw=true)

Painter
=======

Why use different colors of the same asset when you can include one color and change it to fit your needs? Also how do you handle dynamic changes such as when you use a drawer and want to do some really neat effects? 
<br />
This library enables you to color a view, image icons, and text in a very simple way. 

## Usage

### PreRequisites

1. This project includes android support-v4:20.+ and appcompat-v7:20.+. I will make sure to make a version using only native dependencies or without appcompat. 
2. This project currently compiles with API 20 and buildToolsVersion 20.0.0, hopefully there will be a way to use project level in the future. 
3. MinSdk is 5, however with appcompat and support that is upped to 8. I will try to make it lower for non-support libraries.
4. This project is currently in **active** development. Using the development branch has *no* guarantees of working functionality and or/breaking changes to code. The best bet is the master branch for all stable releases, or by using a remote aar dependency. 

### Including in your project

1. Clone this repo
2. Go to your build.gradle file

```groovy

dependencies{
  compile 'com.github.agrosner:library:1.0.+'
  
  //or locally in the a folder named "Libraries"
  compile project(':Libraries:Painter');
}

```
<br />

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
  // "cloneDrawable" specifies we want to mutate the drawable so that any changes to it will not be globally saved
  IconPainter iconPainter = new IconPainter(cloneDrawable, Color.BLACK);
  iconPainter.paint(object);
  
  //specify a PorterDuff Mode for different effects
  iconPainter.withMode(mode);

  //can reuse object for different paints if you wish
  iconPainter.paintColor(cloneDrawable, Color.Black, object1, object2, objectn);
```

#### Background Painting

Background painting will take the background of the item you pass in (namely it's background drawable) and change the color as well. It is **strongly** advised you do not paint the actionbar background more than once on first load as this is extremely inefficient due to the fact we cannot easily retrieve the background drawable once it is set on the actionbar. 

<br />
Example 1:
<br />
```java

  //we can use many View, MenuItem's action view, or ActionBars
  new BackgroundPainter(cloneDrawable, Color.BLUE).paint(view, actionView, actionBar);
  
  //can use different paints if you want
  new BackgroundPainter().paintColor(cloneDrawable, Color.Blue, objects);

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
  
  //this will set the color of the actionbar and begin sliding. 
  // this required for an actionbar as there is no easy way to acquire the ActionBar drawable background
  new ActionBarAlphaSlider(startFullAlpha, actionBar, startColor);

```

#### Color Slider

This will slide from one color to another, displaying all colors in between to create a nice "blending" effect. You pass in the correct **Painter** you want to paint with so it knows which property to look for.

```java

  new ColorSlider(Color.Black, Color.WHITE).with(new BackgroundPainter()).onSlide(slideOffset, object1, object2,objectn);
  new ColorSlider(getResources().getColor(R.color.my_color), getResources().getColor(R.color.my_color_2)).with(new IconPainter()).onSlide(slideOffset, icon1, icon2, icon3, iconn);
  
  ActionBarColorSlider slider = new ActionBarColorSlider(actionBar, startColor, endColor);
  ...
  slider.onSlide(slideOffset);

```

## Open Source

I will love and appreciate all merge requests. Here are some basic rules on them:
1. Try to match my coding style.
2. If they require any breaking changes, they must be on development branch, otherwise I will reject them.
3. Please leave a summary of what you changed/added.

Thank you!

## License

The MIT License (MIT)

Copyright (c) 2014 Andrew Grosner

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.

