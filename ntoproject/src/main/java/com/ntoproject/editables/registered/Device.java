package com.ntoproject.editables.registered;

import com.bpa4j.core.Data.Editable;
import com.bpa4j.editor.EditorEntry;
import com.bpa4j.editor.Input;
@Input(nameProvider = )
public class Device extends Editable{
	public Device(){
		super("Нов Оборудование");
	}
	
	@EditorEntry(translation="Модель")
	public String model;
	@EditorEntry(translation="Гаражный номер")
	public String num;
}
