package p5;

import java.util.*;

public abstract class DefaultObservableProperty<V> implements ObservableProperty<V> {
	private V value;
	private ArrayList<PropertyObserver<V>> observer = new ArrayList<PropertyObserver<V>>();
	
	
	protected void setValue(V newValue){
		if (newValue != value){
			for (PropertyObserver<V> o: this.observer){
				o.propertyChanged(this, value);
			}
			this.value = newValue;
		}
	}
	
	@Override
	public V getValue(){
		return value;
	}
	
	@Override
	public void addObserver(PropertyObserver<V> o){
		if (!this.observer.contains(o)){
			this.observer.add(o);
		}
	}
	
	@Override
	public void removeObserver(PropertyObserver<V> o){
		if (this.observer.contains(o)){
			this.observer.remove(o);
		}
	}
}
