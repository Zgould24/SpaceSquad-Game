public class Asteroid {
    double x, y;
    double radius;
    double dy;
    private String direction;
    Bullet b;
    SpaceShip s;
    
    public Asteroid(double x) {
        this.x = x;
        // Makes sure that the asteroids spawn above the screen so that the
        // player doesn't see them spawn
        this.y = Math.random() + 1.2;
        this.radius = .05;
        // Sets a random speed for asteroids but restricts it to the
        // hundredths so that the speed isn't insane
        this.dy = Math.random()/150;
        this.direction = "down";
    }
    
    // Executes the movement for the asteroids
    public void down() {
        if (this.direction.equals("down")) {
            this.y -= this.dy;
        }
    }
    
    // Reset position for asteroid when it is either shot at or hits bottom
    // of screen
    // Has a predetermined x value so that each asteroid stays in a lane
    public void update(double x) {
        this.x = x;
        this.y = (Math.random() + 1.1) + .4;
        this.dy = Math.random()/150;
    }
    
    // Checks if the asteroid has made it to the bottom of the screen
    public boolean atEdge() {
        double bottom = this.y - this.radius;
        
        if (bottom <= 0.0) {
            return true;
        }
        
        return false;
    }
    
    // Checks if an asteroid has collided with the spaceship to end the game
    public boolean collidesWithShip(SpaceShip ship) {
        double left = this.x - this.radius;
        double right = this.x + this.radius;
        double top = this.y + this.radius;
        double bottom = this.y - this.radius;
        
          if (left > ship.right()) {
              return false;
          }  else if (right < ship.left()) {
              return false;
          }  else if (top < ship.bottom()) {
              return false;
          }  else if (bottom > ship.top()) {
              return false;
          }
          
        return true;
        }
    
    // Checks if an asteroid was hit by a bullet
    public boolean collidesWith(Bullet bullet) {
        double right = this.x + this.radius;
        double left = this.x - this.radius;
        double top = this.y + this.radius;
        double bottom = this.y - this.radius;
        
        if (right < bullet.left()) {
            return false;
        }   else if (left > bullet.right()) {
            return false;
        }   else if (bottom > bullet.top()) {
            return false;
        }  else if (top < bullet.bottom()) {
            return false;
        }
        
        return true;
    }
    
    // Creates the asteroids
    public void draw() {
        StdDraw.setPenColor(255, 255, 255);
        StdDraw.filledSquare(this.x, this.y, this.radius);
    }
}