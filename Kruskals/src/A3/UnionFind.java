package A3;

public class UnionFind {
	int[] array;
	int[] size;
	int count;
	int[] id;

	UnionFind(int n) {
		if (n < 0)
			throw new IllegalArgumentException();
		count = n;
		int size = n + 1;
		this.array = new int[size];
	}
}

class QuickFind extends UnionFind {
	public QuickFind(int n) {
		// call to union find 
		super(n);
		for (int i = 1; i <= n; i++) {
			array[i] = i;
		}
	}

	public void union(int x, int y) {
		int p = array[x];
		int q = array[y];
		int min = Math.min(p, q);
		int max = Math.max(p, q);
		for (int k = 1; k < array.length; k++) {
			if (array[k] == max) {
				array[k] = min;
			}
		}
	}
}

class QuickUnion extends UnionFind {
	public QuickUnion(int n) {
		super(n);
		for (int i = 1; i <= n; i++) {
			array[i] = i;
		}
	}

	public int find(int v) {
		while (v != array[v]) {
			v = array[v];
		}
		return array[v];
	}

	public void union(int u, int v) {
		int p = find(u);
		int q = find(v);
		int min = Math.min(p, q);
		int max = Math.max(p, q);
		array[max] = min;
	}
}

class WeightedQuickUnion extends UnionFind {
	public WeightedQuickUnion(int n) {
		super(n);
		for (int i = 1; i <= n; i++) {
			array[i] = i;
		}
	}

	public int find(int x) {
		int i = array[x];
		if (i > 0) {
			return find(i);
		} else {
			return x;
		}
	}

	public void union(int u, int v) {
		int p = find(u);
		int q = find(v);
		if( p == q)
			return;
		if (p < q) {
			array[p] = q;
			size[q] += size[q];
		}
		else {
			array[q] = p;
			size[p] += size[q];
		}
		
	}
}

class compressWQU extends UnionFind{
	public compressWQU(int n) {
		super(n);
		count = n;
		id = new int[n];
		for (int i = 0; i < n; i++) {
			id[i] = i;
		}
	}

	public int find(int x) {
		int i = x;
		while (i != id[i])
			i = id[i];
		while (x != i) {
			int newi = id[x];
			id[x] = i;
			x = newi;
		}
		return i;
	}
	public void union(int u, int v ){
		int p = find(u);
		int q = find(v);
		if (p == q)
			return;
		id[p] = q;
		count--;
		
	}
	
}