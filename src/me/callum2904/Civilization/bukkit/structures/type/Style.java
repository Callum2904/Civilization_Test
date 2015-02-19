package me.callum2904.Civilization.bukkit.structures.type;

public enum Style {
	
	MODERN, MEDIEVAL;
	
	public static Style fromString(String string){
		for(Style style : Style.values()){
			if(style.toString().equalsIgnoreCase(string))
				return style;
		}
		return null;
	}	

}
