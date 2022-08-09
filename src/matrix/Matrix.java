package matrix;

import java.lang.reflect.Array;
import java.util.Arrays;

@SuppressWarnings("unused")
public class Matrix<T extends Number> {
  private int nRow;
  private int nCol;
  private T[] elements;
  private T[][] elementsGrid;

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

    @SuppressWarnings("unchecked")
    T[][] t = (T[][]) Array.newInstance(elements.getClass().getComponentType(), new int[] { nRow, nCol });

    elementsGrid = t;
    for (int i = 0; i < nRow; i++) {
      for (int j = 0; j < nCol; j++) {
        elementsGrid[i][j] = elements[i * nCol + j];
      }
    }
    System.out.println(Arrays.deepToString(elementsGrid));

  }

  public static void main(String[] args) {
    Double[] m = {
        0.5, 1.2, 2.7,
        3.1, 4.2, 5.0,
        6.3, 7.2, 8.1,
    };

    var matrix = new Matrix<Double>(3, 3, m);
  }

  public static void reflectX(int[] m) {

  }
}
