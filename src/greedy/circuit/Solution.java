package greedy.circuit;

import java.util.List;

public class Solution {
    public int canCompleteCircuit(final List<Integer> gas, final List<Integer> cost) {
        for(int i = 0; i<gas.size(); i++) {
            int gasSum =0;
            for(int j = 0; j<gas.size(); j++) {
                gasSum += gas.get((i + j) % gas.size()) - cost.get((i + j) % gas.size());
                if(gasSum<0){
                    break;
                } else if (j == (gas.size() - 1)) {
                    return i;
                }
            }
        }
        return -1;
    }
}

