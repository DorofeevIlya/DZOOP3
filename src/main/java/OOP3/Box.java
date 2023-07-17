package OOP3;
public class Box extends Container {
    private int weight;
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    @Override
    public String toString() {
        return " " + weight;
    }
    public Box(int weight) {
        this.weight = weight;
    }
}