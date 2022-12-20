package lesson5;

public class AppData {
    private String[] headers;
    private int[][] data;

    public void setHeaders(String[] headers) {
        this.headers = headers;
    }

    public void setData(int[][] data) {
        this.data = data;
    }

    public int[][] getData() {
        return this.data;
    }
}
