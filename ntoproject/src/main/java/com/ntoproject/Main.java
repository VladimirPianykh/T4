package com.ntoproject;

import java.io.File;
import java.util.function.Supplier;

import javax.swing.SwingUtilities;

import com.bpa4j.core.Data.EditableGroup;
import com.bpa4j.core.Navigator;
import com.bpa4j.core.ProgramStarter;
import com.bpa4j.core.Registrator;
import com.bpa4j.core.Root;
import com.bpa4j.core.User;
import com.bpa4j.core.User.Feature;
import com.bpa4j.core.User.Permission;
import com.bpa4j.core.User.Role;
import com.bpa4j.ui.PathIcon;
import com.bpa4j.util.codegen.ProjectGraph;
import com.ntoproject.editables.auxil.WorkNorm;
import com.ntoproject.editables.registered.Device;
import com.ntoproject.editables.registered.Nomencl;
import com.ntoproject.editables.registered.Unit;
import com.ntoproject.editables.registered.WorkType;

public class Main {
    public enum AppRole implements Role{
        MINING(
            ()->new Permission[]{
                AppPermission.CREATE_UNIT, AppPermission.READ_UNIT,
                AppPermission.CREATE_NOMENCL, AppPermission.READ_NOMENCL,
                AppPermission.CREATE_DEVICE, AppPermission.READ_DEVICE,
                AppPermission.CREATE_WORKTYPE, AppPermission.READ_WORKTYPE,
                AppPermission.CREATE_WORKNORM, AppPermission.READ_WORKNORM
            },
            ()->new Feature[]{}
        ),
        REFINING(
            ()->new Permission[]{
                AppPermission.CREATE_UNIT, AppPermission.READ_UNIT,
                AppPermission.CREATE_NOMENCL, AppPermission.READ_NOMENCL,
                AppPermission.CREATE_DEVICE, AppPermission.READ_DEVICE
            },
            ()->new Feature[]{}
        ),
        QUALITY(
            ()->new Permission[]{
                AppPermission.CREATE_UNIT, AppPermission.READ_UNIT,
                AppPermission.CREATE_NOMENCL, AppPermission.READ_NOMENCL
            },
            ()->new Feature[]{}
        );
        private AppRole(Supplier<Permission[]>p,Supplier<Feature[]>f){SwingUtilities.invokeLater(()->Registrator.register(this,f.get(),p.get()));}
    }
    public enum AppPermission implements Permission{
        READ_WORKTYPE,
        CREATE_WORKTYPE,
        READ_WORKNORM,
        CREATE_WORKNORM,
        READ_UNIT,
        CREATE_UNIT,
        READ_NOMENCL,
        CREATE_NOMENCL,
        READ_DEVICE,
        CREATE_DEVICE,
        ;
        private AppPermission(){Registrator.register(this);}
    }
    public static void main(String[] args) {
        // new ProjectGraph(new File("C:\\Users\\ice_d\\Desktop\\Моё\\Програмирование\\NTO training\\T4\\ntoproject\\src\\main\\java")).show();
        Navigator.init();
        ProgramStarter.welcomeMessage="Добро пожаловать в \"Золотую долину\"";
        ProgramStarter.authRequired=false;
        if(ProgramStarter.isFirstLaunch()){
            //Регистрация пользователей
            User.register("Добыча","",AppRole.MINING);
            User.register("Переработка","",AppRole.REFINING);
            User.register("Управление качеством","",AppRole.QUALITY);
            //Декларация групп
            EditableGroup<Unit>unit=new EditableGroup<>(
                new PathIcon("ui/order.png",Root.SCREEN_SIZE.height/11,Root.SCREEN_SIZE.height/11),
                new PathIcon("ui/order_add.png",Root.SCREEN_SIZE.height/11,Root.SCREEN_SIZE.height/11),
                Unit.class
            );
            EditableGroup<Nomencl>nomencl=new EditableGroup<>(
                new PathIcon("ui/product.png",Root.SCREEN_SIZE.height/11,Root.SCREEN_SIZE.height/11),
                new PathIcon("ui/product_add.png",Root.SCREEN_SIZE.height/11,Root.SCREEN_SIZE.height/11),
                Nomencl.class
            );
            EditableGroup<Device>device=new EditableGroup<>(
                new PathIcon("ui/factory.png",Root.SCREEN_SIZE.height/11,Root.SCREEN_SIZE.height/11),
                new PathIcon("ui/factory_add.png",Root.SCREEN_SIZE.height/11,Root.SCREEN_SIZE.height/11),
                Device.class
            );
            EditableGroup<WorkType>workType=new EditableGroup<>(
                new PathIcon("ui/worker.png",Root.SCREEN_SIZE.height/11,Root.SCREEN_SIZE.height/11),
                new PathIcon("ui/worker_add.png",Root.SCREEN_SIZE.height/11,Root.SCREEN_SIZE.height/11),
                WorkType.class
            );
            EditableGroup<WorkNorm>workNorm=new EditableGroup<>(
                new PathIcon("ui/factory.png",Root.SCREEN_SIZE.height/11,Root.SCREEN_SIZE.height/11),
                new PathIcon("ui/factory_add.png",Root.SCREEN_SIZE.height/11,Root.SCREEN_SIZE.height/11),
                WorkNorm.class
            );
            ProgramStarter.runProgram();
            //Регистрация групп
            
            //Тестовые данные
            
        }else ProgramStarter.runProgram();
    }
}