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
   
   //Jeannie
   public boolean scan(BarcodeImage bc)
   {
      // TODO Auto-generated method stub
      return false;
   }


   //Harsandeep
   public boolean readText(String text)
   {
      // TODO Auto-generated method stub
      return false;
   }

   //Jeannie
   public boolean generateImageFromText()
   {
      // TODO Auto-generated method stub
      return false;
   }

   //Harsandeep
   public boolean translateImageToText()
   {
      // TODO Auto-generated method stub
      return false;
   }

   //Jeannie
   public void displayTextToConsole()
   {
      // TODO Auto-generated method stub

   }

   //Bryce
   public void displayImageToConsole()
   {
      //these two strings are always 2 longer than signalWidth
      String topBorder = "--";
      String bottomBorder = "--";
     
      for(int i = 0; i <= computeSignalWidth(); i++)
      {
         topBorder = topBorder + "-";
         bottomBorder = bottomBorder + "-";
      }
      
      System.out.print(topBorder);//displays top hyphens
     
      for(int row = 0; row <= computeSignalHeight(); row++) 
      {
         System.out.print("|");//left side pipe characters
         for(int col = 0; col <= computeSignalWidth(); col++)
         {
            if(image.getPixel(row,col) == true)
               System.out.print("*");
               
            else if (image.getPixel(row,col) == false)
               System.out.print(" ");
         }
         System.out.print("|");//right side pipe characters
      }
      System.out.print(bottomBorder);//displays bottom hyphens
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

