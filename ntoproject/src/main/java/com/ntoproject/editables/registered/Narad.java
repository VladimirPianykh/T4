package com.ntoproject.editables.registered;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.function.Function;

import com.bpa4j.core.Data.Editable;
import com.bpa4j.defaults.input.FunctionEditor;
import com.bpa4j.editor.EditorEntry;
import com.bpa4j.editor.Input;

@Input(completer = Narad.Completer.class)
public class Narad extends Editable{
	public static class Completer implements com.bpa4j.editor.Completer{
		public boolean isCompletable(Editable original,Editable editable,int fieldsEdited){
			Narad e=(Narad)editable;
			return e.plan!=null;
		}
		public void completeObject(Editable original,Editable editable,int fieldsEdited){
			Narad e=(Narad)original;
			Plan plan=e.plan;
			if(fieldsEdited<2)e.date=plan.date;
			if(fieldsEdited<4)e.workType=plan.workType;
			if(fieldsEdited<7)e.amount=plan.getAmountSum();
			if(fieldsEdited<8)e.startTime=LocalDateTime.from(plan.startDate);
			if(fieldsEdited<9)e.endTime=LocalDateTime.from(plan.startDate).plusWeeks(1);
		}
	}
	@EditorEntry(translation="План на нед. (скопировать)")
	public Plan plan;
	@EditorEntry(translation="Дата смены") //2
	public LocalDate date=LocalDate.now();
	@EditorEntry(translation="Доп. информация")
	public String description;
	@EditorEntry(translation="Вид работ") //4
	public WorkType workType;
	@EditorEntry(translation="Оборудование",editorBaseSource = FunctionEditor.class)
	public static Function<Narad,ArrayList<Device>>devices=e->e.workType==null?null:e.workType.device;
	@EditorEntry(translation="Номенклатура",editorBaseSource = FunctionEditor.class)
	public static Function<Narad,Nomencl>nomencl=e->e.workType==null?null:e.workType.product;
	@EditorEntry(translation="Планируемое количество") //7
	public int amount;
	@EditorEntry(translation="Время начала") //8
	public LocalDateTime startTime=LocalDateTime.now();
	@EditorEntry(translation="Время окончания") //9
	public LocalDateTime endTime=LocalDateTime.now().plusHours(5);
	@EditorEntry(translation="Единица измерениия",editorBaseSource = FunctionEditor.class)
	public static Function<Narad,Unit>units=e->e.workType==null?null:WorkType.units.apply(e.workType);
	
	public Narad(){
		super("Новый наряд");
	}
}
