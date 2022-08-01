public class InsectClient {
    public static void main(String[] args) {
        //static method
        Insect.produceRandomFact();
        
        //instance method
        Insect bug1 = new Insect(200);
        bug1.move(3, 2);

        //built-in toString() method
        System.out.println(bug1.toString());
    }
}
