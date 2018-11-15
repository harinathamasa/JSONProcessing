package com.csuohio;
public class Business {
	private String businessId;
	private String address;
    private boolean isOpen;
    private String catagories;
    private String city;
    private float reviews;
    private String name;
    private String neighbours;
    private long longitude;
    private long latitude;
    private float stars;
    private String state;
    private String type;
    private BusinessHours businessHours;
    public BusinessHours getBusinessHours() {
		return businessHours;
	}
	public void setBusinessHours(BusinessHours businessHours) {
		this.businessHours = businessHours;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	private Attributes attributes;
	public String getBusinessId() {
		return businessId;
	}
	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public boolean isOpen() {
		return isOpen;
	}
	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}
	public String getCatagories() {
		return catagories;
	}
	public void setCatagories(String catagories) {
		this.catagories = catagories;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public float getReviews() {
		return reviews;
	}
	public void setReviews(float reviews) {
		this.reviews = reviews;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNeighbours() {
		return neighbours;
	}
	public void setNeighbours(String neighbours) {
		this.neighbours = neighbours;
	}
	public long getLongitude() {
		return longitude;
	}
	public void setLongitude(long longitude) {
		this.longitude = longitude;
	}
	public long getLatitude() {
		return latitude;
	}
	public void setLatitude(long latitude) {
		this.latitude = latitude;
	}
	public float getStars() {
		return stars;
	}
	public void setStars(float stars) {
		this.stars = stars;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Attributes getAttributes() {
		return attributes;
	}
	public void setAttributes(Attributes attributes) {
		this.attributes = attributes;
	}

}
