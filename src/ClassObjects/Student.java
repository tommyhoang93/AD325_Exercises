package ClassObjects;

public class Student {

    private String name;
    private int id_number;
    private int units;

    public Student(String name, int id_number) {
        this.name = name;
        this.id_number = id_number;
        this.units = 0;
    }

    public String getName() {
        return name;

    }

    public int getId_number() {
        return id_number;

    }

    public int getUnits() {
        return units;

    }

    public void incrementUnits(int units) {
        this.units += units;

    }

    public boolean hasEnoughUnits() {
        return this.units >= 180;

    }

    public String toString() {
        return name + ("(#" + id_number + ")");

    }







}
