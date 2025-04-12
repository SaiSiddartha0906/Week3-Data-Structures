import java.util.*;

public class Linear_VS_BinarySearch {
    public static int[] GenerateDataset(int min,int max,int size){
        int[] dataset=new int[size];
        for (int i=0;i<size;i++){
            dataset[i]=i;
        }
        return dataset;
    }

    public static void LinearSearch(int[] dataset, int target){
        int j=0;
        for (int i:dataset){
            if (i==target){
                System.out.println("Target Found for Linear Search with size :"+dataset.length);
                j=1;
                break;
            }
        }
        if (j==0){
        System.out.println("Target not Found");}
    }

    public static void  BinarySearch(int[] dataset, int target){
        Arrays.sort(dataset);
        int j=0;
        int left=0;
        int right=dataset.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if (dataset[mid]==target){
                System.out.println("Target is Found with binary search of size : "+dataset.length);
                j=1;
                break;
            }
            else if (dataset[mid]>target){
                right=mid-1;
            }
            else if(dataset[mid]<target){
                left=mid+1;
            }
        }
        if (j==0){
        System.out.println("Target not found");}
    }


    public static void main(String[] args) {
        double startime,endtime;
        final int a=1000000;
        int[] dataset1000=GenerateDataset(1,1000,1000);
        int[] dataset10000=GenerateDataset(1,10000,10000);
        int[] dataset1000000=GenerateDataset(1,1000000,1000000);

        startime=System.nanoTime()/a;
        LinearSearch(dataset1000,5000);
        endtime=System.nanoTime()/a;
        System.out.println("Total Time taken for linear search with 1k elements : "+(endtime-startime));
        System.out.println();

        startime=System.nanoTime()/a;
        LinearSearch(dataset10000,5000);
        endtime=System.nanoTime()/a;
        System.out.println("Total Time taken for linear search with 10k elements : "+(endtime-startime));
        System.out.println();

        startime=System.nanoTime()/a;
        LinearSearch(dataset1000000,5000);
        endtime=System.nanoTime()/a;
        System.out.println("Total Time taken for linear search with 1M elements : "+(endtime-startime));
        System.out.println();

        startime=System.nanoTime()/a;
        BinarySearch(dataset1000,5000);
        endtime=System.nanoTime()/a;
        System.out.println("Total Time taken for binary search with 1k elements: "+(endtime-startime));
        System.out.println();

        startime=System.nanoTime()/a;
        BinarySearch(dataset10000,5000);
        endtime=System.nanoTime()/a;
        System.out.println("Total Time taken for binary search with 10k elemtns: "+(endtime-startime));
        System.out.println();

        startime=System.nanoTime()/a;
        BinarySearch(dataset1000000,5000);
        endtime=System.nanoTime()/a;
        System.out.println("Total Time taken for binary search with 1M elements: "+(endtime-startime));
    }
}
