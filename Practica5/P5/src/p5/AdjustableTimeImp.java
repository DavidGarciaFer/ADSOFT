package p5;

import java.util.*;

public class AdjustableTimeImp extends DefaultObservableProperty<Integer> implements AdjustableTime {
	
	private List<ObservableProperty<Integer>> properties = new ArrayList<ObservableProperty<Integer>>();
	
	public AdjustableTimeImp(Integer value){
		super(value);
	}
	@Override
	public void incrementTime(int inc) {
		super.setValue(super.getValue()+inc);
		if (super.getValue() < 0)
			throw new IllegalArgumentException();
		
	}
	
	public void addProperty(ObservableProperty<Integer> prop){
		if(this.properties.contains(prop) == false){
			this.properties.add(prop);
			this.incrementTime(prop.getValue());
		}
	}
	
	public void removeProperty(ObservableProperty<Integer> prop){
		if(this.properties.contains(prop)){
			this.properties.remove(prop);
			this.incrementTime(prop.getValue()*(-1));
		}
	}
	@Override
	public void propertyChanged(ObservableProperty<Integer> property, Integer oldValue) {
		Integer actual = property.getValue();
		this.incrementTime(oldValue-actual);
	}

}
