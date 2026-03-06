package com.ntoproject.editables.registered;

import com.bpa4j.core.Data.Editable;
import com.bpa4j.editor.EditorEntry;

public class Nomencl extends Editable{
	public Nomencl(){
		super("Нов Номенклатура");
	}
	@EditorEntry(translation="Единицы Измерения")
	public Unit unit;
}
