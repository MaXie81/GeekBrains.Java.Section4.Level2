public class Test {
    public static void main(String[] args) throws InterruptedException {
        Thread ping = new Thread(new PingPong(true));
        Thread pong = new Thread(new PingPong(false));

        ping.start();
        Thread.sleep(500);
        pong.start();
    }
}
