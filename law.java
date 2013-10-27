import java.io.*;

public class law{
	static int[][] h = new int[100][100];
	static int[] x_top = new int[100];
	static int[] y_top = new int[100];
	static int[] size = new int[2];
    public static void main( String[] args ) {
		try{
			FileReader f = new FileReader("B-large-practice.in");
			String n = "";
			char ch;
			while((ch = (char)f.read()) != '\n'){
				n = n + ch;
			}
			int _n = Integer.parseInt(n);
			n = "";
			
			for(int i = 0; i < _n; i++){
				n = "";
				while((ch = (char)f.read()) != '\n'){
					n = n + ch;
				}
				String[] _size = n.split(" ");
				size[0] = Integer.parseInt(_size[0]);
				size[1] = Integer.parseInt(_size[1]);

				for(int j = 0; j < size[0]; j++){
					for(int k = 0; k < size[1]; k++){
						n = "";
						while((ch = (char)f.read()) != ' ' && ch != '\n' ){
							n = n + ch;
						}	
						h[j][k] = Integer.parseInt(n);
					}
				}
				check(i);
			}			
		}catch(Exception e){
			System.out.println("error");
		}		
	}
	
	public static void check(int _i){
		int _top = 0;
		for(int j = 0; j < size[0]; j++){
			_top = 0;
			for(int k = 0; k < size[1]; k++){
				if(h[j][k] > _top) _top = h[j][k];
			}
			x_top[j] = _top;
		}
		
		for(int j = 0; j < size[1]; j++){
			_top = 0;
			for(int k = 0; k < size[0]; k++){
				if(h[k][j] > _top) _top = h[k][j];
			}
			y_top[j] = _top;
		}
		
		for(int j = 0; j < size[0]; j++){
			for(int k = 0; k < size[1]; k++){
				if(h[j][k] < x_top[j] && h[j][k] < y_top[k]){
					System.out.println("Case #"+(_i+1)+": NO");
					return;
				}
			}
		}
		System.out.println("Case #"+(_i+1)+": YES");
	}
}
