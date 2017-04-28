package p5;

import java.util.*;

public abstract class DefaultObservableProperty<V> implements ObservableProperty<V>, PropertyObserver<V> {
	protected V value;
	protected List<PropertyObserver<V>> observers = new ArrayList<PropertyObserver<V>>();
	protected PropertyObserver<V> observador;
	
	public DefaultObservableProperty(V value){
		this.value = value;
	}
	
	protected void setValue(V newValue){
		V old = this.value;
		if (newValue != value){
			this.value = newValue;
			for (PropertyObserver<V> o: this.observers){
				o.propertyChanged(this, old);
			}
		}
	}
	
	@Override
	public V getValue(){
		return this.value;
	}
	
	@Override
	public void addObserver(PropertyObserver<V> o){
		if (!this.observers.contains(o)){
			this.observers.add(o);
		}
	}
	
	@Override
	public void removeObserver(PropertyObserver<V> o){
		if (this.observers.contains(o)){
			this.observers.remove(o);
		}
	}
}
