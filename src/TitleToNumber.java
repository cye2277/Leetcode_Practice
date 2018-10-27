public class TitleToNumber {
    //Given a column title as appear in an Excel sheet, return its corresponding column number.
    //
    //For example:
    //
    //    A -> 1
    //    B -> 2
    //    C -> 3
    //    ...
    //    Z -> 26
    //    AA -> 27
    //    AB -> 28
    //    ...
    //Example 1:
    //
    //Input: "A"
    //Output: 1
    //Example 2:
    //
    //Input: "AB"
    //Output: 28
    //Example 3:
    //
    //Input: "ZY"
    //Output: 701

    public static void main(String[] args) {
        String s = "A";
        String s2 = "AB";
        String s3 = "ZY";
        System.out.println(totalToNumber(s));
        System.out.println(totalToNumber(s2));
        System.out.println(totalToNumber(s3));

    }
    public static int totalToNumber(String s){
        int result = 0;
        for (int i = 0; i < s.length();  i++){
            result = result * 26 + (s.charAt(i) - 'A' + 1);
        }
        return result;
    }
}
