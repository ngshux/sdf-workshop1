package cart;

import java.util.*;
import java.io.Console;

public class ShoppingCart {
    public static void main(String[] args) {
        System.out.println("Shopping cart");
        List<String> cart = new LinkedList<>();
        Console cons = System.console();
        String input;
        int delIndex;

        boolean stop = false;

        cart.add("apple");
        cart.add("orange");
        cart.add("pear");

        while(!stop){
            input = cons.readLine("> ");
            System.out.printf("READ: %s\n", input);
            String[] terms = input.split(" ");
            String cmd = terms[0];

            switch (cmd){
                case "add":
                    for(int i =1; i<terms.length; i++){
                        boolean found = false;
                        for(int j=0; j<cart.size(); j++){
                            if(terms[i].equals(cart.get(j))){
                                found =true;
                                System.out.printf("%s already in cart\n", terms[i]);
                                break;
                            }
                        }
                        if (!found){
                            cart.add(terms[i]);
                            System.out.printf("Added %s to cart\n", terms[i]);
                        }
                    }
                    break;

                case "list":
                    if(cart.size() > 0){
                        for (int i = 0; i < cart.size(); i++) {
                            System.out.printf("%d, %s\n", (i+1),cart.get(i));
                        }
                    }
                    else{
                        System.out.println("Cart empty");
                    }
                    break;

                case "remove":

                    for(int i =1; i<terms.length; i++){
                    boolean found = false;
                    for(int j=0; j<cart.size(); j++){
                        if(terms[i].equals(cart.get(j))){
                            found =true;
                            cart.remove(terms[i]);
                            System.out.printf("Removed %s from cart\n", terms[i]);
                            break;
                        }
                        
                        else if (terms.length < cart.size()){
                            delIndex = Integer.parseInt(terms[1]) -1;
                        //System.out.println(delIndex);
                        if(delIndex<cart.size()){
                            found = true;
                            System.out.printf("Removed %s from cart\n", cart.get(delIndex));
                            cart.remove(delIndex);
                            break;
                        }
                        }
                        else {
                        
                        System.out.println("Not found in cart");
                        }
                    } 
                    }
                

                    break;
                
                case "end":
                    stop = true;
                    break;
                    
                default:
                    System.out.println("Command not found\nList of commands:");
             
                        System.out.println("add, remove, list");
                    
                    break;
            }
        }
    }
}
