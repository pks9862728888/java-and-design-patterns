package src.main.java.bkp.oop.classnobj;

public class TableDemoLocalCopy {

  public static void main(String[] args) {
    Table table = new Table(1.2, 3, 3);
    printTable(table);

    Table table1 = new Table(9.2, 9, 1);
    printTable(table1);
  }

  private static void printTable(Table table) {
    System.out.println("Table height: " + table.getHeight());
    System.out.println("Table width: " + table.getWidth());
    System.out.println("Table length: " + table.getLength());
  }
}
