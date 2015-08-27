// Eva Cai
Ball mmm;

void setup ()
{
  size (400, 500);
  mmm = new Ball();
 frameRate(150); 
}
void draw ()
{
  background (0);
  mmm.move ();
  mmm.bounce();
  mmm.show ();
  mmm.grow ();
  mmm.shrink ();
  words();
}
void words()
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
    up = boolean(UP);
    right = boolean(RIGHT);
    x= 250;
    y= 250;
    size = 20;
  }
  void move ()
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
  void bounce ()
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
  void face ()
  {		
  	if (x<size/2 & size>50)
  	{
  		fill (255);
  		ellipse(x-(size/4), y, 30, 50);
  	}
  }
  void show ()
  {
    if (x<size/2||x>400-(size/2)||y>500-(size/2)||y<size/2)
    {
      fill (random(255), random(255), random(255));
    }
    ellipse (x, y, size, size);
  }
  void grow ()
  {
    if (mousePressed == true)
    {
      size +=10;
    }
  }
  void shrink ()
  {
    if (keyPressed == true && key == ' ')
    {
      size -=10;
    }
  }
}
