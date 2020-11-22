package src;

public class Connection {
    int x;

    public Connection() {
        x = 10;
    }
    public Connection(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public String search(String term) {
        String output = "";
        for(int i = 0; i < x-1; i++) {
            output += term + '\n';
        }
        return output + term;
    }
}
