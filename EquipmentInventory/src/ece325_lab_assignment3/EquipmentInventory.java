// Student Name: Ronggang Cui
// ID: 1617665
// Lab 3: Controlling the equipment inventory of your band

package ece325_lab3;

import java.util.ArrayList;

public class EquipmentInventory {
	//this class is to manage all the equipments
	//It can set the number of equipments in the InventoryItem, also add items to the bus
	
	// your inventory of items
	ArrayList<InventoryItem> inventory;
	

	public EquipmentInventory() {
		inventory = new ArrayList<InventoryItem>();
	}

	/**
	 * Stow equipment into the trunk of the bus. Note: every type of equipment
	 * should only occur once in the inventory. Make sure to check if you are not
	 * accidentally taking someone else's equipment.
	 * 
	 * @param equip  The type of equipment to stow
	 * @param number The number of items to stow
	 */
	public void addEquipmentToBus(Equipment equip, int number) {
		
		for (int i = 0; i < inventory.size(); i++) {
		      if(equip.equals(inventory.get(i).getEquipment())) {
		    	  
		    	  // Make sure to check if you are not accidentally taking someone else's equipment.
		    	  if(inventory.get(i).getInBus()+number <= inventory.get(i).getInInventory()) {
		    		  inventory.get(i).addToBus(number);
		    	  }else {
		    		  // take no more than the number of items in the inventory
		    		  System.out.println((number - inventory.get(i).getInInventory()) +
		    				  " chairs from someone else may be taken");
		    		  inventory.get(i).setInBus(inventory.get(i).getInInventory());
		    	  }
		    	  
		    	  break;
		      }
		}
		
	}

	/**
	 * Add equipment to your inventory. Note: every type of equipment
	 * should only occur once in the inventory. Whenever you acquire new
	 * equipment, it is always outside the bus. 
	 * 
	 * @param equip  The type of equipment to add to your inventory
	 * @param number The number of items to add
	 */
	public void addEquipmentToInventory(Equipment equip, int number) {
		
		//initial check
		//if the equipment is already in the Inventory, do nothing
		for (int i = 0; i < inventory.size(); i++) {
		      if(equip.equals(inventory.get(i).getEquipment())) {
		    	  return;
		      }
		}
		
		//adding to inventory
		InventoryItem myItem = new InventoryItem(equip, number);
		myItem.setInInventory(number);
		inventory.add(myItem);
	
	}

	
	/**
	 * Returns a list of items that are still missing from the bus. 
	 * @return List of missing items.
	 */
	public ArrayList<InventoryItem> getMissingItems() {
		
		ArrayList<InventoryItem> missingInventory = new ArrayList<InventoryItem>();
		
		for (int i = 0; i < inventory.size(); i++) {
			if(inventory.get(i).getInInventory() > inventory.get(i).getInBus()) {
				missingInventory.add(inventory.get(i));
			}
		}   
		
		return missingInventory;
	}
	

	/**
	 * Returns a list of items that still need wrapping. Note that these items might still 
	 * be (partially) missing from the bus too. 
	 * @return List of items that still need to be wrapped.
	 */
	public ArrayList<InventoryItem> getNeedsWrappingItems() {
		
		ArrayList<InventoryItem> needWrappingInventory = new ArrayList<InventoryItem>();
		
		for (int i = 0; i < inventory.size(); i++) {
			if(inventory.get(i).needsWrapping()) {
				needWrappingInventory.add(inventory.get(i));
				
			}
		}   
		
		
		return needWrappingInventory;
	
	}

	/**
	 * Wrap items of the same type as e.
	 * @param The type of equipment you want to wrap. 
	 */
	public void wrapItems(Equipment e) {
		
		for (int i = 0; i < inventory.size(); i++) {
			if(inventory.get(i).getEquipment().equals(e)) {
				inventory.get(i).wrap();
				return;
			}
		}   

	}

	/** 
	 * Returns a string representation of the inventory.
	 */
	public String toString() {
		
		// Below is another way to format the output
		// unnecessary regarding meeting the requirement of the lab
		/*
		String inventoryOutput = "Equipment"+"   \t"+"In Inventory"+"   \t"+"In Bus"+ "\n";
		
		for (int i = 0; i < inventory.size(); i++) {
			inventoryOutput += inventory.get(i).getEquipment()+"   \t"+
					inventory.get(i).getInInventory()+"   \t\t"+ 
					inventory.get(i).getInBus()+ "\n";
		}
		*/
		
		return inventory.toString();
	}

	/** 
	 * Returns true iff the inventory is complete, wrapped and you are ready to go.
	 * @return true iff inventory is complete and wrapped
	 */
	public boolean getReadyToGo() {
		
		for (int i = 0; i < inventory.size(); i++) {
			if(inventory.get(i).getInInventory() != inventory.get(i).getInBus()
					|| inventory.get(i).needsWrapping()) {
				return false;
			}
		}   
		
		return true;

	}

	public static void main(String[] args) {
		
		EquipmentInventory myInv = new EquipmentInventory();
		
		//Add 2 microphones, 4 guitars and 12 chairs to Equipment Inventory
		
		Microphone myMicrophone = new Microphone(true);
		myInv.addEquipmentToInventory(myMicrophone, 2);
		
		Guitar myGuitar = new Guitar(true);
		myInv.addEquipmentToInventory(myGuitar, 4);
		
		Chair myChair = new Chair(false);
		myInv.addEquipmentToInventory(myChair, 12);
		
		System.out.println("Printing the inventory: ");
		System.out.println(myInv);

		System.out.println("Printing missing items: ");
		ArrayList<InventoryItem> missing = myInv.getMissingItems();
		System.out.println(missing);

		System.out.println("Printing items that need wrapping: ");
		ArrayList<InventoryItem> needsWrapping = myInv.getNeedsWrappingItems();
		System.out.println(needsWrapping);
		
		//Try to add 15 chairs to bus
		myInv.addEquipmentToBus(myChair, 15);

		System.out.println(myInv.getReadyToGo());
		
		//Try to add 4 guitars and 2 microphones to bus
		myInv.addEquipmentToBus(myGuitar, 4);
		myInv.addEquipmentToBus(myMicrophone, 2);
		
		System.out.println(myInv.getReadyToGo());

		//Wrap items that need wrapping but have not been wrapped yet
		
		//One possible way below:
		//myInv.wrapItems(myGuitar);
		//myInv.wrapItems(myMicrophone);
		
		//A better way is to loop through all the needsWrapping items
		//avoid hard coding
		//adding new equipment would have as little impact as possible
		needsWrapping = myInv.getNeedsWrappingItems();
		for (int i = 0; i < needsWrapping.size(); i++) { 		      
	          needsWrapping.get(i).wrap();		
	      }   
		

		System.out.println(myInv.getReadyToGo());
		
	}
}
