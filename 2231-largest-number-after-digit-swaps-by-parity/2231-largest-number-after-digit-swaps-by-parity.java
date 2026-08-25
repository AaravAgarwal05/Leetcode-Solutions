class Solution {
    public int largestInteger(int num) {
        String copy = Integer.toString(num);
        int counter = 0;
        PriorityQueue<Integer> odd = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> even = new PriorityQueue<>((a, b) -> b - a);

        while(num > 0) {
            if(num % 2 == 0) {
                even.offer(num % 10);
            } else {
                odd.offer(num % 10);
            }

            num /= 10;
        }

        while(!odd.isEmpty() || !even.isEmpty()) {
            num *= 10;

            if((copy.charAt(counter++) - '0') % 2 == 0) {
                num += even.poll();
            } else {
                num += odd.poll();
            }
        }

        return num;
    }
}