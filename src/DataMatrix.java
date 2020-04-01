//Stubs for the DataMatrix Class
//Labeled who is doing which sections.

public class DataMatrix implements BarcodeIO {
   // DATA - Bryce
   public static final char BLACK_CHAR = '*';
   public static final char WHITE_CHAR = ' ';
   private BarcodeImage image;
   private String text;

   private int actualWidth;
   private int actualHeight;

   // Constructors - Bryce
   public DataMatrix()// default
   {
      text = "";
      actualWidth = 0;
      actualHeight = 0;
      image = new BarcodeImage();
   }

   public DataMatrix(BarcodeImage image)// image only
   {
      text = "";

      if (scan(image) == false) {
         actualWidth = 0;
         actualHeight = 0;
         image = new BarcodeImage();
      }

   }

   public DataMatrix(String text)// text only
   {
      actualWidth = 0;
      actualHeight = 0;
      image = new BarcodeImage();

      if (readText(text) == false)
         text = "";
   }

   // Accessors - Bryce
   public int getActualWidth() {
      return actualWidth;
   }

   public int getActualHeight() {
      return actualHeight;
   }

   // Jeannie
   public boolean scan(BarcodeImage bc) {
      // TODO Auto-generated method stub
      return false;
   }

   // passing a String parameter to readText method.
   // returning false if text is null
   public boolean readText(String text) {
      if (text == null)
         return false;

      this.text = text;
      return true;
   }

   // Jeannie
   public boolean generateImageFromText() {
      // TODO Auto-generated method stub
      return false;
   }

// reading char from each column in image
   private char readCharFromCol(int col) {
      int readChar = 0;
      int fromCol = 0;

      for (int i = BarcodeImage.MAX_HEIGHT - 2; i > BarcodeImage.MAX_HEIGHT - actualHeight; i--) {
         if (this.image.getPixel(i, col)) {
            readChar = readChar + (int) Math.pow(2, fromCol);
         }
         fromCol++;
      }
      return (char) (readChar);
   }

// translating image to text by decoding each column
   public boolean translateImageToText() {
      char colChar[] = new char[actualWidth - 1];
      for (int i = 1; i < actualWidth - 1; i++) {
         colChar[i] = readCharFromCol(i);
      }
      String colString = new String(colChar);
      text = colString;
      return true;
   }

   // Jeannie
   public void displayTextToConsole() {
      // TODO Auto-generated method stub

   }

   // Bryce
   public void displayImageToConsole() {
      // TODO Auto-generated method stub

   }

   // move the signal to the lower-left of the larger 2D array 
   //with cleanImage method.
   private void cleanImage() {
      int startRow = 0;
      int startColumn = 0;
      boolean spine = false;

      while (!spine) {
         for (int i = BarcodeImage.MAX_HEIGHT; i > 0; i--) {
            for (int j = 0; j < (BarcodeImage.MAX_WIDTH - 1); j++) {
               if (image.getPixel(i, j)) {
                  startRow = i;
                  startColumn = j;
                  spine = true;
                  break;
               }
            }

            if (spine) {
               break;
            }
         }
      }

      int row = BarcodeImage.MAX_HEIGHT - 1;
      for (int i = startRow; i > 0; i--) {
         int column = 0;
         for (int j = startColumn; j < BarcodeImage.MAX_WIDTH; j++) {
            boolean value = image.getPixel(i, j);
            image.setPixel(row, column, value);
            column++;
         }
         row--;
      }
   }

   // Bryce
   private int computeSignalWidth() {

   }

   // Bryce
   private int computeSignalHeight() {

   }

}
