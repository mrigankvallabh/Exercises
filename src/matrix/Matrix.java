package matrix;

import java.util.ArrayList;

public class Matrix<T extends Number> {
  private final int nRow;
  private final int nCol;
  private final T[] elements;
  private final ArrayList<ArrayList<T>> elementsGrid = new ArrayList<>();

  public Matrix(int nRow, T[] elements) {
    this(nRow, nRow, elements);
  }

  public Matrix(int nRow, int nCol, T[] elements) {
    if (elements.length != nRow * nCol) {
      throw new IllegalArgumentException(
          "Incorrect size: Expected(" + nRow * nCol + "), but provided(" + elements.length + ")");
    }
    this.nRow = nRow;
    this.nCol = nCol;
    this.elements = elements;

    for (int i = 0; i < nRow; i++) {
      ArrayList<T> row = new ArrayList<>();
      for (int j = 0; j < nCol; j++) {
        row.add(elements[i * nCol + j]);
      }
      elementsGrid.add(row);
    }
  
    elementsGrid.trimToSize();
  }

  public int getSize() {
    return nRow * nCol;
  }

  public T getElementAt(int i, int j) {
    if (i >= nRow || j >= nCol) {
      throw new IllegalArgumentException("Invalid index (" + i + ", " + j + "): Indexes are 0 based!");
    }
    return elements[i * nCol + j];
  }

  @Override
  public String toString() {
    var sb = new StringBuilder("Matrix (" + nRow + "X" + nCol + ") [\n");
    for (var r : elementsGrid) {
      sb.append("\t" + r + "\n");
    }
    sb.append("]\n");
    return sb.toString();
  }

  public static void main(String[] args) {
    Double[] m = {
        0.5, 1.2, 2.7,
        3.1, 4.2, 5.0,
        6.3, 7.2, 8.1,
    };

    var matrix = new Matrix<Double>(3, 3, m);
    System.out.println(matrix.getElementAt(2, 1));
  }

  public static void reflectX(int[] m) {

  }
}
