package src.main.java.bkp.oop.classnobj;

public class Table {
  // data members
  double height;
  double width;
  double length;

  // No argument constructor
  Table() {}

  // All argument constructor
  Table(double height, double width, double length) {
    this.height = height;
    this.width = width;
    this.length = length;
  }

  // member functions
  public double getHeight() {
    return height;
  }

  public double getWidth() {
    return width;
  }

  public double getLength() {
    return length;
  }

  @Override
  public String toString() {
    return "Table{" +
        "height=" + height +
        ", width=" + width +
        ", length=" + length +
        '}';
  }
}
