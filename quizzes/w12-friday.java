

void swap(double[] arr, int a, int b) {
    double tmp = arr[a];
    arr[a] = arr[b];
    arr[b] = tmp;
}

void sort(double[] arr) {
    for (int i = 0; i < arr.length; i++) {
        // find the min between i and arr.length - 1
        int min_idx = -1;
        double min = arr[i];
        for (int j = i+1; j < arr.length; j++) {
            if (arr[j] < min) {
                min = arr[j];
                min_idx = j;
            }
        }
        // put the min in position i
        swap(arr, i, min_idx);
    }
}

