package com.beanclass;
/*
 * It is a bean class for vehicle
 */

import java.util.Date;

public class vechiclepojo {
		private int id;
		private String name;
		private int wheels;
		private Date dateOfPurchase; 
		private int seats;
		private String number_plate;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getWheels() {
			return wheels;
		}

		public void setWheels(int wheels) {
			this.wheels = wheels;
		}

		public int getSeats() {
			return seats;
		}

		public void setSeats(int seats) {
			this.seats = seats;
		}

		public String getNumber_plate() {
			return number_plate;
		}

		public void setNumber_plate(String number_plate) {
			this.number_plate = number_plate;
		}

		public Date getDateOfPurchase() {
			return dateOfPurchase;
		}

		public void setDateOfPurchase(Date dateOfPurchase) {
			this.dateOfPurchase = dateOfPurchase;
		}
}
