import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class OriginalDesign extends PApplet {

// Eva Cai
Ball mmm;

public void setup ()
{
  size (400, 500);
  mmm = new Ball();
 frameRate(150); 
}
public void draw ()
{
  background (0);
  mmm.move ();
  mmm.bounce();
  mmm.show ();
  mmm.grow ();
  mmm.shrink ();
  words();
}
public void words()
{
  
  textAlign (CENTER);
  textSize (32);
  text ("Click Mouse to Grow",200,410);
  text ("Press Space to Shrink",200,450);
}
class Ball 
{
  int x;
  int y;
  boolean up;
  boolean right;
  int size;
  Ball ()
  {
    up = PApplet.parseBoolean(UP);
    right = PApplet.parseBoolean(RIGHT);
    x= 250;
    y= 250;
    size = 20;
  }
  public void move ()
  {
    if (right == true)
    {
      x++;
    } else
    {
      x--;
    }
    if (up == false)
    {
      y++;
    } else
    {
      y--;
    }
  }
  public void bounce ()
  {
    if (x<size/2)
    {
      right = true;
    }
    if (x>400-(size/2))
    {
      right = false;
    }
    if (y> 500-(size/2))
    {
      up =true;
    }
    if (y<size/2)
    {
      up=false;
    }
  }
  public void face ()
  {		
  	if (x<size/2 & size>50)
  	{
  		fill (255);
  		ellipse(x-(size/4), y, 30, 50);
  	}
  }
  public void show ()
  {
    if (x<size/2||x>400-(size/2)||y>500-(size/2)||y<size/2)
    {
      fill (random(255), random(255), random(255));
    }
    ellipse (x, y, size, size);
  }
  public void grow ()
  {
    if (mousePressed == true)
    {
      size +=10;
    }
  }
  public void shrink ()
  {
    if (keyPressed == true && key == ' ')
    {
      size -=10;
    }
  }
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "OriginalDesign" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
