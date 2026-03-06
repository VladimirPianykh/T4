package com.ntoproject.editables.auxil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.Function;

import com.bpa4j.core.Data.Editable;
import com.bpa4j.defaults.input.FunctionEditor;
import com.bpa4j.editor.EditorEntry;
import com.ntoproject.editables.registered.Device;
import com.ntoproject.editables.registered.Nomencl;
import com.ntoproject.editables.registered.Unit;
import com.ntoproject.editables.registered.WorkType;

public class WorkNorm extends Editable{
	public WorkNorm(){
		super("Нов Установка норм горных работ");
	}
	@EditorEntry(translation="Дата регистрации норм горных работ")
	public LocalDate date=LocalDate.now();
	@EditorEntry(translation="Вид работы")
	public WorkType workType;
	@EditorEntry(translation="Обородувоние")
	public static Function<WorkNorm,ArrayList<Device>> device=e->e.workType.device;
	@EditorEntry(translation="Продукция")
	public static Function<WorkNorm,Nomencl>product=e->e.workType.product;
	@EditorEntry(translation="Норма за смену")
	public int norm;
	@EditorEntry(translation="Единицы измерения",editorBaseSource = FunctionEditor.class)
	public static Function<WorkNorm,Unit>unit=e->WorkType.units.apply(e.workType);
}
