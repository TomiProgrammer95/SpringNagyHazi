package com.example.demo.dto;

import java.time.LocalDateTime;

public class PurchasedTicketDTO {
	
	 	private String category;
	    private LocalDateTime concertDateTime;
	    private String concertName;
	    private int quantity;
	    
	    
		public PurchasedTicketDTO(String category, LocalDateTime concertDateTime, String concertName, int quantity) {
			super();
			this.category = category;
			this.concertDateTime = concertDateTime;
			this.concertName = concertName;
			this.quantity = quantity;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public LocalDateTime getConcertDateTime() {
			return concertDateTime;
		}
		public void setConcertDateTime(LocalDateTime concertDateTime) {
			this.concertDateTime = concertDateTime;
		}
		public String getConcertName() {
			return concertName;
		}
		public void setConcertName(String concertName) {
			this.concertName = concertName;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
	    
	    

}
