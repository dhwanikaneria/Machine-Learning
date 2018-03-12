

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;

public class Kmeans {
	static int size = 0;
	static String data;// = "K:\\Dhwani\\1stSem\\ML\\Ass6\\test_data.txt";
	static String outputfile;// = "K:\\Dhwani\\1stSem\\ML\\Ass6\\output.txt";
	static int k;// = 25;
	static ArrayList<Float[]> list = new ArrayList<>();
	static ArrayList<Float[]> centerp = new ArrayList<>();
	static ArrayList<Float[]> Newcenterp = new ArrayList<>();
	static int[][] cluster;
	static int totalItration = 0;

	public static void main(String[] args) {
		k = Integer.parseInt(args[0]);
		data = args[1];
		outputfile = args[2];
		try {

			File file = new File(data);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String str = br.readLine();
			String[] att = str.split("	");

			Float[] a;
			int j = 0;
			while ((str = br.readLine()) != null) {
				String[] temp = str.split("	");

				a = new Float[att.length - 1];
				for (int i = 1; i < temp.length; i++) {
					a[i - 1] = Float.valueOf(temp[i]);
				}
				list.add(j, a);
				j++;

			}

			size = list.size();
			int center[] = new int[k];
			Float b[];
			for (int i = 0; i < center.length; i++) {
				b = new Float[att.length - 1];
				center[i] = new Random().nextInt(size);

				for (int m = 0; m < list.get(1).length; m++) {
					b[m] = Float.valueOf(list.get(center[i])[m]);
				}
				centerp.add(b);
			}
			while (totalItration < 22) {
				computecenter(centerp);
				totalItration++;
			}
			BufferedWriter bw = null;
			FileWriter fw = null;
			fw = new FileWriter(outputfile);
			bw = new BufferedWriter(fw);

			for (int m = 0; m < k; m++) {
				int r, u = 0;
				r = m + 1;
				bw.write("The points in k=" + " " + r + " " + "classifier are\n");
				System.out.println("The points in k=" + " " + r + " " + "classifier are");
				for (int i = 0; i < size; i++) {
					if (cluster[i][m] == 1) {
						u = i + 1;
						bw.write(u + " ");
						System.out.print(u + "  ");
					}
				}
				bw.write("\n");
				System.out.println();
			}

			double sse = SSE(centerp);
			bw.write("The value of SSE for total " + k + " " + "clusters is" + " " + sse);

			bw.close();
			br.close();

			System.out.println("the value of sse is " + sse);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private static double SSE(ArrayList<Float[]> centerp2) {
		double dist = 0;
		double[] distanceto = new double[k];
		for (int j = 0; j < k; j++) {
			for (int i = 0; i < size; i++) {
				if (cluster[i][j] == 1) {
					float x1 = (float) (Math.pow((centerp2.get(j)[0] - list.get(i)[0]), 2));
					float y1 = (float) (Math.pow((centerp2.get(j)[1] - list.get(i)[1]), 2));
					float finaleucli = (float) Math.sqrt(x1 + y1);
					dist = dist + Math.pow(finaleucli, 2);
				}

			}
			distanceto[j] = dist;
			dist = 0;
		}
		double ssesum = 0;
		// adding values
		for (int i = 0; i < distanceto.length; i++) {
			ssesum += distanceto[i];
		}
		return ssesum;
	}

	private static void computecenter(ArrayList<Float[]> centerp2) {

		float[][] temp = new float[size][k];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < centerp2.size(); j++) {
				float x1 = (float) (Math.pow((centerp2.get(j)[0] - list.get(i)[0]), 2));
				float y1 = (float) (Math.pow((centerp2.get(j)[1] - list.get(i)[1]), 2));
				float finaleucli = (float) Math.sqrt(x1 + y1);
				temp[i][j] = finaleucli;
			}

		}

		classify(temp);
	}

	private static void classify(float[][] temp) {
		cluster = new int[size][k];

		for (int i = 0; i < size; i++) {
			int minindex = 0;
			float minvalue = temp[i][0];
			for (int j = 1; j < centerp.size(); j++) {

				if (temp[i][j] < minvalue) {
					minvalue = temp[i][j];
					minindex = j;
				}
			}
			cluster[i][minindex] = 1;
		}
		computeavg(cluster);

	}

	private static void computeavg(int[][] classi2) {
		float sumx = 0;
		float sumy = 0;
		float avgx = 0;
		float avgy = 0;
		Float c[];
		int counter = 0;
		for (int j = 0; j < centerp.size(); j++) {
			for (int i = 0; i < size; i++) {
				if (cluster[i][j] == 1) {
					counter++;
					sumx += list.get(i)[0];
					sumy += list.get(i)[1];
				}
			}
			avgx = sumx / counter;
			avgy = sumy / counter;

			c = new Float[centerp.get(0).length];

			c[0] = avgx;
			c[1] = avgy;
			Newcenterp.add(c);

			sumx = 0;
			sumy = 0;
			avgx = 0;
			avgy = 0;
			counter = 0;
		}

		// compare the values with previous states.
		for (int i = 0; i < centerp.size(); i++) {
			if (centerp.get(i)[0] == Newcenterp.get(i)[0] && centerp.get(i)[1] == Newcenterp.get(i)[1])// problem in
																										// comparison
			{
				System.out.println("Both are same centers");
				continue;
			}
			centerp.clear();
		}
		for (int j = 0; j < Newcenterp.size(); j++) {
			centerp.add(Newcenterp.get(j));
		}
		Newcenterp.clear();
	}
}
