class RandomizedSet {
    Map<Integer, Integer> map;
    ArrayList<Integer> list;
    int size;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        size = 0;
    }
    
    public boolean insert(int val) {
        if(!map.containsKey(val)) {
            map.put(val, size);
            if(list.size() > size) {
                list.set(size, val);
            } else {
                list.add(val);
            }
            size++;
            return true;
        }
        return false;
    }
    
    public boolean remove(int val) {
        if(map.containsKey(val)) {
            int temp = list.get(size - 1);
            list.set(size - 1, val);
            list.set(map.get(val), temp);
            map.put(temp, map.get(val));
            map.remove(val);
            size--;
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        int rand = (int) Math.floor(Math.random() * size);
        return list.get(rand);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */