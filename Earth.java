public class Earth {
    private double x, y;
    private double radius;
    private double dy;
    private String direction;
    SpaceShip s;
    
    // Interchangeable variables allow me to create the necessary
    // size and position of circles to create the visual of Earth
    public Earth(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.radius = z;
        this.dy = .005;
        this.direction = "down";
    }
    
    // Creates a hitbox for Earth
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
    
    // Checks if the spaceship has landed on Earth
    public boolean collidesWith(SpaceShip ship) {
        if (right() < ship.left()) {
            return false;
        }  else if (left() > ship.right()) {
            return false;
        }  else if (top() < ship.bottom()) {
            return false;
        }  else if (bottom() > ship.top()) {
            return false;
        }
        return true;
    }
    
    // Executes the movement of Earth to come towards the spaceship
    public void update() {
        if (this.direction.equals("down")) {
            this.y -= this.dy;
        }
    }
    
    // Interchangeable variables allow me to change the color of the circles
    // to represent the right parts of Earth correctly
    public void draw(int r, int g, int b) {
        StdDraw.setPenColor(r, g, b);
        StdDraw.filledCircle(this.x, this.y, this.radius);
    }
}