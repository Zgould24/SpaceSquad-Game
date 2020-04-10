import java.awt.event.KeyEvent;

public class SpaceSquad {
    
    // This method allows me to execute an ending to the game when
    // I reach my goal of 7500 points
    public static void endGame(SpaceShip ss, Space space) {
        
        // Using a parent class to make up my Earth at the ending
        Earth main = new Earth(.5, 1.1, .5);
        Earth one = new Earth(.275 , 1.2, .25);
        Earth two = new Earth(.78, 1, .2);
        Earth three = new Earth(.45, .76, .15); 
        Earth four = new Earth(.68, 1.4, .15);
        
        boolean ending = true;
        
        while(ending) {
            StdDraw.clear();
            
            // Adding the black backgound
            space.draw();
            
            
            // Adding all my Earth parts and assigning different colors
            main.update();
            main.draw(0, 0, 230);
            
            one.update();
            one.draw(0, 200, 0);
            
            two.update();
            two.draw(0, 200, 0);
            
            three.update();
            three.draw(0, 200, 0);
            
            four.update();
            four.draw(0, 200, 0);
            
            
            // Checks if my spaceship lands on Earth
            if (main.collidesWith(ss)) {
                ending = false;
                
                StdDraw.setPenColor(255, 100, 0);
                StdDraw.text(.9, .05, "Welcome Back To");
                StdDraw.text(.9, .01, "Earth!");
            }
            
            // Drawing my spaceship
            ss.update();
            ss.draw();
            
            StdDraw.show(10);
        }
    }
    
    // This ending is to indicate when my spaceship has
    // run out of ammo
    public static void earlyEnd(SpaceShip ss, Space space) {
        boolean playing = true;
        
        while(playing) {
            StdDraw.clear();
            
            // Adding black background
            space.draw();
            // Adding spaceship
            ss.draw();
            // Calling method that moves the spaceship offscreen
            ss.retreat();
            
            // Indicating if my spaceship has made it offscreen so I can
            // end the game
            if (ss.atEdge()) {
                playing = false;
            }
            
            StdDraw.setPenColor(255, 0, 0);
            StdDraw.text(.5, .5, "You ran out of ammo. Retreat!!");
            
            StdDraw.show(10);
        }
    }
    
