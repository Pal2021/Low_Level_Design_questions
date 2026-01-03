package Creational_Design_Pattern.Prototype_Pattern.Wrong_Code;
public class GamePiece {

    private String color;
    private int position;

    public String getColor() {
        return color;
    }

    public int getPosition() {
        return position;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public GamePiece(String color,int position){
        this.color = color;
        this.position = position;
    }

    @Override
    public String toString() {
        return "GamePiece{" +
                "color='" + color + '\'' +
                ", position=" + position +
                '}';
    }
}