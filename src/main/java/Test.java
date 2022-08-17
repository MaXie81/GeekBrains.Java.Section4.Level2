public class Test {
    public static void main(String[] args) throws InterruptedException {
        State state = new State();
        Thread ping = new Thread(new PingPong(state, EnumPingPong.PING));
        Thread pong = new Thread(new PingPong(state, EnumPingPong.PONG));

        ping.start();
        pong.start();
    }
}
