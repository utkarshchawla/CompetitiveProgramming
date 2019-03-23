package july_17;

public class queue {

    protected int[] data;
    protected int front;
    protected int size;

    public queue() {
        this(5);
    }

    public queue(int cap) {
        this.data = new int[cap];
    }

    public void enqueue(int item) throws Exception {
        if (size == data.length) {
            throw new Exception("queue is full");
        } else {
            int tail = (front + size) % data.length;
            data[tail] = item;
            size++;
        }
    }

    public int dequeue() throws Exception {
        if (size == 0) {
            throw new Exception("queue is empty");
        } else {

            int rv = data[front];
            data[front] = 0;
            front = (front + 1) % data.length;
            size--;
            return rv;
        }
    }

    public void display() {
        System.out.println("----------------------------------");
        for (int i = 0; i < size; i++) {
            System.out.print(data[((front + i) % data.length)] + ", ");
        }
        System.out.println();
        System.out.println("-----------------------------------");
    }

    public void reversedisplay(int count) throws Exception {
        if (count == size) {
            return;
        }
        int temp = dequeue();
        enqueue(temp);
        reversedisplay(count + 1);
        System.out.print(temp + ", ");

    }

    public void reverse() throws Exception {
        if (size == 0) {
            return;
        }
        int temp = dequeue();
        reverse();
        enqueue(temp);

    }
}
