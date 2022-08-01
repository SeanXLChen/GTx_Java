public class compare {
    public static void main(String[] args) {
        String v1t1 = "park";
        String v1t2 = "park";

        if (v1t1 == v1t2) {
            System.out.println("v1_1 and v1_2 are aliases");
        }
        else {
            System.out.println("v1_1 and v1_2 are not aliases");
        }


        String v2t1 = new String("park");
        String v2t2 = new String("park");

        if (v2t1 == v2t2) {
            System.out.println("v2_1 and v2_2 are aliases");
        }
        else {
            System.out.println("v2_1 and v2_2 are not aliases");
        }

        if (v2t1.equals(v2t2)) {
            System.out.println("v2_1 and v2_2 has same content");
        }
    }
}
