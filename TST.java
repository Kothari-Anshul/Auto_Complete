
public class TST<Value> {
	private static final int R = 26;
	private Node root = new Node();
	private static class Node{
		Object v;
		Node next[] = new Node[R];
	}
	public void put(String key,Value v){
		root = put_wrap(root,key,v,0);
	}
	public Node put_wrap(Node x, String key, Value v, int d){
		
		if(x == null){
			x = new Node();
		}
		if(d == key.length()){
			x.v = v;
			return x;
		}
		char c = key.charAt(d);
		x.next[c - 'a'] = put_wrap(x.next[c - 'a'],key,v,d+1);
		return x;
	}
	public Iterable<String> keys(){
		Queue<String> q = new Queue<String>();
		collect(root,"",q);
		return q;
	}
	private void collect(Node x, String prefix, Queue<String> q){
		if(x == null){
			return;
		}
		if(x.v != null){
			q.enqueue(prefix);
		}
		for(int r=0; r<26; r++){
			char c = (char)(97 + r);
			collect(x.next[r],prefix + c,q);
		}
		
		
		
	}
	public Value get(String key){
		Node x = get(root,key,0);
		if(x == null){
			return null;
		}
		return (Value)x.v;
	}
	public Node get(Node x, String key, int d){
		if(x == null){
			return null;
		}
		if(d == key.length()){
			return x;
		}
		char c = key.charAt(d);
		return get(x.next[c - 'a'],key,d+1);
	}
	public Iterable<String> keys_starts_with(String input){
		Queue<String> q = new Queue<String>();
		Node x = get(root,input,0);
		collect(x,input,q);
		return q;
	}
	
}
