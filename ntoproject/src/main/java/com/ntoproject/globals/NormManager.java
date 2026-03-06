package com.ntoproject.globals;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Optional;

import com.bpa4j.core.Data;
import com.ntoproject.editables.auxil.WorkNorm;
import com.ntoproject.editables.registered.WorkType;

public class NormManager{
    public static int getWorkNormFor(LocalDate date,WorkType type){
        Optional<WorkNorm>w=Data.group(WorkNorm.class)
            .stream()
            .filter(norm->norm.workType==type)
            .filter(norm->!norm.date.isAfter(date))
            .max(new Comparator<WorkNorm>() {
                public int compare(WorkNorm a,WorkNorm b){
                    if(a.date.isAfter(b.date))return 1;
                    else if(a.date.isEqual(b.date))return 0;
                    else return -1;
                }
            });
        if(w.isPresent()){
            return w.get().norm;
        }else{
            return -1;
        }
    }
}
