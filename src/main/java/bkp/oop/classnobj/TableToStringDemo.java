package src.main.java.bkp.oop.classnobj;

public class TableToStringDemo {

  public static void main(String[] args) {
    // Without toString method it prints the object representation rather than data
    Table table = new Table(1.2, 3, 3);
    System.out.println(table);
  }
}
