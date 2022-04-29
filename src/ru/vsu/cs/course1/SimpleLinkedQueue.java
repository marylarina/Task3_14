package ru.vsu.cs.course1;

    public class SimpleLinkedQueue<T> implements SimpleQueue<T> {

        private class SimpleLinkedListNode {
            public T value;
            public SimpleLinkedListNode next;

            public SimpleLinkedListNode(T value, SimpleLinkedListNode next) {
                this.value = value;
                this.next = next;
            }

            public SimpleLinkedListNode(T value) {
                this(value, null);
            }
        }

        private SimpleLinkedListNode head = null;  // first, top
        private SimpleLinkedListNode tail = null;  // last
        private int count = 0;

        public void Solution (){
            SimpleLinkedListNode curr = head;
            T variable;
            while ((curr!=null)&&(curr.next!=null)){
                variable = curr.value;
                curr.value=curr.next.value;
                curr.next.value=variable;
                curr=curr.next.next;
            }
        }

         public int[] QueueToArray (){
            SimpleLinkedListNode curr = head;
            int size = count();
            int [] result=new int[size];
            int index = 0;
            while (curr != null) {
                result[index]= (Integer) curr.value;
                curr = curr.next;
                index++;
            }
            return result;
        }


        @Override
        public void add(T value) {
            if (count == 0) {
                head = tail = new SimpleLinkedListNode(value);
            } else {
                tail.next = new SimpleLinkedListNode(value);
                tail = tail.next;
            }
            count++;
        }

        @Override
        public T remove() throws Exception {
            T result = element();
            head = head.next;
            if (count == 1) {
                tail = null;
            }
            count--;
            return result;
        }

        @Override
        public T element() throws Exception {
            if (count() == 0) {
                throw new Exception("Queue is empty");
            }
            T current = head.value;
            head = head.next;
            return current;
        }

        @Override
        public int count() {
            return count;
        }

        @Override
        public boolean empty() {
            return count() == 0;
        }
    }
