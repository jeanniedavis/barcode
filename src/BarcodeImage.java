
public class BarcodeImage implements Cloneable
{
   public static final int MAX_HEIGHT = 30;
   public static final int MAX_WIDTH = 65;
   private boolean[][] imageData;

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
      if(row < 0 || col < 0 || row >= imageData.length || col >= imageData[0].length)
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
      if(row < 0 || col < 0 || row >= imageData.length || col >= imageData[0].length)
      {
         return false;
      }
      else
      {
         imageData[row][col] = value;
         return true;
      }
   }
   
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
   
   public BarcodeImage clone()
   {
      
   }
}