    // Main method that runs my game
    public static void main(String[] args) {
        // Creating all the necessary elements to have a game
        SpaceShip ss = new SpaceShip();
        Bullet b = new Bullet(ss);
        // Having a set amount of asteroids allows for less code
        // than an ArrayList and helps me keep track of each asteroid
        Asteroid[] a = new Asteroid[8];
        Space background = new Space();
        AmmoCrate ammo = new AmmoCrate();
        boolean playing = true;
        
        // Initializing my points and ammo that keeps track of my progress
        int count = 0;
        int bullets = 75;
        int counter = 0;
        
        // Creating all of my asteroids before the game starts
        // Each asteroid has a predetermined x value which allows each
        // asteroid to have its own lane and keeps the asteroids spaced
        // out and organized
        for (int i = 0; i < a.length; i ++) {
            if (i == 0) {
                a[i] = new Asteroid(.07);
            }  else if (i == 1) {
                a[i] = new Asteroid(.21);
            }  else if (i == 2) {
                a[i] = new Asteroid(.33);
            }  else if (i == 3) {
                a[i] = new Asteroid(.45);
            }  else if (i == 4) {
                a[i] = new Asteroid(.57);
            }  else if (i == 5) {
                a[i] = new Asteroid(.69);
            }  else if (i == 6) {
                a[i] = new Asteroid(.81);
            }  else if (i == 7) {
                a[i] = new Asteroid(.93);
            }  
        }
        
        // This is where the game starts
        while(playing) {
        
            StdDraw.clear();
            
            // Creating my space-like black background
            background.draw();
            
            // Recognizes when I have reached a certain goal so that my
            // reward will be an ammo refill
            if (count >= 50) {
                // Creating the ammo crate and executing its action
                ammo.down();
                ammo.draw();
                // Recognizing when I have acquired the ammo crate
                // so the ammo crate goes off screen
                if (ammo.collidesWithShip(ss)) {
                    bullets = bullets + 25;
                    ammo.y += 2;
                    ammo.radius = 0.0;
                    ammo.color1 = 0;
                    ammo.color2 = 0;
                    ammo.color3 = 0;
                }
            }
            
            // Recognizes when my bullet collides with an asteroid
            // so that it can spawn back up top as if it were a new asteroid
            for (int i = 0; i < a.length; i++) {
                if (a[i].collidesWith(b)) {
                    if (i == 0) {
                        a[i].update(.07);
                    }  else if (i == 1) {
                        a[i].update(.21);
                    }  else if (i == 2) {
                        a[i].update(.33);
                    }  else if (i == 3) {
                        a[i].update(.45);
                    }  else if (i == 4) {
                        a[i].update(.57);
                    }  else if (i == 5) {
                        a[i].update(.69);
                    }  else if (i == 6) {
                        a[i].update(.81);
                    }  else if (i == 7) {
                        a[i].update(.93);
                    }    
                    
                    // Adding a point to my progress each time a bullet
                    // collides with an asteroid
                    count += 1;
                    
                    // Adding points to my counter, going up by 100s
                    if (counter < 75000){
                        counter += 100;
                    }
                }
                
                // When randomizing my speed for the asteroids some are
                // either too fast or too slow. This allows me to adjust
                // the randomization to a certain range that I feel is fit
                // If the random speed doesn't fit into my predeterminded
                // range, then it keeps resetting until it finally fits a
                // a decent speed
                if (a[i].dy >.005 || a[i].dy < .002) {
                    if (i == 0) {
                        a[i].update(.07);
                    }  else if (i == 1) {
                        a[i].update(.21);
                    }  else if (i == 2) {
                        a[i].update(.33);
                    }  else if (i == 3) {
                        a[i].update(.45);
                    }  else if (i == 4) {
                        a[i].update(.57);
                    }  else if (i == 5) {
                        a[i].update(.69);
                    }  else if (i == 6) {
                        a[i].update(.81);
                    }  else if (i == 7) {
                        a[i].update(.93);
                    } 
                }
                // Recognizes that if I have missed an asteroid and it hits
                // the bottom of the screen, it will reset back up top
                // so that I can continue shooting asteroids
                if (a[i].atEdge()) {
                    if (i == 0) {
                        a[i].update(.07);
                    }  else if (i == 1) {
                        a[i].update(.21);
                    }  else if (i == 2) {
                        a[i].update(.33);
                    }  else if (i == 3) {
                        a[i].update(.45);
                    }  else if (i == 4) {
                        a[i].update(.57);
                    }  else if (i == 5) {
                        a[i].update(.69);
                    }  else if (i == 6) {
                        a[i].update(.81);
                    }  else if (i == 7) {
                        a[i].update(.93);
                    }
                }
                
                // Creating the asteroids and executing their movement
                a[i].down();
                a[i].draw();
            }
            
            // Creates the bullet and constantly checks the position of
            // the spaceship to align the bullet with the spaceship
            b.update();
            b.draw();
            
            // Checks that if the bullet is gone from the screen, I have
            // one less bullet in my ammo counter
            if (b.y >= 1.1) {
                bullets -= 1;
                // Makes sure that my bullet counter doesn't keep going
                // when I run out of ammo so that I don't end up with
                // negative ammo
                if (bullets == 0) {
                    bullets = 0;
                }
            }
            
            // Creating ammo counter
            StdDraw.setPenColor(0, 255, 0);
            StdDraw.text(.01, .01, "Ammo:");
            StdDraw.text(.09, .01, Integer.toString(bullets));
            
            // Creating points counter
            StdDraw.setPenColor(255, 0, 0);
            StdDraw.text(.85, .95, "Points:");
            StdDraw.text(.95, .95, Integer.toString(counter));
            
            // Checks that if I have ran out of ammo AND the ammo crate
            // isn't on the screen, then the game ends for me
            // If the ammo crate is still on screen, I would want the game
            // to continue since I would still have a chance to gain ammo
            if (bullets == 0 && !ammo.onScreen(background)) {
                earlyEnd(ss, background);
                playing = false;
                StdDraw.setPenColor(255, 0, 0);
                StdDraw.text(.5, .5, "You ran out of ammo. Retreat!!");
            } 
             
            // Checks if I have reached my goal of 75 asteroid destroyed
            // so that I can return back to Earth
            if (count == 75) {
                endGame(ss, background);
                playing = false;
            }
            
            // Checks if any of the asteroids collides with my spaceship
            // so that I can end the game
            for (int i = 0; i < a.length; i++) {
                if (a[i].collidesWithShip(ss)) {
                        playing = false;
                        
                        StdDraw.setPenColor(255, 0, 0);
                        StdDraw.text(.5, .75, "Game Over!");
                }
            }
            
            // Creates the spaceship and executes its movements
            ss.update();
            ss.draw();
            
            StdDraw.show(10);
        }
    }
}