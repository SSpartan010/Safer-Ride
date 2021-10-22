
public class UserNode {
	
	String UserID;
	DummyGPSLocationVar UserRequestStartLocation;
	DummyGPSLocationVar UserRequestDestination;
	boolean isCarpool;
	boolean isEventRequest;
	boolean isAccepted;
	int currentCost;

	public UserNode(String id, DummyGPSLocationVar start, DummyGPSLocationVar end,
			boolean isShared, boolean forEvent, boolean isAcc ) {
		this.UserID = id;
		this.UserRequestStartLocation = start;
		this.UserRequestDestination = end;
		this.isCarpool = isShared;
		this.isEventRequest = forEvent;
		this.isAccepted = isAcc;
	}
	
	//Getters and Setters:
	public String getUserID() {
		return UserID;
	}

	public void setUserID(String userID) {
		UserID = userID;
	}

	public DummyGPSLocationVar getUserRequestStartLocation() {
		return UserRequestStartLocation;
	}

	public void setUserRequestStartLocation(DummyGPSLocationVar userRequestStartLocation) {
		UserRequestStartLocation = userRequestStartLocation;
	}

	public DummyGPSLocationVar getUserRequestDestination() {
		return UserRequestDestination;
	}

	public void setUserRequestDestination(DummyGPSLocationVar userRequestDestination) {
		UserRequestDestination = userRequestDestination;
	}

	public boolean isAccepted() {
		return isAccepted;
	}

	public void setAccepted(boolean isAccepted) {
		this.isAccepted = isAccepted;
	}

	public int getCurrentCost() {
		return currentCost;
	}

	public void setCurrentCost(int currentCost) {
		this.currentCost = currentCost;
	}
	
	public boolean isCarpool() {
		return isCarpool;
	}

	public void setCarpool(boolean isCarpool) {
		this.isCarpool = isCarpool;
	}

	public boolean isEventRequest() {
		return isEventRequest;
	}

	public void setEventRequest(boolean isEventRequest) {
		this.isEventRequest = isEventRequest;
	}

	//Generates Costs:
	//Not time bound:
	public int distanceFromDriverCost(DummyGPSLocationVar driverLocation) {
		int distanceBetweenTwoLocations = 0; //some method that gets the distance between the user and the driver 
		if (distanceBetweenTwoLocations > 10) {
			//max cost set to 50
			return 50;
		}
		else {
			return 50 - 5 * (int)(10 - distanceBetweenTwoLocations);
		}
	}
	
	//cost for booleans 
	
	//Time bound Costs:
	public int userTimeWaitedCost() {
		return 30;
	}	
	//Evaluation Function (time bounded)
	public int UserCost (DummyGPSLocationVar driverLocation) {
		int userCost = 0;
		if (this.isCarpool == false) {
			userCost+= 10;
			}
		if (this.isEventRequest == false) {
			userCost+= 10;
		}
		userCost += this.distanceFromDriverCost(driverLocation)+ this.userTimeWaitedCost();
		return userCost;
	}
}
