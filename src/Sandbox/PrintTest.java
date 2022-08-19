package Sandbox;

public class PrintTest {  
    PrintTest() { // 3
        System.out.print(" Print1 ");
    }
    
    public void testMethod() { //5 
        System.out.print(" Print2 ");  
    }  
 
    { // 2
        System.out.print(" Print3 ");  
    }  
          
    public void printTest() {  // 4
        System.out.print(" Print4 ");  
    }  
    
    static { // 1
        System.out.print(" Print5 ");  
    }  
    
    public static void main(String[] args) {  
        PrintTest test1 = new PrintTest();  
        test1.printTest();  
        test1.testMethod();
        

  }  
}