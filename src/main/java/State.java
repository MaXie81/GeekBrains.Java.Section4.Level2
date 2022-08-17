public class State {
    private EnumPingPong value;

    public EnumPingPong getValue() {
        return value;
    }

    public void turn() {
        value = value == EnumPingPong.PING ? EnumPingPong.PONG : EnumPingPong.PING;
    }
}
