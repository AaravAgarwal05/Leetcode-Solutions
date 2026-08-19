class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int ate = 0;
        boolean took = false;
        int nS = students.length;
        int nSw = sandwiches.length;
        Stack<Integer> sandwich = new Stack<>();
        Queue<Integer> student = new LinkedList<>();

        for(int i = nSw - 1; i >= 0; i--) {
            sandwich.push(sandwiches[i]);
        }

        for(int i = 0; i < nS; i++) {
            student.offer(students[i]);
        }

        while(true) {
            Queue<Integer> temp = new LinkedList<>();
            took = false;
            
            for(int x : student) {
                if(x == sandwich.peek()) {
                    sandwich.pop();
                    ate++;
                    took = true;
                } else {
                    temp.offer(x);
                }
            }

            if(!took) {
                break;
            }

            student = temp;
        }

        return nS - ate;
    }
}