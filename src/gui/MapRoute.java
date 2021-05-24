package gui;

public class MapRoute {
	private String imgString;
	private Route safeRoute;
	private Route dangerousRoute;
	public MapRoute(String imgString, Route safeRoute, Route dangerousRoute) {
		this.imgString = imgString;
		this.safeRoute = safeRoute;
		this.dangerousRoute = dangerousRoute;
	}
	
	public String getImgString() {
		return this.imgString;
	}
	
	public Route getSafeRoute() {
		return this.safeRoute;
	}
	
	public Route getDangerousRoute() {
		return this.dangerousRoute;
	}
}
