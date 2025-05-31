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
    public static final int MAX_STAT_VALUE = 100;
    public static final int MIN_STAT_VALUE = 0;
    private DebuffType current

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

    // 定义 adjustStatus 方法

    private int adjustStatus(int currentStatus, int amount){
        int newStatus = currentStatus + amount;
        return Math.max(MIN_STAT_VALUE, Math.min(MAX_STAT_VALUE, newStatus));
    }

    // 状态调整方法

    protected void changeHunger(int amount){
        this.hunger = adjustStatus(this.hunger,amount);
    }

    protected void changeThirst(int amount){
        this.thirst = adjustStatus(this.thirst,amount);
    }

    protected void changeMood(int amount){
        this.mood = adjustStatus(this.mood,amount);
    }

    protected void changeHealth(int amount){
        this.health = adjustStatus(this.health,amount);
    }

    protected void changeAffection(int amount){
        this.affection = adjustStatus(this.affection,amount);
    }

    // 设置名字的方法
    public void setName(String name) {
        this.name = name;
    }


// 获取凛喵喵状态
public String getStatus(){
    return String.format("[凛喵喵名]: %s,饱食度:%d/%d,口渴度:%d/%d,心情:%d/%d,健康,%d/%d,好感度:%d/%d]",
    name,hunger,MAX_STAT_VALUE,thirst,MAX_STAT_VALUE,mood,MAX_STAT_VALUE,health,MAX_STAT_VALUE,affection,MAX_STAT_VALUE);
}

public static void main(String[] args) {
    Rinkko rinkko = new Rinkko();
    System.out.println("新喵喵状态：");
    System.out.println(rinkko.getStatus());

    // 测试状态调整方法

rinkko.changeHunger(-30);
rinkko.changeThirst(15);
rinkko.changeMood(-50);
rinkko.changeHealth(-10);
rinkko.changeAffection(1314490);

// 状态调整后

System.out.println("状态调整后：");
System.out.println(rinkko.getStatus());
}




}
