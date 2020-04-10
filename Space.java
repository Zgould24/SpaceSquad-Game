public class Space {
    private double x, y, radius;
    
    // Creating a black background to represent space
    public Space() {
        this.x = .5;
        this.y = .5;
        this.radius= .75;
    }
    
    // Creating a hitbox for the space background to communicate with the
    // ammo box
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
    
    // Creates the space background
    public void draw() {
        StdDraw.setPenColor(0, 0, 0);
        StdDraw.filledSquare(this.x, this.y, this.radius);
    }
}
