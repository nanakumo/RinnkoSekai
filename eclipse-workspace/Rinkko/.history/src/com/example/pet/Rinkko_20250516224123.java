package com.example.pet;

// 创建Rinkko类

public class Rinkko {

    // 创建字段
    private String name;
    private int hunger = 80;
    private int thirst = 80;
    private int mood = 70;
    private int health = 90;
    private int affection = 30;
    private static final int MAX_STAT_VALUE = 100;
    private static final int MIN_STAT_VALUE = 0;

    // 创建构造函数（初始化字段
    public Rinkko( ){
        this.name = "Rinkko";
        this.hunger = 80;
        this.thirst = 80;
        this.mood = 70;
        this.health = 90;
        this.affection = 30;

    }

    // 获取字段（Getter
    public String getName(){
        return name;
    }

    public int getHunger(){
        return hunger;
    }

    public int getThirst(){
        return thirst;
    }

    public int getMood(){
        return mood;
    }

    public int getHealth(){
        return health;
    }

    public int getAffection(){
        return affection;
    }

	public static void main(String[] args) {
        Rinkko rinkko = new Rinkko(){
        System.out.println("凛喵喵名:" + rinkko.getName( ) + "/100");
        System.out.println("饱食度:" + rinkko.getHunger( )+ "/100");
        System.out.println("口渴度::" + rinkko.getThirst( )+ "/100");
        System.out.println("心情:" + rinkko.getMood( )+ "/100");
        System.out.println("健康:" + rinkko.getHealth( )+ "/100");
        System.out.println("好感度: " + rinkko.getAffection( ));

        }

	}

}
