//Holds a barcode image size 30x65 as a 2d array of booleans.
//If image is invalid, creates blank image.
public class BarcodeImage implements Cloneable
{
   public static final int MAX_HEIGHT = 30;
   public static final int MAX_WIDTH = 65;
   private boolean[][] imageData; //Stores pixels of barcode

   //Default Constructor
   public BarcodeImage()
   {
      imageData = new boolean[MAX_HEIGHT][MAX_WIDTH];
      //Set all values in array to false
      for(int row = 0; row < MAX_HEIGHT; row++)
      {
         for(int col = 0; col < MAX_WIDTH; col++)
         {
            imageData[row][col] = false;
         }
      }
   }
   
   //Constructor
   public BarcodeImage(String[] strData)
   {
      imageData = new boolean[MAX_HEIGHT][MAX_WIDTH];
      int height;
      int width = 0;
      
      //Check to see if array strData has valid dimensions.
      if(checkSize(strData) == true)
      {
         height = strData.length;
      }
      else
      {
         height = 0;
      }
      
      int col;
      int arrayIndex = 0; //Index for strData array
      for(int row = MAX_HEIGHT - 1; row >= 0; row--)
      {
         col = 0;
         
         //Set columns according to strData input
         if(row < height) 
         {
            width = strData[arrayIndex].length();
            
            for(; col < width; col++)
            {
               if(strData[arrayIndex].charAt(col) == ' ')
               {
                  imageData[row][col] = false;
               }
               else
               {
                  imageData[row][col] = true;
               }
            }
            
            arrayIndex++;
         }
         
         //Set remaining columns to false
         while(col < MAX_WIDTH)
         {
            imageData[row][col] = false;
            col++;
         }
      }
   }
   
   boolean getPixel(int row, int col)
   {
      if(row < 0 || col < 0 || row >= imageData.length 
            || col >= imageData[0].length)
      {
         return false;
      }
      else
      {
         return imageData[row][col];
      }
   }
   
   boolean setPixel(int row, int col, boolean value)
   {
      if(row < 0 || col < 0 || row >= imageData.length 
            || col >= imageData[0].length)
      {
         return false;
      }
      else
      {
         imageData[row][col] = value;
         return true;
      }
   }
   
   //Validates size of incoming String array.
   private boolean checkSize(String[] data)
   {
      //First check is array is null
      if(data == null)
      {
         return false;
      }
      
      //Second check height
      if(data.length > MAX_HEIGHT || data.length <= 0)
      {
         return false;
      }
      
      //Third check width
      for(String str : data)
      {
         if(str == null || str.length() <= 0 || str.length() > MAX_WIDTH)
         {
            return false;
         }
      }
      
      return true;  
   }
   
   //Displays the current barcode image to console.
   //Used for testing only.
   public void displayToConsole()
   {
      String line;
      for(int row = MAX_HEIGHT - 1; row >= 0; row--)
      {
         line = "";
         
         for(int col = 0; col < MAX_WIDTH; col++)
         {
            if(imageData[row][col] == true)
            {
               line = line + '*';
            }
            else
            {
               line = line + ' ';
            }
         }
         
         System.out.println(line);
      }
   }
   
   //Implements the clonable interface
   public Object clone() throws CloneNotSupportedException
   {
      //Clone BarcodeImage object
      BarcodeImage copy = (BarcodeImage) super.clone();
      
      
      //Clone each row of imageData 2d boolean array to create a deep copy.
      copy.imageData = new boolean[MAX_HEIGHT][];
      for(int row = 0; row < MAX_HEIGHT; row++)
      {
         copy.imageData[row] = imageData[row].clone();
      }
      
      return copy;
   }
   
}
