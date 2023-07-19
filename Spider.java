public class Spider {
    private int x;
    private int y;
    private String direction;

    public Spider(int x, int y, String direction){
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void move(){
        switch(this.direction){
            case "up":
                this.y += 1;
                break;
            case "down":
                this.y -= 1;
                break;
            case "left":
                this.x -= 1;
                break;
            case "right":
                this.x += 1;
                break;
        }
    }

    public void setDirection(String d){
        switch(d){
            case "up":
                this.direction = "up";
                break;
            case "down":
                this.direction = "down";
                break;
            case "left":
                this.direction = "left";
                break;
            case "right":
                this.direction = "right";
                break;
        }
    }
}