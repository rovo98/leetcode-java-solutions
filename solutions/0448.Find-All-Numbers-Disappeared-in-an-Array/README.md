# 0448. Find All Numbers Disappeared in an Array

## Description

Given an array of integers where 1 <= ``a[i]`` <= ``n`` (``n`` = size of array), some elements appear twice and others appear once.

Find all the elements of ``[1, n]`` inclusive that do not appear in this array.

Could you do it without extra space and in $O(n)$ runtime? You may assume the returned list does not count as extra space.

 
**Example:**
```txt
Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]
```

**Links**

[(en)https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/](https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)
<br />
[(中文)https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/](https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/)

## Solutions

思路： 由于元素的范围为 ``[0, n]``, 可以遍历数组，将出现的元素值，作为数组索引，将索引对应的元素设置为负数，之后再进行一次遍历，若遇到非负数的元素，则说明该元素未出现在给定的范围内。

### Solution1

```java
/**
  Complexity Analysis:
  Time complexity: O(n).
  Space complexity: O(1).
  */
public List<Integer> findDisappearedNumbers(int[] nums) {
    List<Integer> ret = new ArrayList<>();

    for (int i = 0; i < nums.length; i++) {
        int val = Math.abs(nums[i]) - 1;
        if (nums[val] > 0)
            nums[val] = -nums[val];
    }

    for (int i = 0; i < nums.length; i++)
        if (nums[i] > 0)
            ret.add(i+1);
    return ret;
}
```

**Submission status**

运行时间 5 ms, 击败 89.54%。

