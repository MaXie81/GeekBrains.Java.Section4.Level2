public class PingPong implements Runnable{
    private final EnumPingPong word;

    public PingPong(boolean isPing) {
        word = isPing ? EnumPingPong.PING : EnumPingPong.PONG;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
                System.out.println(word.getValue());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
