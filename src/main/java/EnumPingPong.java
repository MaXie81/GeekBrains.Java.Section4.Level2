public enum EnumPingPong {
    PING("ping"),
    PONG("pong");

    private String value;

    EnumPingPong(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
