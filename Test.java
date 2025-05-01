public class Test {
    public int b(int[] array, int target) {
        if(array == null || array.length == 0){
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while(left < right - 1){
            int middle = left + (right - left) / 2;
            if(array[middle] == target){
                left = middle + 1;
            }
            else if(array[middle] > target){
                right = middle;
            }else{
                left = middle + 1;
            }
        }

        if(array[left] > target){
            return left;
        }else if(array[right] > target){
            return right;
        }else{
            return -1;
        }

    }

    public static void main(String[] args) {
        Test obj = new Test();

        // Test cases
        int[] array1 = {1, 2, 3, 4};
        System.out.println("Test 1: " + obj.b(array1, 3)); // Expected: 2
    }
}
