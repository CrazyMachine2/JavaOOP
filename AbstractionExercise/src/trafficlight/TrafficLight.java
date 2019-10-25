package trafficlight;

public class TrafficLight {
    private Color color;
//    private int iteration;

    public TrafficLight(Color color) {
        this.color = color;
//        this.iteration = this.color.getValue();
    }

    public void setColor() {
//        setIteration(this.iteration);

        switch (this.color) {
            case RED:
                this.color = Color.GREEN;
                break;
            case GREEN:
                this.color = Color.YELLOW;
                break;
            case YELLOW:
                this.color = Color.RED;
                break;
        }
    }

//    private void setIteration(int iteration) {
//        if (this.iteration >= 2){
//            this.iteration = 0;
//        } else {
//            this.iteration++;
//        }
//    }

    public Color getColor() {
        return color;
    }
}
