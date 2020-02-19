package stack;
class Stack
{
  public static void main(String[] args) {
    Stack1 a = new Stack1(10);
    try {
      for(int i = 0; i < 11; i++) {
        a.push(i);
      }
    }
    catch(StackOverflow e){
      System.out.println(e);
    }
    try {
      for(int i = 0; i < 11; i++) {
        System.out.println(a.pop());
      }
    }
    catch(StackUnderflow e){
      System.out.println(e);
    }
  }
}

interface StackADT {
  void push(int item) throws StackOverflow;
  int pop() throws StackUnderflow;
}

class Stack1 implements StackADT {
  private int arr[];
  private int top;
  Stack1(int size) {
    arr = new int[size];
    top = -1;
  }
  public void push(int item) throws StackOverflow {
    if(top == arr.length - 1) {
      throw new StackOverflow();
    }
    else 
      arr[++top] = item;
  }
  public int pop() throws StackUnderflow {
    if(top < 0) {
      throw new StackUnderflow();
    }
    else 
      return arr[top--];
  }
}

class StackOverflow extends Exception{}
class StackUnderflow extends Exception{}
