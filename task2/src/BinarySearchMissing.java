public class BinarySearchMissing {
    // pre: -1 <= l, r <= a.length, a[i] >= a[i + 1]
    // post: result = min index : a[index] <= x
    //     if (index >= a.length || a[index] != x) result == -result - 1
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
            if (index >= a.length || a[index] != x) {
                index = -index - 1;
            }
        }
        return index;
    }

    // pre: a[i] >= a[i + 1]
    // post: result = min index : a[index] <= x
    //     if (index >= a.length || a[index] != x) result == -result - 1
    public static int IterativeBinarySearch(int[] a, int x) {
        int l = -1, r = a.length, mid;
        //inv: a[l] > x >= a[r]
        while (l < r - 1) {
            mid = l + (r - l) / 2;
            if (x < a[mid]) {
                l = mid;
            } else {
                r = mid;
            }
        }
        if (r >= a.length || a[r] != x) {
            r = -r - 1;
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
        int index = /*IterativeBinarySearch(a, x);*/RecursionBinarySearch(a, x, -1, size);

        System.out.println(index);
    }
}
