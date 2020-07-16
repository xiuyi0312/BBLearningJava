package com.pheobe.leetcode;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    }

    public int trailingZeroes(int n) {
        int count5 = 0;
        while(n > 0) {
            count5 += n/5;
            n /= 5;
        }
        return count5;
    }

    public int lengthOfLastWord(String s) {
        if (s == null) {
            return 0;
        }
        String[] strs = s.split("\\s+");
        if (strs.length <= 0) {
            return 0;
        }
        return strs[strs.length - 1].length();
    }

    public int reverse(int x) {
        String a = String.valueOf(x);
        StringBuilder stringBuilder = new StringBuilder();
        if(a.startsWith("-")) {
            stringBuilder.append("-");
            a = a.substring(1);
        }
        for (int i = a.length() -1 ; i >=0 ; i--) {
            stringBuilder.append(a.charAt(i));
        }
        try {
            return Integer.parseInt(stringBuilder.toString());
        } catch (Exception e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        int[] num = {2, 7, 11, 15};
//        System.out.println(Arrays.toString(s.twoSum(num, 18)));

//        System.out.println(s.trailingZeroes(2));

//        System.out.println(s.lengthOfLastWord("hello word"));

        System.out.println(s.reverse(-283848939));
    }
}
