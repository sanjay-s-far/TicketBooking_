export class Booking {
   private scheduleID !:String;
   private noOfBookingSeats!:number;
   

    

    /**
     * Getter scheduleID
     * @return {String}
     */
	public getScheduleID(): String {
		return this.scheduleID;
	}

    /**
     * Getter noOfBookingSeats
     * @return {number}
     */
	public getNoOfBookingSeats(): number {
		return this.noOfBookingSeats;
	}

    /**
    

   

    /**
     * Setter scheduleID
     * @param {String} value
     */
	public setScheduleID(value: String) {
		this.scheduleID = value;
	}

    /**
     * Setter noOfBookingSeats
     * @param {number} value
     */
	public setNoOfBookingSeats(value: number) {
		this.noOfBookingSeats = value;
	}

   
    

   


}


