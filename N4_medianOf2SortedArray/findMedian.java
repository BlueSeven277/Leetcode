package N4_medianOf2SortedArray;

/**
 * Created by srx on 2018/8/11.
 */
public class findMedian {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int m = nums2.length;
        if ((n+m)%2==1){
            if (n ==0){
                return nums2[m/2];
            }
            else if (m==0){
                return nums1[n/2];
            }
            else
                return findkth(nums1,nums2,(n+m)/2+1,0,0);
        }
        else {
            if (n ==0){
                return (nums2[m/2]+nums2[m/2-1])/2;
            }
            else if (m==0){
                return (nums1[n/2]+nums1[n/2-1])/2;
            }
            else {
                double fir = findkth(nums1, nums2, (n + m) / 2, 0, 0);
                double sec = findkth(nums1, nums2, (n + m) / 2 + 1, 0, 0);
                return (fir + sec) / 2;
            }
        }

    }
    private double findkth (int[] nums1, int[] nums2,int k,int starti, int startj){
        int n = nums1.length;
        int m = nums2.length;
        System.out.println(k/2);
        if (k == 1){
            return (nums1[starti]<nums2[startj]?nums1[starti]:nums2[startj]);
        }
        else if (k/2>=nums1.length-starti){
            if (nums1[nums1.length-1]<=nums2[startj+(nums1.length-starti)-1]){
                return nums2[startj+k-(nums1.length-starti)-1];
            }
            else {
                startj = startj+nums1.length-starti;
                k = k-(nums1.length-starti);
            }
        }
        else if(k/2>=nums2.length-startj){
            if (nums2[nums2.length-1]<=nums1[starti+(nums2.length-startj)-1]){
                return nums1[starti+k-(nums2.length-startj)-1];
            }
            else {
                starti = starti+nums2.length-startj;
                k = k-(nums2.length-startj);
            }
        }
        else if(nums1[starti+k/2-1]>=nums2[startj+k/2-1]){
            startj = startj+k/2;
            k = k-k/2;
        }
        else {
            starti = starti+k/2;
            k = k-k/2;
        }
        return findkth(nums1,nums2,k,starti,startj);
    }

    public static void main(String[] args) {
        int[] nums1 = {100001};
        int[] num22 = {100000};
        findMedian s = new findMedian();
        System.out.println(s.findMedianSortedArrays(nums1,num22));
    }
}
