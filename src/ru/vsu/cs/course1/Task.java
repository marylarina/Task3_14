package ru.vsu.cs.course1;


import java.util.LinkedList;
import java.util.Queue;

public class Task {
    public static int[] Swap(int[] s) throws Exception {
        SimpleLinkedQueue<Integer> queue = new SimpleLinkedQueue<>();
        for (int i = 0; i < s.length; i++) {
                queue.add(s[i]);
        }
        queue.Solution();
        return queue.QueueToArray();
    }

    public static int[] SwapSecondVersion(int[] array) {
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < array.length; i++) {
            if((i==0)||(i%2==0)) {
                queue1.add(array[i]);
            }
            else{
                queue2.add(array[i]);
            }
        }
        if(array.length%2==0) {
            for (int i = 1; i <= array.length; i++) {
                if ((i == 0) || (i % 2 == 0)) {
                    queue.add(queue1.poll());
                } else {
                    queue.add(queue2.poll());
                }
            }
        }
        else{
            for (int i = 1; i <= array.length; i++) {
                if ((i == 0) || (i % 2 == 0)) {
                    if(i== array.length-1) {
                        for (int j = 0; j < 2; j++) {
                            queue.add(queue1.poll());
                        }
                    }
                    queue.add(queue1.poll());
                }
                else {
                    queue.add(queue2.poll());
                }
            }
        }
        int [] result = new int[array.length];
        for(int i=0; i< array.length; i++){
            result[i]= queue.poll();
        }
        return result;
    }
}
