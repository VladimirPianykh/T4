package com.ntoproject.editables.registered;

import com.bpa4j.core.Data.Editable;
import com.bpa4j.editor.EditorEntry;
import com.bpa4j.editor.Input;
@Input(nameProvider = Device.NameProvider.class)
public class Device extends Editable{
	public Device(){
		super("Нов Оборудование");
	}
	public static class NameProvider implements com.bpa4j.editor.NameProvider{
		public String provideName(Editable editable){
			Device e=(Device)editable;
			return e.model + "-" +  e.num;
		}
	}
	@EditorEntry(translation="Модель")
	public String model;
	@EditorEntry(translation="Гаражный номер")
	public String num;
}
