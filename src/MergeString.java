public class MergeString {
    public static void main(String[] args) {
        String s1 = "bee";
        String s2 = "honey";
        char[] test = new char[]{'1','2','3','5'};
//        System.out.println(String.valueOf(test));
        System.out.println(mergeString(s1,s2));
    }

    public static String mergeString(String a, String b){
        //check basic situation
        if (a == null && b== null){
            return null;
        }else if (b== null ){
            return a;
        }else if (a == null){
            return b;
        }

        char[] charArr = new char[a.length()+b.length()];
        int min = Math.min(a.length(),b.length());
        int max = Math.max(a.length(),b.length());
        for (int i = 0; i<min; i ++){
            charArr[2*i] = a.charAt(i);
            charArr[2*i+1] = b.charAt(i);
        }
        if (a.length() >b.length()){
            for (int j = 0 ;j<max-min;j++){
                charArr[2*min + j] = a.charAt(min+j);
            }
        }else if (b.length()>a.length()){
            for (int j = 0 ;j<max-min;j++){
                charArr[2*min + j] = b.charAt(min+j);
            }
        }

        String ans = String.valueOf(charArr);
        return ans;
    }
}
