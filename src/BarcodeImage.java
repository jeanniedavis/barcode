
public class BarcodeImage implements Cloneable
{
   public static final int MAX_HEIGHT = 30;
   public static final int MAX_WIDTH = 65;
   private boolean[][] imageData;

   public BarcodeImage()
   {
      imageData = new boolean[MAX_HEIGHT][MAX_WIDTH];
      //Set all values in array to false
   }
   
   public BarcodeImage(String[] strData)
   {
      //Split string using delimiter
      //Find out dimensions of array
      int height;
      int width;
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
   
   private checkSize(String[] data)
   {
      
   }
   
   public displayToConsole()
   {
      
   }
   
   public clone()
   {
      
   }
}
