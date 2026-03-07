package com.ntoproject.features;

import java.util.ArrayList;

import com.bpa4j.core.BLFeatureManager;
import com.bpa4j.core.Data;
import com.bpa4j.defaults.features.Report;
import com.bpa4j.defaults.ftr_attributes.data_renderers.TableDataRenderer;
import com.github.lgooddatepicker.components.DatePicker;
import com.ntoproject.editables.auxil.NormReportEntry;
import com.ntoproject.editables.registered.WorkType;
import com.ntoproject.globals.NormManager;

public class NormReport extends BLFeatureManager<Report>{
    public static final NormReport instance=new NormReport();
    private DatePicker targetDate = new DatePicker();
    public Report register(){
        Report f=Report.registerReport("Работа на_дату");
        f.addConfigurator(saver->{
            targetDate.addDateChangeListener(e->saver.run());
            return targetDate;
        });
        f.addDataRenderer(new TableDataRenderer<NormReportEntry>(() -> {
            ArrayList<NormReportEntry> list = new ArrayList<>();
            //TODO: Finish this code block
            for (WorkType type: Data.group(WorkType.class)){
                NormReportEntry entry = new NormReportEntry(NormManager.getWorkNormFor(targetDate.getDate(), type), type, type.device, type.product, type.units.apply(type));
                list.add(entry);
            }
            return list;
        } , "Нормы горных работ"));
        return f;
    }
}
