import java.awt.event.KeyEvent;

public class SpaceShip {
    double x, y;
    private double step, up;
    private double radius;
    private String direction;
    
    public SpaceShip() {
        this.x = .5;
        this.y = .01;
        this.radius = .025;
        this.step = .006;
        this.up = 0.015;
        // Determined now for my retreat method
        this.direction = "up";
    }
    
    // Had to declare the methods as doubles so I could get the x and y
    // values for the repositioning of the bullet
    public double leftRight() {
        if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT)) {
             this.x -= (this.step + .0002);
       }
       if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)) {
            this.x += (this.step + .0002);
       }
       
       return this.x;
    }
    public double upDown() {
        if (StdDraw.isKeyPressed(KeyEvent.VK_UP)) {
           this.y += this.step;
       }
       if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)) {
           this.y -= this.step;
       }
       
       return this.y;
    }
    
    // Define hitbox of spaceship
    public double right() {
        return this.x + this.radius;
    }
    public double left() {
        return this.x - this.radius;
    }
    public double top() {
        return this.y + this.radius;
    }
    public double bottom() {
        return this.y - this.radius;
    }
    
    // Retreat method for when player runs out of ammo
    public void retreat() {
        if (this.direction.equals("up")) {
            this.y += this.up;
        }
    }
    
    // Method for determining if spaceship is offscreen so the game can end
    public boolean atEdge() {
        if (this.y >= 1.1) {
            return true;
        }
        
        return false;
    }
    
    // Method that turns the doubles into a void update method so that I
    // can still move the spaceship
    public void update() {
       leftRight();
       upDown();
    }
    
    // Creates the spaceship
    public void draw() {
        StdDraw.setPenColor(250, 100, 0);
        StdDraw.filledSquare(this.x, this.y, this.radius);
    }
}