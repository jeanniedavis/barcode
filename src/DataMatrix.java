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


 //Takes in a string variable and sets the data member "text"
   public boolean readText(String text)
   {
   this.text = text;
   return true;
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
	   char colChar[] = new char[actualWidth - 1];
	   for (int i = 1; i < actualWidth - 1; i++)
	   {
		   colChar[i] = this.readCharFromCol(i);
	   }
	   String colString = new String(colChar);
	   this.text = colString;
	   return true;
	  }

   //Jeannie
   public void displayTextToConsole()
   {
      // TODO Auto-generated method stub

   }

   //Bryce
   public void displayImageToConsole()
   {
      // TODO Auto-generated method stub

   }
   
   //Harsandeep
   private void cleanImage()
   {
	   for (int i = 0; i < BarcodeImage.MAX_HEIGHT; i++)
	   {
		   for (int j = 0; j < BarcodeImage.MAX_WIDTH; j++)
		   {
			   image.setPixel(i, j, false);
		   }
	   } 
   }
   
   //Bryce
   private int computeSignalWidth()
   {
      
   }
   
   //Bryce
   private int computeSignalHeight()
   {
      
   }

}

