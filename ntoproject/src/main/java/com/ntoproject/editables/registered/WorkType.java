package com.ntoproject.editables.registered;

import java.util.ArrayList;
import java.util.function.Function;

import com.bpa4j.core.Data;
import com.bpa4j.core.Data.Editable;
import com.bpa4j.defaults.input.SelectFromEditor;
import com.bpa4j.editor.EditorEntry;

public class WorkType extends Editable{
	public WorkType(){
		super("Нов Вид работы");
	}
	static{
		try{
			SelectFromEditor.configure(WorkType.class.getField("device"), editable->{
				ArrayList<Device>list=new ArrayList<>();
				Data.group(Device.class).stream().forEach(list::add);
				list.add(null);
				return list;
			});
		}catch(Exception ex){
			throw new AssertionError(ex);
		}
	}
	@EditorEntry(translation="Оборудование", editorBaseSource = SelectFromEditor.class)
	public ArrayList<Device> device;	
	@EditorEntry(translation="Продукция")
	public Nomencl product;
	@EditorEntry(translation="Единицы измерения")
	public static Function<WorkType,Unit>units=e->e.product.unit;
}
