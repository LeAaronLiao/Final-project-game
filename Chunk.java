public class Chunk {
    private int[][] chunk;
    private int size;

    public Chunk(int size) {
        this.size = size;
        this.chunk = new int[size][size];
    }

    public int[][] getChunk() {
        return chunk;
    }

    public void setChunk(int[][] chunk) {
        this.chunk = chunk;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}