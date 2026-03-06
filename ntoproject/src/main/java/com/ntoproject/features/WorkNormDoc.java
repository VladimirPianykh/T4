package com.ntoproject.features;

import com.bpa4j.core.BLFeatureManager;
import com.bpa4j.core.Data;
import com.bpa4j.defaults.features.DisposableDocument;
import com.ntoproject.editables.auxil.WorkNorm;

public class WorkNormDoc extends BLFeatureManager<DisposableDocument<WorkNorm>>{
    public static final WorkNormDoc instance=new WorkNormDoc();
    public DisposableDocument<WorkNorm> register(){
        DisposableDocument<WorkNorm> f=DisposableDocument.registerDocument("Нормы работ",WorkNorm.class);
        f.setProcessor(e->{
            Data.group(WorkNorm.class).add(e);
        });
        return f;
    }
}
