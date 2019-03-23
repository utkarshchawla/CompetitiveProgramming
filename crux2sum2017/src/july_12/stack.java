package july_12;

public class stack {

    protected int[] data;
    protected int tos = -1;

    public stack() {
        this(5);
    }

    public stack(int cap) {
        this.data = new int[cap];
    }

    public void push(int item) throws Exception {
        if (tos + 1 >= data.length) {
            throw new Exception("stack is full");
        } else {
            tos++;
            data[tos] = item;
        }
    }

    public int top() throws Exception {
        int rv = 0;
        if (tos <= -1) {
            throw new Exception("stack is empty");
        } else {
            rv = data[tos];
        }
        return rv;
    }

    public int pop() throws Exception {
        int rv = 0;
        if (tos <= -1) {
            throw new Exception("stack is empty");
        } else {
            rv = data[tos];
//            data[tos] = 0;
            tos--;
        }
        return rv;

    }

    public void display() {
        System.out.println("----------------------------------------------");
        for (int i = tos; i >= 0; i--) {
            System.out.print(data[i] + ", ");
        }
        System.out.println();
        System.out.println("----------------------------------------------");

    }

    public void reverseDisplay() throws Exception {
        if (tos == -1) {
            return;
        }
        int temp = pop();
        reverseDisplay();
        System.out.print(temp + ", ");
        push(temp);
    }

    public int size() {
        return tos + 1;
    }

    private void reverseHelp(stack temp) throws Exception {
        if (tos == -1) {
            return;
        }
        temp.push(pop());
        reverseHelp(temp);
    }

    public void reverse(stack t) throws Exception {
        reverseHelp(t);
        this.data = t.data;
        this.tos = t.tos;

    }
}
