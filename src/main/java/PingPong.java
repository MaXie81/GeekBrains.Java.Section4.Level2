public class PingPong implements Runnable{
    private State state;
    private EnumPingPong isPing;

    public PingPong(State state, EnumPingPong isPing) {
        this.state = state;
        this.isPing = isPing;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            while (true) {
                synchronized (state) {
                    if (state.getValue() != isPing) {
                        state.turn();
                        isPing = state.getValue();
                        System.out.println(isPing.getValue());
                        break;
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
