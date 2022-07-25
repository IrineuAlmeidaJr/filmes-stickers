package model.MarvelCharacters;

public class Data {
    private int offset;
    private int limit;
    private Results[] results;

    public Data(int offset, int limit, Results[] results) {
        this.offset = offset;
        this.limit = limit;
        this.results = results;
    }

    public int getOffset() {
        return offset;
    }

    public int getLimit() {
        return limit;
    }

    public Results[] getResults() {
        return results;
    }
}
