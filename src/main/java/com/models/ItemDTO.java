package com.models;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="item_master")
public class ItemDTO implements Cloneable,Serializable,Comparable<ItemDTO>{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int itemId;
	
	private String itemName;
	
	
	@Lob
	private String itemDesc;
	
	@Transient
	private String base64imageFile;
	public String getBase64imageFile() {
		return base64imageFile;
	}
	public void setBase64imageFile(String base64imageFile) {
		this.base64imageFile = base64imageFile;
	}


	@Lob
    @Column(name = "itemImage", columnDefinition="LONGBLOB")
	private byte[] itemImage;
	
	private int itemCategory;
	
	private String unit;
	
	private float itemPrice;
	
	private int itemAvailability;
	

	    
	private static ItemDTO item;
	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemDesc() {
		return itemDesc;
	}
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	public byte[]  getItemImage() {
		return itemImage;
	}
	public void setItemImage(byte[] itemImage) {
		this.itemImage = itemImage;
	}
	public int getItemCategory() {
		return itemCategory;
	}
	public void setItemCategory(int itemCategory) {
		this.itemCategory = itemCategory;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public float getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(float itemPrice) {
		this.itemPrice = itemPrice;
	}
	public int getItemAvailability() {
		return itemAvailability;
	}
	public void setItemAvailability(int itemAvailability) {
		this.itemAvailability = itemAvailability;
	}
	@Override
	public String toString() {
		return "Items [itemId=" + itemId + ", itemName=" + itemName + ", itemDesc=" + itemDesc + ", itemImage="
				+ itemImage + ", itemCategory=" + itemCategory + ", unit=" + unit + ", itemPrice=" + itemPrice
				+ ", itemAvailability=" + itemAvailability + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(itemAvailability, itemCategory, itemDesc, itemId, itemImage, itemName, itemPrice, unit);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemDTO other = (ItemDTO) obj;
		return itemAvailability == other.itemAvailability && Objects.equals(itemCategory, other.itemCategory)
				&& Objects.equals(itemDesc, other.itemDesc) && itemId == other.itemId
				&& Objects.equals(itemImage, other.itemImage) && Objects.equals(itemName, other.itemName)
				&& Float.floatToIntBits(itemPrice) == Float.floatToIntBits(other.itemPrice)
				&& Objects.equals(unit, other.unit);
	}
	@Override
	public int compareTo(ItemDTO o) {
		return this.itemPrice>o.itemPrice?1:0;
	}
	
	
	private ItemDTO(String itemName, String itemDesc, byte[]  itemImage, int itemCategory, String unit, float itemPrice, int itemAvailability) {
		super();
		this.itemName = itemName;
		this.itemDesc = itemDesc;
		this.itemImage = itemImage;
		this.itemCategory = itemCategory;
		this.unit = unit;
		this.itemPrice = itemPrice;
		this.itemAvailability = itemAvailability;
	}
	
	public ItemDTO() {
		super();
	}
	
	public ItemDTO createClone() {
		try {
			return (ItemDTO)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	
	synchronized public static ItemDTO getInstance(String itemName, String itemDesc, byte[]  itemImage, int itemCategory, String unit,
			float itemPrice, int itemAvailability) {
			
			try {
				if(item==null) 
					item=new ItemDTO(itemName,itemDesc,itemImage,itemCategory,unit,itemPrice,itemAvailability);
				else {
						item=item.createClone();
						item.setItemName(itemName);
						item.setItemDesc(itemDesc);
						item.setItemImage(itemImage);
						item.setItemCategory(itemCategory);
						item.setUnit(unit);
						item.setItemPrice(itemPrice);
						item.setItemAvailability(itemAvailability);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return item;
		}
	
	
	
	 
	

}
