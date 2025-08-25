public class Player {
    private final FrameDecoder decoder;
    private final FrameCache cache;

    public Player(FrameDecoder decoder, FrameCache cache) {
        this.decoder = decoder;
        this.cache = cache;
    }

    public void play(byte[] fileBytes) {
        // Decode
        Frame frame = decoder.decode(fileBytes);
        // Cache
        cache.store(frame);
        // Draw UI
        System.out.println("\u25B6 Playing " + fileBytes.length + " bytes");
        System.out.println("Cached last frame? " + cache.hasLast());
    }
}
