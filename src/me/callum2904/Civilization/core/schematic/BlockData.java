package me.callum2904.Civilization.core.schematic;

import org.bukkit.Material;
import org.bukkit.block.Block;

public class BlockData {
	
	private int x, y, z, index;
	private byte block, data;
	
	public BlockData(int x, int y, int z, int index, byte block, byte data){
		this.x = x;
		this.y = y;
		this.z = z;
		this.data = data;
		this.block = block;
		this.index = index;
	}
	
	public int getX(){
		return this.x;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public int getY(){
		return this.y;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	public int getZ(){
		return this.z;
	}
	
	public void setZ(int z){
		this.z = z;
	}
	
	public int getIndex(){
		return this.index;
	}
	
	public byte getBlockID(){
		return this.block;
	}
	
	public byte getBlockData(){
		return this.data;
	}
	
	@SuppressWarnings("deprecation")
	public void setDataForBlock(Block arg){
		arg.setTypeIdAndData(block, data, true);
	}
	
	@SuppressWarnings("deprecation")
	public Material getMaterial(){
		return Material.getMaterial(block);
	}

}
