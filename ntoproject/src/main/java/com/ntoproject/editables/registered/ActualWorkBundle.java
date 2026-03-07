package com.ntoproject.editables.registered;

import java.util.ArrayList;

import com.bpa4j.core.Data.Editable;
import com.ntoproject.editables.auxil.ActualWork;

//S-2 T-5
public class ActualWorkBundle extends Editable{
    public ArrayList<ActualWork>workTable=new ArrayList<>();
    public ActualWorkBundle(){
        super("Новые работы");
    }
}
