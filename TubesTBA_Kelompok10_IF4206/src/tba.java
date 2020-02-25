/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
/**
 *
 * @author Rimdani Alya Annisa
 */

public class tba {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String logikapropo;
        boolean cek;
        int state = 0;
        
        List TokenLexic = new ArrayList();
        Stack<Integer> sLexic = new Stack();
        
        System.out.print("Masukkan Logika Proposisi : ");
        logikapropo = input.nextLine();
        logikapropo += ' ';
        
        for (int i = 0; i < logikapropo.length(); i++) {
            if (state == 0) {
                if ((logikapropo.charAt(i) == 'p' || logikapropo.charAt(i) == 'r' || 
                     logikapropo.charAt(i) == 's' || logikapropo.charAt(i) == 'q') && 
                     (logikapropo.charAt(i+1) == ' ' || logikapropo.length() == 1 || 
                      logikapropo.charAt(i+1) == '(' || logikapropo.charAt(i+1) == ')') ) {
                    state = 1;
                    TokenLexic.add(1);
                    sLexic.push(1);
                    
                    cek = true;
                }
                else if(logikapropo.charAt(i) == 'n'){
                    state = 2;
                }
                else if (logikapropo.charAt(i) == 'a' ) {
                    state = 4;
                }
                else if(logikapropo.charAt(i) == 'o' ){
                    state = 6;
                }
                else if(logikapropo.charAt(i) == 'x' ){
                    state = 7;
                }
                else if (logikapropo.charAt(i) == 'i' ) {
                    state = 9;
                }
                else if (logikapropo.charAt(i) == 't' ) {
                    state = 12;
                }
                else if(logikapropo.charAt(i) == '(' ){
                    state = 15;
                    TokenLexic.add(9);
                    sLexic.push(9);
                    
                    cek = true;
                }
                else if (logikapropo.charAt(i) == ')' ) {
                    state = 15;
                    sLexic.push(10);
                    
                    TokenLexic.add(10);
                    cek = true;
                }
                else if (logikapropo.charAt(i) == ' ' ) {
                    state = 0;
                }
                else{
                    state = 404;
                    sLexic.push(11);
                }
                
            }
            else if (state == 1) {
                if (logikapropo.charAt(i) == ' ') {
                    state = 0;
                }
                else if (logikapropo.charAt(i) == '(' ) {
                    state = 15;
                    sLexic.push(9);
                    
                    TokenLexic.add(9);
                    cek = true;
                }
                else if (logikapropo.charAt(i) == ')' ) {
                    state = 15;
                    sLexic.push(10);
                    
                    TokenLexic.add(10);
                    cek = true;
                }
                else{
                    state = 404;
                    sLexic.push(11);
                }
            }
            else if (state == 2) {
                if (logikapropo.charAt(i) == 'o' ) {
                    state = 3;
//                    sLexic.push(2); //jangan push dulu nanti double
                    
                    TokenLexic.add(2);
                }else{
                    state = 404;
                }
            }
            else if (state == 3) {
                if (logikapropo.charAt(i) == 't' && (logikapropo.charAt(i+1) == ' ' || 
                    logikapropo.length() == 1 || logikapropo.charAt(i+1) == '(' || logikapropo.charAt(i+1) == ')') ) {
                    state = 1;
                    sLexic.push(2);
                    
                    TokenLexic.add(2);
                    cek = true;
                }
                else{
                    state = 404;
                }
            }
            else if (state == 4) {
                if (logikapropo.charAt(i) == 'n' ) {
                    state = 5;
                }else{
                    state = 404;
                }
            }
            else if (state == 5) {
                if (logikapropo.charAt(i) == 'd' && (logikapropo.charAt(i+1) == ' ' || 
                    logikapropo.length() == 1 || logikapropo.charAt(i+1) == '(' || logikapropo.charAt(i+1) == ')')) {
                    state = 1;
                    sLexic.push(3);
                    
                    TokenLexic.add(3);
                    cek = true;
                }else{
                    state = 404;
                }
            }
            else if (state == 6) {
                if (logikapropo.charAt(i) == 'r' && (logikapropo.charAt(i+1) == ' ' || 
                    logikapropo.length() == 1 || logikapropo.charAt(i+1) == '(' || logikapropo.charAt(i+1) == ')') ) {
                    state = 1;
                    sLexic.push(4);
                    
                    TokenLexic.add(4);
                    cek = true;
                }
                else{
                    state = 404;
                }
            }
            else if (state == 7) {
                if (logikapropo.charAt(i) == 'o' ) {
                    state = 8;
                }
                else{
                    state = 404;
                }
            }
            else if (state == 8) {
                if (logikapropo.charAt(i) == 'r' && (logikapropo.charAt(i+1) == ' ' || 
                    logikapropo.length() == 1 || logikapropo.charAt(i+1) == '(' || logikapropo.charAt(i+1) == ')') ) {
                    state = 1;
                    sLexic.push(5);
                    
                    TokenLexic.add(5);
                    cek = true;
                }else{
                    state = 404;
                    sLexic.push(11);
                }
            }
            else if (state == 9) {
                int cekif= i;
               
                if (logikapropo.charAt(i) == 'f' &&  logikapropo.charAt(i+1) == 'f') {
                      state = 10;
                    cek = true;
                }else if (logikapropo.charAt(i) == 'f'&& (logikapropo.charAt(i+1) == ' ' || 
                        logikapropo.length() == 1 || logikapropo.charAt(i+1) == '(' || logikapropo.charAt(i+1) == ')') ) {
                    state = 1;
//                    state = 10;
                    sLexic.push(6);
                    
                    TokenLexic.add(6);
                  
                }else{
                    state = 404;
                }
            }
            else if (state == 10) {
                int cekiff = i;
                if (logikapropo.charAt(i) == ' ' ) {
                    state = 15;
                }
                else if (logikapropo.charAt(i) == 'f' && (logikapropo.charAt(i+1) == ' ' || 
                        logikapropo.length() == 1 || logikapropo.charAt(i+1) == '(' || logikapropo.charAt(i+1) == ')') ) {
                    state = 11;
                    sLexic.push(8);
                    
                    TokenLexic.add(8);
                    cek = true;
                }
                else if (logikapropo.charAt(i) == '(' ) {
                    state = 1;
                    sLexic.push(9);
                    
                    TokenLexic.add(9);
                    cek = true;
                }
                else if (logikapropo.charAt(i) == ')' ) {
                    state = 1;
                    sLexic.push(10);
                    
                    TokenLexic.add(10);
                    cek = true;
                }
                else{
                    state = 404;
                }
            }
            else if (state == 11) {
                if (logikapropo.charAt(i) == ' ' ) {
                    state = 15;
                }
                else if (logikapropo.charAt(i) == '(' ) {
                    state = 1;
                    sLexic.push(9);
                    
                    TokenLexic.add(9);
                    cek = true;
                }
                else if (logikapropo.charAt(i) == ')' ) {
                    state = 1;
                    sLexic.push(10);
                    
                    TokenLexic.add(10);
                    cek = true;
                }
                else{
                    state = 404;
                }
            }
            else if (state == 12) {
                if (logikapropo.charAt(i) == 'h' ) {
                    state = 13;
                }
                else{
                    state = 404;
                    sLexic.push(11);
                }
            }else if (state == 13 ) {
                if (logikapropo.charAt(i) == 'e' ) {
//                    state = 15;
                    state = 14;
                }else{
                    state = 404;
                    sLexic.push(11);
                }
            }
            else if (state == 14) {  //tadi state 15
                if (logikapropo.charAt(i) == 'n' && (logikapropo.charAt(i+1) == ' ' || 
                        logikapropo.length() == 1 || logikapropo.charAt(i+1) == '(' || logikapropo.charAt(i+1) == ')') ) {
                    state = 1;
                    sLexic.push(7);
                    
                    TokenLexic.add(7);
                    cek = true;
                }
                else{
                    state = 1;
                }
            }
            else if (state == 15) {
                if (logikapropo.charAt(i) == ' ' ) {
                    state = 0;
                }
                else if (logikapropo.charAt(i) == 'p' || logikapropo.charAt(i) == 'r' || 
                        logikapropo.charAt(i) == 's' || logikapropo.charAt(i) == 'q') {
                    state = 1;
                    sLexic.push(1);
                    
                    TokenLexic.add(1);
                    cek = true;
                }
                else if (logikapropo.charAt(i) == ')' ) {
                    state = 15;
                    sLexic.push(10);
                    
                    TokenLexic.add(10);
                    cek = true;
                }
                else if (logikapropo.charAt(i) == '(' ) {
                    state = 15;
                    sLexic.push(9);
                    
                    TokenLexic.add(9);
                    cek = true;
                }
                else if(logikapropo.charAt(i) == 'n'){
                    state = 2;
                }
                else if (logikapropo.charAt(i) == 'a' ) {
                    state = 4;
                }
                else if(logikapropo.charAt(i) == 'o' ){
                    state = 6;
                }
                else if(logikapropo.charAt(i) == 'x' ){
                    state = 7;
                }
                else if (logikapropo.charAt(i) == 'i' ) {
                    state = 9;
                }
                else if (logikapropo.charAt(i) == 't' ) {
                    state = 12;
                }
                else{
                    state = 404;
                    sLexic.push(11);
                }
            }
            else{
                state = 404;
                sLexic.push(11);
            }
        }

