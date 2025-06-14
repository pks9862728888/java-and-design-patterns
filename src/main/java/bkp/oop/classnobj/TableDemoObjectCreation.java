package src.main.java.bkp.oop.classnobj;

public class TableDemoObjectCreation {

  public static void main(String[] args) {
    Table table = createTableUsingNoArgumentConstructor();
    printTable(table);

    Table table1 = createTableUsingAllArgumentConstructor();
    printTable(table1);
  }

  private static Table createTableUsingAllArgumentConstructor() {
    return new Table(5, 1.2, 1.2);
  }

  private static Table createTableUsingNoArgumentConstructor() {
    Table table = new Table(); // create object using no argument constructor
    table.height = 5;
    table.width = 1.2;
    table.length = 1.2;
    return table;
  }

  private static void printTable(Table table) {
    System.out.println("Table height: " + table.getHeight());
    System.out.println("Table width: " + table.getWidth());
    System.out.println("Table length: " + table.getLength());
  }
}
