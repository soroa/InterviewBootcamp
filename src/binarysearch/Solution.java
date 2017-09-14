package binarysearch;

import java.util.List;

public class Solution {
    // DO NOT MODIFY THE LIST
    public int findCount(final List<Integer> a, int b) {
        int counter = 0;
        if(a.isEmpty()) return counter;
        int start =0;
        int end = a.size()-1;
        int mid = (start+end)/2;
        while(start<=end){
            if(a.get(mid)<b){
                //go right
                start = mid + 1;
                mid = (start + end) /2;
            } else if (a.get(mid)>b) {
                end = mid - 1;
                mid = (start + end) / 2;
            }
            else{
                //match
                counter++;
                for(int i=mid+1; i<=end; i++){
                    if(a.get(i)==b){
                        counter++;
                    }else{
                        break;
                    }
                }
                for(int i=mid-1; i>=start; i--){
                    if(a.get(i)==b){
                        counter++;
                    }else{
                        break;
                    }
                }
                break;
            }
        }
        return counter;
    }
}
