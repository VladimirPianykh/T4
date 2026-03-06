package com.ntoproject.editables.registered;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.Function;

import com.bpa4j.core.Data.Editable;
import com.bpa4j.editor.EditorEntry;

public class WorkNorm extends Editable{
	public WorkNorm(){
		super("Нов Установка норм горных работ");
	}
	@EditorEntry(translation="Дата регистрации норм горных работ")
	public LocalDate date;
	@EditorEntry(translation="Вид работы")
	public WorkType workType;
	@EditorEntry(translation="Обородувоние")
	public static Function<WorkNorm,ArrayList<Device>> device=e->e.workType.device;
	@EditorEntry(translation="Продукция")
	public static Function<WorkNorm,Nomencl>product=e->e.workType.product;
	@EditorEntry(translation="Норма за смену")
	public int norm;
	@EditorEntry(translation="Единицы измерения")
	public static Function<WorkNorm,Function<WorkType,Unit>>unit=e->e.workType.units;
}
