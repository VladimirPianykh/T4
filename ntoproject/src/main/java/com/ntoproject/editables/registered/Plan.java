package com.ntoproject.editables.registered;

import java.time.LocalDate;
import java.util.Random;
import java.util.function.Function;

import com.bpa4j.core.Data.Editable;
import com.bpa4j.defaults.input.FunctionEditor;
import com.bpa4j.editor.EditorEntry;

public class Plan extends Editable{
    @EditorEntry(translation="Дата регистрации")
    public LocalDate date=LocalDate.now();
    @EditorEntry(translation="Дата начала смены")
    public LocalDate startDate=LocalDate.now();
    @EditorEntry(translation="Вид работ")
    public WorkType workType;
    @EditorEntry(translation="Номенклатура",editorBaseSource = FunctionEditor.class)
    public static Function<Plan,Nomencl>nomencl=e->e.workType==null?null:e.workType.product;

    @EditorEntry(translation="Количество в пн")
    public int amount1=new Random().nextInt(1,10);
    @EditorEntry(translation="Количество в вт")
    public int amount2=new Random().nextInt(1,10);
    @EditorEntry(translation="Количество в ср")
    public int amount3=new Random().nextInt(1,10);
    @EditorEntry(translation="Количество в чт")
    public int amount4=new Random().nextInt(1,10);
    @EditorEntry(translation="Количество в пт")
    public int amount5=new Random().nextInt(1,10);
    @EditorEntry(translation="Количество в сб")
    public int amount6=new Random().nextInt(1,10);
    @EditorEntry(translation="Количество в вс")
    public int amount7=new Random().nextInt(1,10);
    
    public int getAmountSum(){
        return amount1+amount2+amount3+amount4+amount5+amount6+amount7;
    }
    public Plan(){
        super("Новый план");
    }
}