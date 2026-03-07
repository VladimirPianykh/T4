package com.ntoproject.editables.registered;

import java.time.LocalTime;

import com.bpa4j.core.Data.Editable;
import com.bpa4j.editor.EditorEntry;

public class Shift extends Editable{
    @EditorEntry(translation="Время начала")
    public LocalTime startTime=LocalTime.now();
    @EditorEntry(translation="Время окончания")
    public LocalTime endTime=LocalTime.now().plusHours(5);
    
    public Shift(){
        super("Новая смена");
    }
}
