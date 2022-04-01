package leetcode;

import org.junit.Test;

public class Demo4 {
    @Test
    public void demo4(){
        int[] nums1={1,4,7};
        int[] nums2={2,3};
        demott(nums1,nums2);
//        System.out.println(findMedianSortedArrays(nums1,nums2));
    }
    public void demott(int[] nums1, int[] nums2){
        int index=(nums1.length+nums2.length)/2;
        int start=index-1;
        int end=0;
        do {
            if (nums1.length - 1 < index) {
                int[] temp = nums2;
                nums2 = nums1;
                nums1 = temp;
            }
            if (nums1[start] > nums2[end]) {
                start = start / 2;
                index = index-start;
            }
        } while (nums1[start] > nums2[end]);
        System.out.println(index);
        System.out.println(nums1[index]);
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int index=(nums1.length+nums2.length)/2;
        if(index<=1){
            if(nums1.length==nums2.length){
                if(nums1.length==0){
                    return 0;
                }
                return ((double)(nums1[0]+nums2[0]))/2;
            }else{
                return nums1.length>nums2.length?nums1[0]:nums2[0];
            }
        }
        int nums1Start=index-1;
        int nums2Start=0;
        int middleNumber=nums1[nums1Start];

        while (true){
            if(nums1[nums1Start]>nums2[nums2Start]){
                if(nums1[nums1Start-1]<=nums2[nums2Start]){
                    break;
                }else{
                    nums1Start-=nums1Start/2;
                    nums2Start=index-nums1Start-1;
                }
            }else{
                int[] temp=nums2;
                int tempStart=nums2Start;
                nums2=nums1;
                nums1=temp;
                nums2Start=nums1Start;
                nums1Start=tempStart;
            }
        }
        int bigNumber;
        if(nums1.length-1==nums1Start){
            bigNumber=nums2[index-nums1Start+1];
        }
        if(nums2.length-1==nums2Start){
            bigNumber=nums1[nums1Start+1];
        }
        bigNumber= Math.max(nums1[nums1Start + 1], nums2[index - nums1Start + 1]);
        if((nums1.length+nums2.length)%2==0){
            return ((double)(nums1[nums1Start]+bigNumber))/2;
        }else{
            return bigNumber;
        }
    }
}
