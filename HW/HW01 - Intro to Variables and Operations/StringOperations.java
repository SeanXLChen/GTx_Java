

public class StringOperations {
    public static void main(String[] args) {
        String myName = new String("Sean");
        System.out.println(myName);
        String name = "A" + myName.substring(1,myName.length()-1) + "Z";
        System.out.println(name);
        String url = "www.webtoon.com";
        System.out.println(url);
        int nameIdx1 = url.indexOf('.');
        int nameIdx2 = url.lastIndexOf('.');
        String urlName = url.substring(nameIdx1+1,nameIdx2).concat("1331");
        System.out.println(urlName);
    }
}
