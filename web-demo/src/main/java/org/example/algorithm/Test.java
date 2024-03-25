package org.example.algorithm;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        reverse(12345);
        reverseStr("123456");
        sortArr(new int[]{10, 3, 1, 5, 6, 7});
        selectSort(new int[]{10, 3, 1, 5, 6, 7});
        int[] newArr = quickSortArr(new int[]{10, 3, 1, 5, 6, 7, 4});
        binSearch(newArr, 6);
        MyNode node = new MyNode(1);
        node.appendNode(2);
        node.appendNode(3);
        node.appendNode(4);
        node.appendNode(5);
        MyNode res = node.reverseNode(node);
        node.printNode(res);
    }

    static class MyNode {
        int data;
        MyNode next;

        public MyNode(int data) {
            this.data = data;
            this.next = null;
        }

        public void appendNode(int data) {
            if (this.next == null) {
                this.next = new MyNode(data);
            } else {
                this.next.appendNode(data);
            }
        }

        public MyNode reverseNode(MyNode node) {
            MyNode cur = node;
            MyNode pre = null;
            while (cur != null) {
                MyNode tmp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = tmp;
            }
            return pre;
        }

        public void printNode(MyNode node) {
            while (node != null) {
                System.out.println(node.data);
                node = node.next;
            }
        }

    }

    public static void reverse(int num) {
        int res = 0;
        while (num > 0) {
            int mod = num % 10;
            res = res * 10 + mod;
            num = num / 10;
        }
        System.out.println(res);
    }

    public static void reverseStr(String str) {
        char[] arr = str.toCharArray();
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
        System.out.println(new String(arr));
    }

    public static void sortArr(int[] arr) {
        for (int i=0;i<arr.length-1;i++) {
            for (int j=i+1;j<arr.length;j++) {
                if (arr[i]>arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void selectSort(int[] arr) {
        for (int i=0;i<arr.length-1;i++) {
            int min = i;
            for (int j=i+1;j<arr.length;j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static int[] quickSortArr(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        return arr;
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int l = start;
        int r = end;
        int p = arr[l];
        while (l < r) {
            while (l < r && arr[r] > p) {
                r--;
            }
            arr[l] = arr[r];
            while (l < r && arr[l] < p) {
                l++;
            }
            arr[r] = arr[l];
        }
        arr[l] = p;
        quickSort(arr, 0, l - 1);
        quickSort(arr, l + 1, r);
    }

    public static void binSearch(int[] arr, int num) {
        int l=0,r=arr.length-1,middle;
        while (l <= r) {
            middle = (l+r)/2;
            if (num == arr[middle]) {
                System.out.println(middle);
                return;
            } else if (num < arr[middle]) {
                r = middle -1;
            } else {
                l = middle + 1;
            }
        }
        System.out.println(-1);
    }

}