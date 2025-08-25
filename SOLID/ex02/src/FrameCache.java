public class FrameCache {
    private Frame last;

    public void store(Frame frame) {
        last = frame;
    }

    public boolean hasLast() {
        return last != null;
    }
}
