import java.util.Scanner;


public class Robot {
	private float headRadius;
	private float eyeRadius;
	private float bodySide;
	private float handHeight;
	private float handWidth;
	private float legHeight;
	private float legWidth;
	private Scanner sc = new Scanner(System.in);
	public Robot() {
	}

	// 构造函数赋初值
	public Robot(float headRadius, float eyeRadius, float bodySide,
			float handHeight, float handWidth, float legHeight, float legWidth) {
		this.headRadius=headRadius;
		this.eyeRadius=eyeRadius;
		this.bodySide=bodySide;
		this.handHeight=handHeight;
		this.handWidth=handWidth;
		this.legHeight=legHeight;
		this.legWidth=legWidth;
	}

	private float square(float side) {
		float sarc = side * side;
		return sarc;
	}

	private float circle(float radius) {
		final float π = 3.1415927f;
		float carc = π * radius * radius;
		return carc;
	}

	private float rectangle(float height, float width) {
		float rectangleArea;
		rectangleArea = height * width;
		return rectangleArea;
	}

	public float getRobotArea() {
		float RobotArea = 0;
		float[] partArea = { circle(headRadius) / 2,
							2 * circle(eyeRadius),
							square(bodySide), 
							2 * rectangle(handHeight, handWidth),
							2 * rectangle(legHeight, legWidth) };
		for (int i = 0; i < partArea.length; i++) {
			RobotArea += partArea[i];
		}
		return RobotArea;
	}

	public float getheadRadius() {
		return headRadius;
	}

	public void setheadRadius() {
		headRadius = sc.nextFloat();
	}

	public float geteyeRadius() {
		return eyeRadius;
	}

	public void seteyeRadius() {
		eyeRadius = sc.nextFloat();
	}

	public float getbodySide() {
		return bodySide;
	}

	public void setbodySide() {
		bodySide = sc.nextFloat();
	}

	public float gethandHeight() {
		return handHeight;
	}

	public void sethandHeight() {
		handHeight = sc.nextFloat();
	}

	public float gethandWidth() {
		return handWidth;
	}

	public void sethandWidth() {
		handWidth = sc.nextFloat();
	}

	public float getlegHeight() {
		return legHeight;
	}

	public void setlegHeight() {
		legHeight = sc.nextFloat();
	}

	public float getlegWidth() {
		return legWidth;
	}

	public void setlegWidth() {
		legWidth = sc.nextFloat();
	}
}
