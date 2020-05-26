package bean;

import java.awt.Image;
import java.io.Serializable;

public class Picture implements Serializable{
	private static final long serialVersionUID = 1L;
	private int pictID;
	private Image image;

	public Picture(){}

	public Picture(int pictID, Image image) {
		this.pictID = pictID;
		this.image = image;
	}

}
