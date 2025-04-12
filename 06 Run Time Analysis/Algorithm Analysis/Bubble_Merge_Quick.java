import java.util.*;

public class Bubble_Merge_Quick {

    public static int[] GenerateDataset(int min,int max,int size){
        int[] dataset=new int[size];
        Random random=new Random();
        for (int i=0;i<size;i++){
            dataset[i]= random.nextInt(max-min+1)+min;
        }
        return dataset;
    }

    public static void BubbleSort(int[] dataset){
        for (int i=0;i< dataset.length-1;i++){
            for (int j=0;j< dataset.length-i-1;j++){
                if (dataset[j]>dataset[j+1]){
                    int temp=dataset[j];
                    dataset[j]=dataset[j+1];
                    dataset[j+1]=temp;
                }
            }
        }
        System.out.println("Bubble sort Took Place for size "+dataset.length);
    }

    public static void MergeSort(int[] dataset,int left,int right){
        if (left<right){
            int mid=left+(right-left)/2;
            MergeSort(dataset,left,mid);
            MergeSort(dataset,mid+1,right);
            merge(dataset,left,right,mid);
        }
    }

    public static void merge(int[] dataset,int left, int right, int mid){
        int n1=mid-left+1;
        int n2=right-mid;

        int[] leftarray=new int[n1];
        int[] rightarray=new int[n2];

        for(int i=0;i<n1;i++){
            leftarray[i]=dataset[left+i];
        }

        for (int j=0;j<n2;j++){
            rightarray[j]=dataset[mid+1+j];
        }

        int i=0,j=0,k=left;
        while (i<n1 && j<n2){
            if (leftarray[i]<rightarray[j]){
                dataset[k]=leftarray[i];
                i++;
            }
            else{
                dataset[k]=rightarray[j];
                j++;
            }
            k++;
        }

        while (i<n1){
            dataset[k++]=leftarray[i++];
        }
        while(j<n2){
            dataset[k++]=rightarray[j++];
        }
    }


    public static void QuickSort(int[] dataset,int low, int high){
        if (low<high){
            int pivotindex=partition(dataset,low,high);

            QuickSort(dataset,low,pivotindex-1);
            QuickSort(dataset,pivotindex+1,high);
        }
    }

    public static int partition(int[] dataset, int low, int high){
        int mid=low+(high-low)/2;
        int pivot=dataset[mid];
        int i=low-1;

        for (int j=low;j<high;j++){
            if (dataset[j]<pivot){
                i++;
                int temp=dataset[i];
                dataset[i]=dataset[j];
                dataset[j]=temp;
            }
        }
        int temp=dataset[mid];
        dataset[mid]=dataset[high];
        dataset[high]=temp;

        return i+1;
    }
    public static void main(String[] args) {
        int[] dataset1000=GenerateDataset(1,1000,1000);
        int[] dataset10000=GenerateDataset(1,10000,10000);
        int[] dataset1000000=GenerateDataset(1,1000000,1000000);
        final int a=1000000;
        double starttime,endtime;

        starttime=System.nanoTime();
        BubbleSort(dataset1000);
        endtime=System.nanoTime();
        System.out.println("Total time taken by bubble sort for 1k elements is :"+(endtime-starttime)/a);
        System.out.println();

        starttime=System.nanoTime();
        BubbleSort(dataset10000);
        endtime=System.nanoTime();
        System.out.println("Total time taken by bubble sort for 10k elements is :"+(endtime-starttime)/a);
        System.out.println();

        /*starttime=System.nanoTime();
        BubbleSort(dataset1000000);
        endtime=System.nanoTime();
        System.out.println("Total time taken by bubble sort for 1M elements is :"+(endtime-starttime)/a);
        System.out.println();*/


        starttime=System.nanoTime();
        MergeSort(dataset1000,0,dataset1000.length-1);
        endtime=System.nanoTime();
        System.out.println("Total time taken by Merge sort for 1k elements is :"+(endtime-starttime)/a);
        System.out.println();

        starttime=System.nanoTime();
        MergeSort(dataset10000,0,dataset10000.length-1);
        endtime=System.nanoTime();
        System.out.println("Total time taken by Merge sort for 10k elements is :"+((endtime-starttime)/a));
        System.out.println();

        starttime=System.nanoTime();
        MergeSort(dataset1000000,0,dataset1000000.length-1);
        endtime=System.nanoTime();
        System.out.println("Total time taken by Merge sort for 1M elements is :"+(endtime-starttime)/a);
        System.out.println();

        starttime=System.nanoTime();
        QuickSort(dataset1000,0,dataset1000.length-1);
        endtime=System.nanoTime();
        System.out.println("Total time taken by Quick sort for 1k elements is :"+(endtime-starttime)/a);
        System.out.println();

        starttime=System.nanoTime();
        QuickSort(dataset10000,0,dataset10000.length-1);
        endtime=System.nanoTime();
        System.out.println("Total time taken by Quick sort for 10k elements is :"+(endtime-starttime)/a);
        System.out.println();

        starttime=System.nanoTime();
        QuickSort(dataset1000000,0,dataset1000000.length-1);
        endtime=System.nanoTime();
        System.out.println("Total time taken by Quick sort for 1M elements is :"+(endtime-starttime)/a);
        System.out.println();
    }
}
