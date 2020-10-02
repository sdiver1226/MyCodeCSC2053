//author@Sophia Diver

import java.util.Iterator;


public class RecursiveLinkedCollection<T> implements CollectionInterface<T>{

	
	LLNode<T> front;
	int size;
	
	RecursiveLinkedCollection() {
		front = null;
		size = 0;
	}
	// add to rear of list
	
	private LLNode<T> recAdd(LLNode<T> node, T element)  {
		if (node != null)  {
			node.setLink(recAdd(node.getLink(), element));
		} 
		else  {
			node = new LLNode<T>(element);
		}
		return node;
	}
	@Override
	public boolean add(Object element) {
		if (element ==null) 
		return false;
	front =recAdd(front, ((T) element));
	return true;
	}
	
	private LLNode<T> recGet (LLNode<T> node, T target)   {
		if(node.getInfo()==(target)) {
			return node;
		}
		else if (node.getLink()==(null))
			return null;
		return recGet(node.getLink(), target);
			
		}
	
	public Object get(Object target)  {
		return recGet(front, (T) target).getInfo();
	}
	
	private LLNode<T> recRemove(LLNode<T> node, T element)  {
		if (node.getLink().getInfo() != element && node.getLink() != null) {
			recRemove(node.getLink(), element);
		}
		if(node.getLink().getInfo()== element) {
			node.setLink(node.getLink().getLink());
		}
		
		return node;
	}
	@Override
	public boolean remove(T element) {
		front = recRemove(front, ((T) element));
		return true;
	}
	
	private boolean recContains(LLNode<T> node, T target)  {
		if (node.getInfo()==(target))  {
			return true;
		} else if (node.getLink()==null)
		return false;
		return recContains(node.getLink(), target);
	}

	@Override
	public boolean contains(T target) {
		return recContains (front, ((T) target));
		
	}
	

	@Override
	public boolean isFull() {
		
		return false;
	}

	@Override
	public boolean isEmpty() {
		if (front==(null))
			return true;
		else
			return false;
	}

	private int recSize (LLNode<T> node)  {
		if(node.getLink()!= null)
			 size ++;
		else if(node.getLink() == null)
			return size+1;
		return recSize(node.getLink());
	}
	
	
	@Override
	public int size() {
		size=0;
		return recSize(front);
	}
	public String toString() {
		if (front ==null) {
			return "";
			
		}
		String ret = front.getInfo().toString();
		LLNode<T> temp =front.getLink();
		while (temp != null)  {
			ret += "," +temp.getInfo().toString();
			temp = temp.getLink();
		}
		return ret;
	}
	

}
