public class BinarySearchMissing {
    //pre: -1 <= l, r <= a.length, a[i] >= a[i + 1]
    //post: R = min(i) : a[i] <= x
    public static int RecursionBinarySearch(int[] a, int x, int l, int r) {
        int index;
        int mid = l + (r - l) / 2;
        if (l < r - 1) {
            if (x >= a[mid]) {
                index = RecursionBinarySearch(a, x, l, mid);
            } else {
                index = RecursionBinarySearch(a, x, mid, r);
            }
        } else {
            index = r;
        }
        return index;
    }

    //pre: a[i] >= a[i + 1]
    //post: R = min(i) : a[i] <= x
    public static int IterativeBinarySearch(int[] a, int x) {
        int l = -1, r = a.length;
        //inv: a[l] > x >= a[r]
        while (l < r - 1) {
            int mid = l + (r - l) / 2;
            if (x >= a[mid]) {
                r = mid;
            } else {
                l = mid;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        int size = args.length - 1;
        int[] a = new int[size];
        int x = Integer.parseInt(args[0]);
        for (int i = 0; i < size; ++i) {
            a[i] = Integer.parseInt(args[i + 1]);
        }
        int index = IterativeBinarySearch(a, x);//RecursionBinarySearch(a, x, -1, size);
        System.out.println(index);
        if (a[index] != x) {
            index = -(index - 1) - 1;
        }
        System.out.println(index);
        //System.out.print(RecursionBinarySearch(a, x, -1, size)); //true
        //System.out.println(IterativeBinarySearch(a, x)); //true
    }
}
