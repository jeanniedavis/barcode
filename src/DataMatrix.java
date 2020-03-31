import java.lang.Math; 
//Stubs for the DataMatrix Class
//Labeled who is doing which sections.

public class DataMatrix implements BarcodeIO
{
   //DATA - Bryce
   public static final char BLACK_CHAR = '*';
   public static final char WHITE_CHAR = ' ';  
   
   private BarcodeImage image;
   private String text;
   
   private int actualWidth;
   private int actualHeight;
 
   //Constructors - Bryce
   public DataMatrix()//default
   {
      text = "";
      actualWidth = 0;
      actualHeight = 0; 
      image = new BarcodeImage();
   }

   public DataMatrix(BarcodeImage image)//image only
   {
      text = "";

      if(scan(image) == false)
      {
         actualWidth = 0;
         actualHeight = 0;
         image = new BarcodeImage();
      }
    
   }
   
   public DataMatrix(String text)//text only
   {
      actualWidth = 0;
      actualHeight = 0;
      image = new BarcodeImage();
      
      if(readText(text) == false)
         text = "";
   }
   
   //Accessors - Bryce
   public int getActualWidth()
   {
      return actualWidth;
   }
   
   public int getActualHeight()
   {
      return actualHeight;
   }
   
   /**
    * @author Jeannie
    @param Barcode - accepts a Barcode Image to create a cloned image to store 
    * calls cleanImage in order to lower-left justify the Barcode Image 
    * Also sets the actual width and height 
    */
   public boolean scan(BarcodeImage bc)
   {
      // TODO Auto-generated method stub
      try {
         image = bc.clone();
         cleanImage();
         // find actualWidth
         for (int i = 0; i<bc.MAX_WIDTH; i++){
            if (!bc.getPixel(bc.MAX_HEIGHT-1, i)){
               break;
            }
            actualWidth++;
         }
         // find actualHeight
         for (int k = bc.MAX_HEIGHT-1; k>=0; k--){
            if (!bc.getPixel(i, 0)){
               break;
            }
            actualHeight++;
         }
      } catch (Exception CloneNotSupportedException) {
         //TODO: handle exception
      }
      return false;
   }


   //Harsandeep
   public boolean readText(String text)
   {
      // TODO Auto-generated method stub
      return false;
   }

   /**
    * @author Jeannie
    * This method will generate an image from the internal text
    * This method calls WriteCharToCol which will generate the column for the image
    */
   public boolean generateImageFromText()
   {
      // TODO Auto-generated method stub
      //generate column
      int x;
      char [] chars = text.toCharArray();
      for (int k =0; k<chars.length; k++){
         x = chars[k];
         WriteCharToCol(k, x);
      }
      return false;
   }
   /**
    * @author Jeannie
    * @param col - This is the column to write the character
    * @param code - This is the integer representation of the character
    * @return - returns true
    */
   private boolean WriteCharToCol(int col, int code){
      String b = Integer.toBinaryString(code);
      int counter = 1;
      for (int i = computeSignalHeight()-1; i >= 0; i--){
         if (b.length() - counter < 0) {
            image.setPixel(col, i, false);
         }
         else {
            char var = b.charAt(b.length() -1);
            if (var == '1'){
               image.setPixel(col, i, true);
            }
            else {
               image.setPixel(col, i, false);
            }
         }
         counter++;
      }
      return true;
   }

   //Harsandeep
   public boolean translateImageToText()
   {
      // TODO Auto-generated method stub
      return false;
   }

   //
   /**
    * @author Jeannie
    * This method simply prints out the String text 
    */
   public void displayTextToConsole()
   {
      // TODO Auto-generated method stub
      System.out.println(text);
   }

   //Bryce
   public void displayImageToConsole()
   {
      // TODO Auto-generated method stub

   }
   
   //Harsandeep
   private void cleanImage()
   {
      
   }
   
   //Bryce
   private int computeSignalWidth()
   {
      return 0;
      
   }
   
   //Bryce
   private int computeSignalHeight()
   {
      return 0;
   }

}

