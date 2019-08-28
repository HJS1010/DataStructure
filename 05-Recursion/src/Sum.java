public class Sum {

    public static int sum(int[] arr) {
        return sum(arr, 0);
    }

    // 计算arr[left...n)这个区间内所有数字的和
    private static int sum(int[] arr, int left) {
        if (left == arr.length) {
            return 0;
        }
        return arr[left] + sum(arr, left + 1);
    }

    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        int sum = sum(arr);
        System.out.println(sum);
    }
}
