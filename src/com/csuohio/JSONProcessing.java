package com.csuohio;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

public class JSONProcessing {
	
	public void writeBusinessHoursData(String businessId,BusinessHours businesshours){
		try{
			FileWriter fw=new FileWriter("./BusinessHours_data.txt",true);
			BufferedWriter bw=new BufferedWriter(fw);
			PrintWriter pw=new PrintWriter(bw);
			pw.println(businessId+","+
					businesshours.getMonday()+","+
					businesshours.getTuesday()+","+
					businesshours.getWednesday()+","+
					businesshours.getThursday()+","+
					businesshours.getFriday()+","+
					businesshours.getSaturday()+","+
					businesshours.getSunday()
					);
			pw.flush();
		}catch(Exception e){
			
		}
		
	}
	public void writeBusinessFeaturesData(String businessId,Attributes attributes){
		try{
			if(attributes!=null){
			FileWriter fw=new FileWriter("./BusinessAttributes_data.txt",true);
			BufferedWriter bw=new BufferedWriter(fw);
			PrintWriter pw=new PrintWriter(bw);
				pw.println(businessId+","+
						attributes.isTakeOut()+","+
						attributes.isDriveThru()+","+
						attributes.isCaters()+","+
						attributes.getNoiseLevel()+","+
						attributes.isTakesReservations()+","+
						attributes.isDelivery()+","+
						attributes.isHasTv()+","+
						attributes.isOutDoorSeating()+","+
						attributes.getAttire()+","+
						attributes.getAlcohal()+","+
						attributes.isAcceptsCreditCards()+","+
						attributes.isGoodForKids()+","+
						attributes.isGoodForGroups()+","+
						attributes.getPriceRange()
						);
				pw.flush();
				writeBusinessGoodFarData(businessId,attributes.getGoodFor());
				writeBusinessAmbienceData(businessId,attributes.getAmbience());
				writeBusinessParkingData(businessId,attributes.getParking());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void writeBusinessGoodFarData(String businessId,GoodFor goodFor){
		try{
			if(goodFor!=null){
			FileWriter fw=new FileWriter("./BusinessGoodFar_data.txt",true);
			BufferedWriter bw=new BufferedWriter(fw);
			PrintWriter pw=new PrintWriter(bw);
				pw.println(businessId+","+
						goodFor.isBreakfast()+","+
						goodFor.isBrunch()+","+
						goodFor.isDessert()+","+
						goodFor.isDinner()+","+
						goodFor.isLatenight()+","+
						goodFor.isLunch()
						);
				pw.flush();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void writeBusinessAmbienceData(String businessId,Ambience ambience){
		try{
			if(ambience!=null){
			FileWriter fw=new FileWriter("./BusinessAmbience_data.txt",true);
			BufferedWriter bw=new BufferedWriter(fw);
			PrintWriter pw=new PrintWriter(bw);
				pw.println(businessId+","+
						ambience.isCasual()+","+
						ambience.isClassy()+","+
						ambience.isDivey()+","+
						ambience.isHipster()+","+
						ambience.isIntimate()+","+
						ambience.isRomantic()+","+
						ambience.isToutsity()+","+
						ambience.isTrendy()+","+
						ambience.isUpscale()
						);
				pw.flush();
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void writeBusinessParkingData(String businessId,Parking parking){
		try{
			if(parking!=null){
			FileWriter fw=new FileWriter("./BusinessParking_data.txt",true);
			BufferedWriter bw=new BufferedWriter(fw);
			PrintWriter pw=new PrintWriter(bw);
				pw.println(businessId+","+
						parking.isGarage()+","+
						parking.isLot()+","+
						parking.isStreet()+","+
						parking.isValet()+","+
						parking.isValidated()
						);
				pw.flush();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void writeBussinessData(Business business){
		try{
			if(business!=null){
				FileWriter fw=new FileWriter("./business_data.txt",true);
				BufferedWriter bw=new BufferedWriter(fw);
				PrintWriter pw=new PrintWriter(bw);
				pw.println(business.getBusinessId()+","+
						business.getAddress()+","+
						business.isOpen()+","+
						business.getCatagories()+","+
						business.getCity()+","+
						business.getReviews()+","+
						business.getName()+","+
						business.getNeighbours()+","+
						business.getLongitude()+","+
						business.getState()+","+
						business.getStars()+","+
						business.getLatitude()+","+
						business.getType()
						);
				pw.flush();
				writeBusinessHoursData(business.getBusinessId(),business.getBusinessHours());
				writeBusinessFeaturesData(business.getBusinessId(),business.getAttributes());
			}
			
		}catch(Exception e){
			   e.printStackTrace();
		}
	}
	public static void main(String args[]){
		DB db=DBConnection.getDBConnection().connect("CISJsonParsing");
		DBCollection dbCollection=MongoActions.switchCollection("business", db);
		DBCursor dbCursor= MongoActions.showContentInDocument(dbCollection);
		if(dbCursor!=null && dbCursor.size()!=0){
			while(dbCursor.hasNext()){
				BasicDBObject dbObject=(BasicDBObject) dbCursor.next();
				Business businessObj=new Business();
				try {
					JSONObject keyObject=new JSONObject(dbObject.toString());
					ArrayList<String>weekHours=new ArrayList<String>();
					String businessId=keyObject.getString("business_id");
					String address=keyObject.has("full_address")?keyObject.getString("full_address").replaceAll(","," "):"";
					Boolean isOpen=keyObject.has("open")?keyObject.getBoolean("open"):false;	
					String city=keyObject.has("city")?keyObject.getString("city"):"";
					float reviews=keyObject.has("review_count")?keyObject.getLong("review_count"):0;
					String name=keyObject.has("name")?keyObject.getString("name"):"";
					long longitude=keyObject.has("longitude")?keyObject.getLong("longitude"):0;
					String state=keyObject.has("state")?keyObject.getString("state"):"";
					float stars=keyObject.has("stars")?keyObject.getLong("stars"):0;
					long latitude=keyObject.has("latitude")?keyObject.getLong("latitude"):0;
					String type=keyObject.has("type")?keyObject.getString("type"):"";
					JSONArray catagories=keyObject.has("categories")?keyObject.getJSONArray("categories"):null;
					String subcatagories="";
					if(catagories!=null){
						for(int i=0;i<catagories.length();i++){
							if(i==catagories.length()-1){
								subcatagories=subcatagories+catagories.getString(i);
							}else{
								subcatagories=subcatagories+catagories.getString(i)+"|";
							}
						
					 }
					}
				    JSONArray neighborhoods=keyObject.has("neighborhoods")?keyObject.getJSONArray("neighborhoods"):null;
					String subneighbor="";
					if(neighborhoods!=null){
						for(int i=0;i<neighborhoods.length();i++){
							if(i==neighborhoods.length()-1){
								subneighbor=subneighbor+neighborhoods.getString(i);
							}else{
								subneighbor=subneighbor+neighborhoods.getString(i)+"|";
							}
						
					    }	
					}
					//Getting hours Object
					JSONObject hours=keyObject.has("hours")?keyObject.getJSONObject("hours"):null;
					BusinessHours businessHours=new BusinessHours();
					if(hours!=null){
						JSONObject monday=hours.has("Monday")?hours.getJSONObject("Monday"):null;
						JSONObject tuesday=hours.has("Tuesday")?hours.getJSONObject("Tuesday"):null;
						JSONObject wednesday=hours.has("Wednesday")?hours.getJSONObject("Wednesday"):null;
						JSONObject thursday=hours.has("Thursday")?hours.getJSONObject("Thursday"):null;
						JSONObject friday=hours.has("Friday")?hours.getJSONObject("Friday"):null;
						JSONObject saturday=hours.has("Saturday")?hours.getJSONObject("Saturday"):null;
						JSONObject sunday=hours.has("Sunday")?hours.getJSONObject("Sunday"):null;
						String mondayTimes=monday!=null?"Open: "+monday.getString("open")+" & Close: "+monday.getString("close"):"Closed";
						String tuesdayTimes=tuesday!=null?"Open: "+tuesday.getString("open")+" & Close: "+tuesday.getString("close"):"Closed";
						String wednesdayTimes=wednesday!=null?"Open: "+wednesday.getString("open")+" & Close: "+wednesday.getString("close"):"Closed";
						String thursdayTimes=thursday!=null?"Open: "+thursday.getString("open")+" & Close: "+thursday.getString("close"):"Closed";
						String fridayTimes=friday!=null?"Open: "+friday.getString("open")+" & Close: "+friday.getString("close"):"Closed";
						String saturdayTimes=saturday!=null?"Open: "+saturday.getString("open")+" & Close: "+saturday.getString("close"):"Closed";
						String sundayTimes=sunday!=null?"Open: "+sunday.getString("open")+" & Close: "+sunday.getString("close"):"Closed";
						businessHours.setMonday(mondayTimes);
						businessHours.setTuesday(tuesdayTimes);
						businessHours.setWednesday(wednesdayTimes);
						businessHours.setThursday(thursdayTimes);
						businessHours.setFriday(fridayTimes);
						businessHours.setSaturday(saturdayTimes);
						businessHours.setSunday(sundayTimes);
					}
					// Getting Attributes
					JSONObject attributes=keyObject.has("attributes")?keyObject.getJSONObject("attributes"):null;
					Attributes attributeObj=new Attributes();
					if(attributes!=null){
						attributeObj.setTakeOut(attributes.has("Take-out")?attributes.getBoolean("Take-out"):false);
						attributeObj.setDriveThru(attributes.has("Drive-Thru")?attributes.getBoolean("Drive-Thru"):false);
						// Getting inner object Good For from attribures
						JSONObject goodFor=attributes.has("Good For")?attributes.getJSONObject("Good For"):null;
						GoodFor goodForObj=new GoodFor();
						if(goodFor!=null){
							goodForObj.setDessert(goodFor.has("goodFor")?goodFor.getBoolean("dessert"):false);
							goodForObj.setBreakfast(goodFor.has("breakfast")?goodFor.getBoolean("breakfast"):false);
							goodForObj.setBrunch(goodFor.has("brunch")?goodFor.getBoolean("brunch"):false);
							goodForObj.setLunch(goodFor.has("lunch")?goodFor.getBoolean("lunch"):false);
							goodForObj.setLatenight(goodFor.has("latenight")?goodFor.getBoolean("latenight"):false);
							goodForObj.setDinner(goodFor.has("dinner")?goodFor.getBoolean("dinner"):false);
						}else{
							goodForObj=null;
						}
						attributeObj.setGoodFor(goodForObj); 		// Adding GoodFor Object to features
						attributeObj.setCaters(attributes.has("Caters")?attributes.getBoolean("Caters"):false);
						attributeObj.setNoiseLevel(attributes.has("Noise Level")?attributes.getString("Noise Level"):"None");
						attributeObj.setTakesReservations(attributes.has("Takes Reservations")?attributes.getBoolean("Takes Reservations"):false);
						attributeObj.setDelivery(attributes.has("Delivery")?attributes.getBoolean("Delivery"):false);
						// Getting Ambience information from Features
						JSONObject ambience=attributes.has("Ambience")?attributes.getJSONObject("Ambience"):null;
						Ambience ambienceObj=new Ambience();
						if(ambience!=null){
							ambienceObj.setRomantic(ambience.has("romantic")?ambience.getBoolean("romantic"):false);
							ambienceObj.setIntimate(ambience.has("intimate")?ambience.getBoolean("intimate"):false);
							ambienceObj.setClassy(ambience.has("classy")?ambience.getBoolean("classy"):false);
							ambienceObj.setHipster(ambience.has("hipster")?ambience.getBoolean("hipster"):false);
							ambienceObj.setDivey(ambience.has("divey")?ambience.getBoolean("divey"):false);
							ambienceObj.setToutsity(ambience.has("touristy")?ambience.getBoolean("touristy"):false);
							ambienceObj.setTrendy(ambience.has("trendy")?ambience.getBoolean("trendy"):false);
							ambienceObj.setUpscale(ambience.has("upscale")?ambience.getBoolean("upscale"):false);
							ambienceObj.setCasual(ambience.has("casual")?ambience.getBoolean("casual"):false);
							
						}else{
							ambienceObj=null;
						}
						attributeObj.setAmbience(ambienceObj);  // Add Ambience obj to attribute Object
						//Fetching information related to parking
						JSONObject parking=attributes.has("Parking")?attributes.getJSONObject("Parking"):null;
						Parking parkingObj=new Parking();
						if(parking!=null){
							parkingObj.setGarage(parking.has("garage")?parking.getBoolean("garage"):false);
							parkingObj.setStreet(parking.has("street")?parking.getBoolean("street"):false);
							parkingObj.setValidated(parking.has("validated")?parking.getBoolean("validated"):false);
							parkingObj.setLot(parking.has("lot")?parking.getBoolean("lot"):false);
							parkingObj.setValet(parking.has("valet")?parking.getBoolean("valet"):false);
						}else{
							parkingObj=null;
						}
						   attributeObj.setParking(parkingObj); //Add parking obj to attribute object
						   attributeObj.setHasTv(attributes.has("Has TV")?attributes.getBoolean("Has TV"):false);
						   attributeObj.setOutDoorSeating(attributes.has("Outdoor Seating")?attributes.getBoolean("Outdoor Seating"):false);
						   attributeObj.setAttire(attributes.has("Attire")?attributes.getString("Attire"):"");
						   attributeObj.setAlcohal(attributes.has("Alcohol")?attributes.getString("Alcohol"):"");
						   attributeObj.setWaiterService(attributes.has("Waiter Service")?attributes.getBoolean("Waiter Service"):false);
						   attributeObj.setAcceptsCreditCards(attributes.has("Accepts Credit Cards")?attributes.getBoolean("Accepts Credit Cards"):false);
						   attributeObj.setGoodForKids(attributes.has("Good for Kids")?attributes.getBoolean("Good for Kids"):false);
						   attributeObj.setGoodForGroups(attributes.has("Good For Groups")?attributes.getBoolean("Good For Groups"):false);
						   attributeObj.setPriceRange(attributes.has("Price Range")?attributes.getLong("Price Range"):0);
					}else{
						attributeObj=null;
					}
					businessObj.setBusinessId(businessId);// Setting the main Object..
					businessObj.setAddress(address);
					businessObj.setBusinessHours(businessHours);
					businessObj.setOpen(isOpen);
					businessObj.setCatagories(subcatagories);
					businessObj.setCity(city);
					businessObj.setReviews(reviews);
					businessObj.setName(name);
					businessObj.setNeighbours(subneighbor);
					businessObj.setLongitude(longitude);
					businessObj.setLatitude(latitude);
					businessObj.setState(state);
					businessObj.setStars(stars);
					businessObj.setAttributes(attributeObj);
					businessObj.setType(type);
					JSONProcessing jsonProcessing=new JSONProcessing();
					jsonProcessing.writeBussinessData(businessObj);
			}
				 catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
}