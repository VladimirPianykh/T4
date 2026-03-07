package com.ntoproject.editables.auxil;

import java.util.ArrayList;
import java.util.function.Function;

import com.bpa4j.core.Data.Editable;
import com.bpa4j.editor.EditorEntry;
import com.ntoproject.editables.registered.Device;
import com.ntoproject.editables.registered.Nomencl;
import com.ntoproject.editables.registered.Unit;
import com.ntoproject.editables.registered.WorkType;

public class NormReportEntry extends Editable{
    
    public NormReportEntry(int norm, WorkType workType, ArrayList<Device> device, Nomencl product, Unit init){
        super("Новый Мусор");
        this.norm = norm;
        this.workType = workType;
        this.device = workType == null?null:workType.device;
        this.product = workType == null?null:workType.product;
        this.unit = workType == null?null:WorkType.units.apply(workType);

    }
    @EditorEntry(translation="Вид работы")
    public WorkType workType;
    @EditorEntry(translation="Оборудование")
    public ArrayList<Device> device;
    @EditorEntry(translation="Продукция")
    public Nomencl product;
    @EditorEntry(translation="Норма за смену")
    public int norm;
    @EditorEntry(translation="Единицы измерения")
    public Unit unit;
}
