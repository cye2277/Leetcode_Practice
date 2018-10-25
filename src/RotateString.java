public class RotateString {
    public static void main(String[] args) {

    }

    //method 1
    //Time Complexity: O(N^2)where N is the length of A.
    //Space Complexity: O(N), the space used building A+A.
    public static boolean rotateString(String A, String B) {
        if (A.length() != B.length()){
            return false;
        }
        if ((A+A).contains(B)){
            return true;
        }
        return false;
    }
}
