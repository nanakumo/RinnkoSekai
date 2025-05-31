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
    // Q4
    private DebuffType currentDebuff = DebuffType.NONE;
    private int DebuffTurnLeft = 0;

    public static final int MAX_STAT_VALUE = 100;
    public static final int MIN_STAT_VALUE = 0;

    // Q4：新增常量
    private static final int HUNGER_THRESHOLD = 20;
    private static final int THIRST_THRESHOLD = 20;
    private static final int MOOD_THRESHOLD = 30;
    private static final int HEALTH_THRESHOLD_FOR_SICK = 30;
    private static final int DEBUFF_DURATION = 3;



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

    // 获取当前Debuff
    public DebuffType getCurrentDebuff(){
        return currentDebuff;
    }

    // 返回Debuff剩余回合
    public int getDebuffTurnLeft(){
        return DebuffTurnLeft;
    }

    // 返回Debuff状态描述
    public String getDebuffStatusMessage(){
        if (currentDebuff != DebuffType.NONE) {
            return String.format("[负面状态: %s, 剩余: %d 回合]",
            currentDebuff.getDescription(), DebuffTurnLeft);
        }
        return "";
    }

    // 每回合状态衰减和Debuff处理
    public void passTurnUpdate(){
        changeHunger(-5);
        changeThirst(-7);
        changeMood(-3);
        if(health < 50){
            changeMood(-2);
        }
        changeMood(-2);
        if (hunger < HUNGER_THRESHOLD || thirst < THIRST_THRESHOLD) {
            changeHealth(-3);
        }
        //Debuff处理
        if (DebuffTurnLeft > 0) {
            DebuffTurnLeft--;
            if (DebuffTurnLeft == 0) {
                System.out.println("由于"+ name + "的" + currentDebuff.getDescription() + "状态未被照料，好感度下降了！ /(ㄒoㄒ)/~~");
                changeAffection(-15);
                currentDebuff = DebuffType.NONE;
            } else {
                // 检查是否会触发新的 Debuff
                if (health < HEALTH_THRESHOLD_FOR_SICK && currentDebuff == DebuffType.NONE) {
                    currentDebuff = DebuffType.SICK;
                    DebuffTurnLeft = DEBUFF_DURATION + 1;
                    System.out.println(name + "凛喵喵生病了！小猫娘快来照顾我！");
                } else if (hunger < HUNGER_THRESHOLD && currentDebuff == DebuffType.NONE) {
                    currentDebuff = DebuffType.HUNGRY;
                    DebuffTurnLeft = DEBUFF_DURATION;
                    System.out.println(name +"凛喵喵饿了！小猫娘快来喂饭！");
                } else if (mood < MOOD_THRESHOLD || currentDebuff == DebuffType.NONE) {
                    currentDebuff = DebuffType.UNHAPPY;
                    DebuffTurnLeft = DEBUFF_DURATION;
                    System.out.println(name + "凛喵喵不开心了！小猫娘快来哄我！");
                }

            }
        }
    }

    // 主动清除指定 Debuff
public void clearDebuff(DebuffType typeToClear) {
    if (currentDebuff == typeToClear) {
        currentDebuff = DebuffType.NONE;
        DebuffTurnLeftt = 0;
        System.out.println(name + " 的 " + typeToClear.getDescription() + " 状态被清除！");
    }
}



// 获取凛喵喵状态
    public String getStatus(){
    String status = String.format("[凛喵喵名]: %s,饱食度:%d/%d,口渴度:%d/%d,心情:%d/%d,健康,%d/%d,好感度:%d/%d]",
    name,hunger,MAX_STAT_VALUE,thirst,MAX_STAT_VALUE,mood,MAX_STAT_VALUE,health,MAX_STAT_VALUE,affection,MAX_STAT_VALUE);

    String DebuffStatusMessage = getDebuffStatusMessage();
    if (!DebuffStatusMessage.isEmpty()) {
        status += DebuffStatusMessage;
    }
    return status;

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
