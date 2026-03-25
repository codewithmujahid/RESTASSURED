package ComplexJson;

public class EmployeeAddress {
	/*{
  "orderId": "ORD123",
  "customer": {
    "name": "Mujahid",
    "email": "mujahid@test.com",
    "phone": "9876543210"
  },
  "items": [
    {
      "productId": "P101",
      "productName": "Laptop",
      "price": 50000,
      "quantity": 1
    },
    {
      "productId": "P102",
      "productName": "Mouse",
      "price": 500,
      "quantity": 2
    }
  ],
  "shippingAddress": {
    "city": "Pune",
    "state": "Maharashtra",
    "pincode": "411001"
  },
  "payment": {
    "method": "UPI",
    "status": "Paid"
  }
}*/
	
	
	
	
	private String Street;
	private String City;
	private String State;
	private double Pincode;
	public String getStreet() {
		return Street;
	}
	public void setStreet(String street) {
		Street = street;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public double getPincode() {
		return Pincode;
	}
	public void setPincode(double pincode) {
		Pincode = pincode;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
