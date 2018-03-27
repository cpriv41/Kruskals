package A3;

import java.util.Comparator;

public class edgeComparator implements Comparator<Edge>{

		public int compare(Edge w1, Edge w2) {
			// TODO Auto-generated method stub
			if (w1.weight < w2.weight){
				return -1;
			}
			if ( w1.weight > w2.weight){
				return 1;
			}
			return 0;
		}
	}

