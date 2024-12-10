public class q1 {

    static int size=4;
    static int[]stack=new int[size];
    static int top=-1;

    public static void push(int x)
    {
        if (isFull())
         {
        System.out.println("Overflow");  
        return;
        }
        stack[++top]=x;
    }
    public static boolean isFull()
    {
        return(top==size-1);
    }
    public static boolean isEmpty(){
        return(top==-1);
    }
    public static int pop(){
        if(isEmpty()){
            System.out.println("Underflow");
            return -1;
        }
        return stack[top--];
    }
    public static int peak(){
        if(isEmpty()){
            System.out.println("Underflow");
            return -1;
        
    }
    return stack[top];
}
public static void display(){
    for(int i=top;i>=0;i--){
        System.out.println(stack[i]);
    }
}
public static void main(String[] args) {
    push(10);
    push(20);
    push(30);
    push(40);
    pop();

    display();
    pop();
    pop();
    pop();
    display();
    System.out.println("Peak is" +peak());
}
}