        for (int i = 0; i < sLexic.size(); i++) {
            if (sLexic.get(i) == 11) {
                System.out.println("Error");
                break;
            }
            System.out.print(sLexic.get(i) + " ");
        }
        System.out.println("");
        System.out.println("");
        
        ArrayList<Integer> hasil = new ArrayList<>();
        hasil.addAll(sLexic);
        
        if (PDA(hasil) == true) {
            System.out.println("VALID");
        }
        else {
            System.out.println("TIDAK VALID");
        }
        
}
   
    public static boolean PDA(ArrayList<Integer> hasil) {
        Stacks stack = new Stacks();
        boolean valid = false;
        if (hasil.size() != 0) {
            if (hasil.get(0).equals(1) || hasil.get(0).equals(2) || hasil.get(0).equals(6) || hasil.get(0).equals(9)) {
                stack.pop();
                if (hasil.get(0).equals(1)) {
                    stack.push("A");
                    stack.push("1");
                }
                else if (hasil.get(0).equals(2)) {
                    stack.push("B");
                    stack.push("2");
                }
                else if (hasil.get(0).equals(6)) {
                    stack.push("B");
                    stack.push("7");
                    stack.push("B");
                    stack.push("6");
                }
                else if (hasil.get(0).equals(9)) {
                    stack.push("A");
                    stack.push("10");
                    stack.push("S");
                    stack.push("9");
                }

                for (int i = 0; i < hasil.size(); i++) {
                    if (i != hasil.size()) {
                        if (stack.cekTop("1") == true) {
                            stack.pop();
                            if (stack.cekTop("A") == true) {
                                if (i == hasil.size()-1) {
                                    stack.pop();
                                    valid = true;
                                }
                                else {
                                    if (hasil.get(i+1).equals(3) || hasil.get(i+1).equals(4) || hasil.get(i+1).equals(5) ||
                                            hasil.get(i+1).equals(7) || hasil.get(i+1).equals(8) || hasil.get(i+1).equals(10)
                                            || i == hasil.size()-1) {
                                        stack.pop();
                                        if (hasil.get(i+1).equals(3)) {
                                            stack.push("B");
                                            stack.push("3");
                                        }
                                        else if (hasil.get(i+1).equals(4)) {
                                            stack.push("B");
                                            stack.push("4");
                                        }
                                        else if (hasil.get(i+1).equals(5)) {
                                            stack.push("B");
                                            stack.push("5");
                                        }
                                        else if(hasil.get(i+1).equals(7)) {
                                            
                                        }
                                        else if (hasil.get(i+1).equals(8)) {
                                            stack.push("B");
                                            stack.push("8");
                                        }
                                        else if (hasil.get(i+1).equals(10)) {
                                            
                                        }
                                        else {
                                            valid = true;
                                        }
                                    }
                                    else valid = false;
                                }
                            }
                            else valid = false;
                        }
                        else if (stack.cekTop("2") == true) {
                            stack.pop();
                            if (stack.cekTop("B") == true) {
                                if (i == hasil.size()-1) {
                                    valid = false;
                                }
                                else {
                                    if (hasil.get(i+1).equals(1) || hasil.get(i+1).equals(9)) {
                                        stack.pop();
                                        if (hasil.get(i+1).equals(1)) {
                                            stack.push("A");
                                            stack.push("1");
                                        }
                                        else if (hasil.get(i+1).equals(9)) {
                                            stack.push("A");
                                            stack.push("10");
                                            stack.push("S");
                                            stack.push("9");
                                        }
                                    } else valid = false;
                                }
                            } else valid = false;
                        }
                        else if (stack.cekTop("3") == true) {
                            stack.pop();
                            if (stack.cekTop("B") == true) {
                                if (i == hasil.size()-1) {
                                    valid = false;
                                }
                                else {
                                    if (hasil.get(i+1).equals(1) || hasil.get(i+1).equals(9)) {
                                        stack.pop();
                                        if (hasil.get(i+1).equals(1)) {
                                            stack.push("A");
                                            stack.push("1");
                                        }
                                        else if (hasil.get(i+1).equals(9)) {
                                            stack.push("A");
                                            stack.push("10");
                                            stack.push("S");
                                            stack.push("9");
                                        }
                                    } else valid = false;
                                }
                            } else valid = false;
                        }
                        else if (stack.cekTop("4")) {
                            stack.pop();
                            if (stack.cekTop("B") == true) {
                                if (i == hasil.size()-1) {
                                    valid = false;
                                }
                                else {
                                    if (hasil.get(i+1).equals(1) || hasil.get(i+1).equals(9)) {
                                        stack.pop();
                                        if (hasil.get(i+1).equals(1)) {
                                            stack.push("A");
                                            stack.push("1");
                                        }
                                        else if (hasil.get(i+1).equals(9)) {
                                            stack.push("A");
                                            stack.push("10");
                                            stack.push("S");
                                            stack.push("9");
                                        }
                                    } else valid = false;
                                }
                                
                            } else valid = false;
                        }
                        else if (stack.cekTop("5")) {
                            stack.pop();
                            if (stack.cekTop("B") == true) {
                                if (i == hasil.size()-1) {
                                    valid = false;
                                }
                                else {
                                    if (hasil.get(i+1).equals(1) || hasil.get(i+1).equals(9)) {
                                        stack.pop();
                                        if (hasil.get(i+1).equals(1)) {
                                            stack.push("A");
                                            stack.push("1");
                                        }
                                        else if (hasil.get(i+1).equals(9)) {
                                            stack.push("A");
                                            stack.push("10");
                                            stack.push("S");
                                            stack.push("9");
                                        }
                                    } else valid = false;
                                }
                            } else valid = false;
                        }
                        else if (stack.cekTop("6") == true) {
                            stack.pop();
                            if (stack.cekTop("B") == true) {
                                if (i == hasil.size()-1) {
                                    valid = false;
                                }
                                else {
                                    if (hasil.get(i+1).equals(1) || hasil.get(i+1).equals(9)) {
                                        stack.pop();
                                        if (hasil.get(i+1).equals(1)) {
                                            stack.push("A");
                                            stack.push("1");
                                        }
                                        else if (hasil.get(i+1).equals(9)) {
                                            stack.push("A");
                                            stack.push("10");
                                            stack.push("S");
                                            stack.push("9");
                                        }
                                    } else valid = false;
                                }
                            } else valid = false;
                        }
                        else if (stack.cekTop("7") == true) {
                            stack.pop();
                            if (stack.cekTop("B") == true) {
                                if (i == hasil.size()-1) {
                                    valid = false;
                                }
                                else {
                                    if (hasil.get(i+1).equals(1) || hasil.get(i+1).equals(9)) {
                                        stack.pop();
                                        if (hasil.get(i+1).equals(1)) {
                                            stack.push("A");
                                            stack.push("1");
                                        }
                                        else if (hasil.get(i+1).equals(9)) {
                                            stack.push("A");
                                            stack.push("10");
                                            stack.push("S");
                                            stack.push("9");
                                        }
                                    } else valid = false;
                                }
                            } else valid = false;
                        }
                        else if (stack.cekTop("8") == true) {
                            stack.pop();
                            if (stack.cekTop("B") == true) {
                                if (i== hasil.size()-1) {
                                    valid = false;
                                }
                                else {
                                    if (hasil.get(i+1).equals(1) || hasil.get(i+1).equals(9)) {
                                        stack.pop();
                                        if (hasil.get(i+1).equals(1)) {
                                            stack.push("A");
                                            stack.push("1");
                                        }
                                        else if (hasil.get(i+1).equals(9)) {
                                            stack.push("A");
                                            stack.push("10");
                                            stack.push("S");
                                            stack.push("9");
                                        }
                                    } else valid = false;
                                }
                            } else valid = false;
                        }
                        else if (stack.cekTop("9") == true) {
                            stack.pop();
                            if (stack.cekTop("S") == true) {
                                if (i == hasil.size()-1) {
                                    valid = false;
                                }
                                else {
                                    if (hasil.get(i+1).equals(1) || hasil.get(i+1).equals(2) || hasil.get(i+1).equals(6) ||
                                        hasil.get(i+1).equals(9) || hasil.get(i+1).equals(10)) {
                                        stack.pop();
                                        if (hasil.get(i+1).equals(1)) {
                                            stack.push("A");
                                            stack.push("1");
                                        }
                                        else if (hasil.get(i+1).equals(2)) {
                                            stack.push("B");
                                            stack.push("2");
                                        }
                                        else if (hasil.get(i+1).equals(6)) {
                                            stack.push("B");
                                            stack.push("7");
                                            stack.push("B");
                                            stack.push("6");
                                        }
                                        else if (hasil.get(i+1).equals(9)) {
                                            stack.push("A");
                                            stack.push("10");
                                            stack.push("S");
                                            stack.push("9");
                                        }
                                        else if (hasil.get(i+1).equals(10)) {
//                                            
                                        }
                                    } else valid = false;
                                }
                            } else valid = false;
                        }
                        else if (stack.cekTop("10") == true) {
                            stack.pop();
                            if (stack.cekTop("A") == true) {
                                if (i == hasil.size()-1) {
                                    stack.pop();
                                    if (stack.isEmpty() == true) {
                                        valid = true;
                                    }
                                    else {
                                        valid = false;
                                    }
                                }
                                else {
                                    if (hasil.get(i+1).equals(3) || hasil.get(i+1).equals(4) || hasil.get(i+1).equals(5) || 
                                            hasil.get(i+1).equals(7) || hasil.get(i+1).equals(8) ||
                                            hasil.get(i+1).equals(10) || i == hasil.size()-1) {
                                        stack.pop();
                                        if (hasil.get(i+1).equals(3)) {
                                            stack.push("B");
                                            stack.push("3");
                                        }
                                        else if (hasil.get(i+1).equals(4)) {
                                            stack.push("B");
                                            stack.push("4");
                                        }
                                        else if (hasil.get(i+1).equals(5)) {
                                            stack.push("B");
                                            stack.push("5");
                                        }
                                        else if (hasil.get(i+1).equals(7)) {
                                            
                                        }
                                        else if (hasil.get(i+1).equals(8)) {
                                            stack.push("B");
                                            stack.push("8");
                                        }
                                        else if (hasil.get(i+1).equals(10)) {
                                            
                                        } else valid = true;
                                    } else valid = false;
                                }
                            }
                            else valid = false;
                        }
                    }
                }
            }
            else valid = false;
        }
        if (valid == true) {
            stack.pop();
        }
        stack.getIsi();
        return valid;
    }
    
}
