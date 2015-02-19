package me.callum2904.Civilization.bukkit.structures.type;

public enum Type {
	
	HOUSE;
	
	public static Type fromString(String string){
		for(Type type : Type.values()){
			if(type.toString().equalsIgnoreCase(string))
				return type;
		}
		return null;
	}	

}
