public class Sort {
    public static void selectionSort(Comparable[] list) {
        int minIndex;
        Comparable nextSmallest;

        for (int unSortedStart = 0; unSortedStart < list.length - 1; unSortedStart++) {
            minIndex = unSortedStart;
            for (int currentIndex = unSortedStart + 1; currentIndex < list.length; currentIndex++) {
                if (list[currentIndex].compareTo(list[minIndex]) < 0) {
                    minIndex = currentIndex;
                }
            }

            nextSmallest = list[minIndex];
            list[minIndex] = list[unSortedStart];
            list[unSortedStart] = nextSmallest;
        }
    }
}
