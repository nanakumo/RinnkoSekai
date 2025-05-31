package com.example.game;

import com.example.pet.Rinkko;
import java.util.Scanner;
import java.util.Random;

public class Game {
    private Player player;
    private Scanner scanner;
    private String[] petNamePrefiexs = {"傲娇", "可爱", "贪吃", "元气", "懒散"};
    private Random random;
    private int currentLevel = 1;
    private static final int maxLevel = 5;

    // 构造方法
    public Game(){
        this.player = new Player();
        this.scanner =new Scanner(System.in);
        this.random = new Random();
    }

    // 游戏启动
    public void start(){
        System.out.println("欢迎来到凛喵喵的世界！");
        boolean running = true;

        while(running){
            System.out.println("\n当前你在第" + currentLevel + "关");
            System.out.println("请选择操作：");
            System.out.println("1. 领养一只凛喵喵");
            System.out.println("2. 查看你的凛喵喵");
            System.out.println("3. 前往下一关");
            System.out.println("4. 退出游戏");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 1 : adoptRinkko();
                case 2 : player.listPets();
                case 3 : nextLevel():

            }

        }
    }
}
