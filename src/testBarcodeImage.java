//Test main for BarcodeImage.java
public class testBarcodeImage
{
   public static void main(String[] args)
   {
      System.out.println("---Test Default Constructor Barcode()---");
      BarcodeImage defaultImage = new BarcodeImage();
      System.out.println("Test One:");
      //Should print out blanks
      defaultImage.displayToConsole();
      
      System.out.println("\n\n---Test Constructor Barcode(String[] strData)---");
      String[] oneStrArray = 
         {
               "        ",
               "    **  ",
               "   ***  ",
               "    **  ",
               "    **  ",
               "  ******",
               "  ******",
               "        "
         };
      
      BarcodeImage testOne = new BarcodeImage(oneStrArray);
      System.out.println("Test One:");
      //Should print out the number one in lower left corner.
      testOne.displayToConsole();
      
      String[] testStrArray = new String[15];
      for(int row = 0; row < testStrArray.length; row++)
      {
         if(row % 2 == 0)
         {
            testStrArray[row] = "* * * * * * * * * * * *";
         }
         else
         {
            testStrArray[row] = " * * * * * * * * * * * ";
         }
      }
      
      BarcodeImage testTwo = new BarcodeImage(testStrArray);
      System.out.println("\nTest Two:");
      //Should print out pattern in lower left corner.
      testTwo.displayToConsole();
      
      String[] testArrayTwo = new String[35];
      for(int row = 0; row < testArrayTwo.length; row++)
      {
         if(row % 2 == 0)
         {
            testArrayTwo[row] = "* * * * * * * * * * * *";
         }
         else
         {
            testArrayTwo[row] = " * * * * * * * * * * * ";
         }
      }
      
      BarcodeImage testThree = new BarcodeImage(testArrayTwo);
      System.out.println("\nTest Three:");
      //Should output blanks because input String array was too large for BarcodeImage class.
      testThree.displayToConsole();
      
      String[] testArrayThree = new String[30];
      String line = "";
      for(int col = 0; col < 65; col++)
      {
         line = line + '*';
      }
      
      for(int row = 0; row < 30; row++)
      {
         testArrayThree[row] = line;
      }
      
      BarcodeImage testFour = new BarcodeImage(testArrayThree);
      System.out.println("\nTest Four:");
      //Should output block of stars.
      testFour.displayToConsole();
      
      //Test Clonable
      BarcodeImage cloneImage;
      try
      {
         cloneImage = testOne.clone();
      } catch (CloneNotSupportedException e)
      {
         // TODO Auto-generated catch block
         cloneImage = new BarcodeImage();
      }
      //Change clone by adding extra line at the bottom of the one.
      //This shows that it actually made a deep copy.
      for(int i = 0; i < 10; i++)
      {
         cloneImage.setPixel(0, i, true);
      }
     
      System.out.println("\n\n---Testing Clone()---");
      System.out.println("\nOriginal Hashcode: " + testOne.hashCode());
      testOne.displayToConsole();
      System.out.println("\nClone Hashcode: " + cloneImage.hashCode());
      cloneImage.displayToConsole();
   }
   
   
}
