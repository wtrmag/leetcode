//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
// Related Topics 堆 分治算法 
// 👍 138 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        quickSort(arr, 0, arr.length - 1);
        int[] temp = new int[k];
        for (int i = 0; i < k; i++){
            temp[i] = arr[i];
        }
        return temp;
    }

    public static void quicksort(int[] nums, int left, int right){
        if (left < right) {
            int pivot = partition(nums, left, right);
            quicksort(nums, left, pivot - 1);
            quicksort(nums, pivot + 1 , right);
        }
    }

    public static int partition(int[] nums, int left, int right){
        int pivot = left;
        while (left != right) {
            while(nums[right] >= nums[pivot]){
                right--;
            }
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = nums[left];
            }

            while(nums[left] < nums[pivot]){
                left++;
            }
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = nums[left];
            }
        }
        nums[left] = nums[pivot];

        return left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
