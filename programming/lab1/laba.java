public class laba{
	static double calc(short z, double x){
		switch(z){
			case 7:
				return Math.asin(Math.pow(Math.E, -Math.abs(x)));
			case 9, 15, 17:
				return Math.pow(((3.0/4.0) / (Math.tan(Math.pow(0.25*x, 2)))), 2);
			default:
				return Math.pow((
				(Math.sin(Math.pow(0.25-Math.tan(x), 3))) / 
				(2 - (Math.pow(Math.pow((((3.0/4.0) + Math.pow((1.0/4.0)/x,x))/2.0), Math.sin(x)), (3.0/4.0)/(Math.pow((Math.asin(Math.E * ((x+5)/2.0) + 1))*(Math.pow((2.0/3.0)*(1-x),x) - 1), 3)))))
			), (Math.pow(Math.E, Math.cos(Math.atan(Math.E * ((x+5)/2.0) + 1)))));
		}
	}
	
	static void print(double[][] a){
		for (int i = 0; i < a.length; ++i){
			for (int j = 0; j < a[i].length; ++j){
				System.out.print(String.format("%.5f", a[i][j]) + " ");
			}
			System.out.print('\n');
		}
	}
	
        public static void main(String[] args){
                short[] z = new short[6];
                short val = 7;
                for (int i = 0; i < 6; ++i){
                        z[i] = val;
                        val += 2;
                }
                double[] x = new double[15];
		for (int i = 0; i < 15; ++i) x[i] = (Math.random()*20 - 5);
		double[][] w = new double[6][15];
		for (int i = 0; i < 6; ++i){
			for (int j = 0; j < 15; ++j){
				w[i][j] = calc(z[i], x[j]);
			}
		}
		print(w);
        }
}

