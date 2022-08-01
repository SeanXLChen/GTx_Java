public class ArraySearch {
    public static void main(String[] args) {
        String[] names = { "sean", "riddle", "brian", "bill", "alice" };
        searchStringArray("riddle", names);
    }

    public static String searchStringArray(String target, String[] array) {
        String result = "not found";
        for (String name : array) {
            if (name.equals(target)) {
                result = "found";
                break;
            }
        }
        System.out.println(result);
        // return就结束了，之后不能再有其他行的操作
        return result;
    }
}
