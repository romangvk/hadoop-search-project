package src;

import src.Actions;
import src.ErrorDialog;
import src.LoadFiles;
import src.SearchTerm;
import src.TopNTerms;

class Main {
  public static void main(String[] args) {
    Actions a = new Actions();
    a.setVisible(true);

    LoadFiles l = new LoadFiles();
    l.setVisible(true);

    SearchTerm s = new SearchTerm();
    s.setVisible(true);

    TopNTerms t = new TopNTerms();
    t.setVisible(true);
  }
}