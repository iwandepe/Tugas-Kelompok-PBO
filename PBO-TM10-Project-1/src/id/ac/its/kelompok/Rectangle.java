package id.ac.its.kelompok;

public class Rectangle extends Shape{

		protected double height;
		protected double width;
		
		
		public Rectangle()
		{
			super();
			
//			System.out.println("[Rectangle]: Default Constructor");
			this.height = 0.0;
			this.width = 0.0;
		}
		
		public Rectangle(double height, double width)
		{
			super();
			
//			System.out.println("[Rectangle]: Constructor 2");
			this.height = height;
			this.width = width;
		}
		
		public double getHeight() {
			return height;
		}

		public void setHeight(double height) {
			this.height = height;
		}

		public double getWidth() {
			return width;
		}
		
		public void setWidth(double width) {
			this.width = width;
		}

		@Override
		public double getArea() {
			return getWidth() * getHeight();
		}

		@Override
		public double getAround() {
			return 2*(getWidth() + getHeight());
		}

}
