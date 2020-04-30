package com.company;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Graf {
    int map[][];
    boolean[] used ;
    int q;
    Scanner sc = new Scanner(System.in);


    public Graf(int s) {
        this.q = s;
        this.map = new int[q][q];
        this.used = new boolean[q];

    }

    public void fillGraf(){
        for(int i = 0 ; i <q ; i++){
            for(int z = 0 ; z <q ; z++) {
                map[i][z] = sc.nextInt();
            }
        }
        dfs(0);

    }

    public Graf(){
        Random r = new Random();
        q = 400;
        this.map = new int[q][q];
        this.used = new boolean[q];
        for(int i = 0 ; i < q ; i++){
            for(int z = 0 ; z < q ; z++){
                map[i][z] = r.nextInt(2);
            }
        }

        print();
        dfs(0);
    }

    public Graf(String direcotry) {

        if(direcotry.isEmpty()){
            System.out.println("Ви не ввели назву файла");
            return;
        }
        try (FileReader f = new FileReader(direcotry)){
            Scanner sc = new Scanner(f);
            int temporary =  sc.nextInt();
            q = temporary;
            this.used = new boolean[q];
            this.map = new int[q][q];
                for(int i = 0 ; i < q ; i++) {
                    for (int z = 0; z < q; z++) {
                        temporary =  sc.nextInt();
                        map[i][z] = temporary;
                    }
                }
            //print();
            dfs(0);
        }catch (FileNotFoundException e){
            System.out.println("Такого файла нету");
        }catch (IOException e){
            System.out.println("Хюстон у нас проблеми");
        }
    }

    public void print(){
        System.out.println(q);
        for(int i = 0 ; i < q ; i++){
            for(int z = 0 ; z < q ; z++){
                System.out.print(map[i][z]+" ");
            }
            System.out.println();
        }
    }

    public void dfs(int pos){
        used[pos] = true;
        int next = 0;
        System.out.println(pos+1);
        for(int i = 0 ; i < q ; i++){
             if(map[pos][i]==1) {
                 next = i;
                 if (!used[next]) {
                     dfs(next);
                 }
             }
        }
    }


}
