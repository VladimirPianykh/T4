package com.ntoproject.editables.registered;

import com.bpa4j.core.Data.Editable;
import com.bpa4j.editor.EditorEntry;

public class Unit extends Editable{
	public Unit(){
		super("Нов Единицы измерения");
	}
	@EditorEntry(translation="Полное наименование")
	public String fullUnit;
}
