package com.ntoproject.editables.registered;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.Function;

import com.bpa4j.core.Data.Editable;
import com.bpa4j.defaults.input.FunctionEditor;
import com.bpa4j.editor.EditorEntry;

public class ActualWork extends Editable{
	@EditorEntry(translation="Наряд на смену")
	public Narad narad;
	@EditorEntry(translation="Тип работ")
	public WorkType type;
	@EditorEntry(translation="Время начала")
	public LocalDate time=LocalDate.now();
	@EditorEntry(translation="Оборудование",editorBaseSource = FunctionEditor.class)
	public static Function<Narad,ArrayList<Device>>devices=e->e.workType==null?null:e.workType.device;
	@EditorEntry(translation="Номенклатура",editorBaseSource = FunctionEditor.class)
	public static Function<Narad,Nomencl>nomencl=e->e.workType==null?null:e.workType.product;
	public ActualWork(){
		super("Новые работы");
	}
}