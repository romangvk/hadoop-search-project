package src;

public class Cluster {
    Boolean hugo;
    Boolean shakespeare;
    Boolean tolstoy;

    public void setAllFiles() {
        this.hugo = true;
        this.shakespeare = true;
        this.tolstoy = true;
    }
    public void setFiles(Boolean hugo, Boolean shakespeare, Boolean tolstoy) {
        this.hugo = hugo;
        this.shakespeare = shakespeare;
        this.tolstoy = tolstoy;
    }

    public String top(int n) {
        String output = "";
        for (int i = 0; i < n - 1; i++) {
            output += "the" + '\n';
        }
        return output + "the";
    }

    public String search(String term) {
        String output = "";
        if (hugo)
            output += "hugo" + '\n';
        if (shakespeare)
            output += "shakespeare " + '\n';
        if (tolstoy)
            output += "tolstoy" + '\n';
        return output + term;
    }
}
