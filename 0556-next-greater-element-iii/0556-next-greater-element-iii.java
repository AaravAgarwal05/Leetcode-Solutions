class Solution {
    public int nextGreaterElement(int n) {
        StringBuilder sb = new StringBuilder(Integer.toString(n));
        int idx = -1;

        for(int i = sb.length() - 2; i >= 0; i--) {
            if(sb.charAt(i) < sb.charAt(i + 1)) {
                idx = i;
                break;
            }
        }

        if(idx == -1) {
            return idx;
        }

        for(int i = sb.length() - 1; i >= 0; i--) {
            if(sb.charAt(i) > sb.charAt(idx)) {
                swap(sb, i, idx);
                break;
            }
        }

        reverse(sb, idx + 1, sb.length() - 1);
        long res = Long.parseLong(sb.toString());

        if(res > Integer.MAX_VALUE) {
            return -1;
        }

        return (int)res;
    }

    private void reverse(StringBuilder sb, int start, int end) {
        while(start < end) {
            swap(sb, start, end);
            start++;
            end--;
        }
    }

    private void swap(StringBuilder sb, int i, int j) {
        char temp = sb.charAt(j);
        sb.setCharAt(j, sb.charAt(i));
        sb.setCharAt(i, temp);
    }
}