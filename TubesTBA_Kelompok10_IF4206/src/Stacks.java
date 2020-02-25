
import java.util.ArrayList;

public class Stacks {
    
    ArrayList stack;
    public Stacks() {
        stack = new ArrayList();
        stack.add("#");
        stack.add("S");
    }
    public void push(String push){
        stack.add(push);
    }
    public void pop(){
        int top = stack.size()-1;
        stack.remove(top);
    }
    public boolean cari(String search){
        boolean ketemu = false;
        for (int i = 0; i < stack.size(); i++) {
            if(stack.equals(search)) ketemu = true;
        }
        return ketemu;
    }
    public boolean cekTop(String search){
        int top = stack.size()-1;
        boolean cek = (stack.get(top).equals(search)) ? true : false;
        return cek;
    }
    
    public boolean isEmpty() {
        if (cekTop("#")) {
            return true;
        }
        return false;
    }
    
    public void getIsi() {
        if (stack.size() == 0) {
            System.out.println("Stack sudah kosong");
        }
        else {
            System.out.println("Stack masih ada isi : ");
            for (int i = 0; i < stack.size(); i++) {
                System.out.print(stack.get(i) + " ");
            }
            System.out.println("");
        }
    }
}
