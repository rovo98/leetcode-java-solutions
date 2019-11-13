class Solution1 {
    /**
    approach one:
    Complexity Analysis: 
        Time complexity: O(n log n)
        Spacce complexity: O(n)
    */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        
        // put elemts into the map for counting
        for (int n : arr2) {
            map.put(n , 0);
        }
        for (int n : arr1) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                list.add(n);
            }
        }
        int[] result = new int[arr1.length];
        int index = 0;
        // combine them together
        for (int n : arr2) {
            for (int i = 0; i < map.get(n); i++) {
                result[index++] = n;
            }
        }
        // sort the rest of elements. using mergeSort built-in in Collections tool.
        Collections.sort(list, (o1, o2) -> o1.compareTo(o2));
        for (int n : list) {
            result[index++] = n;
        }
        return result;
    }
}
