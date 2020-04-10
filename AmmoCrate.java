public class AmmoCrate {
    double x, y;
    double radius;
    double dy;
    int color1, color2, color3;
    private String direction;
    SpaceShip s;
    Space background;
    
    public AmmoCrate() {
        // Ammo crate will always spawn at a different position each time a
        // new game begins
        this.x = Math.random();
        this.y = 1.1;
        this.radius = .053;
        this.dy = .003;
        // Predetermines movement of ammo crate 
        this.direction = "down";
        // Having controlable variables for colors so that I can change all
        // the colors to black to give the illusion that the crate has
        // despawned
        this.color1 = 220;
        this.color2 = 100;
        this.color3 = 255;
    }
    
    // Method that creates hitbox for ammo crate and checks if the
    // spaceship and the ammo crate collide
    public boolean collidesWithShip(SpaceShip s) {
        double left = this.x - this.radius;
        double right = this.x + this.radius;
        double top = this.y + this.radius;
        double bottom = this.y - this.radius;
        
        if (right < s.left()) {
            return false;
        }  else if (left > s.right()) {
            return false;
        }  else if (top < s.bottom()) {
            return false;
        }  else if (bottom > s.top()) {
            return false;
        }
        
        return true;
    }
    
    // Checks if the ammo crate is within the boundaries of the black
    // space background so that the game doesn't end if I run out of ammo
    // and the ammo crate is still on screen
    public boolean onScreen(Space space) {
        double left = this.x - this.radius;
        double right = this.x + this.radius;
        double top = this.y + this.radius;
        double bottom = this.y - this.radius;
        
        if (right < space.left()) {
            return false;
        }  else if (left > space.right()) {
            return false;
        }  else if (top < -0.1) {
            return false;
        }  else if (bottom > 1.0) {
            return false;
        }
        
        return true;
    }
    
    // Executes the movement for the ammo crate to come towards the spaceship
    public void down() {
        if (this.direction.equals("down")) {
            this.y -= this.dy;
        }
    }
    
    public void draw() {
        StdDraw.setPenColor(color1, 0, color2);
        StdDraw.filledCircle(this.x, this.y, this.radius);
        StdDraw.setPenColor(color3, color3, color3);
        StdDraw.text(this.x, this.y, "+Ammo");
    }
    
}
