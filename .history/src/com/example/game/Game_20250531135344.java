package com.example.game;

import com.example.pet.Rinkko;
import java.util.Scanner;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import com.example.Item.*;

public class Game {
    private Player player;
    private Scanner scanner;
    private String[] petNamePrefiexs = {"傲娇", "可爱", "贪吃", "元气", "懒散"};
    private Random random;
    private int currentLevel = 1;
    private static final int maxLevel = 5;
  // 喝水吃饭
    private List<FoodItem> availableFoods;
    private List<DrinkItem> availableDrinks;


    // 构造方法
    public Game(){
        this.player = new Player();
        this.scanner =new Scanner(System.in);
        this.random = new Random();

            // 初始化食物列表
        this.availableFoods = new ArrayList<>();
        availableFoods.add(new FoodItem("普通汉堡",10,30,5));
         availableFoods.add(new FoodItem("美味炸鸡",25,50,10));

        //  初始化饮料
        this.availableDrinks = new ArrayList<>();
        availableDrinks.add(new DrinkItem("干净的水",5,30,2));
         availableDrinks.add(new DrinkItem("肥宅快乐",15,45,5));
    }

    // 添加通过辅助方法
    private <T extends MenuItem> T selectItemFromMenu(List<T> items, String prompt){
        System.out.println(prompt);
        for(int i = 0; i < items.size(); i++){
            T item = items.get(i);
            System.out.println((i + 1) + ". " + item.getName() + " (" + item.getDescription() + ")");
        }
        System.out.println("0. 返回上一级");

        int choice = -1;
        while (condition) {
            
        }

    }


    // 前往下一关
    private void nextLevel(){
         if(currentLevel < maxLevel){
            currentLevel ++;
            System.out.println("正在前往下一关，现在是第" + currentLevel + "关。");
        } else {
            System.out.println("恭喜你已通过所有关卡，接下来就和所有凛喵喵们一起共度余生吧！");
        }
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
                case 1 :adoptRinkko();
                case 2 : player.listPets();
                case 3 : nextLevel();
                case 4 : {
                    System.out.println("感谢游玩，期待下次相遇！");
                    running = false;
                }
                default : System.out.println("无效选择！");


            }

        }
    }

    // 领养凛喵喵功能

    private void adoptRinkko(){
        System.out.println("请你为你的可爱凛喵喵取一个名字吧！");
        String newName = scanner.nextLine();

        // 随机前缀

        String[] prefixes = {"A", "B", "C"};
        Random random = new Random();
        int randomIndex = random.nextInt(prefixes.length); // 生成 0, 1, 或 2
        String randomPrefix = prefixes[randomIndex];

        // 创建新的凛喵喵

        Rinkko newRinkko = new Rinkko();
        String fullName = randomPrefix + "的" + newName;
        newRinkko.setName(fullName);

        // 添加到玩家

        player.addPet(newRinkko);
        System.out.println("你成功领养了一只新的凛喵喵：" + fullName);

    }

    // 主方法 - 运行游戏
    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}


