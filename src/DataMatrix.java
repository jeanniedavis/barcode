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
       Object clone;
       // TODO Auto-generated method stub
       try {
          clone = bc.clone();
          if (clone instanceof BarcodeImage){
             image = (BarcodeImage) clone;
            cleanImage();
            // find actualWidth
           actualWidth = computeSignalWidth();
           actualHeight= computeSignalHeight();
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
       image = new BarcodeImage();
       int x;
       char [] chars = text.toCharArray();
       // bottom row - spine 
       for (int i = 0; i<actualWidth+1; i++){
          image.setPixel(image.MAX_HEIGHT-1, i, true);
       }
       //left column - spine
       int counter = 0;
       for (int i = image.MAX_HEIGHT-1; i>=0; i--){
          if (counter == actualHeight){
             break;
          }
          image.setPixel(i, 0, true);
          counter++;
       }
       //right side -- spine 
       counter = 0;
       for (int i = image.MAX_HEIGHT-1; i>=0; i--){
          if (counter == actualHeight){
             break;
          }       
          image.setPixel(i, actualWidth+1, i%2!=0);
          counter++;
       }
       //top row - spine
       for (int i = 0; i<actualWidth+1; i++){
          image.setPixel(image.MAX_HEIGHT-2-actualHeight, i, i%2==0);
       }
 
       // filling in barcode data
       for (int k =1; k<actualWidth+1; k++){     
          x = chars[k-1];
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
       // convert binary string into barcode columns
       for (int i = image.MAX_HEIGHT-2; i >= image.MAX_HEIGHT-actualHeight-1; i--){ 
          // if you've reached the end of the binary string, and not the end of the loop
          // set the rest to false     
          if (b.length() - counter < 0) {
             image.setPixel(col, i, false);
          }
          else {
             //parsing the binary string
             char var = b.charAt(b.length() -counter);
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
      //these two strings are always 2 longer than signalWidth
      String horizontalBorder = "--";
     
      for(int i = 0; i < actualWidth; i++)
         horizontalBorder = horizontalBorder + "-";
 
      System.out.print(horizontalBorder);//displays top hyphens
     
      for(int row = 0; row < actualHeight; row++) 
      {
         System.out.print("|");//left side pipe characters
         
         for(int col = 0; col < actualWidth; col++)
         {
            if(image.getPixel(row, col) == true)
               System.out.print("*");
               
            else
               System.out.print(" ");
         }
         System.out.print("|");//right side pipe characters
      }
      System.out.print(horizontalBorder);//displays bottom hyphens
   }

   //Harsandeep
   private void cleanImage()
   {
      
   }
   
   //Bryce
   private int computeSignalWidth()
   { 
      int width = 0;
      int col = 0;
      
      //adds to width as long as true values are encountered
      while(image.getPixel(0, col) == true)
      {
         col++;
         width++;
      }
      return width;   
   }
   
   //Bryce
   private int computeSignalHeight()
   {
      int height = 0;
      int row = 0;
      
      //adds to height as long as true values are encountered
      while(image.getPixel(row, 0) == true)
      {
         row++;
         height++;
      }
      return height;
   }
}

