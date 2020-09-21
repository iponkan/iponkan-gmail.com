public class Entrance {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = new int[] { 1, 2, 3 };
        int[] b = new int[] { 2, 3, 4 };
        double result = solution.findMedianSortedArrays(a, b);
        System.out.println("result===" + result);
    }

}
