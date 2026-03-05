package com.ntoproject;

import java.util.function.Supplier;

import javax.swing.SwingUtilities;

import com.bpa4j.core.ProgramStarter;
import com.bpa4j.core.Registrator;
import com.bpa4j.core.User;
import com.bpa4j.core.User.Feature;
import com.bpa4j.core.User.Permission;
import com.bpa4j.core.User.Role;
import com.bpa4j.navigation.Navigator;

public class Main {
    public enum AppRole implements Role{
        MINING(
            ()->new Permission[]{},
            ()->new Feature[]{}
        ),
        REFINING(
            ()->new Permission[]{},
            ()->new Feature[]{}
        ),
        QUALITY(
            ()->new Permission[]{},
            ()->new Feature[]{}
        );
        private AppRole(Supplier<Permission[]>p,Supplier<Feature[]>f){SwingUtilities.invokeLater(()->Registrator.register(this,f.get(),p.get()));}
    }
    public enum AppPermission implements Permission{
        ;
        private AppPermission(){Registrator.register(this);}
    }
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Navigator.init();
        ProgramStarter.welcomeMessage="Добро пожаловать в \"Золотую долину\"";
        ProgramStarter.authRequired=false;
        if(ProgramStarter.firstLaunch){
            //Регистрация пользователей
            User.register("Добыча","",AppRole.MINING);
            User.register("Переработка","",AppRole.REFINING);
            User.register("Управление качеством","",AppRole.QUALITY);
            //Декларация групп
            
            ProgramStarter.runProgram();
            //Регистрация групп
            
            //Тестовые данные
            
        }else ProgramStarter.runProgram();
    }
}