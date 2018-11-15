package com.csuohio;

public class Attributes {
	private boolean isTakeOut;
	private boolean driveThru;
	private boolean caters;
	private String noiseLevel;
	private boolean isTakesReservations;
	private boolean isDelivery;
	private boolean hasTv;
	private boolean isOutDoorSeating;
	private String attire;
	private String alcohal;
	private boolean isWaiterService;
	private boolean isAcceptsCreditCards;
	private boolean isGoodForKids;
	private boolean isGoodForGroups;
	private float priceRange;
	private GoodFor goodFor;
	private Ambience ambience;
	private Parking parking;
	public float getPriceRange() {
		return priceRange;
	}
	public void setPriceRange(float priceRange) {
		this.priceRange = priceRange;
	}
	public GoodFor getGoodFor() {
		return goodFor;
	}
	public void setGoodFor(GoodFor goodFor) {
		this.goodFor = goodFor;
	}
	public Ambience getAmbience() {
		return ambience;
	}
	public void setAmbience(Ambience ambience) {
		this.ambience = ambience;
	}
	public Parking getParking() {
		return parking;
	}
	public void setParking(Parking parking) {
		this.parking = parking;
	}
	public boolean isTakeOut() {
		return isTakeOut;
	}
	public void setTakeOut(boolean isTakeOut) {
		this.isTakeOut = isTakeOut;
	}
	public boolean isDriveThru() {
		return driveThru;
	}
	public void setDriveThru(boolean driveThru) {
		this.driveThru = driveThru;
	}
	public boolean isCaters() {
		return caters;
	}
	public void setCaters(boolean caters) {
		this.caters = caters;
	}
	public String getNoiseLevel() {
		return noiseLevel;
	}
	public void setNoiseLevel(String noiseLevel) {
		this.noiseLevel = noiseLevel;
	}
	public boolean isTakesReservations() {
		return isTakesReservations;
	}
	public void setTakesReservations(boolean isTakesReservations) {
		this.isTakesReservations = isTakesReservations;
	}
	public boolean isDelivery() {
		return isDelivery;
	}
	public void setDelivery(boolean isDelivery) {
		this.isDelivery = isDelivery;
	}
	public boolean isHasTv() {
		return hasTv;
	}
	public void setHasTv(boolean hasTv) {
		this.hasTv = hasTv;
	}
	public boolean isOutDoorSeating() {
		return isOutDoorSeating;
	}
	public void setOutDoorSeating(boolean isOutDoorSeating) {
		this.isOutDoorSeating = isOutDoorSeating;
	}
	public String getAttire() {
		return attire;
	}
	public void setAttire(String attire) {
		this.attire = attire;
	}
	public String getAlcohal() {
		return alcohal;
	}
	public void setAlcohal(String alcohal) {
		this.alcohal = alcohal;
	}
	public boolean isWaiterService() {
		return isWaiterService;
	}
	public void setWaiterService(boolean isWaiterService) {
		this.isWaiterService = isWaiterService;
	}
	public boolean isAcceptsCreditCards() {
		return isAcceptsCreditCards;
	}
	public void setAcceptsCreditCards(boolean isAcceptsCreditCards) {
		this.isAcceptsCreditCards = isAcceptsCreditCards;
	}
	public boolean isGoodForKids() {
		return isGoodForKids;
	}
	public void setGoodForKids(boolean isGoodForKids) {
		this.isGoodForKids = isGoodForKids;
	}
	public boolean isGoodForGroups() {
		return isGoodForGroups;
	}
	public void setGoodForGroups(boolean isGoodForGroups) {
		this.isGoodForGroups = isGoodForGroups;
	}
}
