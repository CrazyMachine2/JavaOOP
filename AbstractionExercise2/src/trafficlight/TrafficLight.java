package trafficlight;

public class TrafficLight {
    private State state;

    public TrafficLight(State state) {
        this.state = state;
    }

    public void changeState() {

        switch (this.state) {
            case RED:
                this.state = State.GREEN;
                break;
            case GREEN:
                this.state = State.YELLOW;
                break;
            case YELLOW:
                this.state = State.RED;
                break;
        }

//        if (this.state.name().equals("RED")) {
//            this.state = State.GREEN;
//        } else if (this.state.name().equals("YELLOW")) {
//            this.state = State.RED;
//        } else {
//            this.state = State.YELLOW;
//        }
    }

    public String getState() {
        return this.state.name();
    }
}
