public class PrimitiveOperations {
    public static void main(String[] args) {
        int value1 = 666;
        double value2 = 12.88;
        System.out.println(value1);
        System.out.println(value2);
        double total = value1 * value2;
        System.out.println(total);
        double value4 = value1*1.0;
        System.out.println(value4);
        int value3 = (int)value2;
        System.out.println(value3);
        char text = 'Y';
        System.out.println(text);
        char textNew = (char)((int)text + 32);
        System.out.println(textNew);
    }
}