package com.dmitrydrobysh.app;
import java.util.Scanner;

import com.dmitrydrobysh.app.btree.*;

public class App {
    public static void main( String[] args ){

        Scanner in = new Scanner(System.in);

        System.out.println("Enter number");
        int n = in.nextInt();

        BTree myTree = new BTree(n);

        for(int i = 0; i < 2; i ++){
            System.out.println("Enter number");
            n = in.nextInt();
            myTree.append(n);
        }

        System.out.println(myTree.toString());

        for(int i = 0; i < 1; i ++){
            System.out.println("Enter value to delete");
            n = in.nextInt();
            myTree.delete(n);
        }

        System.out.println(myTree.toString());

        // for(int i = 0; i < 2; i ++){
        //     System.out.println("Enter number");
        //     n = in.nextInt();
        //     myTree.append(n);
        // }

        // System.out.println(myTree.toString());
    }
        
}
