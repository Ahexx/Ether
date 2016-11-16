package pl.ether.models;

public enum ValidationLevel {
    ALL(0), BODY(1), BODY_TEXT(3);
    int choice;

    ValidationLevel(int lvl) {
        // TODO Auto-generated constructor stub
        choice = lvl;
    }
}