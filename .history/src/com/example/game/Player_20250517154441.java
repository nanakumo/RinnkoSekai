package com.example.game;
import java.util.ArrayList;

import com.example.pet.Rinkko;

// 创建类
public class Player {

    //创建字段
    private int money = 500;
    private ArrayList<Rinkko> pets;

    // 构造方法，无参数
    public Player(){
        this.money = 500;
        this.pets = new ArrayList<>(); // 这是一个空的喵喵列表
    }

    // 方法：获取金钱
    public int getMoney(){
        return this.money;
    }

    //方法：增加金钱
    public void addMoney(int amount){
        if(amount > 0){
            this.money += amount;
        }
    }

    // 方法：花费金钱
    public boolean spendMoney(int amount){
        if(amount > 0 && this.money >= amount){
            this.money -= amount;
            return true;
        }
        return false;
    }

    // 方法：添加宠物
    public void addPet(Rinkko pet){
        if(pet _)
    }

}

