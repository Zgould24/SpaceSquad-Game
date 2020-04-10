import java.awt.event.KeyEvent;

public class Bullet {
    
    double x, y, newX;
    private double radius;
    private double dy;
    private String direction;
    SpaceShip s;
    Asteroid[] a;

    public Bullet(SpaceShip ship) {
        this.x = ship.x;
        this.y = ship.y;
        this.radius = .015;
        this.dy = .04;
        // Doesn't confuse the program with a predetermined movement but also
        // allows me to change the direction to something when a button is
        // pressed
        this.direction = "";
        // Allows me to access variables and methods inside SpaceShip
        this.s = ship;
    }

    // Controls the movement of the bullet when it is shot or when it is
    // inside the spaceship
    public void update() {
        if (this.direction.equals("up")) {
            this.y += this.dy;
        }   else if (this.direction.equals("return")) {
            this.x = this.s.x;
            this.y = this.s.y;
        }  else if (!this.direction.equals("up")){
            this.x = this.s.leftRight();
            this.y = this.s.upDown();
        }
        
        if (StdDraw.isKeyPressed(KeyEvent.VK_SPACE)) {
            this.direction = "up";
        }
        
        if (this.y >= 1.1) {
            this.direction = "return";
        }
    }
    
    // Creates a hitbox for the bullet
    public double left() {
        return this.x - this.radius;
    }
    public double right() {
        return this.x + this.radius;
    }
    public double top() {
        return this.y + this.radius;
    }
    public double bottom() {
        return this.y - this.radius;
    }
    
    // Creates the bullet
    public void draw() {
        StdDraw.setPenColor(0, 255, 0);
        StdDraw.filledCircle(this.x, this.y, this.radius);
    }
}