import java.util.*;

public class DataStructureSearchComparison {

    public static int[] generateDataset(int size, int min, int max) {
        Random random = new Random();
        int[] dataset = new int[size];
        for (int i = 0; i < size; i++) {
            dataset[i] = random.nextInt(max - min + 1) + min;
        }
        return dataset;
    }

    public static void testArraySearch(int[] array, int target) {
        long startTime = System.nanoTime();
        boolean found = false;

        for (int value : array) {
            if (value == target) {
                found = true;
                break;
            }
        }

        long endTime = System.nanoTime();
        System.out.println("Time taken by Array search: " + ((endTime - startTime) / 1_000_000) + " ms");
    }
    
    public static void testHashSetSearch(HashSet<Integer> hashSet, int target) {
        long startTime = System.nanoTime();
        boolean found = hashSet.contains(target);
        long endTime = System.nanoTime();
        System.out.println("Time taken by HashSet search: " + ((endTime - startTime) / 1_000_000) + " ms");
    }

    public static void testTreeSetSearch(TreeSet<Integer> treeSet, int target) {
        long startTime = System.nanoTime();
        boolean found = treeSet.contains(target);
        long endTime = System.nanoTime();
        System.out.println("Time taken by TreeSet search: " + ((endTime - startTime) / 1_000_000) + " ms");
    }

    public static void main(String[] args) {
        // Define dataset sizes
        int[] sizes = {1_000, 100_000, 1_000_000};

        for (int size : sizes) {
            System.out.println("\nDataset Size: " + size);

            int[] dataset = generateDataset(size, 1, size * 2); // Range ensures varied data


            HashSet<Integer> hashSet = new HashSet<>();
            TreeSet<Integer> treeSet = new TreeSet<>();
            for (int value : dataset) {
                hashSet.add(value);
                treeSet.add(value);
            }


            int target = dataset[new Random().nextInt(size)];


            testArraySearch(dataset, target);
            testHashSetSearch(hashSet, target);
            testTreeSetSearch(treeSet, target);
        }
    }
}