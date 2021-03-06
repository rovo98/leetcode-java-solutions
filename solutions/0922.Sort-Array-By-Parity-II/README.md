# 922. Sort Array By Parity II

## Description

Given an array A of non-negative integers, half of the integers in A are odd, and half of the integers are even.

Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.

You may return any answer array that satisfies this condition.

**Example 1:**

```txt
Input: [4,2,5,7]
Output: [4,5,2,7]
Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
```
 
### Note

- 2 <= A.length <= 20000
- A.length % 2 == 0
- 0 <= A[i] <= 1000

### Links

[(en)https://leetcode.com/problems/sort-array-by-parity-ii](https://leetcode.com/problems/sort-array-by-parity-ii/)
<br />
[(中文)https://leetcode-cn.com/problems/sort-array-by-parity-ii](https://leetcode-cn.com/problems/sort-array-by-parity-ii/)

## 解题思路

### Solution1


将输入的原始数组分割成两个数组，一个存放偶数 ``even``，一个存放奇数 ``odd``。再通过一次循环，重新合成 ``result`` 数组。

#### Java Code 

我解题时的线上提交代码:

```java
class Solution {
    /**
    time complexity: O(n)
    space complexity: O(n)
    */
    public int[] sortArrayByParityII(int[] A) {
        
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();
        
        for (int n : A) {
            if (n % 2 == 0)
                even.add(n);
            else 
                odd.add(n);
        }
        int[] result = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            if (i % 2 == 0) {
                result[i] = even.remove(0);
            } else {
                result[i] = odd.remove(0);
            }
        }
        return result;
    }
}
```

#### Submission status

![submission1-status](../../images/0922-sort-array-in-parity-II-my-status.png)

可以看到，这一解决方法在速度方面有点糟糕。


